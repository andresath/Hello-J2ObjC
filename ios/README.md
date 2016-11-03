Hello J2ObjC iOS
================

See notes in the top level Java [../README.md](../README.md) (if you didn't start there, go read that, that project creates and provides the static library that this project will import and link).

For this Hello World example, this project favors importing code compiled with J2ObjC as a Podfile. This is due to multiple transitive dependencies and a multi-project gradle setup for shared code. If you have a simple project/module setup, you can also directly link against a fat static library binary. (See instructions below).

RECOMMENDED: Setup XCode w. Cocoapods
-----------
* Make sure your Project is initialized with Cocoapods
  ```
  cd ../../ios/Hello-J2ObjC-iOS
  pod init
  pod install
  ```
* Update the settings in ```core/shared/build.gradle```
    ```
    xcodeProjectDir '../../ios/Hello-J2ObjC-iOS'
    xcodeTargetsIos 'Hello-J2ObjC-iOS', 'Hello-J2ObjC-iOSTests'  // replace with your iOS targets
    ```
    * and also the Bridging header settings if you are using Swift
            ```
            ext {
                j2ObjcBridgingHeaderFile = "Hello-J2ObjC-iOS-Bridging-Header.h"
                j2ObjcBridgingHeaderDef = "Hello_J2ObjC_Bridging_iOS_Header_h"
                j2ObjcBridgingHeaderPath = project.buildDir.toString() + "/j2objcOutputs/src/main/objc/"
            }
            ```
            * In the J2Objc root level project, ensure you add this information if you would like to generate a bridging header.
                * Then update the :core:shared ```build gradle``` with:
                    ```
                    ext {
                        j2ObjcBridgingHeaderFile = "Hello-J2ObjC-iOS-Bridging-Header.h"
                        j2ObjcBridgingHeaderDef = "Hello_J2ObjC_Bridging_Header_h"
                        j2ObjcBridgingHeaderPath = project.buildDir.toString() + "/j2objcOutputs/src/main/objc/"
                    }

                    task j2ObjcBridgingHeader << {
                        File headerFile = new File("$j2ObjcBridgingHeaderPath" + "$j2ObjcBridgingHeaderFile")
                        String content = "////--- Auto-Generated. Copy this to your bridging header ---////" + System.getProperty("line.separator")
                        content += "#ifndef $j2ObjcBridgingHeaderDef" + System.getProperty("line.separator")
                        content += "#define $j2ObjcBridgingHeaderDef" + System.getProperty("line.separator") + System.getProperty("line.separator")
                        allprojects.each { project ->

                            println project.buildDir.toString() + '/j2objcOutputs/src/main/objc'
                            FileTree headers = fileTree(dir: project.buildDir.toString() + '/j2objcOutputs/src/main/objc', include: '**/*.h', exclude: "**/$j2ObjcBridgingHeaderFile")
                            headers = headers.matching {
                                include '**/*.h'
                            }
                            if (!headers.isEmpty()) {
                                content += "////--- Shared $project.name Headers. Auto-Generated. Copy this to your bridging header. ---///" + System.getProperty("line.separator")
                                headers.visit {element ->
                                    if (!element.isDirectory()) {
                                        content += /#import "$element.relativePath"/ + System.getProperty("line.separator")
                                    }
                                }
                                content += "////--- End $project.name Shared Headers. Auto-Generated. Copy this to your bridging header. ---///" + System.getProperty("line.separator")
                                content += System.getProperty("line.separator")
                            }
                        }
                        content += System.getProperty("line.separator")
                        content += "#endif /* $j2ObjcBridgingHeaderDef */" + System.getProperty("line.separator")
                        content += "////--- End Auto-Generated. Copy this to your bridging header. ---///" + System.getProperty("line.separator")
                        println content
                        headerFile.write(content)
                    }
                    j2ObjcBridgingHeader.shouldRunAfter j2objcXcode
                    ```
* If shared project has *NOT* already been transpiled you will need to build it to create static shared libraries.
   ```
   cd core
   ./gradlew shared:build --info
   ```
   * If shared project *HAS* already been transpiled and you just want to update XCode Project to point at shared lib:
       ```
       cd core
       ./gradlew shared:j2objcXcode --info
       ```

* Re-Run Pod Install to link your transpiled libraries to your iOS Projec
  ```
  cd ../../ios/Hello-J2ObjC-iOS
  pod install
  ```
* If you already have a [https://developer.apple.com/library/content/documentation/Swift/Conceptual/BuildingCocoaApps/MixandMatch.html](bridging header file), please create an empty one first.
    * Otherwise please create a new one or import the one from ./core/shared/build/j2objcOutputs/src/main/objc/Hello-J2ObjC-iOS-Bridging-Header.h to your XCode project.
* If using Swift and already have a Bridging Header: Copy bridging header content in ```shared/build/j2objcOutputs/src/main/objc``` to your bridging header file
* In your XCode Project Settings or XCConfig, Ensure ```SWIFT_OBJC_BRIDGING_HEADER```  is set to: ```$(SRCROOT)/$(PROJECT_NAME)/$(PROJECT_NAME)-Bridging-Header.h ```

ALTERNATIVE FOR SIMPLE PROJECTS: Setup XCode w. Fat Static Library
-----------
This iOS project ASSUMES you have already succeeded in transpiling
*HelloWorld.java* into *libHello-J2ObjC-j2objc.a* (the static library) from the top level project (../).

* Make sure that *java/build/packedBinaries/libHello-J2ObjC-j2objc.a* exists.
* Open the iOS project in Xcode: File->Open, browse to "iOS" folder of this project and open.

Inside the iOS project go to the main target, then *Build Settings* and *Build Phase*, and update several properties so the project knows how to link and compile the library.   

There are library and header search paths that must be updated, and one build phase.
There are several RELATIVE paths that you should not have to change, and some complete paths that you will need to update.

You must REPLACE ```/Users/cecollins/projects/j2objc-1.0.2``` with YOUR PATH to j2objc in the below settings that indicate such. 

The COMPLETE settings needed to link the static library are as follows:
* ALREADY SET - Build Settings -> Linking -> Other Linker Flags ```-ljre_emul```
* ALREADY SET - Build Settings -> Search Paths -> Always Search User Paths set to ```Yes```.
* UPDATE PATH - Build Settings -> Search Paths -> Header Search Paths: ```<path to J2ObjC>/include``` (for both debug and release)
* UPDATE PATH - Build Settings -> Search Paths -> Library Search Paths: ```<path to J2ObjC>/lib``` (for both debug and release)
* ALREADY SET - Build Settings -> Search Paths -> Library Search Paths Debug: ````../build/packedBinaries/Hello-J2ObjC-j2objcStaticLibrary/iosDebug```
* ALREADY SET - Build Settings -> Search Paths -> Library Search Paths Release: ````../build/packedBinaries/Hello-J2ObjC-j2objcStaticLibrary/iosRelease```
* ALREADY SET - Build Settings -> Search Paths -> User Header Search Paths: ````../build/j2objcOutputs/src/main/objc```
* ALREADY SET - Build Phase -> Link Binaries With Libraries -> and point to lib: ```libHello-J2ObjC-j2objc.a```
* Build and Run in XCode


TODO (below here are just notes for future, to simplify this, ignore) 
After getting env vars to work add these:
* Make sure that $J2OBJC_HOME is set correctly before proceeding.
* Allow XCode to use env vars: ```defaults write com.apple.dt.Xcode UseSanitizedBuildSystemEnvironment -bool NO```






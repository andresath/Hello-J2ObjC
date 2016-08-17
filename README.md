Hello J2ObjC
============


Overview
--------
Sample project for getting started with J2ObjC.

Uses [IDEA](https://www.jetbrains.com/idea/), [J2ObjC](http://j2objc.org/),
[j2objc-gradle](https://github.com/j2objc-contrib/j2objc-gradle),
and [Xcode](https://developer.apple.com/xcode/).

Maven and Multi-Library Overview
========
The philosophy here is to demonstrate creating an ObjC Dynamic Framework via Maven, from Java source code.
Then AFTER the J2ObjC transpilation works, import the created library into Xcode.

Setup JAVA Project and run J2ObjC
----------------------------------

The first part is to get a plain Java project with J2ObjC support working (no XCode involved, yet).

* Ensure that you have Java 1.8 Installed, and your ```JAVA_HOME``` Path setup
* Ensure that you have the latest version of Maven installed.(3.3.9 as of writing) and on your ```PATH``` NOTE: you can use homebrew for this.
* Download and unpack J2ObjC (1.1.0 as of writing) somewhere logical. Define ```J2OBJC_HOME``` and add it to your ```PATH```.
* Make sure J2ObjC works (```cd <J2OBJC_HOME>``` >  ```j2objc -version```).
* Clone this repo. (note you cannot have spaces in path name. Kayla stop being lazy and just fork & patch the plugin...)
* Import this project into IDEA (the main project is plain Java), import EXTERNAL MODEL -> MAVEN.
* Edit local.properties and set j2objc.home to the correct path (your local install).
* Once you have the Hello-J2OBJC project in IDEA, and local.properties, run ```mvn j2objc:convert``` or ```mvn j2objc:convert -DJ2OBJC_HOME='path/to/j2objc-version'```!

This should succeed and create *target/j2objc/src* and *target/j2objc/binaries* (TODO) etc.

Examine the transpiled Objective-C files at *target/j2objc/src.

Original Java source is at *api/src/main/java*.

Original Java source is at *src/main/java*.


Gradle and Static Library Overview
=========
*NOTE* the J2ObjC Gradle Plugin development has been halted, and does not work with J2ObjC latest version (1.1). Please see Maven section above for latest info.

The philosophy here is to create an ObjC STATIC LIBRARY from Java source code.
Then AFTER the J2ObjC transpilation works, import the created library into Xcode.

(There are many other ways to work with J2ObjC, you can, for example, have Xcode build your
Java files on the fly, or have your Java project create a Cocoapod via j2objc-gradle,
but for a clear understanding and clean path this project favors the static library approach.)


Setup JAVA Project and run J2ObjC
----------------------------------

The first part is to get a plain Java project with J2ObjC support working (no XCode involved, yet).

* Download and unpack J2ObjC somewhere logical.
* Make sure J2ObjC works (```cd <J2OBJC_HOME>``` >  ```j2objc -version```).
* Clone this repo.
* Import this project into IDEA (the main project is plain Java), import EXTERNAL MODEL -> GRADLE.
* Edit local.properties and set j2objc.home to the correct path (your local install).
* Once you have the Hello-J2OBJC project in IDEA, and local.properties, run ```gradle build```!

This should succeed and create *build/j2objcOutputs* and *build/binaries* and *build/packedBinaries*, etc.

Examine the transpiled Objective-C files at *build/j2objcOutputs/src/main/objc*.

Original Java source is at *src/main/java*.


Setup Xcode and Include Static Library
---------------------------------------

The second part is to use the static library you created in Xcode with an iOS project.

See the [ios/README.md](./ios/README.md).




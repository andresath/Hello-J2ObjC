Hello J2ObjC
============


Overview
--------
Sample project for getting started using J2ObjC & Swagger to auto-generate and share as much code as possible across Android and iOS.

Uses [J2ObjC](http://j2objc.org/), [Swagger](http://swagger.io/),
[IDEA](https://www.jetbrains.com/idea/) and [Xcode](https://developer.apple.com/xcode/).


TODO
--------
* Stop using ```--build-closure``` in transpilation process
    We should transpile a separate framework for every dependency in ```deps```
    The source jars should be in the transpile commands' classpath
    When generating the ```data`` or ```domain``` Libraries, the individual ```deps``` libraries should be pointed at via linker
        Currently the swagger-annotations library is holding this up. It won't compile to a library after transpilation
* Create Example iOS Project
* Create Example Android Project
* Create ```scripts/``` for adding swagger auto-generation to build process
* Finish Domain contrived example


Project Structure
--------
* ```core``` - the bulk of our app logic
    * ```petstore``` Logic/Business Domain Core
        * Theoretically there is one of these for each Business Domain (Petstore, PetShelter, PetGroomers)
        * Everything under this package will be transpiled by J2ObjC and shareable with iOS apps
        * There should be VERY MINIMAL dependencies for any code under this layer.
            * See ```deps/lib``` (below) folder for dependencies that are compatible with J2ObjC and can be used in sub modules
        * Domain Module (transpilable)
            * Reactive APIs
            * Contains Business Logic, App/View Models, DTO <=> Domain Model Mapping, Consumer facing APIs.
        * Data Module (transpilable, auto-generated)
            * NOTE: _EVERYTHING in this layer should be auto-generated_ by Swagger
                 *  The exception is tests, which swagger will auto-generate a portion of, and you manually flesh
                 out the rest of test validations.
            * Reactive APIs
            * Contains Service Logic, Service DTOs, Request/Response <=> DTO Mapping, Service Unit Tests
            * Requires the consumer to provide an HTTPClient Driver Implementation
    * Drivers
        * Default Native Java Driver Implementations, Driver Integration Tests
            * OkHttpService client. Super simple service client for use on Android or in Java environments
* ```deps```
    * Local distribution of any dependencies that will be used in ```core.domain```,
    or ```core.data``` and need to be transpiled into Objective-C
        * Currently:
            * RxJava 1.1.6
            * Joda Time 2.9.3
            * Joda Convert 1.8.1
            * GSON 2.7
            * And the following, which have Jars and Pre-Transpiled framework that are distributed with J2ObjC
                * Guava 19.0
                * Junit 4.1.2
                * Hamcrest Core 1.3
    * ```build``` - transpiled libraries, and the raw transpiled source code
    * ```Makefile``` Makefile used to transpile all dependencies
* ```ios```
    * iOS Example Project
        * Consumes transpiled dependencies and core libraries
* ```android```
    * Android Example Project
        * Consumes core modules
* ```misc```
    * ```templates```
       * Example Mustache templates for customizing Swagger generated code. (See below)


Data Module - Auto-Generated Service Clients
--------

*TODO* Instead of using a fork, we should be using a custom generator module, but the Java generator is pretty complex,
so we would have to port a decent ammount of the abstract generator code any way. For now, just use a fork.

This project uses a forked version of Swagger Codegen that generates a custom
Reactive Service Client from any valid Open Api spec. This code has minimal 3rd party dependencies,
and NO platform specific dependencies, and is designed to be highly platform independent (read: able to be translated by J2Objc).
The intention is to be able to auto generate the the majority of Service Client, DTO mapping code, Unit tests, and JavaDocs
and subsequently encapsulate them in the transpiled J2ObjC library.

This code will use GSON, RxJava, and JUnit.

To generate this code, use the custom java "library" option ```rx-abstract-httpclient-gson``` which
will auto-generate this platform-independent code. The generated project will include:

*Generic Logic*
- ApiClient - Generic Api Client with things like serialization, deserialization, and passes ApiRequest/ApiResponse objects
back and forth via the generic HttpClient interface.

- Generic Api Classes. ApiException, ApiRequest, ApiResponse for use in your Native HttpClient implementation

*Your API-Specific Logic* (generated based on provided) Open API spec
- Api Classes (PetApi, UserApi, etc.) for individual REST resources. These contain the Api-Specific endpoint building,
DTO mapping logic, parameter validation, post-processing, etc.
- Api Test Bases (Observer/Subscriber and Param Skeletons) that you can manually flesh out with business logic/validation tests.
- Model/DTO Classes. Which the ApiClient will automatically serialize from an ApiRequest or deserialize from an ApiResponse.

*HTTP Clients*
- (Interface) The HTTPClient is simply an very simple interface to be defined and injected by the Native consumer of the APIs.
- (Optional) A Super-Basic Default HttpClient Implementation for example purposes. *(note this is NOT platform independent,
and cannot be compiled with J2ObjC)*

*Build Files*
- Gradle build file
- Maven build file

Along with the typical Swagger Codegen Options such as Documentation, etc.

1 Clone the Swagger Fork from: [https://github.com/kaylarose/swagger-codegen/tree/rx-abstract-http-client-generator]()
2 Build Swagger Codegen with the following:
```
cd swagger-codegen
mvn clean package
```
3 Generate Code
Then you can use the new generator via the following command:
```
java -DuseRxJava=true,generateDefaultHttpClient=false \
-jar modules/swagger-codegen-cli/target/swagger-codegen-cli.jar \
generate -i http://petstore.swagger.io/v2/swagger.json -l java \
-o Hello-J2ObjC/core/petstore/data --library=rx-abstract-httpclient-gson \
--model-package com.pets.core.petstore.data.models \
--api-package com.pets.core.petstore.data.store.api

```

The [following templates](https://github.com/kaylarose/swagger-codegen/tree/rx-abstract-http-client-generator/modules/swagger-codegen/src/main/resources/Java/libraries/rx-abstract-httpclient-gson) are included in the Swagger Fork:
- api.mustache
- api_test.mustache
- ApiClient.mustache
- ApiResponse.mustache
- ApiException.mustache
- ApiRequest.mustache
- build.gradle.mustache
- build.sbt.mustache
- HttpClient.mustache
- HttpClientUtils.mustache
- JSONSerializer.mustache
- OkHttpServiceClient.mustache (Optional Default HttpClient impl)
- Pair.mustache
- pom.mustache
- auth/ApiKeyAuth.mustache
- auth/Authentication.mustache
- auth/HttpBasicAuth.mustache
- auth/OAuth.mustache

To override the code generated by the Abstract Codegen, you can create a local directory with a copy of each template,
and modify to suit your needs. Then use the ```-t``` option in Swagger Codegen to point at your local template directory.

```
java -jar modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate \
-i http://petstore.swagger.io/v2/swagger.json -l java \
-o ../swagger-retro --library=rx-abstract-httpclient-gson \
--model-package com.pets.core.petstore.data.models \
--api-package com.pets.core.petstore.data.store.api \
-DuseRxJava=true -DgenerateDefaultHttpClient=true \
-t /Users/kamartin/Desktop/Spikes/j2Objc/Hello-J2ObjC/core/templates/abstract-rx-swagger
```

Domain Module - Custom Business/App Logic
--------
Contains Business Logic, App/View Models, DTO <=> Domain Model Mapping, Consumer facing APIs.



Transpiling with J2ObjC
--------
The philosophy here is to create an ObjC STATIC LIBRARY from Java source code.
Then AFTER the J2ObjC transpilation works, import the created library into Xcode.
--model-package com.pets.core.petstore.data.models --api-package com.pets.core.petstore.data.store.api
(There are many other ways to work with J2ObjC, you can, for example, have Xcode build your
Java files on the fly, or have your Java project create a Cocoapod via j2objc-gradle,
but for a clear understanding and clean path this project favors the static library approach.)


Using Make to Transpile Dependencies
--------
The following will transpile any *-sources directory in ./deps/libs/local_src into Objective C, and then into a Static Library in the ./deps/build directory.
```
cd ./deps
make
```
To download new dependency sources jars, you can run:
Reccomended to download the *-sources.jar from maven via: ```mvn dependency:sources``` and grab the jar from M2_HOME.
Paste into raw_src_jars/ and then unzip into a folder with the same name in local_src.
NOTE: Originally this was scripted, but because we should not be adding dependencies often, the overhead of scripting a stable/flexible solution was not worth it.

Using Make to Transpile Core Code
--------
```
cd ./core/petstore/data
make
```

Setup JAVA Project and run J2ObjC
----------------------------------
* IN PROGRESS *

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
* TODO *
The second part is to use the static library you created in Xcode with an iOS project.

See the [ios/README.md](./ios/README.md).




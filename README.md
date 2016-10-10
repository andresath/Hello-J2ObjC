Hello J2ObjC
============


Overview
--------
Sample project for getting started with J2ObjC.

Uses [IDEA](https://www.jetbrains.com/idea/), [J2ObjC](http://j2objc.org/),
[j2objc-gradle](https://github.com/j2objc-contrib/j2objc-gradle),
and [Xcode](https://developer.apple.com/xcode/).

The philosophy here is to create an ObjC STATIC LIBRARY from Java source code.
Then AFTER the J2ObjC transpilation works, import the created library into Xcode.
--model-package com.pets.core.petstore.data.models --api-package com.pets.core.petstore.data.store.api
(There are many other ways to work with J2ObjC, you can, for example, have Xcode build your
Java files on the fly, or have your Java project create a Cocoapod via j2objc-gradle,
but for a clear understanding and clean path this project favors the static library approach.)

This project uses a forked version of Swagger Codegen that generates a custom type of Service Client where
the HTTPClient is simply an interface to be defined and injected by consumer of the APIs. To run the generator:
Clone the Swagger Fork from:

```
cd swagger-codegen
mvn clean package
```

Then you can use the new generator via the following command:
```
java -jar modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate \
-i http://petstore.swagger.io/v2/swagger.json \
-l java -o ../swagger-retro --library=rx-abstract-httpclient-gson \
--model-package com.pets.core.petstore.data.models \
--api-package com.pets.core.petstore.data.store.api \
-DuseRxJava=true -t /Users/kamartin/Desktop/Spikes/j2Objc/Hello-J2ObjC/core/templates/abstract-rx-swagger
```

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




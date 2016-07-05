Hello J2ObjC
============


Overview
--------
Sample project for getting started with J2ObjC.

Uses IDEA, [J2ObjC](http://j2objc.org/),
[j2objc-gradle](https://github.com/j2objc-contrib/j2objc-gradle) plugin,
and [XCode](https://developer.apple.com/xcode/) and includes required libs.


Setup
-----
* Download and unzip J2ObjC.
* Set J2OBJC_HOME as an env var (```export J2OBJC_HOME=<your dir>```).
* Make sure J2ObjC works (```cd $J2OBJC_HOME``` >  ```j2objc -version```).
*




NOTE all steps to setup, etc

NOTE approach - use j2objc-gradle to create a STATIC LIBRARY
then include that library in an iOS project manually (plugin xcode doesn't work, building the library/java from xcode is dumb)

NOTE iOS dir

NOTE libs version of j2objc-gradle plugin
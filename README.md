# Android Clean Architecture Boilerplate

[![License Apache 2.0](https://img.shields.io/badge/license-Apache%202.0-green.svg)](https://github.com/fjoglar/android-clean-architecture-boilerplate/blob/master/LICENSE)
[![fjoglar twitter](https://img.shields.io/badge/twitter-@felipejoglar-blue.svg)](http://twitter.com/felipejoglar)
[![Platform Android](https://img.shields.io/badge/platform-Android-blue.svg)](https://www.android.com)

This is intended to be a base project to be used as a base when starting a new project.


## Languages, libraries and tools used

* [Java](https://docs.oracle.com/javase/8/)
* Android Support Libraries
* [RxJava2](https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0)


## Requirements

* JDK 1.8
* [Android SDK](https://developer.android.com/studio/index.html)
* Android O ([API 26](https://developer.android.com/preview/api-overview.html))
* Latest Android SDK Tools and build tools.


## Getting started

First clone the boilerplate repository. Next, if you want to copy the boilerplate into your own repository follow _Clone into your own repository_.
If you just want to get started with customising things for your own project skip onto _Make it your own_.

### Clone into your own repository

Follow these steps if you have a repository with a branch you'd like to copy the boilerplate project into:
```
$ cd <path to boilerplate>
$ git remote add newrepo <path to newrepo>
$ git checkout --orphan copy
$ git commit -m "Copying boilerplate"
$ git push newrepo copy:<branch on new repo>
```
This will copy the boilerplate project without history to your own branch in your repository.

### Make it your own

Personalise the boilerplate for your own project:

1. Rename `com.fjoglar.android.boilerplate` packages to your own domain's stucture. E.g `com.mydomain.myapp`.
    See [StackOverflow](http://stackoverflow.com/a/29092698) for steps to easily accomplish this in Android Studio.

2. Open `app/build.gradle` and change the following to match your new package names:
    * `applicationId "com.mydomain.myapp"`
    * `testInstrumentationRunner "com.mydomain.myapp.application.ApplicationTestRunner"`


## References

Thanks to the devs involved with these repos!

- https://github.com/android10/Android-CleanArchitecture

- https://github.com/googlesamples/android-architecture

- https://github.com/ustwo/android-boilerplate


## License

```
Copyright 2017 Felipe Joglar Santos

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
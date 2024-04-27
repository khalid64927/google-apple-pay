/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("io.github.khalid64927.gradle.multiplatform.mobile")
    id("io.github.khalid64927.gradle.publication")
    id("io.github.khalid64927.gradle.stub.javadoc")
    id("io.github.khalid64927.gradle.detekt")
    id("com.diffplug.spotless")
}

android {
    namespace = "com.khalid.multiplatform.googleapple.payments"

    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
}

dependencies {
    commonMainImplementation(libs.coroutines)
    androidMainImplementation(libs.appCompat)
    androidMainImplementation(libs.lifecycle)
    androidMainImplementation(libs.lifecycleRuntime)

    // Google Pay
    androidMainImplementation(libs.gwallet)
    androidMainImplementation(libs.google.pay.button)
    androidMainImplementation(libs.kotlinx.coroutines.play.services)
}



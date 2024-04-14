/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("dev.icerock.moko.gradle.multiplatform.mobile")
    id("dev.icerock.moko.gradle.publication")
    id("dev.icerock.moko.gradle.stub.javadoc")
    id("dev.icerock.moko.gradle.detekt")
    id("com.diffplug.spotless")
}

android {
    namespace = "com.khalid.multiplatform.googleapple.payments"

    compileSdk = libs.versions.compileSDK.get().toInt()
    defaultConfig {
        minSdk = libs.versions.minSDK.get().toInt()
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



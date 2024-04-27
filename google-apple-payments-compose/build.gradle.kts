/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("io.github.khalid64927.gradle.multiplatform.mobile")
    id("io.github.khalid64927.gradle.publication")
    id("io.github.khalid64927.gradle.stub.javadoc")
    id("io.github.khalid64927.gradle.detekt")
    id("org.jetbrains.compose")
    id("com.diffplug.spotless")
}

android {
    namespace = "com.khalid.multiplatform.googleapple.payments.compose"

    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
}

dependencies {
    commonMainApi(projects.googleApplePayments)
    commonMainApi(compose.runtime)

    androidMainImplementation(libs.appCompat)
    androidMainImplementation(libs.composeActivity)
}

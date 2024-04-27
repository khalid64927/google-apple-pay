/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("io.github.khalid64927.gradle.multiplatform.mobile")
    id("dev.icerock.mobile.multiplatform.ios-framework")
    id("io.github.khalid64927.gradle.detekt")
    id("com.diffplug.spotless")
}

dependencies {
    commonMainApi(libs.mokoMvvmCore)
    commonMainApi(projects.googleApplePayments)
    commonTestImplementation(libs.mokoMvvmTest)
}

android {
    namespace = "com.icerockdev.library"
}

framework {
    export(projects.googleApplePayments)
    export(libs.mokoMvvmCore)
}

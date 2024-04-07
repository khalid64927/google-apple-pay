/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("dev.icerock.moko.gradle.multiplatform.mobile")
    id("dev.icerock.mobile.multiplatform.ios-framework")
    id("dev.icerock.moko.gradle.detekt")
    id("com.diffplug.spotless")
}

dependencies {
    commonMainApi(libs.mokoMvvmCore)
    commonMainApi(projects.googleApplePayments)
    commonTestImplementation(libs.mokoMvvmTest)
}

framework {
    export(projects.googleApplePayments)
    export(libs.mokoMvvmCore)
}

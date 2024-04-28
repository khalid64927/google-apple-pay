/*
 * Copyright 2024 Mohammed Khalid Hamid.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.diffplug.gradle.spotless.SpotlessExtension

buildscript {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    dependencies {
        classpath(libs.kotlinGradlePlugin)
        classpath(libs.androidGradlePlugin)
        classpath(libs.khalidGradlePlugin)
        classpath(libs.mobileMultiplatformGradlePlugin)
        classpath(libs.kotlinSerializationGradlePlugin)
        classpath(libs.composeJetBrainsGradlePlugin)
        classpath(libs.detektGradlePlugin)
        classpath(libs.spotlessPlugin)
    }
}

apply(plugin = "io.github.khalid64927.gradle.publication.nexus")
apply(plugin = "com.diffplug.spotless")
configure<SpotlessExtension>{
    kotlin {
        target("**/*.kt")
        licenseHeaderFile(project.rootProject.file("Copyright.txt"))
    }

}




val paymentsVersion = libs.versions.khalidPaymentsVersion.get()
allprojects {
    group = "io.github.khalid64927"
    version = paymentsVersion

}
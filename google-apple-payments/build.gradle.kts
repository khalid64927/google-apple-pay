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

plugins {
    id("io.github.khalid64927.gradle.multiplatform.mobile")
    id("io.github.khalid64927.gradle.publication")
    id("io.github.khalid64927.gradle.stub.javadoc")
}

android {
    namespace = "com.khalid.multiplatform.googleapple.payments"

    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
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


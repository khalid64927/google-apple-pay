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
    id("io.github.khalid64927.gradle.android.application")
    id("org.jetbrains.compose")
}

android {
    compileSdk = 34
    namespace = "com.khalid.googlepay.compose.app"
    defaultConfig {
        applicationId = "com.khalid.googlepay.compose.app"
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.coroutines)
    implementation(libs.lifecycleRuntime)
    implementation(libs.lifecycleCompose)
    implementation(libs.lifecycle)
    implementation(libs.composeActivity)
    implementation(libs.appCompat)
    implementation(libs.gwallet)
    implementation(libs.google.pay.button)
    implementation(libs.coreKtx)
    implementation(libs.material)
    api(projects.sample.mppLibrary)
    api(projects.googleApplePaymentsCompose)
    implementation(libs.androidx.material3)
    implementation(libs.foundation.layout.android)
    implementation(libs.foundation.android)
}

plugins {
    id("dev.icerock.moko.gradle.android.application")
    id("dev.icerock.moko.gradle.detekt")
    id("org.jetbrains.compose")
    id("com.diffplug.spotless")
}

android {
    compileSdk = 34
    defaultConfig {
        applicationId = "com.khalid.googlepay.compose.app"
        minSdk = 24
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



plugins {
    id("io.github.khalid64927.gradle.android.application")
    id("io.github.khalid64927.gradle.detekt")
    id("kotlin-kapt")
    id("com.diffplug.spotless")
}

android {
    buildFeatures.dataBinding = true
    buildFeatures.viewBinding = true
    namespace = "com.khalid.googlepay.app"

    compileSdk = 34
    defaultConfig {
        minSdk = 24
        applicationId = "com.khalid.googlepay.app"
        versionCode = 1
        versionName = "0.1.0"
    }

}


dependencies {
    implementation(libs.appCompat)
    implementation(libs.gwallet)
    implementation(libs.coreKtx)
    implementation(libs.material)
    api(projects.sample.mppLibrary)
}

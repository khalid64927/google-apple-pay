

plugins {
    id("dev.icerock.moko.gradle.android.application")
    id("dev.icerock.moko.gradle.detekt")
    id("kotlin-kapt")
    id("com.diffplug.spotless")
}

android {
    buildFeatures.dataBinding = true
    buildFeatures.viewBinding = true

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

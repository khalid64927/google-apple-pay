buildscript {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    dependencies {
        classpath(libs.kotlinGradlePlugin)
        classpath(libs.androidGradlePlugin)
        classpath(libs.mokoGradlePlugin)
        classpath(libs.mobileMultiplatformGradlePlugin)
        classpath(libs.kotlinSerializationGradlePlugin)
        classpath(libs.composeJetBrainsGradlePlugin)
        classpath(libs.detektGradlePlugin)
        classpath(libs.spotlessPlugin)
    }
}

apply(plugin = "dev.icerock.moko.gradle.publication.nexus") // TODO: change
val paymentsVersion = libs.versions.paymentsLibVersion.get()
allprojects {
    group = "io.github.khalid64927" // TODO: change
    version = paymentsVersion
}
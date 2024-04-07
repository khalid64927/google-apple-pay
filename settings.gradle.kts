enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
    }
}

include(":sample:android-app")
include(":sample:compose-android-app")
include(":sample:mpp-library")
include(":google-apple-payments")
include(":google-apple-payments-compose")

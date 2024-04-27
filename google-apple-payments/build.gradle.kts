import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.variant.LibraryVariant
import java.util.Base64

plugins {
    id("dev.icerock.moko.gradle.multiplatform.mobile")
    id("dev.icerock.moko.gradle.stub.javadoc")
    id("dev.icerock.moko.gradle.detekt")
    id("com.diffplug.spotless")
    id("maven-publish")
    id("signing")

}

android {
    namespace = "com.khalid.multiplatform.googleapple.payments"
    compileSdk = libs.versions.compileSDK.get().toInt()
    defaultConfig {
        minSdk = libs.versions.minSDK.get().toInt()
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

publishing {
    val libraryName: String = requiredStringProperty("publish.name")
    val description: String = requiredStringProperty("publish.description")
    val gitHubOrganization: String = requiredStringProperty("publish.repo.org")
    val gitHubName: String = requiredStringProperty("publish.repo.name")
    val license: String = requiredStringProperty("publish.license")
    val developersString: String = requiredStringProperty("publish.developers")
    val gitHubUrl = "https://github.com/$gitHubOrganization/$gitHubName"
    val sshUrl = "scm:git:ssh://github.com/$gitHubOrganization/$gitHubName.git"
    val developersList: List<Developer> = developersString.split(",").map { parseDeveloper(it) }

    publications {
        create<MavenPublication>("maven") {
            artifactId = "google-apple-payments"
            // Customize the POM metadata
            pom {
                this.name.set(libraryName)
                this.description.set(description)
                this.url.set(gitHubUrl)
                licenses {
                    license {
                        this.name.set(license)
                        this.distribution.set("repo")
                        this.url.set("$gitHubUrl/blob/master/LICENSE.md")
                    }
                }

                developers {
                    developersList.forEach { dev ->
                        developer {
                            id.set(dev.id)
                            name.set(dev.name)
                            email.set(dev.email)
                        }
                    }
                }

                scm {
                    this.connection.set(sshUrl)
                    this.developerConnection.set(sshUrl)
                    this.url.set(gitHubUrl)
                }
            }
        }
    }

    repositories.maven("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/") {
        name = "OSSRH"
        credentials {
            username = System.getenv("OSSRH_USER")
            password = System.getenv("OSSRH_KEY")
        }
    }
}

//signing {
//
//    val signingKeyId: String? = System.getenv("SIGNING_KEY_ID")
//    val signingPassword: String? = System.getenv("SIGNING_PASSWORD")
//    val signingKey: String? = System.getenv("SIGNING_KEY")?.let { base64Key ->
//        String(Base64.getDecoder().decode(base64Key))
//    }
//    println("signingKeyId : $signingKeyId")
//    println("signingKey : $signingKeyId")
//    println("signingKeyId  Encoded : ${System.getenv("SIGNING_KEY")}")
//    println("signingKeyId  decoded : $signingKeyId")
//
//    if (signingKeyId != null && signingPassword != null && signingKey != null) {
//        useInMemoryPgpKeys(signingKeyId, signingKey, signingPassword)
//
//        // Sign all publications
//        println("Sign all publications")
//        publishing.publications.forEach {
//            println("publication name: ${it.name}")
//            //sign(it.name)
//            //sign(it)
//        }
//
//        println("publishing publications: ${publishing.publications}")
//        println("configurations archives: ${configurations.archives.name}")
//        //sign(publishing.publications)
//        //sign(configurations.runtimeOnly.name)
//        sign(configurations.archives.name)
//
//    }
//}




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

fun <T> Project.requiredProperty(name: String, mapper: (Any) -> T): T {
    val propertyName = "moko.$name"
    val anyValue: Any = property(propertyName)
        ?: throw GradleException("Required property $propertyName not defined!")

    return try {
        mapper(anyValue)
    } catch (exc: Exception) {
        throw GradleException("Can't map property $propertyName to required type", exc)
    }
}

fun Project.requiredIntProperty(name: String): Int {
    return requiredProperty(name) { it.toString().toInt() }
}

fun Project.requiredStringProperty(name: String): String {
    return requiredProperty(name) { it.toString() }
}

fun parseDeveloper(text: String): Developer {
    val items: List<String> = text.split("|").map { it.trim() }
    if (items.size != 3) throw GradleException("Developer profile should have 3 parts with | delimiter. For example: alex009|Aleksey Mikhailov|Aleksey.Mikhailov@icerockdev.com")
    return Developer(
        id = items[0],
        name = items[1],
        email = items[2]
    )
}

data class Developer(
    val id: String,
    val name: String,
    val email: String,
)


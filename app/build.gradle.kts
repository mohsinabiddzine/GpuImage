plugins {
    id("com.android.library")
    id("maven-publish")
}


android {
    namespace = "com.dzm.gpuimage"
    compileSdk = 36
    ndkVersion = "29.0.14033849"

    defaultConfig {
        minSdk = 24
        targetSdk = 36

        // no applicationId here ⬅️ only in apps
        ndk {
            abiFilters += listOf("armeabi-v7a", "arm64-v8a", "x86", "x86_64")
        }
    }

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
}


publishing {
    publications {
        create<MavenPublication>("release") {
            from(components["release"])
            groupId = "com.github.mohsinabiddzine"
            artifactId = "gpuimage"
            version = "2.1.1-aligned"
        }
    }
}


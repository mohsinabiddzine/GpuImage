plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    namespace = "com.dzm.gpuimage"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
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

    // 👇 Important: this tells AGP to register the release variant for publishing
    publishing {
        singleVariant("release")
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                // AGP will provide the "release" component only after evaluation
                from(components["release"])
                groupId = "com.github.mohsinabiddzine"
                artifactId = "gpuimage"
                version = "2.1.1-aligned"
            }
        }
    }
}

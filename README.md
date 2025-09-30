# GpuImage (16KB aligned fork)

This is a fork of [CyberAgent's GPUImage for Android](https://github.com/CyberAgent/android-gpuimage), updated to work with the latest **Gradle / AGP / NDK** and aligned to **16KB** requirements.

## Installation

Add JitPack to your repositories:

```gradle
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
dependencies {
    implementation("com.github.mohsinabiddzine:GpuImage:2.1.3-aligned")
}

package io.github.vishalecho.gradle

object Constants {
    const val applicationId = "io.github.vishalecho.android.carousellnews"
    const val AndroidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Versions {
    const val minSdk = 19
    const val targetSdk = 30
    const val compileSdk = 30
    const val buildTools = "29.0.3"
    const val jvmTarget = "1.8"
    const val versionCode = 1
    const val versionName = "1.0.0"

    const val kotlin = "1.3.72"
    const val gradle = "4.0.0"
    const val core_ktx = "1.3.0"
    const val appcompat = "1.1.0"
    const val constraintlayout = "1.1.3"
    const val recyclerview = "1.1.0"
    const val material = "1.2.0-beta01"

    const val junit = "4.13"
    const val junitX = "1.1.1"
    const val espresso_coreX = "3.2.0"
 }

object Libs {
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraintlayout= "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val material = "com.google.android.material:material:${Versions.material}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
    const val junitX = "androidx.test.ext:junit:${Versions.junitX}"
    const val espresso_coreX = "androidx.test.espresso:espresso-core:${Versions.espresso_coreX}"
}

object Modules {
    const val app = ":app"
    const val core = ":core"
}

object MavenUrls {
    const val fabric_public = "https://maven.fabric.io/public"
    const val jitpack_io = "https://jitpack.io"
    const val commons_ware = "https://s3.amazonaws.com/repo.commonsware.com"
}

object GradlePlugins {
    const val android_gradle_build = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Plugins {
    const val android_application = "com.android.application"
    const val android_library = "com.android.library"
    const val kotlin_android = "kotlin-android"
    const val kotlin_kapt = "kotlin-kapt"
    const val kotlin_android_extensions = "kotlin-android-extensions"
}
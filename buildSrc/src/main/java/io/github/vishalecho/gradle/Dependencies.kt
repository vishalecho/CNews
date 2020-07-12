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
    const val versionCode = 1
    const val versionName = "1.0.0"

    const val kotlin = "1.3.72"
    const val gradle = "4.0.0"
    const val support = "1.0.0"
    const val core_ktx = "1.3.0"
    const val appcompat = "1.1.0"
    const val constraintlayout = "1.1.3"
    const val recyclerview = "1.1.0"
    const val cardView = "1.0.0"
    const val material = "1.2.0-beta01"
    const val lifecycle = "2.0.0"
    const val rxJava = "2.1.7"
    const val rxAndroid = "2.0.1"
    const val dagger = "2.26"
    const val gson = "2.8.2"
    const val stetho = "1.5.0"
    const val retrofit = "2.3.0"
    const val gsonConverter = ""
    const val okhttp = "3.9.0"
    const val retrofitRxAdapter = "1.0.0"
    const val preference = "1.1.1"
    const val room = "2.0.0"
    const val jodaTime = "2.9.9"

    const val junit = "4.13"
    const val junitX = "1.1.1"
    const val espresso_coreX = "3.2.0"
 }

object Libs {
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val kotlin_stdlib8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val support = "androidx.legacy:legacy-support-v4:${Versions.support}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraintlayout= "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardView}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val gson ="com.google.code.gson:gson:${Versions.gson}"
    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
    const val stetho_okhttp3 = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val retrofitRxAdapter = "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:${Versions.retrofitRxAdapter}"
    const val preference_ktx = "androidx.preference:preference-ktx:${Versions.preference}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomRx = "androidx.room:room-rxjava2:${Versions.room}"
    const val jodaTime = "joda-time:joda-time:${Versions.jodaTime}"
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
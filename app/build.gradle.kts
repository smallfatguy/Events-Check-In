plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.belimov.CftEventsRegistrator"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release"){
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.31")
    implementation("androidx.appcompat:appcompat:1.1.0-alpha05")
    implementation("androidx.core:core-ktx:1.0.2")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0-alpha05")
    implementation("com.google.android.material:material:1.0.0")

    implementation("androidx.room:room-runtime:2.1.0-alpha07")
    annotationProcessor("androidx.room:room-compiler:2.1.0-alpha07")
    kapt("androidx.room:room-compiler:2.1.0-rc01")

    implementation("com.google.dagger:dagger:2.19")
    kapt("com.google.dagger:dagger-compiler:2.19")
    implementation("com.google.dagger:dagger-android:2.19")
    implementation("com.google.dagger:dagger-android-support:2.19")
    kapt ("com.google.dagger:dagger-android-processor:2.19")

    implementation("io.reactivex.rxjava2:rxjava:2.2.6")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxkotlin:2.3.0")

    implementation("com.squareup.retrofit2:retrofit:2.4.0")
    implementation("com.squareup.retrofit2:converter-gson:2.4.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.3.0")
    implementation("com.squareup.okhttp3:logging-interceptor:3.6.0")

    implementation("com.arello-mobile:moxy:1.5.5")
    kapt("com.arello-mobile:moxy-compiler:1.5.5")
    implementation("com.arello-mobile:moxy-app-compat:1.5.5")

    implementation("com.squareup.picasso:picasso:2.5.2")

    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1")
}

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")

}

android {
    namespace = "com.hfad.animeapi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hfad.animeapi"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
    }


    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    testImplementation("junit:junit:4.12")
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Retrofit -> Network
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    //OkHttp
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

    //GSON
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.retrofit2:converter-gson:2.10.0")

    //Hilt
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")



    //--------------ViewModel Test dependencies-----------------

    // Dependency: Mockito is a mocking framework that allows you to create and configure mock objects.
    testImplementation ("org.mockito:mockito-core:3.11.2")

    //Dependency: Mockito Kotlin library, which provides some Kotlin-specific features.
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")

    //Dependency: Ensures access to Mockito's "inline" functionality
    testImplementation ("org.mockito:mockito-inline:3.11.2")

    //Dependency: Ensures that you have access to testing utilities specifically
    //testing Kotlin coroutines in your test code.
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.0")

    //Dependency: provides utilities for android architecture components:
    //Offers classes and methods that facilitate testing of components like LiveData,
    // ViewModel, Room, and other architectural elements in Android apps.
    testImplementation ("androidx.arch.core:core-testing:2.1.0")
}
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt") // This applies the kapt plugin
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.choimaro.compose_study"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.choimaro.compose_study"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        dataBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val kotlinVersion: String by project
    val hiltVersion: String by project
    val splashScreenVersion = "1.0.1"

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(project(":data"))
    implementation(project(":domain"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion")
    implementation (libs.androidx.appcompat)
    implementation (libs.androidx.core.ktx)
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")

    // Splash Screen
    implementation("androidx.core:core-splashscreen:$splashScreenVersion")

    // Okhttp
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("org.json:json:20220320")

    // Hilt
    implementation("com.google.dagger:hilt-android:${hiltVersion}")
    kapt("com.google.dagger:hilt-compiler:${hiltVersion}")

    // Navigation
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    val nav_version = "2.7.7"

    implementation("androidx.navigation:navigation-compose:$nav_version")
}
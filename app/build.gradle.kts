plugins {
    id("com.android.application") version "8.6.1"
    id("com.google.gms.google-services")
}

android {
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 23
        targetSdk = 33
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

    // Enable View Binding in Kotlin DSL
    viewBinding {
        enable = true
    }

    // Enable BuildConfig generation explicitly in Kotlin DSL
    buildFeatures {
        buildConfig = true
    }

    namespace = "com.example.myapplication"
}

dependencies {
    implementation(platform("com.google.firebase:firebase-bom:33.3.0"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-database-ktx")
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.firebase:firebase-storage-ktx")

    implementation("androidx.drawerlayout:drawerlayout:1.1.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.6.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.6.0")
    implementation("androidx.core:core-ktx:1.10.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.5.1")
    implementation ("androidx.lifecycle:lifecycle-livedata:2.5.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
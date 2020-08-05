plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(AndroidSdk.compileSdk)

    defaultConfig {
        applicationId = "gst.trainingcourse.sampleproject"
        minSdkVersion(AndroidSdk.minSdk)
        targetSdkVersion(AndroidSdk.targetSdk)
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlinStdLib)
    implementation(Libs.coreKtx)
    implementation(Libs.appCompat)
    implementation(Libs.constraintLayout)

    // dagger
    implementation(Libs.daggerHilt)
    implementation(Libs.daggerHiltKtx)
    kapt(Libs.daggerKapt)
    kapt(Libs.daggerKaptKtx)

    // ktx
    implementation(Libs.viewModelKtx)
    implementation(Libs.fragmentKtx)

    // paging
    implementation(Libs.paging3)

    // room
    implementation(Libs.roomKtx)
    implementation(Libs.roomDatabase)
    kapt(Libs.roomKapt)

    // retrofit
    implementation(Libs.retrofit)
    implementation(Libs.jsonConverter)

    // coroutine
    implementation(Libs.coroutineCore)
    implementation(Libs.coroutineAndroid)

    // logging okhttp3
    implementation(Libs.loggingInterceptor)

    // picasso
    implementation(Libs.picasso)

    testImplementation(TestLibs.junit)
    androidTestImplementation(TestLibs.extJunit)
    androidTestImplementation(TestLibs.espressoCore)

}
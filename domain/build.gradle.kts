plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}
android {
    compileSdkVersion(AndroidSdk.compileSdk)

    defaultConfig {
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
}


dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlinStdLib)
    implementation(Libs.coreKtx)
    implementation(Libs.appCompat)
    testImplementation(TestLibs.junit)
    androidTestImplementation(TestLibs.extJunit)
    androidTestImplementation(TestLibs.espressoCore)

}
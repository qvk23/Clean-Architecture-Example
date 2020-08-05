object App {
    const val kotlinVersion = "1.3.72"
    const val buildToolsVersion = "3.3.1"
}

object AndroidSdk {
    const val minSdk = 24
    const val targetSdk = 29
    const val compileSdk = 29
    const val versionCode = 1
    const val versionName = "1.0"
}

object Libs {
    private object Version {
        const val constraintLayout = "1.1.3"
        const val ktx = "1.3.0"
        const val appCompat = "1.1.0"
        const val roomDatabase = "2.3.0-alpha01"
        const val retrofit = "2.9.0"
        const val coroutine = "1.3.8"
        const val paging3 = "3.0.0-alpha04"
        const val daggerHilt = "2.28-alpha"
        const val daggerHiltViewModel = "1.0.0-alpha01"
        const val loggingInterceptor = "4.2.2"
        const val lifeCycle = "2.2.0"
        const val fragmentKtx = "1.2.5"
        const val koin = "2.1.6"
        const val picasso = "2.71828"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${App.kotlinVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    const val coreKtx = "androidx.core:core-ktx:${Version.ktx}"

    const val roomDatabase = "androidx.room:room-runtime:${Version.roomDatabase}"
    const val roomKtx = "androidx.room:room-ktx:${Version.roomDatabase}"
    const val roomKapt = "androidx.room:room-compiler:${Version.roomDatabase}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val jsonConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"

    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutine}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutine}"

    const val paging3 = "androidx.paging:paging-runtime:${Version.paging3}"

    const val daggerHilt = "com.google.dagger:hilt-android:${Version.daggerHilt}"
    const val daggerKapt = "com.google.dagger:hilt-android-compiler:${Version.daggerHilt}"
    const val daggerHiltKtx = "androidx.hilt:hilt-lifecycle-viewmodel:${Version.daggerHiltViewModel}"
    const val daggerKaptKtx = "androidx.hilt:hilt-compiler:${Version.daggerHiltViewModel}"

    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Version.fragmentKtx}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifeCycle}"

    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.loggingInterceptor}"

    const val koin = "org.koin:koin-core:${Version.koin}"
    const val koinAndroidx = "org.koin:koin-androidx-viewmodel:${Version.koin}"

    const val picasso = "com.squareup.picasso:picasso:${Version.picasso}"
}

object TestLibs {
    private object Version {
        const val junit = "4.12"
        const val extJunit = "1.1.1"
        const val espressoCore = "3.2.0"
    }

    const val junit = "junit:junit:${Version.junit}"
    const val extJunit = "androidx.test.ext:junit:${Version.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
}
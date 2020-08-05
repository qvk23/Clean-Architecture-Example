
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
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${App.kotlinVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    const val coreKtx = "androidx.core:core-ktx:${Version.ktx}"
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
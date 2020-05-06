object Versions {
    const val targetSdkVersion = 29
    const val compileSdkVersion = 29
    const val minSdkVersion = 21
    const val buildToolsVersion = "29.0.2"

    const val versionCode = 1
    const val versionName = "1.0"

    const val kotlinVersion = "1.3.72"
    const val coreKtx = "1.2.0"
    const val lifecycle = "2.2.0"
    const val junit = "4.12"
    const val espresso = "3.2.0"
    const val appCompat = "1.1.0"
    const val legacySupport = "1.0.0"

    const val coroutines = "1.3.5"
    const val room = "2.2.5"
    const val materialComponent = "1.2.0-alpha06"
    const val dagger = "2.27"
    const val navigation = "2.3.0-alpha06"
    const val constraintLayout = "2.0.0-beta4"
    const val gson = "2.8.5"
    const val gradle = "3.6.0"
    const val testExt = "1.1.1"
    const val materialStepper = "4.3.1"
    const val safeArgs = "2.2.2"
    const val niceSpinner = "1.4.5"
    const val rxPermissions = "0.10.2"
    const val fresco = "2.2.0"
    const val rxJava = "2.2.10"
    const val glide = "4.11.0"
    const val googleMaps = "16.1.0"
}

object ClassPaths {
    const val gradleVersion = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val safeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.safeArgs}"
}

object CoreDependencies {
    const val packageName = "com.example.cleanWithCoRoutine"

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui:${Versions.navigation}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
    const val kotlinStd = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
}

object TestDependencies {
    const val junit = "junit:junit:${Versions.junit}"
}

object AndroidTestDependencies {
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val textExt = "androidx.test.ext:junit:${Versions.testExt}"
}

object ViewDependencies {
    const val materialComponent =
        "com.google.android.material:material:${Versions.materialComponent}"
    const val materialStepper = "com.stepstone.stepper:material-stepper:${Versions.materialStepper}"
    const val niceSpinner = "com.github.arcadefire:nice-spinner:${Versions.niceSpinner}"
    const val fresco = "com.facebook.fresco:fresco:${Versions.fresco}"
}

object DependencyInjectionDependencies {
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerAndroidProcessor =
        "com.google.dagger:dagger-android-processor:${Versions.dagger}"
}

object PersistenceDependencies {
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
}

object UtilityDependencies {
    const val rxPermissions = "com.github.tbruyelle:rxpermissions:${Versions.rxPermissions}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideProcessor = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val googleMaps = "com.google.android.gms:play-services-maps:${Versions.googleMaps}"
}
plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    buildFeatures {
        dataBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dep.Compose.version
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":features:core-ui"))
    implementation(project(":shared"))

    implementation(Dep.AndroidX.core)
    implementation(Dep.AndroidX.appcompat)
    implementation(Dep.AndroidX.fragment)
    implementation(Dep.AndroidX.material)
    implementation(Dep.AndroidX.Lifecycle.viewModel)
    implementation(Dep.AndroidX.recyclerview)
    implementation(Dep.AndroidX.browser)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation(Dep.Compose.ui)
    implementation(Dep.Compose.material)
    implementation(Dep.Compose.tooling)
    implementation(Dep.Compose.themeAdapter)
    implementation(Dep.Compose.liveData)

    implementation(Dep.Coil.compose)

    implementation(Dep.Kotlin.dateTime)

    implementation(Dep.Dagger.hiltAndroid)
    kapt(Dep.Dagger.hiltCompiler)

    implementation(Dep.timber)

    testImplementation(Dep.Test.junit)
    androidTestImplementation(Dep.Test.junitExt)
    androidTestImplementation(Dep.Test.espresso)
}
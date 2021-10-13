plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
}

android {
}

dependencies {
    implementation(Dep.inject)

    implementation(Dep.Kotlin.coroutine)
    implementation(Dep.Kotlin.dateTime)
    implementation(Dep.Kotlin.serialization)
}
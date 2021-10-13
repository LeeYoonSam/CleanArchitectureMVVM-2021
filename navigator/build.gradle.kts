plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
}

dependencies {
    implementation (project(":shared"))

    testImplementation(Dep.Test.junit)
    androidTestImplementation(Dep.Test.junitExt)
    androidTestImplementation(Dep.Test.espresso)
}
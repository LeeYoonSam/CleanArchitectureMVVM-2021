package dependencies

object Versions {
    const val compileSdk = 31
    const val buildTools = "30.0.3"

    const val minSdk = 23
    const val targetSdk = 31
    const val versionCode = 1
    const val versionName = "0.0.0"
}

object Dep {
    object AndroidX {
        const val lifecycleVersion = "2.4.0-beta01"
        const val core = "androidx.core:core-ktx:1.6.0"
        const val appcompat = "androidx.appcompat:appcompat:1.3.1"
        const val activity = "androidx.activity:activity-ktx:1.3.0"
        const val fragment = "androidx.fragment:fragment-ktx:1.3.6"
        const val material = "com.google.android.material:material:1.4.0"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"

        const val activityCompose = "androidx.activity:activity-compose:1.3.0-rc02"

        object Navigation {
            private const val version = "2.3.5"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
        }
    }

    object Compose {
        const val version = "1.0.1"
        const val ui = "androidx.compose.ui:ui:$version"
        const val material = "androidx.compose.material:material:$version"
        const val tooling = "androidx.compose.ui:ui-tooling:$version"

        const val themeAdapter = "com.google.android.material:compose-theme-adapter:$version"
    }

    object Kotlin {
        const val version = "1.5.21"
    }

    object Dagger {
        const val hiltVersion = "2.38.1"
        const val hiltAndroid = "com.google.dagger:hilt-android:$hiltVersion"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:$hiltVersion"
    }

    object Accompanist {
        private const val version = "0.13.0"
        const val coil = "com.google.accompanist:accompanist-coil:$version"
        const val flowLayout = "com.google.accompanist:accompanist-flowlayout:$version"
        const val pager = "com.google.accompanist:accompanist-pager:$version"
        const val pagerIndicators = "com.google.accompanist:accompanist-pager-indicators:$version"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val junitExt = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
    }

    const val timber = "com.jakewharton.timber:timber:5.0.1"
    const val inject = "javax.inject:javax.inject:1"
}
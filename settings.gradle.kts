pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("com.android.application") version "7.1.0-alpha13"
        id("com.android.library") version "7.1.0-alpha13"
        id("org.jetbrains.kotlin.android") version "1.5.30"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "CleanArchitectureMVVM-2021"
include(":app")
include(":data")
include(":domain")
include(":features")
include(":features:ui-core")
include(":features:ui-core-compose")
include(":features:home")
include(":features:schedule")
include(":features:setting")
include(":features:detail")
include(":navigator")
include(":shared")

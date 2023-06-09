pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Gallery App"
include(":app")
include(":core:storage")
include(":core:model")
include(":core:common")
include(":core:data")
include(":core:domain")
include(":core:designsystem")
include(":feature:pictures")
include(":core:ui")
include(":feature:videos")

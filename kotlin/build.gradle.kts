import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    java
    alias(deps.plugins.kotlinJvm)
    alias(deps.plugins.kotlinKapt)
    alias(deps.plugins.kotlinSpring)
}

allprojects {

    group = "ro.jtonic.handson"
    version = rootProject.deps.versions.appVersion.get()

    apply {
        plugin("java")
        plugin("org.jetbrains.kotlin.jvm")
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        implementation(rootProject.deps.kotlinScript)
        implementation(rootProject.deps.slf4)

        testImplementation(rootProject.deps.bundles.kotest)
    }

    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf(
                    "-Xinline-classes",
                    "-Xjsr305=strict",
                    "-Xopt-in=kotlin.RequiresOptIn",
                    "-Xopt-in=kotlin.time.ExperimentalTime",
                    "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                    "-Xopt-in=kotlinx.coroutines.FlowPreview"
                )
                jvmTarget = rootProject.deps.versions.javaTargetVersion.get()
                apiVersion = rootProject.deps.versions.kotlinApiVersion.get()
                languageVersion = rootProject.deps.versions.kotlinLangVersion.get()
            }
        }
        withType<Test> {
            useJUnitPlatform()
        }
    }
}

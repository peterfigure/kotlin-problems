import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version PluginVersions.Kotlin
    kotlin(PluginIds.KotlinKapt) version PluginVersions.Kotlin // must not have a version apparently
    id(PluginIds.TaskTree) version PluginVersions.TaskTree
    id(PluginIds.GrGit) version PluginVersions.GrGit
    id(PluginIds.TestLogger) version PluginVersions.TestLogger apply false
    id(PluginIds.DependencyUpdates) version PluginVersions.DependencyUpdates apply false
    id(PluginIds.Idea)
    id(PluginIds.SourceSets) version PluginVersions.SourceSets
    `java-library`
}

testSets {
    create("integrationTest") {
        dirName = "integration-test"
    }
}

tasks {
    "check" {
        dependsOn("integrationTest")
    }
    "integrationTest" {
        mustRunAfter("test")
        outputs.upToDateWhen { false } // force full run every time
    }
}

group = "io.ys.poc"
version = "0.1"

apply(plugin = PluginIds.DependencyUpdates)
apply(plugin = PluginIds.TestLogger)
repositories {
    mavenCentral()
}

tasks.withType<JavaCompile> {
    sourceCompatibility = JavaVersion.VERSION_11.toString()
    targetCompatibility = sourceCompatibility
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict", "-Xinline-classes", "-Xopt-in=kotlin.RequiresOptIn")
            jvmTarget = "11"
            languageVersion = "1.5"
            apiVersion = "1.5"
        }
    }
}

    configure<com.adarshr.gradle.testlogger.TestLoggerExtension> {
        theme = com.adarshr.gradle.testlogger.theme.ThemeType.STANDARD
        showCauses = true
        slowThreshold = 1000
        showSummary = true
    }

tasks.withType<Test> {
    useJUnitPlatform()
    maxHeapSize = "1G"
}


dependencies {
    implementation.let {
        // Kotlin
        it(Libraries.KotlinReflect)
        it(Libraries.KotlinStdlibJdk8)

        platform("io.arrow-kt:arrow-stack:${Versions.Arrow}")
        it(Libraries.ArrowCore)
        it(Libraries.Config4k)
        it(Libraries.KafkaClients)
        it(Libraries.KotlinLogging)
        it(Libraries.KotlinXCoRoutinesCore)
        it(Libraries.KotlinXCoRoutinesJDK8)
        it(Libraries.KotlinXSerializationCore)
        it(Libraries.LogbackClassic)
        it(Libraries.LogbackCore)
        it(Libraries.SLF4JAPI)
    }
    kapt(Libraries.ArrowMeta)

    testImplementation.let {
        it(Libraries.Kotest)
        it(Libraries.KotestAssertions)
        it(Libraries.Mockk)

        it(Libraries.KotestTestContainers)
        it(Libraries.TestContainers)
        it(Libraries.TestContainersJUnit)
        it(Libraries.TestContainersKafka)
        it(Libraries.TestContainersPostgres)
    }

    integrationTestImplementation.let {
        it(Libraries.KotestTestContainers)
        it(Libraries.TestContainers)
        it(Libraries.TestContainersJUnit)
        it(Libraries.TestContainersKafka)
        it(Libraries.TestContainersPostgres)
    }
}

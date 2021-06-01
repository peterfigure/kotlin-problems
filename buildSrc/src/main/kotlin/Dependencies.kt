object PluginIds { // please keep this sorted in sections
    // Kotlin
    const val Kotlin = "kotlin"
    const val KotlinKapt = "kapt"

    // 3rd Party
    const val DependencyUpdates = "com.github.ben-manes.versions"
    const val GrGit = "org.ajoberstar.grgit"
    const val Idea = "idea"
    const val SourceSets = "org.unbroken-dome.test-sets"
    const val TaskTree = "com.dorongold.task-tree"
    const val TestLogger = "com.adarshr.test-logger"
}

object PluginVersions { // please keep this sorted in sections
    // Kotlin
    const val Kotlin = "1.5.10"

    // 3rd Party
    const val DependencyUpdates = "0.36.0"
    const val GrGit = "4.1.0"
    const val SourceSets = "4.0.0"
    const val TaskTree = "1.5"
    const val TestLogger = "2.1.1"
}

object Versions {
    // kotlin
    const val Kotlin = PluginVersions.Kotlin
    const val KotlinXCoroutines = "1.5.0"
    const val KotlinXSerializationCore = "1.2.0"

    // 3rd Party
    const val Arrow = "0.13.2"
    const val Config4k = "0.4.2"
    const val Kafka = "2.6.1"
    const val Kotest = "4.6.0"
    const val KotestExtensions = "1.0.0"
    const val KotlinLogging = "2.0.4"
    const val Logback = "1.2.3"
    const val Mockk = "1.10.6"
    const val SLF4J = "1.7.30"
    const val TestContainers = "1.15.2"
}

object Libraries {
    // Kotlin
    const val KotlinReflect = "org.jetbrains.kotlin:kotlin-reflect"
    const val KotlinStdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    const val KotlinXCoRoutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KotlinXCoroutines}"
    const val KotlinXCoRoutinesJDK8 = "org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:${Versions.KotlinXCoroutines}"
    const val KotlinXSerializationCore = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.KotlinXSerializationCore}"

    // 3rd Party
    const val ArrowCore = "io.arrow-kt:arrow-core:${Versions.Arrow}"
    const val ArrowFx = "io.arrow-kt:arrow-fx-coroutines:${Versions.Arrow}"
    const val ArrowOptics = "io.arrow-kt:arrow-optics:${Versions.Arrow}"
    const val ArrowMeta = "io.arrow-kt:arrow-meta:${Versions.Arrow}"

    const val Config4k = "io.github.config4k:config4k:${Versions.Config4k}" // also consider hoplite
    const val KafkaClients = "org.apache.kafka:kafka-clients:${Versions.Kafka}"

    const val Kotest = "io.kotest:kotest-runner-junit5-jvm:${Versions.Kotest}"
    const val KotestAssertions = "io.kotest:kotest-assertions-core-jvm:${Versions.Kotest}"
    const val KotestTestContainers = "io.kotest.extensions:kotest-extensions-testcontainers:${Versions.KotestExtensions}"

    const val KotlinLogging = "io.github.microutils:kotlin-logging-jvm:${Versions.KotlinLogging}"
    const val LogbackClassic = "ch.qos.logback:logback-classic:${Versions.Logback}"
    const val LogbackCore = "ch.qos.logback:logback-core:${Versions.Logback}"
    const val Mockk = "io.mockk:mockk:${Versions.Mockk}"

    const val SLF4JAPI = "org.slf4j:slf4j-api:${Versions.SLF4J}"

    const val TestContainers = "org.testcontainers:testcontainers:${Versions.TestContainers}"
    const val TestContainersJUnit = "org.testcontainers:junit-jupiter:${Versions.TestContainers}"
    const val TestContainersKafka = "org.testcontainers:kafka:${Versions.TestContainers}"
    const val TestContainersPostgres = "org.testcontainers:postgresql:${Versions.TestContainers}"
}

object Locations {
}

// gradle configurations
const val api = "api"
const val implementation = "implementation"
const val runtimeOnly = "runtimeOnly"
const val testCompileOnly = "testCompileOnly"
const val testImplementation = "testImplementation"
const val testRuntimeOnly = "testRuntimeOnly"
const val developmentOnly = "developmentOnly"
const val integrationTestImplementation = "integrationTestImplementation"
const val integrationTestRuntimeOnly = "integrationTestRuntimeOnly"

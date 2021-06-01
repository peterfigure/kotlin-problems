import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import mu.KotlinLogging

private val logger = KotlinLogging.logger {  }

tailrec suspend fun monitorProcessWithRetryConfig(
    processName: String,
    createProcess: () -> Unit,
    coroutineScope: CoroutineScope,
    attempts: Long = 0L,
    // crashes compiler: https://youtrack.jetbrains.com/issue/KT-47084
    supervisor: CompletableJob = SupervisorJob().also { it.invokeOnCompletion { logger.warn("Supervision Job for process [$processName] has completed") } }
) {
    monitorProcessWithRetryConfig(processName, createProcess, coroutineScope,  attempts + 1)
}
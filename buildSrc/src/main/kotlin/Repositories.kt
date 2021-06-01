import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.artifacts.repositories.MavenArtifactRepository

fun RepositoryHandler.arrow(project: Project): MavenArtifactRepository = maven {
    url = project.uri("https://dl.bintray.com/arrow-kt/arrow-kt/")
}

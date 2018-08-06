package com.betterme.localizer

import org.gradle.api.Plugin
import org.gradle.api.Project

open class LocalizerPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val extension = project.extensions.create("localizer", LocalizerExtension::class.java, project)

        project.tasks.create("downloadTranslations", TranslationsUploaderTask::class.java) {
            it.apiToken.set(extension.apiToken)
            it.projectId.set(extension.projectId)
            it.resourcesPath.set(extension.resourcesPath).toString()
            it.exportLocale.set(extension.exportLocale)
            it.overwriteOnExport.set(extension.overwriteOnExport)
        }
    }
}
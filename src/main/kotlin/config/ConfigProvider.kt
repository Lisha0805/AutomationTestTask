package config

import config.model.ApplicationConfiguration
import config.model.Configuration
import util.ResourceConverter
import java.io.FileNotFoundException

object ConfigProvider {
    private const val APPLICATION_CONFIGURATION_FILE_PATH = "application/application_configuration.yaml"
    private const val FILE_NOT_FOUND_MESSAGE = "file not found!"

    private inline fun <reified T: Configuration> getConfiguration(fileName: String): T {
        val config: T
        try {
            config = ResourceConverter().yamlToObject(fileName, T::class.java) as T
        } catch (e: FileNotFoundException) {
            error(FILE_NOT_FOUND_MESSAGE)
        }
        return config
    }

    fun readApplicationConfiguration(): ApplicationConfiguration {
        return getConfiguration(APPLICATION_CONFIGURATION_FILE_PATH)
    }
}
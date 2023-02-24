package logger

import org.apache.log4j.Logger
import org.apache.log4j.PropertyConfigurator

internal object Logger {
    private val log: Logger = Logger.getLogger("Log")
    private const val PROPERTY_PATH = "src/main/resources/logger/log4j.properties"

    init {
        PropertyConfigurator.configure(PROPERTY_PATH)
    }

    fun fatal(message: String) {
        log.fatal(message)
    }

    fun info(message: String) {
        log.info(message)
    }
}
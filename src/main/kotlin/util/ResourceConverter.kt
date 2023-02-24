package util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import java.io.File

internal class ResourceConverter {
    private val defaultResourcePath = "src/main/resources/"
    private val yamlObjectMapper = ObjectMapper(YAMLFactory())

    fun <T> yamlToObject(filename: String, className: Class<T>): Any {
        yamlObjectMapper.findAndRegisterModules()
        return yamlObjectMapper.readValue(File("$defaultResourcePath + filename"), className)
            ?: error("Can't deserialize file to object")
    }
}
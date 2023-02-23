package context

import config.ConfigProvider
import config.model.ApplicationConfiguration

object StaticContext : BaseContext {
    private lateinit var applicationConfig: ApplicationConfiguration

    fun getBaseUrl(): String {
        return applicationConfig.baseUrl ?: error("URL should not be empty")
    }

    fun setContext() {
        if (!this::applicationConfig.isInitialized) {
            applicationConfig = ConfigProvider.readApplicationConfiguration()
        }
    }
}
package services.userdata

import api.model.UserData
import services.userdata.UserDataGenerator.generatePassword
import services.userdata.UserDataGenerator.generateUserName

internal object UserDataProvider {
    private const val DEFAULT_USER_NAME_CHAR_AMOUNT: Int = 2
    private const val DEFAULT_PASSWORD_CHAR_AMOUNT: Int = 3

    fun getUserData(): UserData {
        return UserData(
            userName = generateUserName(DEFAULT_USER_NAME_CHAR_AMOUNT),
            password = generatePassword(DEFAULT_PASSWORD_CHAR_AMOUNT)
        )
    }
}
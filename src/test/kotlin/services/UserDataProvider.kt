package services

import api.model.UserData
import services.UserDataGenerator.generatePassword
import services.UserDataGenerator.generateUserName

object UserDataProvider {
    private const val DEFAULT_USER_NAME_CHAR_AMOUNT: Int = 2
    private const val DEFAULT_PASSWORD_CHAR_AMOUNT: Int = 3

    fun getUserData(): UserData {
        return UserData(
            userName = generateUserName(DEFAULT_USER_NAME_CHAR_AMOUNT),
            password = generatePassword(DEFAULT_PASSWORD_CHAR_AMOUNT)
        )
    }
}
package services.userdata

import java.lang.StringBuilder

internal object UserDataGenerator {
    private val mandatoryPasswordChars: List<CharRange> = listOf(('a'..'z'), ('A'..'Z'), ('0'..'9'), ('!'..'%'))
    private val mandatoryUserNameChars: List<CharRange> = listOf(('a'..'z'), ('A'..'Z'))

    fun generatePassword(repeatChars: Int): String {
        return generateStringWithMandatoryChars(repeatChars, mandatoryPasswordChars)
    }

    fun generateUserName(repeatChars: Int): String {
        return generateStringWithMandatoryChars(repeatChars, mandatoryUserNameChars)
    }

    private fun generateStringWithMandatoryChars(repeatChars: Int, mandatoryChars: List<CharRange>): String {
        val stringBuilder = StringBuilder()
        repeat(repeatChars) {
            stringBuilder.append(mandatoryChars.map { it.random() }.joinToString(""))
        }
        return stringBuilder.toString()
    }
}
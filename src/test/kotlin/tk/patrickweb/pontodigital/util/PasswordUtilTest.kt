package tk.patrickweb.pontodigital.util

import org.junit.Assert
import org.junit.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class PasswordUtilTest {

    private val password = "12345678"
    private val bCryptPasswordEncoder = BCryptPasswordEncoder()

    @Test
    fun testGenerateHashPassword() {
        val hash = PasswordUtil().generateBcrypt(password)
        Assert.assertTrue(bCryptPasswordEncoder.matches(password, hash))
    }

}
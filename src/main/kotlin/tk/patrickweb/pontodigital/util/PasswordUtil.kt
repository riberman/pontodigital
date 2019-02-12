package tk.patrickweb.pontodigital.util

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class PasswordUtil {

    fun generateBcrypt(password: String): String = BCryptPasswordEncoder().encode(password)
}
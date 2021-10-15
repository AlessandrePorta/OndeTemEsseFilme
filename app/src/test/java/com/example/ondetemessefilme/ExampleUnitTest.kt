package com.example.ondetemessefilme

import com.example.ondetemessefilme.utils.validateEmail
import com.example.ondetemessefilme.utils.validateName
import com.example.ondetemessefilme.utils.validatePassword
import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun anonymousLogin(){
        val name = "Name Test"
        val expected = true

        val result = name.validateName()

        assertEquals(expected, result)
    }

    @Test
    fun anonymousInvalidLogin(){
        val name = ""
        val expected = false

        val result = name.validateName()

        assertEquals(expected, result)
    }

    @Test
    fun anonymousBlankLogin(){
        val name = "   "
        val expected = false

        val result = name.validateName()

        assertEquals(expected, result)
    }

    @Test
    fun loginPasswordValid(){
        val senha = "Ab@124356"
        val expected = true

        val result = senha.validatePassword()

        assertEquals(expected, result)
    }

    @Test
    fun loginPasswordBlank(){
        val senha = "   "
        val expected = false

        val result = senha.validatePassword()

        assertEquals(expected, result)
    }

    @Test
    fun loginPasswordEmpty(){
        val senha = ""
        val expected = false

        val result = senha.validatePassword()

        assertEquals(expected, result)
    }

    @Test
    fun loginPasswordLength(){
        val senha = "aaaa"
        val expected = false

        val result = senha.validatePassword()

        assertEquals(expected, result)
    }

    @Test
    fun loginEmailValid(){
        val email = "test@test.com"
        val expected = true
        val result = email.validateEmail()

        assertEquals(expected, result)
    }

    @Test
    fun loginEmailBlank(){
        val email = "    "
        val expected = false

        val result = email.validateEmail()

        assertEquals(expected, result)
    }

    @Test
    fun loginEmailEmpty(){
        val email = ""
        val expected = false

        val result = email.validateEmail()

        assertEquals(expected, result)
    }

    @Test
    fun loginEmailNotContaisChar(){
        val email = "test@test"
        val expected = false

        val result = email.validateEmail()

        assertEquals(expected, result)
    }

    @Test
    fun loginEmailNotContaisCharDot(){
        val email = "test.com"
        val expected = false

        val result = email.validateEmail()

        assertEquals(expected, result)
    }

}
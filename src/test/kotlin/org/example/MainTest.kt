package org.example

import org.junit.Test
import kotlin.test.assertEquals
import org.example.main

class MainTest {

    @Test
    fun `example list case`() {
        val stringInput = "Apple, Apple, Orange, Apple"

        val total = Fruit.myCheckout(stringInput)
        val expectedTotal = 2.05

        assertEquals(expectedTotal, total)
    }

    @Test
    fun `empty list case`() {
        val stringInput = ""


        val total = Fruit.myCheckout(stringInput)
        val expectedTotal = 0.0

        assertEquals(expectedTotal, total)
    }

    @Test
    fun `irregular input case`() {
        val stringInput = "asdfadsf"

        val total = Fruit.myCheckout(stringInput)
        val expectedTotal = 0.0

        assertEquals(expectedTotal, total)
    }



}

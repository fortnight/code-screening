package org.example

import org.junit.Test
import kotlin.test.assertEquals
import org.example.main
import org.example.Order
class MainTest {

    @Test
    fun `test event service running out of apples`(){
        val order = Order("Apple, Apple, Apple, Orange, Apple, Apple, Apple")
        order.onStatusChanged = {oldValue, newValue ->
            println("Order: ${order.order} | Status now set to: ${order.status} | with time: ${order.time}")
        }

        val total = Fruit.myOrderCheckout(order)
        val expectedTotal = -1.0

        assertEquals(total, expectedTotal)

    }

    @Test
    fun `test event service running out of oranges`(){
        val order = Order("Apple, Orange, Orange, Orange, Orange, Orange, Orange")
        order.onStatusChanged = {oldValue, newValue ->
            println("Order: ${order.order} | Status now set to: ${order.status} | with time: ${order.time}")
        }

        val total = Fruit.myOrderCheckout(order)
        val expectedTotal = -1.0

        assertEquals(total, expectedTotal)

    }

    @Test
    fun `test event service`(){
        val order = Order("Apple, Apple, Apple, Orange")
        order.onStatusChanged = {oldValue, newValue ->
            println("Order: ${order.order} | Status now set to: ${order.status} | with time: ${order.time}")
        }

        val total = Fruit.myOrderCheckout(order)
        val expectedTotal = 1.45

        assertEquals(total, expectedTotal)

    }

    @Test
    fun `example list case`() {
        val stringInput = "Apple, Apple, Orange, Apple, Orange"

        val total = Fruit.myCheckout(stringInput)
        val expectedTotal = 1.70

        assertEquals(expectedTotal, total)
    }

    @Test
    fun `bulk order to test discounts`() {
        val stringInput = "Apple, Orange, Orange, Orange, Apple, Orange, Apple"

        val total = Fruit.myCheckout(stringInput)
        val expectedTotal = 1.95

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

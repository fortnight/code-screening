package org.example

fun main(args: Array<String>) {

    println("Enter Comma separated List of Groceries: (Example: [Apple, Orange])")
    val stringInput = readLine()!!
    val total = Fruit.myCheckout(stringInput)

    println("total: " + total)
}



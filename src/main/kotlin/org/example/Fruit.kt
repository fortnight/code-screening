package org.example

import kotlin.math.round

class Fruit {

     var name: String = "";
     var price: Double = 0.0;
     var stock: Int = 0;

     constructor(name: String, price: Double, stock: Int) {
         this.name = name
         this.price = price
         this.stock = stock
     }

     override fun toString(): String {
        return "Fruit(name='$name', price=$price)"
     }

    companion object {
        fun myCheckout(stringInput: String): Double {
            if (stringInput == "") {
                return 0.0
            }

            val apple = Fruit("Apple", .60, 5)
            val orange = Fruit("Orange", .25, 5)

            val fruitList = stringInput.split(", ")

            var total = 0.0;
            var appleCount = 0
            var orangeCount = 0
            for (fruit in fruitList) {
                if (fruit == "Apple") {
                    appleCount++
                    if(appleCount%2 == 1) {
                        total += apple.price
                    }
                }
                if (fruit == "Orange") {
                    orangeCount++
                    if(orangeCount%3 != 0) {
                        total += orange.price
                    }
                }
                if (appleCount > apple.stock) {
                    return -1.0
                }
                if (orangeCount > orange.stock) {
                    return -1.0
                }
            }
            total = round(total * 100.0) / 100.0
            return (total)
        }

        fun myOrderCheckout(order: Order): Double {
            val total = Fruit.myCheckout(order.order)
            order.status = "submitted"
            if (total == -1.0) {
                order.status = "failed"
                order.time = 0
            }
            return total
        }
    }


}
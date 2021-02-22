package org.example

class Fruit {

     var name: String = "";
     var price: Double = 0.0;

     constructor(name: String, price: Double) {
        this.name = name
        this.price = price
     }

     override fun toString(): String {
        return "Fruit(name='$name', price=$price)"
     }

    companion object {
        fun myCheckout(stringInput: String): Double {
            if (stringInput == "") {
                return 0.0
            }

            val apple = Fruit("Apple", .60)
            val orange = Fruit("Orange", .25)

            val fruitList = stringInput.split(", ")

            var total = 0.0;
            for (fruit in fruitList) {
                if (fruit == "Apple") {
                    total += apple.price
                }
                if (fruit == "Orange") {
                    total += orange.price
                }
            }
            return (total)
        }
    }


}
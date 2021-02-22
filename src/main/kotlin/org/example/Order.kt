package org.example

import kotlin.properties.Delegates.observable

class Order {
    var order: String = ""
    var status: String by observable("created") {  _, oldValue, newValue ->
        onStatusChanged?.invoke(oldValue, newValue)
    }
    var time: Int = 0
    var onStatusChanged: ((String, String) -> Unit)? = null

    constructor(order: String) {
        this.order = order
        this.status = "submitted"
        this.time = 10
    }

}
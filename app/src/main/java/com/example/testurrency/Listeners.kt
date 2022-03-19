package com.example.testurrency

import com.example.testurrency.data.Money

interface Listener {
    fun listener(value: List<Money>)
}
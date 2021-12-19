package com.anddev404.timer

import java.util.*

class Timer {
    private var start = 0.0;
    fun start() {
        start = Calendar.getInstance().timeInMillis.toDouble()
    }

    fun getMs(): Double {
        return Calendar.getInstance().timeInMillis - start.toDouble()
    }

    fun getSeconds(): Double {
        var t = Calendar.getInstance().timeInMillis - start
        return t / 1000.0

    }
}
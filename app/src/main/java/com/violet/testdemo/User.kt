package com.violet.testdemo

import javax.inject.Inject

class User @Inject constructor() {

    fun getName(): String {
        return "user1"
    }
}
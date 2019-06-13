package com.cmkk.concurrency.defensivecopy

import java.util.*
import kotlin.collections.ArrayList

class MyDataStructureKotlin {

    val list = ArrayList<String>()

    fun add(s: String) {
        list.add(s)
    }

    /**
     * Makes a defensive copy of the List and return it
     * This way cannot modify the list itself
     *
     * @return List<String>
     */
    fun getList() : List<String> {
        return  Collections.unmodifiableList(list)
    }
}
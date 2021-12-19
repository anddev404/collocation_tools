package com.anddev404.cache

import java.lang.Exception

class Cache(private var numberOfCacheObject: Int) {

    private var listOfCacheObjects = arrayListOf<Any>()
    private var listOfIndexObjects = arrayListOf<Int>()

    fun addToCache(obj: Any, id: Int) {
        if (listOfCacheObjects.size < numberOfCacheObject) {
            listOfCacheObjects.add(obj)
            listOfIndexObjects.add(id)

        } else if (numberOfCacheObject > 0) {

            try {
                listOfCacheObjects.removeAt(0)
                listOfIndexObjects.removeAt(0)

            } catch (e: Exception) {

            }
            listOfCacheObjects.add(obj)
            listOfIndexObjects.add(id)

        }
    }

    fun tryToGetOrNull(id: Int): Any? {
        try {
            for (i in listOfIndexObjects.indices) {

                if (listOfIndexObjects.get(i) == id) {
                    return listOfCacheObjects.get(i)
                }
            }
        } catch (e: Exception) {

        }

        return null
    }

    override fun toString(): String {
        var str = ""
        for (i in listOfCacheObjects) {
            str = str + ", " + i.toString()
        }
        return str
    }

}
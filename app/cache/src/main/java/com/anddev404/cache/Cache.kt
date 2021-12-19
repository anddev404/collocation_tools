package com.anddev404.cache

import java.lang.Exception

class Cache(private var numberOfCacheObject: Int) {

    class Wrapper(var any: Any, var id: Int) {
    }

    private var listOfCacheObjects = arrayListOf<Wrapper>()

    fun addToCache(obj: Any, id: Int) {
        if (listOfCacheObjects.size < numberOfCacheObject) {
            listOfCacheObjects.add(Wrapper(obj, id))

        } else if (numberOfCacheObject > 0) {

            try {
                listOfCacheObjects.removeAt(0)

            } catch (e: Exception) {

            }
            listOfCacheObjects.add(Wrapper(obj, id))

        }
    }

    fun tryToGetOrNull(id: Int): Any? {
        try {
            for (i in listOfCacheObjects.indices) {

                if (listOfCacheObjects.get(i).id == id) {
                    return listOfCacheObjects.get(i).any
                }
            }
        } catch (e: Exception) {

        }

        return null
    }

    fun isCached(id: Int): Boolean {
        try {
            for (i in listOfCacheObjects.indices) {
                if (id == listOfCacheObjects.get(i).id) {

                    var obj = listOfCacheObjects.get(i)
                    listOfCacheObjects.removeAt(i)
                    listOfCacheObjects.add(obj)

                    return true
                }
            }
        } catch (e: Exception) {
        }
        return false
    }

    override fun toString(): String {
        var str = ""
        for (i in listOfCacheObjects) {
            str = str + ", " + i.any.toString()
        }
        return str
    }

}
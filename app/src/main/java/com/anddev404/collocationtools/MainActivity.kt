package com.anddev404.collocationtools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.anddev404.cache.Cache

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var cache = Cache(3)

        Log.d("MARCIN", "cache: ${cache.toString()} 1");

        cache.addToCache("jeden", 1)

        cache.addToCache("dwa", 2)
        Log.d("MARCIN", "cache: ${cache.toString()} 2");

        cache.addToCache("trzy", 3)

        cache.addToCache("cztery", 4)

        cache.addToCache("piec", 5)

        cache.addToCache("szesc", 6)

        cache.addToCache("siedem", 7)
        Log.d("MARCIN", "cache: ${cache.toString()} 3");

        if (!cache.isCached(6)) {
            cache.addToCache("szesc", 6)

        }


        Log.d("MARCIN", "cache: ${cache.toString()} 3");

        var s = cache.tryToGetOrNull(6)
        Log.d(
            "MARCIN", "get: ${
                s.toString() as String
            } 3"
        );


    }
}
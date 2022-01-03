package com.anddev404.timer

import android.content.Context
import android.util.Log
import com.pixplicity.easyprefs.library.Prefs
import java.util.*

class Timer(context: Context, var activityId: Int) {

    init {
        com.pixplicity.easyprefs.library.Prefs.Builder()
            .setContext(context)
            .setMode(android.content.ContextWrapper.MODE_PRIVATE)
            .setPrefsName(context.getPackageName())
            .setUseDefaultSharedPreference(true)
            .build();
    }

    private var start = 0.0
    private var isStarted = false

    fun start() {
        isStarted = true
        start = Calendar.getInstance().timeInMillis.toDouble()
        var savedTime =
            Prefs.getDouble("$activityId,${Calendar.getInstance().get(Calendar.DAY_OF_YEAR)}", 0.0);
        Log.d(
            "TIMER", "timer: start: $savedTime"
        );

    }

    fun getTime(): String {

        if (isStarted) {
            var timeSecond = stop()
            var minutes = (timeSecond / 60).toInt()
            var seconds = Math.round(timeSecond - (60 * minutes))

            start()
            Log.d(
                "TIMER", "timer: get: $minutes:$seconds"
            );
            return "$minutes:$seconds"
        } else {
            var timeSecond =
                Prefs.getDouble(
                    "$activityId,${Calendar.getInstance().get(Calendar.DAY_OF_YEAR)}",
                    0.0
                );
            var minutes = (timeSecond / 60).toInt()
            var seconds = Math.round(timeSecond - (60 * minutes))

            Log.d(
                "TIMER", "timer: get: $minutes:$seconds"
            );

            return "$minutes:$seconds"
        }

    }

    fun stop(): Double {
        isStarted = false
        var actualSeconds = (Calendar.getInstance().timeInMillis - start) / 1000.0
        var savedTime =
            Prefs.getDouble("$activityId,${Calendar.getInstance().get(Calendar.DAY_OF_YEAR)}", 0.0);
        Prefs.putDouble(
            "$activityId,${Calendar.getInstance().get(Calendar.DAY_OF_YEAR)}",
            actualSeconds + savedTime
        );
        Log.d(
            "TIMER", "timer: stop: ${actualSeconds + savedTime}"
        );
        return actualSeconds + savedTime
    }

//public boolean savePreference(Integer integer) {
//
//    try {
//
//        Prefs.putInt("", integer);
//        Toast.makeText(this, "Save preference: "+integer, Toast.LENGTH_SHORT).show();
//
//
//        return true;
//    } catch (Exception e) {
//
//        return false;
//    }
//}

//Integer ;
//
//public boolean getPreference() {
//
//
//
//
//}

//    Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
}
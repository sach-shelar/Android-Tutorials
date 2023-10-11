package com.sach.daggersample.data.remote

import android.util.Log
import com.sach.daggersample.core.Constant

interface AnalyticsService {
    fun addNewEvent(event: String, eventType: String)
}

class MixPanelAnalyticsService : AnalyticsService {
    override fun addNewEvent(event: String, eventType: String) {
        Log.e(Constant.TAG, "MixPanel Event: $event - $eventType")
    }
}

class FirebaseAnalyticsService : AnalyticsService {
    override fun addNewEvent(event: String, eventType: String) {
        Log.e(Constant.TAG, "Firebase Event: $event - $eventType")
    }
}
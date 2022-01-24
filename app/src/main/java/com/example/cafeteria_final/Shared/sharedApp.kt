package com.example.cafeteria_final.Shared

import android.app.Application

class sharedApp : Application() {
    companion object {
        lateinit var prefs: prefs
    }
    override fun onCreate() {
        super.onCreate()
        prefs = prefs(applicationContext)
    }
}
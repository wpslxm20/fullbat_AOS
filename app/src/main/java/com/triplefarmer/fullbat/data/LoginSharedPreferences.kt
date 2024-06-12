package com.triplefarmer.fullbat.data

import android.content.Context
import android.content.SharedPreferences

class LoginSharedPreferences(context: Context) {
    private val prefsFileName = "login_prefs"
    private val keyId = "id"
    private val prefs:SharedPreferences = context.getSharedPreferences(prefsFileName,0)

    var loginId: String?
        get() = prefs.getString(keyId, "")
        set(value) = prefs.edit().putString(keyId, value).apply()

    fun removeId() {
        prefs.edit().clear().apply()
    }
}
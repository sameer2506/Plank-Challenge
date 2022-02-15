package com.plank.challenge.database

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(ctx: Context) {

    private var level: SharedPreferences =
        ctx.getSharedPreferences("APP_PREFFERENCES", Context.MODE_PRIVATE)

    private var gender: SharedPreferences =
        ctx.getSharedPreferences("APP_PREFFERENCES", Context.MODE_PRIVATE)

    fun saveLevel(data: Int) {
        level.edit().putInt("level", data).apply()
    }

    fun getLevel(): Int {
        return level.getInt("level", 0)
    }

    fun saveGender(string: String) {
        gender.edit().putString("gender", string).apply()
    }

    fun getGender(): String? {
        return gender.getString("gender", "")
    }

}
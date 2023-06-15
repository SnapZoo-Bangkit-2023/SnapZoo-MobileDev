package com.example.snapzoo.data

import android.content.Context
import android.content.SharedPreferences

class SnapZooPref(ctx:Context) {
    private var pref: SharedPreferences = ctx.getSharedPreferences(SNAP_ZOO_PREF, Context.MODE_PRIVATE)

    fun setCameraFlashPref(isFlashOn: Boolean) = pref.edit().putBoolean(CAM_FLASH_PREF, isFlashOn).apply()
    fun getCameraFlashPref(): Boolean = pref.getBoolean(CAM_FLASH_PREF, false)

    companion object {
        private const val SNAP_ZOO_PREF = "snapzoo_preference"
        private const val CAM_FLASH_PREF = "camera_flash"
    }
}
package dev.pankaj.aidlserver

import android.app.Service
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder

class AIDLService : Service() {


    override fun onBind(intent: Intent?): IBinder {
        return object : IInfoPickerAidlInterface.Stub() {
            override fun getColor(): Int {
                val random = java.util.Random()
                return Color.argb(255, random.nextInt(256), 255, 255)
            }

            override fun getAndroidOSInfo(): String {
                val androidVersion = Build.VERSION.RELEASE
                val deviceModel = Build.MODEL
                val manufacturer = Build.MANUFACTURER
                val user = Build.USER
                return "Android Version: $androidVersion\n" +
                        "Device Model: $deviceModel\n" +
                        "Manufacturer: $manufacturer" +
                        "User: $user"
            }
        }
    }



}
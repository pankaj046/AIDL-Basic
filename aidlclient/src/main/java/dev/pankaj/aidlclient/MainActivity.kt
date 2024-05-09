package dev.pankaj.aidlclient

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textview.MaterialTextView
import dev.pankaj.aidlserver.IInfoPickerAidlInterface

class MainActivity : AppCompatActivity() {

    var iInfoPickerAidlInterface: IInfoPickerAidlInterface ?=null

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            iInfoPickerAidlInterface = IInfoPickerAidlInterface.Stub.asInterface(service)
        }

        override fun onServiceDisconnected(name: ComponentName?) {

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent("AIDLService")
        intent.setPackage("dev.pankaj.aidlserver")
        bindService(intent, connection, BIND_AUTO_CREATE)
        findViewById<Button>(R.id.btn).setOnClickListener {
            iInfoPickerAidlInterface?.let {
                findViewById<MaterialTextView>(R.id.info).text = it.androidOSInfo
                findViewById<ConstraintLayout>(R.id.main).setBackgroundColor(it.color)
            }
        }
    }
}
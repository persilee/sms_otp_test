package com.example.sms.sms_otp_test

import android.Manifest
import android.content.Context
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.content.IntentFilter
import android.os.BatteryManager
import android.content.ContextWrapper
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {

    private val CHANNEL = "com.apdbank.mb.personal"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECEIVE_SMS), 101)
        } else {
            receiveMsg()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 101 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            receiveMsg()
    }

    private fun receiveMsg() {

    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor, CHANNEL).setMethodCallHandler(MethodChannel.MethodCallHandler { call, result ->
            if (call.method == "getOpt") {
                result.success("123456")
            } else {
                result.notImplemented()
            }
        })
    }

}

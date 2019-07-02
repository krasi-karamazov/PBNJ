package com.appsbg.presentation.utils

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class PermissionsHandlerImpl: PermissionsHandler {

    override fun requestPermission(activity: AppCompatActivity, permissions: Array<String>, requestCode: Int) {
        ActivityCompat.requestPermissions(activity, permissions, requestCode)
    }

    override fun checkHasPermission(activity: AppCompatActivity, permission: String): Boolean {
        return ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED
    }

}
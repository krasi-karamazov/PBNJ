package com.appsbg.presentation.utils

import androidx.appcompat.app.AppCompatActivity

interface PermissionsHandler {

    fun checkHasPermission(activity: AppCompatActivity, permission: String): Boolean
    fun requestPermission(activity: AppCompatActivity, permissions: Array<String>, requestCode: Int)
}
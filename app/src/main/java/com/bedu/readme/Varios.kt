package com.bedu.readme

import android.content.Context
import androidx.appcompat.app.AlertDialog
import java.security.AccessControlContext

private fun showDialog(title:String,message:String, context: Context){
    AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton("OK"){dialogInterface, which -> }
        .create()
        .show()
}
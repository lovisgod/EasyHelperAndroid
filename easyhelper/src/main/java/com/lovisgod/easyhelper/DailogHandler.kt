package com.lovisgod.easyhelper

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar


class DailogHandler {

    fun makeSnack(view: View, message:String, context: Context, color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setBackgroundTint(context.getColor(color))
                .show()
        } else {
            Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .show()
        }
    }

    fun makeToast(message: String, context: Context, background: Int? = null) {
        val toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
        val view = toast.view
        println("getting here")
        if (view != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                view.background = background?.let { context.getDrawable(it) }
            }
        }
        toast.show()

    }

    fun inflateDialog(context: Context, layout: Int, action: ((v: View?) -> Unit?)? = null ): AlertDialog? {
        val builder = AlertDialog.Builder(context)
        var inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val mView: View = inflater.inflate(layout, null )
        if (action != null) {
            action(mView)
        }
        builder.setView(mView)
        return builder.create()
    }

}
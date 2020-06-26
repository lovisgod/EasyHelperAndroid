package com.lovisgod.easyhelper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog

class EasyDialogHelper {
    // Listener defined earlier
    interface DialogListener {
        fun onObjectReady(view: View?)
    }

    // Member variable was defined earlier
    private var listener: DialogListener? = null

    // ... setter defined here
    // Assign the listener implementing events interface that will receive the events
    fun setDialogOpenListener(listener: DialogListener?) {
        this.listener = listener
    }


    fun createdDialog(
        context: Context,
        layout: Int
    ): AlertDialog? {
        val builder =
            AlertDialog.Builder(context)
        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val mView = inflater.inflate(layout, null)
        builder.setView(mView)
        if (listener != null) {
            listener!!.onObjectReady(mView) // <---- fire listener here
        }
        return builder.create()
    }
}
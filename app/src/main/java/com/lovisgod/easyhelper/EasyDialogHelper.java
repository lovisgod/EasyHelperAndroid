package com.lovisgod.easyhelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

public class EasyDialogHelper {
    // Listener defined earlier
    public interface DialogListener {
        void onObjectReady(View view);
    }

    // Member variable was defined earlier
    private DialogListener listener;

    // Constructor where listener events are ignored
    public EasyDialogHelper() {
        // set null or default listener or accept as argument to constructor
        this.listener = null;
    }

    // ... setter defined here
    // Assign the listener implementing events interface that will receive the events
    public void setDialogOpenListener(DialogListener listener) {
        this.listener = listener;
    }



    public AlertDialog createdDialog(Context context, int layout) {
        AlertDialog.Builder builder  = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mView = inflater.inflate(layout, null);
        builder.setView(mView);
                if (listener != null) {
                    listener.onObjectReady(mView); // <---- fire listener here
                }
        return  builder.create();
    }
}

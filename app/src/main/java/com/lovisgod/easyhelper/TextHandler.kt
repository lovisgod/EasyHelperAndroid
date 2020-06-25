package com.lovisgod.easyhelper

import android.widget.EditText

class TextHandler {
     fun setError(elements: Array<EditText>) {
        for (element in elements) {
            element.requestFocus()
            element.error = "This cannot be empty"
        }

    }

     fun setEmpty(elements: Array<EditText>) {
        for (x in elements) {
            x.setText("")
        }
    }
}
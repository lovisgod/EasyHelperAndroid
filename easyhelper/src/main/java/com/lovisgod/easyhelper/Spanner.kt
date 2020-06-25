package com.lovisgod.easyhelper

import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView

class Spanner {
    fun  makeForeGroundSpan(txt: TextView, from:Int, to: Int, content: String, color: Int) {
        val ss = SpannableString(content)
        ss.setSpan(ForegroundColorSpan(color), from, to, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        txt.text = ss
    }

    fun makeClickableSpan(
        method: (() -> Unit?)? = null,
        color: Int,
        underline: Boolean,
        txt: TextView,
        from:Int,
        to: Int,
        content: String) {

        val clickableSpan =  object : ClickableSpan() {
            override fun onClick(p0: View) {
                println("getting here")
                if (method != null) {
                    method()
                }
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = underline
                ds.color = color
            }

        }
        val ss = SpannableString(content)
        ss.setSpan(clickableSpan, from, to, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        txt.text = ss
        txt.isClickable = true
        txt.movementMethod = LinkMovementMethod.getInstance()
    }
}
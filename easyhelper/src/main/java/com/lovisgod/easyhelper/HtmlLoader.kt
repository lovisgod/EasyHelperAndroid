package com.lovisgod.easyhelper

import android.content.Context
import android.content.res.AssetManager
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class HtmlLoader {

    fun loader(context: Context, filename: String): String {
        val mgr: AssetManager = context.assets
        val data: InputStream = mgr.open(filename, AssetManager.ACCESS_BUFFER)
        val html = loadHtml(data)
        data.close()
        return html
    }


    private fun loadHtml(`in`: InputStream): String {
        val builder = StringBuilder()
        val reader = BufferedReader(InputStreamReader(`in`))
        var line: String?
        while (reader.readLine().also { line = it } != null) {
                builder.append(line)
        }
        return builder.toString()
    }
}
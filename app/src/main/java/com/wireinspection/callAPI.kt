package com.wireinspection

import android.os.AsyncTask
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class callAPI(): AsyncTask<URL, Void, Void>(){
    override fun doInBackground(vararg p0: URL?): Void? {
        for(url in p0){
            Log.i("URL", url.toString())
            val conn : HttpURLConnection = url?.openConnection() as HttpURLConnection
            conn.setRequestMethod("GET")
        }

        return null
    }

}
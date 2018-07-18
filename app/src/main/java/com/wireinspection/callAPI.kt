package com.wireinspection

import android.os.AsyncTask
import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class ApiParams (val url: URL, val requestMethod: String, val jsonObject: JSONObject)


class callAPI(): AsyncTask<ApiParams, Void, String?>(){
    override fun doInBackground(vararg p0: ApiParams?): String? {
        val client = OkHttpClient()
        val JSON = MediaType.parse("application/json")
        val body = RequestBody.create(JSON, p0[0]?.jsonObject.toString())
        val request = Request.Builder()
                .url(p0[0]?.url)
                .post(body)
                .build()
        val response = client.newCall(request).execute() as Response
        return response.body()?.string()


    }

}
package com.wireinspection

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.io.BufferedReader
import java.io.InputStreamReader


class LoginActivity : Activity(){


    lateinit var usesrname : EditText;
    lateinit var password : EditText;
    lateinit var login : Button;
    var auth = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        usesrname = findViewById(R.id.username)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)
        login.setOnClickListener(View.OnClickListener {
            val user = usesrname.text
            val pass = password.text
            val obj = JSONObject();
            obj.put("UserName", user)
            obj.put("Password", pass)
            val a = ApiParams(URL("http://183.82.46.166:88/WireInspectionService.svc/LoginUser"), "POST", obj)
            val r = callAPI().execute(a).get()
            Log.i("Return Value", r)
            if(r != "\"Fail\""){
                startActivity(Intent(this, MainActivity::class.java))
            }


        })
        if(auth){

        }

    }
}
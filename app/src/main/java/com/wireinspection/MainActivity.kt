package com.wireinspection


import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.view.ViewTreeObserver


class MainActivity : FragmentActivity() {

    internal var navHeight = -1

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                goToDataFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard ->

                return@OnNavigationItemSelectedListener true
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = findViewById<View>(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                navHeight = navigation.measuredHeight
                if (Build.VERSION.SDK_INT < 16) {
                    navigation.viewTreeObserver.removeGlobalOnLayoutListener(this)
                } else {
                    navigation.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }
                goToDataFragment()
            }
        })
    }

    private fun goToDataFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val addDataFragment = AddDataFragment()
        addDataFragment.arguments = addHeight()
        fragmentTransaction.replace(R.id.content, addDataFragment).commit()
    }

    private fun addHeight(): Bundle {
        val data = Bundle()
        data.putInt("navHeight", navHeight)
        return data
    }

}

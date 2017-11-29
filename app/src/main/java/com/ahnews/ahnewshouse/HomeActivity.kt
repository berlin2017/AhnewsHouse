package com.ahnews.ahnewshouse

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.internal.BottomNavigationItemView
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.layout_main.*

/**
 * Created by Administrator on 2017/11/28 0028.
 */
class HomeActivity : AppCompatActivity() {

    var map = HashMap<Int, Fragment>()
    var currentFragmnet = Fragment();

    private val mNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.main_home -> {
                changeFragment(item.itemId)
                return@OnNavigationItemSelectedListener true
            }
            R.id.main_chat -> {
                changeFragment(item.itemId)
                return@OnNavigationItemSelectedListener true
            }
            R.id.main_suggest -> {
                changeFragment(item.itemId)
                return@OnNavigationItemSelectedListener true
            }
            R.id.main_my -> {
                changeFragment(item.itemId)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)
        main_navigation.setOnNavigationItemSelectedListener(mNavigationItemSelectedListener)
        main_navigation.selectedItemId = R.id.main_home
    }

    internal fun changeFragment(id: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        if (currentFragmnet!=null){
            transaction.hide(currentFragmnet)
        }
        var fragment: Fragment? = map.get(id)
        if (fragment == null) {
            fragment = HomeFragment()
        }
        if (!fragment.isAdded) {
            map.put(id,fragment)
            transaction.add(R.id.fragment_container, fragment)
        }else{
            transaction.show(fragment)
        }
        transaction.commitAllowingStateLoss()
        currentFragmnet = fragment
    }

    override fun onBackPressed() {
//        super.onBackPressed()
        var share = getSharedPreferences("AHNEWS_HOUSE", Context.MODE_PRIVATE);

        var first = share.getLong("back_time",0L)
        var current = System.currentTimeMillis()
        if (current - first <= 3000){
            finish()
        }else{
            share.edit().putLong("back_time",current)
            share.edit().commit()
            Toast.makeText(this,"再按一次推出",Toast.LENGTH_SHORT).show()
        }
    }
}
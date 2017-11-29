package com.ahnews.ahnewshouse

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
//        sample_text.text = stringFromJNI()
        var handler = MyHandler()
        handler.sendEmptyMessageDelayed(0,3000)
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

    inner class MyHandler : Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            this@MainActivity.jumpToActivtiy()
        }
    }

    private fun jumpToActivtiy(){
        var intent = Intent(this,HomeActivity::class.java);
        startActivity(intent)
        finish()
    }
}

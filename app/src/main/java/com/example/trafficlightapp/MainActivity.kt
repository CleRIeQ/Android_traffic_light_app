package com.example.trafficlightapp

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.*

private var startBtn:ImageView? = null
private var gray:ImageView? = null
private var redLight:ImageView? = null
private var orangeLight:ImageView? = null
private var greenLight:ImageView? = null

class MainActivity : Activity() {

    var imageArray:IntArray = intArrayOf(R.drawable.red, R.drawable.orange, R.drawable.green)
    private var isRun = false
    var timer: Timer? = null
    var counter = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBtn = findViewById(R.id.imageButton)
        gray = findViewById(R.id.gray)

    }
    fun onClickStartStop(view: View) {
        view as ImageButton
        if (!isRun) {
            startStop()
            isRun = true

        } else {
            gray?.setImageResource(R.drawable.gray)
            timer?.cancel()
            counter = 0
            isRun = false
        }
    }
    fun startStop() {
        Thread {
            timer = Timer()
            timer?.schedule(object:TimerTask(){
                override fun run() {
                    runOnUiThread() {
                        gray?.setImageResource(imageArray[counter])
                    }
                    counter++
                    if (counter == 3) counter = 0
                }

            }, 0, 1000)
        }.start()

}

    }

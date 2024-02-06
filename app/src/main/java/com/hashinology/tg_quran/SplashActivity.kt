package com.hashinology.tg_quran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.hashinology.tg_quran.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }

    private fun initViews() {
        startSplash()
    }

    private fun startSplash() {
        Handler(Looper.getMainLooper()).postDelayed({
            val start = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
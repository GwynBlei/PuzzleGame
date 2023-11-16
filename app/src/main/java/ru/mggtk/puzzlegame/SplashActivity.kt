package ru.mggtk.puzzlegame

import android.content.Intent
import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh)
        scheduleSplashScreen()
    }
    private fun scheduleSplashScreen() {
        val imageView: ImageView = findViewById(R.id.imageView1)
        imageView.setBackgroundResource(R.drawable.avd_anim_)
        val animation = imageView.background as AnimatedVectorDrawable
        animation.start()
        val splashScreenDuration: Long = 2001
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity,
                MainActivity::class.java)
            startActivity(intent)
            finish()
        }, splashScreenDuration)
    }
}
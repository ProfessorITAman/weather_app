package com.example.loading_app.Loading_app

import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loading_app.R
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var progressText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        progressBar = findViewById(R.id.progressBar)
        progressText = findViewById(R.id.progressText)


        val downloadThread = Thread(Runnable {
            for (i in 0..100) {

                Thread.sleep(100)
                Handler(Looper.getMainLooper()).post {
                    progressBar.progress = i
                    progressText.text = "Загрузка... $i%"
                }
            }

            Handler(Looper.getMainLooper()).post {
                progressText.text = "Загрузка завершена!"
            }
        })
        downloadThread.start()
    }
}

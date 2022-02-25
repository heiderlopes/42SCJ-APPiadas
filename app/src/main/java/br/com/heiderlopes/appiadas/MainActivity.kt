package br.com.heiderlopes.appiadas

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import br.com.heiderlopes.appiadas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.btTellJoker.setOnClickListener { button ->
            showJoker()
        }
    }

    private fun showJoker() {

        binding.btTellJoker.isEnabled = false

        val jokers = resources.getStringArray(R.array.jokers)
//        val numberJoker = Random().nextInt(jokers.size)
//        val joker = jokers[numberJoker]

        binding.tvJoker.text = jokers.random()

        playSong()

        Handler(Looper.getMainLooper()).postDelayed({
            binding.btTellJoker.isEnabled = true
        }, 2000)

    }

    private fun playSong() {
        val mediaPlayer = MediaPlayer.create(this, R.raw.risada)
        mediaPlayer.start()
    }
}
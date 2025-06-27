package com.sntsb.groovy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sntsb.groovy.databinding.ActivityMainBinding
import com.sntsb.groovy.playlist.presentation.PlaylistFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, PlaylistFragment.newInstance()).commit()
        }

    }
}
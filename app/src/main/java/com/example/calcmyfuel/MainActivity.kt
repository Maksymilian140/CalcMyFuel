package com.example.calcmyfuel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import androidx.navigation.ActivityNavigator
import com.example.calcmyfuel.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    lateinit var startingLocation: String
    lateinit var destination: String
    var averageFuelUsage = 0.0
    var fuelInTank = 0
    var typeOfFuel = 0

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


}
package com.example.calcmyfuel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import androidx.navigation.Navigation
import com.example.calcmyfuel.databinding.FragmentStartScreenBinding

class startScreen : Fragment() {
    lateinit var binding: FragmentStartScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartScreenBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val calculateButton = binding.calculateButton
        calculateButton.setOnClickListener{
            (activity as MainActivity).startingLocation = binding.startingLocation.text.toString()
            (activity as MainActivity).destination = binding.destination.text.toString()
            (activity as MainActivity).averageFuelUsage = binding.avgFuelUsage.text.toString().toDouble()
            (activity as MainActivity).fuelInTank = binding.fuelInTank.text.toString().toInt()
            //Navigation.findNavController(binding.root).navigate(R.id.action_startScreen_to_resultScreen)
            Navigation.findNavController(binding.root).navigate(R.id.action_startScreen_to_resultScreen)
            }

        binding.fuelButtons.setOnCheckedChangeListener { group, checkedId ->
            (activity as MainActivity).typeOfFuel = when (checkedId) {
                R.id.dieselButton -> 1
                R.id.gasolineButton -> 2
                R.id.lpgButton -> 3
                else -> 0
            }
        }
    }

    private fun calculate() {
        //algorytm obliczania kosztow paliwa
    }

}
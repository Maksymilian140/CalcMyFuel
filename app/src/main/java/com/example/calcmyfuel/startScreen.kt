package com.example.calcmyfuel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
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
            calculate()
            //Navigation.findNavController(binding.root).navigate(R.id.action_startScreen_to_resultScreen)
            Navigation.findNavController(binding.root).navigate(R.id.action_startScreen_to_resultScreen)
        }
    }

    private fun calculate() {
        //algorytm obliczania kosztow paliwa
    }

}
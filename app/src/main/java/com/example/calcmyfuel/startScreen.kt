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

class startScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_start_screen, container, false);

        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val calculateButton = view.findViewById<Button>(R.id.calculateButton);
        calculateButton.setOnClickListener{
            calculate();
            Navigation.findNavController(view).navigate(R.id.action_startScreen_to_resultScreen);
        }
    }

    private fun calculate() {
        //algorytm obliczania kosztow paliwa
    }

}
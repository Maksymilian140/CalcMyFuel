package com.example.calcmyfuel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.calcmyfuel.databinding.FragmentResultScreenBinding

class resultScreen : Fragment() {
    lateinit var binding: FragmentResultScreenBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentResultScreenBinding.inflate(layoutInflater)
        val view = binding.root
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val goBackButton = binding.backButton
        goBackButton.setOnClickListener{
            Navigation.findNavController(view).popBackStack();
        }

    }
}
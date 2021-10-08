package com.example.calcmyfuel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.calcmyfuel.databinding.FragmentResultScreenBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

class resultScreen : Fragment(), OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap

    lateinit var binding: FragmentResultScreenBinding

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //binding.mapView!!.onCreate(savedInstanceState)
        //binding.mapView!!.onResume()
        //binding.mapView!!.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap?) {
        map?.let{
            googleMap = it
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentResultScreenBinding.inflate(layoutInflater)
        val view = binding.root
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val goBackButton = binding.backButton
        binding.startL?.text = (activity as MainActivity).startingLocation
        binding.dest?.text = (activity as MainActivity).destination
        binding.averageF?.text = (activity as MainActivity).averageFuelUsage.toString()
        binding.fuelI?.text = (activity as MainActivity).fuelInTank.toString()
        binding.radio?.text = (activity as MainActivity).typeOfFuel.toString()

        goBackButton.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_resultScreen_to_mapsActivity)
        }

    }
}
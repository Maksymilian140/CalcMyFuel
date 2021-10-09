package com.example.calcmyfuel

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.calcmyfuel.databinding.ActivityMapsBinding
import java.io.File

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var strAddress : String;
    private lateinit var strAddress2 : String;
    var lat1 : Double = 0.0;
    var lon1 : Double = 0.0;
    var lat2 : Double = 0.0;
    var lon2 : Double = 0.0;

    var path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
    var folder = File(path,"/CalcMyFuel")
    var file = File(folder, "/data.txt")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var coder : Geocoder = Geocoder(this);
        var address : List<Address>;

        val bufferedReader = file.bufferedReader()
        val text: List<String> = bufferedReader.readLines()

        strAddress = text[0];
        strAddress2 = text[1];
        address = coder.getFromLocationName(strAddress,5);

        val location : Address =address.get(0);

        lat1 = location.getLatitude();
        lon1 = location.getLongitude();

        address = coder.getFromLocationName(strAddress2,5);

        val location2 : Address =address.get(0);

        lat2 = location2.getLatitude();
        lon2 = location2.getLongitude();

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val firstMarker = LatLng(lat1, lon1)
        val secondMarker = LatLng(lat2, lon2)
        mMap.addMarker(MarkerOptions().position(firstMarker).title("Starting location"))
        mMap.addMarker(MarkerOptions().position(secondMarker).title("Destination"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(firstMarker))
    }


}

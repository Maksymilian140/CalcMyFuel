package com.example.calcmyfuel

import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import android.os.AsyncTask
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
import com.google.android.gms.maps.model.PolylineOptions
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.lang.Exception

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
        var address : List<Address>

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
        val origin = LatLng(lat1, lon1)
        val dest = LatLng(lat2, lon2)

        val firstMarker = LatLng(lat1, lon1)
        val secondMarker = LatLng(lat2, lon2)
        mMap.addMarker(MarkerOptions().position(firstMarker).title("Starting location"))
        mMap.addMarker(MarkerOptions().position(secondMarker).title("Destination"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(firstMarker))
        //val URL = getDirectionURL(origin, dest)
        //GetDirection(URL).execute()
    }
/*
    fun getDirectionURL(origin: LatLng, dest: LatLng): String{
        print("https://maps.googleapis.com/maps/api/directions/json?origin=${origin.latitude},${origin.longitude}&destination=${dest.latitude},${dest.longitude}&key=AIzaSyAo3mSHcu5PD0Bmkk5xlfnQwswjyXau1u0")
        //return "https://maps.googleapis.com/maps/api/directions/json?origin=${origin.latitude},${origin.longitude}&destination=${dest.latitude},${dest.longitude}&key=AIzaSyAo3mSHcu5PD0Bmkk5xlfnQwswjyXau1u0"
        return "https://maps.googleapis.com/maps/api/directions/json?origin=52.405625,16.933351&destination=53.436144,14.450666&key=AIzaSyAo3mSHcu5PD0Bmkk5xlfnQwswjyXau1u0"
    }

    inner class GetDirection(val url: String) : AsyncTask<Void, Void, List<List<LatLng>>>(){
        override fun doInBackground(vararg p0: Void?): List<List<LatLng>> {
            val client = OkHttpClient()
            val request = Request.Builder().url(url).build()
            val response = client.newCall(request).execute()
            val data = response.body().toString()
            val result = ArrayList<List<LatLng>>()
            try{
                val respObj = Gson().fromJson(data, GoogleMapDTO::class.java)
                val path = ArrayList<LatLng>()
                for(i in  0..(respObj.routes[0].legs[0].steps.size - 1)){
                    val startLatLng = LatLng(respObj.routes[0].legs[0].steps[i].start_location.lat.toDouble(), respObj.routes[0].legs[0].steps[i].start_location.lng.toDouble())
                    path.add(startLatLng)
                    val endLatLng = LatLng(respObj.routes[0].legs[0].steps[i].end_location.lat.toDouble(), respObj.routes[0].legs[0].steps[i].end_location.lng.toDouble())
                    path.add(endLatLng)
                }
                result.add(path)
            }catch (e:Exception){
                e.printStackTrace()
            }
            return result
        }

        override fun onPostExecute(result: List<List<LatLng>>?) {
            val lineoption = PolylineOptions()
            for(i in result!!.indices) {
                lineoption.addAll(result[i])
                lineoption.width(10f)
                lineoption.color(Color.BLUE)
                lineoption.geodesic(true)
            }
            print(lineoption)
            mMap.addPolyline(lineoption)
        }

    }

 */

}

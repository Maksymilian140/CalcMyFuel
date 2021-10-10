package com.example.calcmyfuel

class GoogleMapDTO {
    var routes = ArrayList<Routes>()
}

class Routes{
    var legs = ArrayList<Legs>()
}

class Legs{
    var distance = Distance()
    var duration = Duration()
    var end_address = ""
    var start_address = ""
    var end_location = Location()
    var start_location = Location()
    var steps = ArrayList<Steps>()
}

class Steps{
    var distance = Distance()
    var duration = Duration()
    var end_address = ""
    var start_address = ""
    var end_location = Location()
    var start_location = Location()
    var polyline = Polyline()
    var travel_mode = ""
    var maneuver = ""
}

class Duration{
    var text = ""
    var value = 0
}

class Distance{
    var text = ""
    var value = 0
}

class Polyline{
    var Point = ""
}

class Location{
    var lat = ""
    var lng = ""
}
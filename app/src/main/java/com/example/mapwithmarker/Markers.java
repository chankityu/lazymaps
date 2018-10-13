package com.example.mapwithmarker;

import com.google.android.gms.maps.model.Marker;

public class Markers{
    Marker marker;
    String details;

    public Markers(Marker marker, String details){
        this.marker = marker;
        this.details = details;
    }
};
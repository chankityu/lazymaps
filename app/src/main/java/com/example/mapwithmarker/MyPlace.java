package com.example.mapwithmarker;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.util.Hashtable;



public class MyPlace  {

    private static MyPlace _instance;
    private Hashtable<String, Markers> _hash;

    private MyPlace() {
        _hash = new Hashtable<String, Markers>();
    }

    private static MyPlace getInstance() {
        if(_instance==null) {
            _instance = new MyPlace();
        }
        return _instance;
    }

    public static void addObjectForKey(String object, Markers key) {
        getInstance()._hash.put(object,key);
    }

    public static Object getObjectForKey(String key) {
        MyPlace helper = getInstance();
        Object data = helper._hash.get(key);
        //helper._hash.remove(key);
        helper = null;
        return data;
    }

}

package com.example.anthony.notepadandroidv2;

import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

/**
 * Created by timothee on 07/04/16.
 */
public class Geoloc {


    public static String getCoordonates(Context context){
        Geocoder geocoder;
        String bestProvider;
        List<Address> user = null;
        double lat;
        double lng;
        try{
            LocationManager lm = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            bestProvider = lm.getBestProvider(criteria, false);
            Location location = lm.getLastKnownLocation(bestProvider);

            if(location == null){
                Toast.makeText(context, "Location not found", Toast.LENGTH_LONG).show();
            }else{

                geocoder = new Geocoder(context);
                try {
                    user = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    lat=(double)user.get(0).getLatitude();
                    lng=(double)user.get(0).getLongitude();
                    Log.d(">>>>>>>>>", " DDD lat: " + lat + ",  longitude: " + lng);
                    user = geocoder.getFromLocation(lat,lng,1);
                    return user.get(0).getLocality();

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }catch(SecurityException e){
            e.printStackTrace();
        }
        return null;
    }
}

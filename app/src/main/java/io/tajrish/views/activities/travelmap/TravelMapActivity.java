package io.tajrish.views.activities.travelmap;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.maps.android.ui.IconGenerator;

import io.tajrish.R;
import io.tajrish.models.ProvinceModel;
import io.tajrish.views.activities.BaseActivity;

/**
 * Created by root on 12/18/15.
 */
public class TravelMapActivity extends BaseActivity{

    private GoogleMap mGoogleMap;
    private double mLongitude;
    private double mLatitude;
    private ProvinceModel mProvince;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_map);
//
//        Gson gson = new Gson();
//        String json = gson.toJson(offers);
//        Intent intent = new Intent(DashboardActivity.this, GoogleMapActivity.class);
//        intent.putExtra(PACKAGE_NAME + ": province", json);
//        intent.putExtra(PACKAGE_NAME + ": latitude", location[0]);
//        intent.putExtra(PACKAGE_NAME + ": longitude", location[1]);
        getJsonInformationFromIntent();
        setUpMapIfNeeded();
    }

    private void getJsonInformationFromIntent() {
        Intent intent = getIntent();
        String json = intent.getStringExtra(PACKAGE_NAME + ": province");
        if(json == null){
            Gson gson = new Gson();
            json = gson.toJson(ProvinceModel.getProvinceList().get(1));
        }
        mLatitude = intent.getDoubleExtra(PACKAGE_NAME + ": latitude", 32.420654);
        mLongitude = intent.getDoubleExtra(PACKAGE_NAME + ": longitude", 53.682362);
        mProvince = new Gson().fromJson(json, ProvinceModel.class);
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mGoogleMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mGoogleMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mGoogleMap = ((SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.travel_map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mGoogleMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mGoogleMap} is not null.
     */
    private void setUpMap() {
        /*markers.clear();

        for (int i = 0; i < offerList.length; i++) {
            Offer offer = offerList[i];
            IconGenerator factory = new IconGenerator(this);
            factory.setBackground(getResources().getDrawable(R.drawable.pin_empty));
            TextView textView = new TextView(this);
            textView.setText("%" + offer.getMaxPercentage());
            textView.setPadding(15, 15, 0, 0);
            textView.setTextColor(Color.WHITE);
            textView.setTypeface(FontHelper.getDefaultTypeface(this));
            factory.setContentView(textView);
            Bitmap icon = factory.makeIcon();
            Marker marker = mGoogleMap.addMarker(
                    new MarkerOptions().position(
                            new LatLng(
                                    offer.getStore().getLatitude(),
                                    offer.getStore().getLongitude()))
                            .icon(BitmapDescriptorFactory.fromBitmap(icon)));
            markers.add(marker);
            markersMap.put(marker, i);
        }

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Marker marker : markers) {
            builder.include(marker.getPosition());
        }

        *//*LatLngBounds bounds = builder.build();*//*

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        final int width = size.x;
        final int height = size.y;

        int padding = 50; // offset from edges of the map in pixels
        *//*CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);
        mGoogleMap.moveCamera(cu);*//*
        mGoogleMap.setMyLocationEnabled(true);
        if(offerList.length > 0) {
            Log.d(PACKAGE_NAME, offerList[0].getStore().getLatitude() + " " + offerList[0].getStore().getLongitude());
            mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(
                            offerList[0].getStore().getLatitude(),
                            offerList[0].getStore().getLongitude()), 15));
            mViewPagerOffer.setMaxHeight(200);
        }
        else {
            mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                            new LatLng(
                                    latitude,
                                    longitude
                            ), 15)
            );
            *//*mViewPagerOffer.setMaxHeight(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,60);
            layoutParams.setMargins(0, 0, 0, 0);
            mLinearLayoutResults.setLayoutParams(layoutParams);*//*
        }*/
    }
}

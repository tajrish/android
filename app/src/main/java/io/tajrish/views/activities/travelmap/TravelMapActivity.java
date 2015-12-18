package io.tajrish.views.activities.travelmap;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import github.chenupt.dragtoplayout.DragTopLayout;
import io.tajrish.R;
import io.tajrish.models.Pin;
import io.tajrish.models.Province;
import io.tajrish.views.activities.BaseActivity;

/**
 * Created by root on 12/18/15.
 */
public class TravelMapActivity extends BaseActivity {

    private GoogleMap mGoogleMap;
    private double mLongitude;
    private double mLatitude;
    private Province mProvince;
    private ArrayList<Marker> markers = new ArrayList<>();
    private Map<Marker, Integer> markersMap = new HashMap();

    private FrameLayout mExpander;
    private ImageView mBackpack;
    private boolean isOpen = true;
    private int mHeight;

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
        findViewsById();
        getScreenHeight();
        setOnClickListeners();
    }

    private void findViewsById() {
        mBackpack = (ImageView) findViewById(R.id.travel_backpack);
        mExpander = (FrameLayout) findViewById(R.id.travel_expander);
    }

    private void getScreenHeight() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        mHeight = size.y;
    }

    private void setOnClickListeners() {
        mBackpack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen) {
                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                            FrameLayout.LayoutParams.MATCH_PARENT,
                            RadioGroup.LayoutParams.MATCH_PARENT
                    );
                    params.setMargins(0, mHeight-200, 0, 0);
                    mExpander.setLayoutParams(params);
                } else {
                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                            FrameLayout.LayoutParams.MATCH_PARENT,
                            RadioGroup.LayoutParams.MATCH_PARENT
                    );
                    params.setMargins(0, 30, 0, 0);
                    mExpander.setLayoutParams(params);
                }
                isOpen = !isOpen;
                Log.d(PACKAGE_NAME, isOpen ? "TRUE" : "FALSE");
            }
        });
    }

    private void getJsonInformationFromIntent() {
        Intent intent = getIntent();
        String json = intent.getStringExtra(PACKAGE_NAME + ": province");
        if (json == null) {
            Gson gson = new Gson();
            json = gson.toJson(Province.getProvinceList().get(0));
            Log.d(PACKAGE_NAME, json);
        }
        mLatitude = intent.getDoubleExtra(PACKAGE_NAME + ": latitude", 32.420654);
        mLongitude = intent.getDoubleExtra(PACKAGE_NAME + ": longitude", 53.682362);
        mProvince = new Gson().fromJson(json, Province.class);
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
        markers.clear();

        for (int i = 0; i < mProvince.getPinList().size(); i++) {
            Pin pin = mProvince.getPinList().get(i);
            IconGenerator factory = new IconGenerator(this);
            factory.setBackground(getResources().getDrawable(R.drawable.pin_empty));
            /*TextView textView = new TextView(this);
            textView.setText("%" + offer.getMaxPercentage());
            textView.setPadding(15, 15, 0, 0);
            textView.setTextColor(Color.WHITE);
            textView.setTypeface(FontHelper.getDefaultTypeface(this));
            factory.setContentView(textView);*/
            Bitmap icon = factory.makeIcon();
            Marker marker = mGoogleMap.addMarker(
                    new MarkerOptions().position(
                            new LatLng(
                                    pin.getLatitude(),
                                    pin.getLongitude()))
                            .icon(BitmapDescriptorFactory.fromBitmap(icon)));
            markers.add(marker);
            markersMap.put(marker, i);
        }

        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                        new LatLng(
                                mProvince.getLatitude(),
                                mProvince.getLongitude()
                        ), 15)
        );
    }
}

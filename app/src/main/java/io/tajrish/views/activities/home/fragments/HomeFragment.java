package io.tajrish.views.activities.home.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import io.tajrish.R;
import io.tajrish.models.Province;
import io.tajrish.views.adapters.ProvinceAdapter;

/**
 * Created by mehdiii on 12/18/15.
 */
public class HomeFragment extends Fragment {

    GridView gridView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        find(view);
        configure();
    }

    private void find(View view) {
        gridView = (GridView) view.findViewById(R.id.grid_view);
    }

    private void configure() {
        ProvinceAdapter adapter = new ProvinceAdapter(getActivity(), R.layout.province_in_grid_template, R.id.title, Province.getProvinceList());
        gridView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}

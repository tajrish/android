package io.tajrish.views.activities.home;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import io.tajrish.R;
import io.tajrish.views.activities.BaseActivity;

/**
 * Created by mehdiii on 12/17/15.
 */
public class HomeActivity extends BaseActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        find();
        configure();
    }

    private void find() {
        gridView = (GridView) findViewById(R.id.grid_view);
    }

    private void configure() {

        List<String> all = new ArrayList<>();
        all.add("aaa");
        all.add("bbb");
        all.add("ccc");
        all.add("ddd");

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.province_in_grid_template, R.id.title, all);
        gridView.setAdapter(adapter);
    }


}

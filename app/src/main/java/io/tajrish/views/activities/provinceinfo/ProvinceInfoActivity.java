package io.tajrish.views.activities.provinceinfo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import io.tajrish.R;
import io.tajrish.views.activities.BaseActivity;
import io.tajrish.views.activities.home.adapters.ViewPagerAdapter;
import io.tajrish.views.activities.home.fragments.BadgeFragment;
import io.tajrish.views.activities.home.fragments.HomeFragment;
import io.tajrish.views.activities.home.fragments.TrainFragment;
import io.tajrish.views.activities.provinceinfo.adapters.MyPagerAdapter;
import io.tajrish.views.custom.ToggleButton;

/**
 * Created by mehdiii on 12/18/15.
 */
public class ProvinceInfoActivity extends BaseActivity {

    ViewPager viewPager;
    CirclePageIndicator pageIndicator;

    ToggleButton trainButton;
    ToggleButton carButton;
    ToggleButton planeButton;
    ToggleButton previous;

    ViewPager viewPagerMain;
    ViewPagerAdapter adapter;
    Fragment trainFragment;
    Fragment carFragment;
    Fragment planeFragment;
    List<Fragment> childFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province_info);

        find();
        configure();
    }

    private void find() {
        viewPager = (ViewPager)findViewById(R.id.pager);
        pageIndicator = (CirclePageIndicator) findViewById(R.id.indicator_avatars);

        trainButton = (ToggleButton) findViewById(R.id.button_train);
        carButton = (ToggleButton) findViewById(R.id.button_car);
        planeButton = (ToggleButton) findViewById(R.id.button_plane);

        viewPagerMain = (ViewPager) findViewById(R.id.viewpager_main);
    }

    private void configure() {
        viewPager.setAdapter(new MyPagerAdapter());
        pageIndicator.setViewPager(viewPager);

        childFragments = new ArrayList<>();
        trainFragment = Fragment.instantiate(this, TrainFragment.class.getName(), null);
        carFragment = Fragment.instantiate(this, TrainFragment.class.getName(), null);
        planeFragment = Fragment.instantiate(this, TrainFragment.class.getName(), null);
        childFragments.add(trainFragment);
        childFragments.add(carFragment);
        childFragments.add(planeFragment);

        if (previous == null)
            previous = this.planeButton.toggle();

        this.trainButton.setOnClickListener(pageSelectorClickListener);
        this.carButton.setOnClickListener(pageSelectorClickListener);
        this.planeButton.setOnClickListener(pageSelectorClickListener);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), childFragments, null);
        viewPagerMain.setAdapter(adapter);
        viewPagerMain.setOnPageChangeListener(pageChangeListener);
        viewPagerMain.setCurrentItem(2);
        viewPagerMain.setOffscreenPageLimit(3);
    }

    private View.OnClickListener pageSelectorClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (previous != null)
                previous.toggle();
            ((ToggleButton) view).toggle();
            previous = (ToggleButton) view;

            switch (view.getId()) {
                case R.id.button_train:
                    viewPagerMain.setCurrentItem(0, true);
                    break;
                case R.id.button_car:
                    viewPagerMain.setCurrentItem(1, true);
                    break;
                case R.id.button_plane:
                    viewPagerMain.setCurrentItem(2, true);
                    break;
            }
        }
    };

    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }


        @Override
        public void onPageSelected(int position) {
            if (previous != null)
                previous.toggle();

            ToggleButton selection = null;
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++)
                        getSupportFragmentManager().popBackStack();
                }
            });

            switch (position) {
                case 0:
                    selection = trainButton;
                    break;
                case 1:
                    selection = carButton;
                    break;
                case 2:
                    selection = planeButton;
                    break;
            }

            if (selection != null) {
                selection.toggle();
                previous = selection;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };
}

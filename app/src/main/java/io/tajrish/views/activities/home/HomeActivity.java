package io.tajrish.views.activities.home;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.tajrish.R;
import io.tajrish.views.activities.BaseActivity;
import io.tajrish.views.activities.home.adapters.ViewPagerAdapter;
import io.tajrish.views.activities.home.fragments.BadgeFragment;
import io.tajrish.views.activities.home.fragments.HomeFragment;
import io.tajrish.views.custom.ToggleButton;

/**
 * Created by mehdiii on 12/17/15.
 */
public class HomeActivity extends BaseActivity {

    ViewPager viewPager;
    ViewPagerAdapter adapter;

    ToggleButton homeButton;
    ToggleButton badgeButton;
    ToggleButton previous;

    Fragment homeFragment;
    Fragment badgeFragment;

    List<Fragment> childFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        find();
        configure();
    }

    private void find() {
        this.viewPager = (ViewPager) findViewById(R.id.viewpager_main);
        this.homeButton = (ToggleButton) findViewById(R.id.button_home);
        this.badgeButton = (ToggleButton) findViewById(R.id.button_badges);
    }

    private void configure() {
        childFragments = new ArrayList<>();
        homeFragment = Fragment.instantiate(this, HomeFragment.class.getName(), null);
        badgeFragment = Fragment.instantiate(this, BadgeFragment.class.getName(), null);
        childFragments.add(badgeFragment);
        childFragments.add(homeFragment);

        if (previous == null)
            previous = this.homeButton.toggle();

        this.homeButton.setOnClickListener(pageSelectorClickListener);
        this.badgeButton.setOnClickListener(pageSelectorClickListener);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), childFragments, null);
        viewPager.setAdapter(adapter);
        this.viewPager.setOnPageChangeListener(pageChangeListener);
        this.viewPager.setCurrentItem(1);
        viewPager.setOffscreenPageLimit(2);
    }

    private View.OnClickListener pageSelectorClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (previous != null)
                previous.toggle();
            ((ToggleButton) view).toggle();
            previous = (ToggleButton) view;

            switch (view.getId()) {
                case R.id.button_home:
                    viewPager.setCurrentItem(1, true);
                    break;
                case R.id.button_badges:
                    viewPager.setCurrentItem(0, true);
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
                    selection = badgeButton;
                    break;
                case 1:
                    selection = homeButton;
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

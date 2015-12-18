package io.tajrish.views.activities.provinceinfo.adapters;

/**
 * Created by mehdiii on 12/18/15.
 */
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import io.tajrish.R;

public class MyPagerAdapter extends PagerAdapter {

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return o==view;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        ImageView image = new ImageView(container.getContext());
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        image.setLayoutParams(params);

        int[] pics = new int[5];
        pics[0] = R.drawable.aaa;
        pics[1] = R.drawable.bbb;
        pics[2] = R.drawable.ccc;
        pics[3] = R.drawable.ddd;
        pics[4] = R.drawable.eee;

        image.setImageResource(pics[position]);

        final int page = position;
        image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(container.getContext(), "You clicked: " + page + ". page.", Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(image);
        return image;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView)object);
    }
}
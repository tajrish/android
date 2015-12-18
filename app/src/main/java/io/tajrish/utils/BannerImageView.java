package io.tajrish.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import io.tajrish.R;

public class BannerImageView extends View {

    public void setLogo(Drawable logo) {
        this.logo = logo;
        setBackgroundDrawable(logo);
    }

    private Drawable logo;

    public BannerImageView(Context context) {
        super(context);
        logo = context.getResources().getDrawable(R.drawable.image_gallery);
        setBackgroundDrawable(logo);
    }

    public BannerImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        logo = context.getResources().getDrawable(R.drawable.image_gallery);
        setBackgroundDrawable(logo);
    }

    public BannerImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        logo = context.getResources().getDrawable(R.drawable.image_gallery);
        setBackgroundDrawable(logo);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec,
                             int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = width * logo.getIntrinsicHeight() / logo.getIntrinsicWidth();
        setMeasuredDimension(width, height);
    }
}
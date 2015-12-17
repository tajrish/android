package io.tajrish.views.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import io.tajrish.utils.FontHelper;

/**
 * Created by Sadjad on 9/18/2015.
 */
public class FFTextView extends TextView {

    public FFTextView(Context context) {
        super(context);
        fixFont();
    }

    public FFTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        fixFont();
    }

    public FFTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        fixFont();
    }

    private void fixFont() {
        setTypeface(FontHelper.getDefaultTypeface(getContext()));
    }
}

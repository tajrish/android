package io.tajrish.views.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import io.tajrish.utils.FontHelper;


/**
 * Created by Sadjad on 9/18/2015.
 */
public class FFEditText extends EditText {

    public FFEditText(Context context) {
        super(context);
        fixFont();
    }

    public FFEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        fixFont();
    }

    public FFEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        fixFont();
    }

    private void fixFont() {
        setTypeface(FontHelper.getDefaultTypeface(getContext()));
    }
}

package io.tajrish.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by Sadjad on 9/18/2015.
 */
public class FontHelper {
    private static Typeface menu = null;
    private static final String FONT_MENU_NAME = "icons.ttf";
    private static final String APP_DEFAULT_FONT_PATH = "IRAN Sans.ttf";
    private static final String APP_DEFAULT_FONT_PATH_BOLD = "IRAN Sans Bold.ttf";
    private static Typeface defaultFont = null;

    public static Typeface getDefaultTypeface(Context context) {
        if (defaultFont == null)
            defaultFont = Typeface.createFromAsset(context.getAssets(), APP_DEFAULT_FONT_PATH);
        return defaultFont;
    }

    public static Typeface getDefaultTypefaceBold(Context context) {
        if (defaultFont == null)
            defaultFont = Typeface.createFromAsset(context.getAssets(), APP_DEFAULT_FONT_PATH_BOLD);
        return defaultFont;
    }

    public static void setDefaultTypeface(Context context, TextView... views) {
        Typeface typeface = getDefaultTypeface(context);
        for (TextView view : views) {
            view.setTypeface(typeface);
        }
    }

    public static void setDefaultTypefaceBold(Context context, TextView... views) {
        Typeface typeface = getDefaultTypefaceBold(context);
        for (TextView view : views) {
            view.setTypeface(typeface);
        }
    }

    public static Typeface getIcons(Context context) {
        if (menu == null)
            menu = Typeface.createFromAsset(context.getAssets(), FONT_MENU_NAME);
        return menu;
    }
}

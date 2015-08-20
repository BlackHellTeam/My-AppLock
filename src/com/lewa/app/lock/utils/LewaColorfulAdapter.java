package com.lewa.app.lock.utils;

import android.content.res.LewaColorfulResources.LewaColorfulStyle;
import android.content.res.LewaColorfulResources;
import lewa.util.ColorUtils;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.content.Context;

public class LewaColorfulAdapter {

    public static Drawable getColorDrawable(Context context,Drawable sourceDraw) {
        LewaColorfulStyle.ColorfulNode colorfulStyle = LewaColorfulResources.getInstance().getColorfulStyle(context);
        if (colorfulStyle != null) {
             int color = colorfulStyle.getMainColor();
             Drawable resultDrawable = ColorUtils.resetDrawableColor(context, sourceDraw, color);
                return resultDrawable;
            }
        return sourceDraw;
    }

}
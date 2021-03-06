package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

public class ae {
    private final int iw;
    private final int ix;

    public ae(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        this.iw = (int) (((float) i) * 0.7f);
        this.ix = (int) (((float) i2) * 0.65f);
    }

    public void a(View view, Point point) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = point.x;
        layoutParams.height = point.y;
        view.setLayoutParams(layoutParams);
    }

    public Point b(int i, int i2) {
        int i3;
        int i4;
        boolean z = i2 > i;
        float f = ((float) i) / ((float) i2);
        if (z) {
            i3 = this.ix;
            i4 = (int) (((float) i3) * f);
            int i5 = this.iw;
            if (i4 > i5) {
                i3 = (int) (((float) i5) / f);
                i4 = i5;
            }
        } else {
            i4 = this.iw;
            i3 = (int) (((float) i4) / f);
        }
        Point point = new Point();
        point.x = i4;
        point.y = i3;
        return point;
    }
}

package com.freshchat.consumer.sdk.b;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.j.af;
import com.freshchat.consumer.sdk.j.ai;

public class f {
    public static x j(Context context) {
        try {
            Class.forName("androidx.appcompat.widget.Toolbar");
            View findViewById = ((Activity) context).findViewById(16908290);
            if (findViewById instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) findViewById;
                View inflate = LayoutInflater.from(context).inflate(R.layout.freshchat_toolbar, (ViewGroup) null);
                if (inflate != null) {
                    int i = R.id.freshchat_material_toolbar;
                    if (inflate.findViewById(i) instanceof Toolbar) {
                        Toolbar toolbar = (Toolbar) inflate.findViewById(i);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 49);
                        layoutParams.setMargins(0, 0, 0, 0);
                        inflate.setLayoutParams(layoutParams);
                        frameLayout.addView(inflate);
                        View childAt = frameLayout.getChildAt(0);
                        if (childAt != null) {
                            int paddingLeft = childAt.getPaddingLeft();
                            int paddingRight = childAt.getPaddingRight();
                            int paddingTop = childAt.getPaddingTop();
                            i.a(context, childAt, paddingLeft, paddingTop + af.h(context, 56), paddingRight, childAt.getPaddingBottom());
                        }
                        if (toolbar != null) {
                            ((f0) context).setSupportActionBar(toolbar);
                        }
                    }
                }
                ai.e("FRESHCHAT_WARNING", "Toolbar Missing ! Did you uncomment the toolbar widget in layout/freshchat_toolbar.xml and remove the dummy view ?");
                return null;
            }
            return ((f0) context).getSupportActionBar();
        } catch (ClassNotFoundException e) {
            ai.e("FRESHCHAT_WARNING", "Failed to setup Toolbar based ActionBar", e);
            return null;
        }
    }
}

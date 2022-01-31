package com.urbanairship.iam.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.urbanairship.automation.R;
import java.util.List;

public class InAppButtonLayout extends BoundedLinearLayout {
    public int h;
    public int i;
    public int j;
    public ButtonClickListener k;

    public interface ButtonClickListener {
        void b(View view, xq5 xq5);
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ xq5 f;

        public a(xq5 xq5) {
            this.f = xq5;
        }

        public void onClick(View view) {
            ButtonClickListener buttonClickListener = InAppButtonLayout.this.k;
            if (buttonClickListener != null) {
                buttonClickListener.b(view, this.f);
            }
        }
    }

    public InAppButtonLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.UrbanAirshipInAppButtonLayout, 0, 0);
            this.h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.UrbanAirshipInAppButtonLayout_urbanAirshipStackedSpaceHeight, 0);
            this.i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.UrbanAirshipInAppButtonLayout_urbanAirshipSeparatedSpaceWidth, 0);
            this.j = obtainStyledAttributes.getResourceId(R.styleable.UrbanAirshipInAppButtonLayout_urbanAirshipButtonLayoutResourceId, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public void a(String str, List<xq5> list) {
        boolean z;
        boolean z2;
        int i2;
        if (list.size() > 1) {
            z2 = "stacked".equals(str);
            z = "joined".equals(str);
        } else {
            z = false;
            z2 = false;
        }
        removeAllViews();
        int i3 = z2 ? 1 : 0;
        int i4 = z2 ? 1 : 0;
        int i5 = z2 ? 1 : 0;
        setOrientation(i3);
        setMeasureWithLargestChildEnabled(true);
        int i6 = 0;
        while (i6 < list.size()) {
            xq5 xq5 = list.get(i6);
            if (z) {
                i2 = i6 == 0 ? 9 : i6 == list.size() - 1 ? 6 : 0;
            } else {
                i2 = 15;
            }
            Button button = (Button) LayoutInflater.from(getContext()).inflate(this.j, (ViewGroup) this, false);
            hd3.o(button, xq5, i2);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
                layoutParams.weight = 1.0f;
                button.setLayoutParams(layoutParams);
                if (i6 > 0) {
                    layoutParams.setMargins(0, this.h, 0, 0);
                }
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
                layoutParams2.weight = 1.0f;
                button.setLayoutParams(layoutParams2);
                if (!z && i6 > 0) {
                    layoutParams2.setMargins(this.i, 0, 0, 0);
                    layoutParams2.setMarginStart(this.i);
                }
            }
            addView(button);
            button.setOnClickListener(new a(xq5));
            i6++;
        }
        requestLayout();
    }

    public void setButtonClickListener(ButtonClickListener buttonClickListener) {
        this.k = buttonClickListener;
    }
}

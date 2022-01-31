package com.google.android.material.appbar;

import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R;

public class MaterialToolbar extends Toolbar {
    public static final int g = R.style.Widget_MaterialComponents_Toolbar;
    public Integer f;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialToolbar(android.content.Context r8, android.util.AttributeSet r9) {
        /*
        // Method dump skipped, instructions count: 101
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.MaterialToolbar.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof ho4) {
            hd3.N2(this, (ho4) background);
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        hd3.L2(this, f2);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (!(drawable == null || this.f == null)) {
            drawable = h.H0(drawable);
            drawable.setTint(this.f.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i) {
        this.f = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }
}

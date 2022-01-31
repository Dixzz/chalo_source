package defpackage;

import android.content.res.ColorStateList;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.google.android.material.R;

/* renamed from: kl4  reason: default package */
/* compiled from: MaterialCheckBox */
public class kl4 extends AppCompatCheckBox {
    public static final int h = R.style.Widget_MaterialComponents_CompoundButton_CheckBox;
    public static final int[][] i = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    public ColorStateList f;
    public boolean g;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kl4(android.content.Context r8, android.util.AttributeSet r9) {
        /*
            r7 = this;
            int r3 = com.google.android.material.R.attr.checkboxStyle
            int r4 = defpackage.kl4.h
            android.content.Context r8 = defpackage.bq4.a(r8, r9, r3, r4)
            r7.<init>(r8, r9, r3)
            android.content.Context r8 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialCheckBox
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            android.content.res.TypedArray r9 = defpackage.mn4.d(r0, r1, r2, r3, r4, r5)
            int r0 = com.google.android.material.R.styleable.MaterialCheckBox_buttonTint
            boolean r1 = r9.hasValue(r0)
            if (r1 == 0) goto L_0x0029
            android.content.res.ColorStateList r8 = defpackage.hd3.h1(r8, r9, r0)
            r7.setButtonTintList(r8)
        L_0x0029:
            int r8 = com.google.android.material.R.styleable.MaterialCheckBox_useMaterialThemeColors
            boolean r8 = r9.getBoolean(r8, r6)
            r7.g = r8
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kl4.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f == null) {
            int[][] iArr = i;
            int[] iArr2 = new int[iArr.length];
            int g1 = hd3.g1(this, R.attr.colorControlActivated);
            int g12 = hd3.g1(this, R.attr.colorSurface);
            int g13 = hd3.g1(this, R.attr.colorOnSurface);
            iArr2[0] = hd3.Z1(g12, g1, 1.0f);
            iArr2[1] = hd3.Z1(g12, g13, 0.54f);
            iArr2[2] = hd3.Z1(g12, g13, 0.38f);
            iArr2[3] = hd3.Z1(g12, g13, 0.38f);
            this.f = new ColorStateList(iArr, iArr2);
        }
        return this.f;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.g && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.g = z;
        if (z) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }
}

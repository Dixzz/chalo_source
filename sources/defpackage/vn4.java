package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.TypedValue;
import com.google.android.material.R;
import defpackage.y5;

/* renamed from: vn4  reason: default package */
/* compiled from: TextAppearance */
public class vn4 {

    /* renamed from: a  reason: collision with root package name */
    public final ColorStateList f3665a;
    public final ColorStateList b;
    public final String c;
    public final int d;
    public final int e;
    public final float f;
    public final float g;
    public final float h;
    public final boolean i;
    public final float j;
    public float k;
    public final int l;
    public boolean m = false;
    public Typeface n;

    /* renamed from: vn4$a */
    /* compiled from: TextAppearance */
    public class a extends y5.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ xn4 f3666a;

        public a(xn4 xn4) {
            this.f3666a = xn4;
        }

        @Override // defpackage.y5.c
        public void onFontRetrievalFailed(int i) {
            vn4.this.m = true;
            this.f3666a.a(i);
        }

        @Override // defpackage.y5.c
        public void onFontRetrieved(Typeface typeface) {
            vn4 vn4 = vn4.this;
            vn4.n = Typeface.create(typeface, vn4.d);
            vn4 vn42 = vn4.this;
            vn42.m = true;
            this.f3666a.b(vn42.n, false);
        }
    }

    public vn4(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.TextAppearance);
        this.k = obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
        this.f3665a = hd3.h1(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor);
        hd3.h1(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        hd3.h1(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.d = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.e = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int i3 = R.styleable.TextAppearance_fontFamily;
        i3 = !obtainStyledAttributes.hasValue(i3) ? R.styleable.TextAppearance_android_fontFamily : i3;
        this.l = obtainStyledAttributes.getResourceId(i3, 0);
        this.c = obtainStyledAttributes.getString(i3);
        obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.b = hd3.h1(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.f = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.g = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.h = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i2, R.styleable.MaterialTextAppearance);
        int i4 = R.styleable.MaterialTextAppearance_android_letterSpacing;
        this.i = obtainStyledAttributes2.hasValue(i4);
        this.j = obtainStyledAttributes2.getFloat(i4, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        if (this.n == null && (str = this.c) != null) {
            this.n = Typeface.create(str, this.d);
        }
        if (this.n == null) {
            int i2 = this.e;
            if (i2 == 1) {
                this.n = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.n = Typeface.SERIF;
            } else if (i2 != 3) {
                this.n = Typeface.DEFAULT;
            } else {
                this.n = Typeface.MONOSPACE;
            }
            this.n = Typeface.create(this.n, this.d);
        }
    }

    public void b(Context context, xn4 xn4) {
        a();
        int i2 = this.l;
        if (i2 == 0) {
            this.m = true;
        }
        if (this.m) {
            xn4.b(this.n, true);
            return;
        }
        try {
            a aVar = new a(xn4);
            ThreadLocal<TypedValue> threadLocal = y5.f3999a;
            if (context.isRestricted()) {
                aVar.callbackFailAsync(-4, null);
            } else {
                y5.b(context, i2, new TypedValue(), 0, aVar, null, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.m = true;
            xn4.a(1);
        } catch (Exception unused2) {
            this.m = true;
            xn4.a(-3);
        }
    }

    public void c(Context context, TextPaint textPaint, xn4 xn4) {
        a();
        d(textPaint, this.n);
        b(context, new wn4(this, textPaint, xn4));
        ColorStateList colorStateList = this.f3665a;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f2 = this.h;
        float f3 = this.f;
        float f4 = this.g;
        ColorStateList colorStateList2 = this.b;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void d(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i2 = (~typeface.getStyle()) & this.d;
        textPaint.setFakeBoldText((i2 & 1) != 0);
        textPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.k);
        if (this.i) {
            textPaint.setLetterSpacing(this.j);
        }
    }
}

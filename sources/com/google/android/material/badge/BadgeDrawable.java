package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.R;
import com.google.firebase.perf.util.Constants;
import defpackage.kn4;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.concurrent.atomic.AtomicInteger;

public class BadgeDrawable extends Drawable implements kn4.b {
    public static final int v = R.style.Widget_MaterialComponents_Badge;
    public static final int w = R.attr.badgeStyle;
    public final WeakReference<Context> f;
    public final ho4 g = new ho4();
    public final kn4 h;
    public final Rect i = new Rect();
    public final float j;
    public final float k;
    public final float l;
    public final SavedState m;
    public float n;
    public float o;
    public int p;
    public float q;
    public float r;
    public float s;
    public WeakReference<View> t;
    public WeakReference<FrameLayout> u;

    public BadgeDrawable(Context context) {
        vn4 vn4;
        Context context2;
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.f = weakReference;
        mn4.c(context, mn4.b, "Theme.MaterialComponents");
        Resources resources = context.getResources();
        this.j = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
        this.l = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.k = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
        kn4 kn4 = new kn4(this);
        this.h = kn4;
        kn4.f2086a.setTextAlign(Paint.Align.CENTER);
        this.m = new SavedState(context);
        int i2 = R.style.TextAppearance_MaterialComponents_Badge;
        Context context3 = weakReference.get();
        if (context3 != null && kn4.f != (vn4 = new vn4(context3, i2)) && (context2 = weakReference.get()) != null) {
            kn4.b(vn4, context2);
            g();
        }
    }

    @Override // defpackage.kn4.b
    public void a() {
        invalidateSelf();
    }

    public final String b() {
        if (d() <= this.p) {
            return NumberFormat.getInstance().format((long) d());
        }
        Context context = this.f.get();
        if (context == null) {
            return "";
        }
        return context.getString(R.string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.p), "+");
    }

    public FrameLayout c() {
        WeakReference<FrameLayout> weakReference = this.u;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int d() {
        if (!e()) {
            return 0;
        }
        return this.m.i;
    }

    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && this.m.h != 0 && isVisible()) {
            this.g.draw(canvas);
            if (e()) {
                Rect rect = new Rect();
                String b = b();
                this.h.f2086a.getTextBounds(b, 0, b.length(), rect);
                canvas.drawText(b, this.n, this.o + ((float) (rect.height() / 2)), this.h.f2086a);
            }
        }
    }

    public boolean e() {
        return this.m.i != -1;
    }

    public void f(View view, FrameLayout frameLayout) {
        this.t = new WeakReference<>(view);
        this.u = new WeakReference<>(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        g();
        invalidateSelf();
    }

    public final void g() {
        float f2;
        float f3;
        Context context = this.f.get();
        WeakReference<View> weakReference = this.t;
        FrameLayout frameLayout = null;
        View view = weakReference != null ? weakReference.get() : null;
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.i);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.u;
            if (weakReference2 != null) {
                frameLayout = weakReference2.get();
            }
            if (frameLayout != null) {
                if (frameLayout == null) {
                    frameLayout = (ViewGroup) view.getParent();
                }
                frameLayout.offsetDescendantRectToMyCoords(view, rect2);
            }
            SavedState savedState = this.m;
            int i2 = savedState.n;
            if (i2 == 8388691 || i2 == 8388693) {
                this.o = (float) (rect2.bottom - savedState.q);
            } else {
                this.o = (float) (rect2.top + savedState.q);
            }
            if (d() <= 9) {
                float f4 = !e() ? this.j : this.k;
                this.q = f4;
                this.s = f4;
                this.r = f4;
            } else {
                float f5 = this.k;
                this.q = f5;
                this.s = f5;
                this.r = (this.h.a(b()) / 2.0f) + this.l;
            }
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(e() ? R.dimen.mtrl_badge_text_horizontal_edge_offset : R.dimen.mtrl_badge_horizontal_edge_offset);
            int i3 = this.m.n;
            if (i3 == 8388659 || i3 == 8388691) {
                AtomicInteger atomicInteger = r8.f3055a;
                if (view.getLayoutDirection() == 0) {
                    f2 = (((float) rect2.left) - this.r) + ((float) dimensionPixelSize) + ((float) this.m.p);
                } else {
                    f2 = ((((float) rect2.right) + this.r) - ((float) dimensionPixelSize)) - ((float) this.m.p);
                }
                this.n = f2;
            } else {
                AtomicInteger atomicInteger2 = r8.f3055a;
                if (view.getLayoutDirection() == 0) {
                    f3 = ((((float) rect2.right) + this.r) - ((float) dimensionPixelSize)) - ((float) this.m.p);
                } else {
                    f3 = (((float) rect2.left) - this.r) + ((float) dimensionPixelSize) + ((float) this.m.p);
                }
                this.n = f3;
            }
            Rect rect3 = this.i;
            float f6 = this.n;
            float f7 = this.o;
            float f8 = this.r;
            float f9 = this.s;
            rect3.set((int) (f6 - f8), (int) (f7 - f9), (int) (f6 + f8), (int) (f7 + f9));
            ho4 ho4 = this.g;
            ho4.f.f1403a = ho4.f.f1403a.e(this.q);
            ho4.invalidateSelf();
            if (!rect.equals(this.i)) {
                this.g.setBounds(this.i);
            }
        }
    }

    public int getAlpha() {
        return this.m.h;
    }

    public int getIntrinsicHeight() {
        return this.i.height();
    }

    public int getIntrinsicWidth() {
        return this.i.width();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isStateful() {
        return false;
    }

    @Override // defpackage.kn4.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void setAlpha(int i2) {
        this.m.h = i2;
        this.h.f2086a.setAlpha(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int f;
        public int g;
        public int h = Constants.MAX_HOST_LENGTH;
        public int i = -1;
        public int j;
        public CharSequence k;
        public int l;
        public int m;
        public int n;
        public boolean o;
        public int p;
        public int q;

        public static class a implements Parcelable.Creator<SavedState> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Context context) {
            int i2 = R.style.TextAppearance_MaterialComponents_Badge;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.TextAppearance);
            obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
            ColorStateList h1 = hd3.h1(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor);
            hd3.h1(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
            hd3.h1(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
            obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
            obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
            int i3 = R.styleable.TextAppearance_fontFamily;
            i3 = !obtainStyledAttributes.hasValue(i3) ? R.styleable.TextAppearance_android_fontFamily : i3;
            obtainStyledAttributes.getResourceId(i3, 0);
            obtainStyledAttributes.getString(i3);
            obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
            hd3.h1(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
            obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
            obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
            obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i2, R.styleable.MaterialTextAppearance);
            int i4 = R.styleable.MaterialTextAppearance_android_letterSpacing;
            obtainStyledAttributes2.hasValue(i4);
            obtainStyledAttributes2.getFloat(i4, 0.0f);
            obtainStyledAttributes2.recycle();
            this.g = h1.getDefaultColor();
            this.k = context.getString(R.string.mtrl_badge_numberless_content_description);
            this.l = R.plurals.mtrl_badge_content_description;
            this.m = R.string.mtrl_exceed_max_badge_number_content_description;
            this.o = true;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h);
            parcel.writeInt(this.i);
            parcel.writeInt(this.j);
            parcel.writeString(this.k.toString());
            parcel.writeInt(this.l);
            parcel.writeInt(this.n);
            parcel.writeInt(this.p);
            parcel.writeInt(this.q);
            parcel.writeInt(this.o ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            this.h = parcel.readInt();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readString();
            this.l = parcel.readInt();
            this.n = parcel.readInt();
            this.p = parcel.readInt();
            this.q = parcel.readInt();
            this.o = parcel.readInt() != 0;
        }
    }
}

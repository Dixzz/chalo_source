package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import pl.droidsonroids.gif.GifInfoHandle;
import pl.droidsonroids.gif.R;

/* renamed from: zn6  reason: default package */
/* compiled from: GifViewUtils */
public final class zn6 {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f4192a = Arrays.asList("raw", "drawable", "mipmap");

    public static void a(int i, Drawable drawable) {
        if (drawable instanceof wn6) {
            GifInfoHandle gifInfoHandle = ((wn6) drawable).l;
            Objects.requireNonNull(gifInfoHandle);
            if (i < 0 || i > 65535) {
                throw new IllegalArgumentException("Loop count of range <0, 65535>");
            }
            synchronized (gifInfoHandle) {
                GifInfoHandle.setLoopCount(gifInfoHandle.f2819a, (char) i);
            }
        }
    }

    public static boolean b(ImageView imageView, boolean z, int i) {
        Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                if (!f4192a.contains(resources.getResourceTypeName(i))) {
                    return false;
                }
                wn6 wn6 = new wn6(resources, i);
                if (z) {
                    imageView.setImageDrawable(wn6);
                    return true;
                }
                imageView.setBackground(wn6);
                return true;
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return false;
    }

    /* renamed from: zn6$a */
    /* compiled from: GifViewUtils */
    public static class a extends b {
        public final int c;
        public final int d;

        public a(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
            super(imageView, attributeSet, i, i2);
            this.c = a(imageView, attributeSet, true);
            this.d = a(imageView, attributeSet, false);
        }

        public static int a(ImageView imageView, AttributeSet attributeSet, boolean z) {
            int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", z ? "src" : ProductPromotionsObject.KEY_BACKGROUND, 0);
            if (attributeResourceValue > 0) {
                if (!zn6.f4192a.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) || zn6.b(imageView, z, attributeResourceValue)) {
                    return 0;
                }
                return attributeResourceValue;
            }
            return 0;
        }

        public a() {
            this.c = 0;
            this.d = 0;
        }
    }

    /* renamed from: zn6$b */
    /* compiled from: GifViewUtils */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4193a;
        public final int b;

        public b(View view, AttributeSet attributeSet, int i, int i2) {
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.GifView, i, i2);
            this.f4193a = obtainStyledAttributes.getBoolean(R.styleable.GifView_freezesAnimation, false);
            this.b = obtainStyledAttributes.getInt(R.styleable.GifView_loopCount, -1);
            obtainStyledAttributes.recycle();
        }

        public b() {
            this.f4193a = false;
            this.b = -1;
        }
    }
}

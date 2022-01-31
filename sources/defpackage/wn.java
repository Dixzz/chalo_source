package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: wn  reason: default package */
/* compiled from: ViewUtils */
public class wn {

    /* renamed from: a  reason: collision with root package name */
    public static final co f3805a;
    public static final Property<View, Float> b = new a(Float.class, "translationAlpha");

    /* renamed from: wn$a */
    /* compiled from: ViewUtils */
    public static class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(wn.a(view));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, Float f) {
            float floatValue = f.floatValue();
            wn.f3805a.e(view, floatValue);
        }
    }

    /* renamed from: wn$b */
    /* compiled from: ViewUtils */
    public static class b extends Property<View, Rect> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Rect get(View view) {
            AtomicInteger atomicInteger = r8.f3055a;
            return view.getClipBounds();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, Rect rect) {
            AtomicInteger atomicInteger = r8.f3055a;
            view.setClipBounds(rect);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            f3805a = new bo();
        } else if (i >= 23) {
            f3805a = new ao();
        } else if (i >= 22) {
            f3805a = new zn();
        } else {
            f3805a = new yn();
        }
        new b(Rect.class, "clipBounds");
    }

    public static float a(View view) {
        return f3805a.b(view);
    }

    public static void b(View view, int i, int i2, int i3, int i4) {
        f3805a.d(view, i, i2, i3, i4);
    }
}

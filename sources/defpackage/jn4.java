package defpackage;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.util.Objects;

/* renamed from: jn4  reason: default package */
/* compiled from: StaticLayoutBuilderCompat */
public final class jn4 {
    public static boolean j;
    public static Constructor<StaticLayout> k;
    public static Object l;

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f1958a;
    public final TextPaint b;
    public final int c;
    public int d;
    public Layout.Alignment e = Layout.Alignment.ALIGN_NORMAL;
    public int f = Integer.MAX_VALUE;
    public boolean g = true;
    public boolean h;
    public TextUtils.TruncateAt i = null;

    /* renamed from: jn4$a */
    /* compiled from: StaticLayoutBuilderCompat */
    public static class a extends Exception {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(java.lang.Throwable r3) {
            /*
                r2 = this;
                java.lang.String r0 = "Error thrown initializing StaticLayout "
                java.lang.StringBuilder r0 = defpackage.hj1.i0(r0)
                java.lang.String r1 = r3.getMessage()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r2.<init>(r0, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.jn4.a.<init>(java.lang.Throwable):void");
        }
    }

    public jn4(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.f1958a = charSequence;
        this.b = textPaint;
        this.c = i2;
        this.d = charSequence.length();
    }

    public StaticLayout a() throws a {
        if (this.f1958a == null) {
            this.f1958a = "";
        }
        int max = Math.max(0, this.c);
        CharSequence charSequence = this.f1958a;
        if (this.f == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.b, (float) max, this.i);
        }
        int min = Math.min(charSequence.length(), this.d);
        this.d = min;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            if (this.h) {
                this.e = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, min, this.b, max);
            obtain.setAlignment(this.e);
            obtain.setIncludePad(this.g);
            obtain.setTextDirection(this.h ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.i;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f);
            return obtain.build();
        }
        if (!j) {
            try {
                l = this.h && i2 >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
                k = declaredConstructor;
                declaredConstructor.setAccessible(true);
                j = true;
            } catch (Exception e2) {
                throw new a(e2);
            }
        }
        try {
            Constructor<StaticLayout> constructor = k;
            Objects.requireNonNull(constructor);
            Object obj = l;
            Objects.requireNonNull(obj);
            return constructor.newInstance(charSequence, 0, Integer.valueOf(this.d), this.b, Integer.valueOf(max), this.e, obj, Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.g), null, Integer.valueOf(max), Integer.valueOf(this.f));
        } catch (Exception e3) {
            throw new a(e3);
        }
    }
}

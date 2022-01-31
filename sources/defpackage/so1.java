package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* renamed from: so1  reason: default package */
/* compiled from: MemorySizeCalculator */
public final class so1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f3234a;
    public final int b;
    public final Context c;
    public final int d;

    /* renamed from: so1$a */
    /* compiled from: MemorySizeCalculator */
    public static final class a {
        public static final int e = (Build.VERSION.SDK_INT > 26 ? 4 : 1);

        /* renamed from: a  reason: collision with root package name */
        public final Context f3235a;
        public ActivityManager b;
        public c c;
        public float d = ((float) e);

        public a(Context context) {
            this.f3235a = context;
            this.b = (ActivityManager) context.getSystemService("activity");
            this.c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && this.b.isLowRamDevice()) {
                this.d = 0.0f;
            }
        }
    }

    /* renamed from: so1$b */
    /* compiled from: MemorySizeCalculator */
    public static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final DisplayMetrics f3236a;

        public b(DisplayMetrics displayMetrics) {
            this.f3236a = displayMetrics;
        }
    }

    /* renamed from: so1$c */
    /* compiled from: MemorySizeCalculator */
    public interface c {
    }

    public so1(a aVar) {
        this.c = aVar.f3235a;
        int i = aVar.b.isLowRamDevice() ? 2097152 : 4194304;
        this.d = i;
        ActivityManager activityManager = aVar.b;
        float f = 0.4f;
        int round = Math.round(((float) (activityManager.getMemoryClass() * 1024 * 1024)) * (activityManager.isLowRamDevice() ? 0.33f : f));
        DisplayMetrics displayMetrics = ((b) aVar.c).f3236a;
        float f2 = (float) (displayMetrics.widthPixels * displayMetrics.heightPixels * 4);
        int round2 = Math.round(aVar.d * f2);
        int round3 = Math.round(f2 * 2.0f);
        int i2 = round - i;
        if (round3 + round2 <= i2) {
            this.b = round3;
            this.f3234a = round2;
        } else {
            float f3 = ((float) i2) / (aVar.d + 2.0f);
            this.b = Math.round(2.0f * f3);
            this.f3234a = Math.round(f3 * aVar.d);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            a(this.b);
            a(this.f3234a);
            a(i);
            a(round);
            aVar.b.getMemoryClass();
            aVar.b.isLowRamDevice();
        }
    }

    public final String a(int i) {
        return Formatter.formatFileSize(this.c, (long) i);
    }
}

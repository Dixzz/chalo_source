package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.telephony.TelephonyManager;

/* renamed from: ri5  reason: default package */
/* compiled from: MultiSimManagerBase */
public abstract class ri5 implements qi5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3085a;
    public final nj5 b;

    @SuppressLint({"NewApi"})
    /* renamed from: ri5$a */
    /* compiled from: MultiSimManagerBase */
    public enum a {
        MEDIATEK_1(ki5.f2065a, 0, null),
        MEDIATEK_2(li5.f2223a, 0, null),
        SAMSUNG(ni5.f2561a, 0, "samsung"),
        MOTOROLA(mi5.f2384a, 0, "motorola"),
        LOLLIPOP_MR1_XIAOMI(di5.f841a, 22, "xiaomi"),
        MARSHMALLOW_SAMSUNG(hi5.f1377a, 23, "samsung"),
        MARSHMALLOW_HUAWEI(fi5.f1128a, 23, "huawei"),
        MARSHMALLOW_LG(gi5.f1266a, 23, "lge"),
        MARSHMALLOW_XIAOMI(ii5.f1520a, 23, "xiaomi"),
        MARSHMALLOW_YU(ji5.f1929a, 23, "yu"),
        SAMSUNG_LOLLIPOP_MR1(pi5.f2808a, 22, "samsung"),
        MARSHMALLOW(ei5.f977a, 23, null),
        SAMSUNG_LOLLIPOP(oi5.f2695a, 21, "samsung"),
        LOLLIPOP_MR1(ci5.f568a, 22, null),
        LG(zh5.f4176a, 21, "lge"),
        LOLLIPOP_2(bi5.f434a, 21, null),
        LOLLIPOP_1(ai5.f169a, 21, null);
        
        public si5 creator;
        public String manufacturer;
        public int minVersionCode;

        /* access modifiers changed from: public */
        static {
            int i = fj5.c;
            int i2 = gj5.c;
            int i3 = jj5.e;
            int i4 = ij5.m;
            int i5 = yi5.h;
            int i6 = cj5.i;
            int i7 = aj5.i;
            int i8 = bj5.i;
            int i9 = dj5.i;
            int i10 = ej5.i;
            int i11 = lj5.o;
            int i12 = zi5.h;
            int i13 = kj5.m;
            int i14 = xi5.g;
            int i15 = ti5.o;
            int i16 = vi5.o;
            int i17 = ui5.n;
        }

        private a(si5 si5, int i, String str) {
            this.creator = si5;
            this.minVersionCode = i;
            this.manufacturer = str;
        }
    }

    public ri5(Context context) {
        wh5 wh5;
        Context applicationContext = context.getApplicationContext();
        this.f3085a = applicationContext;
        if (wh5.b == null) {
            synchronized (wh5.class) {
                if (wh5.b == null) {
                    if (yh5.a(context)) {
                        wh5 = new yh5(context);
                    } else {
                        wh5 = new xh5(context);
                    }
                    wh5.b = wh5;
                }
            }
        }
        this.b = new nj5(applicationContext);
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } else if (i >= 23) {
            TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService("phone");
        } else {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        }
    }
}

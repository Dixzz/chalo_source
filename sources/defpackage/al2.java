package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.rabbitmq.client.StringRpcServer;
import com.razorpay.AnalyticsConstants;
import defpackage.i12;
import j$.util.concurrent.ConcurrentHashMap;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;

/* renamed from: al2  reason: default package */
public final class al2 implements i12.b {
    public static final Charset b = Charset.forName(StringRpcServer.STRING_ENCODING);
    public static final kf2 c;
    public static final kf2 d = new kf2(null, kh4.a("com.google.android.gms.clearcut.public"), "gms:playlog:service:sampling_", "LogSampling__", false, false);
    public static final ConcurrentHashMap<String, af2<nk2>> e = new ConcurrentHashMap<>();
    public static final HashMap<String, af2<String>> f = new HashMap<>();
    public static Boolean g = null;
    public static Long h = null;
    public static final af2<Boolean> i;

    /* renamed from: a  reason: collision with root package name */
    public final Context f177a;

    static {
        kf2 kf2 = new kf2(null, kh4.a("com.google.android.gms.clearcut.public"), "gms:playlog:service:samplingrules_", "LogSamplingRules__", false, false);
        c = kf2;
        Object obj = af2.g;
        i = new ff2(kf2, "enable_log_sampling_rules", Boolean.FALSE);
    }

    public al2(Context context) {
        this.f177a = context;
        if (context != null && af2.h == null) {
            synchronized (af2.g) {
                if (Build.VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                }
                if (af2.h != context) {
                    af2.i = null;
                }
                af2.h = context;
            }
        }
    }

    public static long a(String str, long j) {
        if (str == null || str.isEmpty()) {
            return gj1.Q0(ByteBuffer.allocate(8).putLong(j).array());
        }
        byte[] bytes = str.getBytes(b);
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 8);
        allocate.put(bytes);
        allocate.putLong(j);
        return gj1.Q0(allocate.array());
    }

    public static boolean b(long j, long j2, long j3) {
        if (j2 < 0 || j3 <= 0) {
            return true;
        }
        if (j < 0) {
            j = ((j & Long.MAX_VALUE) % j3) + (Long.MAX_VALUE % j3) + 1;
        }
        return j % j3 < j2;
    }

    public static boolean c(Context context) {
        if (g == null) {
            g = Boolean.valueOf(ob2.a(context).f2531a.checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return g.booleanValue();
    }

    public static long d(Context context) {
        Object obj;
        if (h == null) {
            long j = 0;
            if (context == null) {
                return 0;
            }
            if (c(context)) {
                ContentResolver contentResolver = context.getContentResolver();
                Uri uri = dl2.f853a;
                synchronized (dl2.class) {
                    dl2.c(contentResolver);
                    obj = dl2.k;
                }
                Long l = (Long) dl2.a(dl2.i, AnalyticsConstants.ANDROID_ID, 0L);
                if (l != null) {
                    j = l.longValue();
                } else {
                    String b2 = dl2.b(contentResolver, AnalyticsConstants.ANDROID_ID);
                    if (b2 != null) {
                        try {
                            long parseLong = Long.parseLong(b2);
                            l = Long.valueOf(parseLong);
                            j = parseLong;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    dl2.e(obj, dl2.i, AnalyticsConstants.ANDROID_ID, l);
                }
            }
            h = Long.valueOf(j);
        }
        return h.longValue();
    }
}

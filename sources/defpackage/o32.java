package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import defpackage.x22;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import server.zophop.Constants;

/* renamed from: o32  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public class o32 implements Handler.Callback {
    @RecentlyNonNull
    public static final Status p = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status q = new Status(4, "The user must be signed in to make this API call.");
    public static final Object r = new Object();
    @GuardedBy("lock")
    public static o32 s;

    /* renamed from: a  reason: collision with root package name */
    public long f2644a = Constants.THRESHOLD_TIMESTAMP;
    public boolean b = false;
    public TelemetryData c;
    public j82 d;
    public final Context e;
    public final q22 f;
    public final m92 g;
    public final AtomicInteger h;
    public final AtomicInteger i;
    public final Map<j32<?>, p52<?>> j;
    @GuardedBy("lock")
    public g42 k;
    @GuardedBy("lock")
    public final Set<j32<?>> l;
    public final Set<j32<?>> m;
    @NotOnlyInitialized
    public final Handler n;
    public volatile boolean o;

    public o32(Context context, Looper looper, q22 q22) {
        boolean z = true;
        this.h = new AtomicInteger(1);
        this.i = new AtomicInteger(0);
        this.j = new ConcurrentHashMap(5, 0.75f, 1);
        this.k = null;
        this.l = new p2(0);
        this.m = new p2(0);
        this.o = true;
        this.e = context;
        ve2 ve2 = new ve2(looper, this);
        this.n = ve2;
        this.f = q22;
        this.g = new m92(q22);
        PackageManager packageManager = context.getPackageManager();
        if (gj1.e == null) {
            gj1.e = Boolean.valueOf((!gj1.N() || !packageManager.hasSystemFeature("android.hardware.type.automotive")) ? false : z);
        }
        if (gj1.e.booleanValue()) {
            this.o = false;
        }
        ve2.sendMessage(ve2.obtainMessage(6));
    }

    public static Status c(j32<?> j32, ConnectionResult connectionResult) {
        String str = j32.b.c;
        String valueOf = String.valueOf(connectionResult);
        return new Status(1, 17, hj1.c0(new StringBuilder(String.valueOf(str).length() + 63 + valueOf.length()), "API: ", str, " is not available on this device. Connection failed with: ", valueOf), connectionResult.h, connectionResult);
    }

    @RecentlyNonNull
    public static o32 e(@RecentlyNonNull Context context) {
        o32 o32;
        synchronized (r) {
            if (s == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                Looper looper = handlerThread.getLooper();
                Context applicationContext = context.getApplicationContext();
                Object obj = q22.c;
                s = new o32(applicationContext, looper, q22.d);
            }
            o32 = s;
        }
        return o32;
    }

    public final p52<?> a(z22<?> z22) {
        j32<?> apiKey = z22.getApiKey();
        p52<?> p52 = this.j.get(apiKey);
        if (p52 == null) {
            p52 = new p52<>(this, z22);
            this.j.put(apiKey, p52);
        }
        if (p52.s()) {
            this.m.add(apiKey);
        }
        p52.r();
        return p52;
    }

    public final <T> void b(zi4<T> zi4, int i2, z22 z22) {
        if (i2 != 0) {
            j32 apiKey = z22.getApiKey();
            a62 a62 = null;
            if (g()) {
                RootTelemetryConfiguration rootTelemetryConfiguration = i82.a().f1489a;
                boolean z = true;
                if (rootTelemetryConfiguration != null) {
                    if (rootTelemetryConfiguration.g) {
                        boolean z2 = rootTelemetryConfiguration.h;
                        p52<?> p52 = this.j.get(apiKey);
                        if (p52 != null) {
                            x22.f fVar = p52.g;
                            if (fVar instanceof w72) {
                                w72 w72 = (w72) fVar;
                                if (w72.hasConnectionInfo() && !w72.isConnecting()) {
                                    ConnectionTelemetryConfiguration a2 = a62.a(p52, w72, i2);
                                    if (a2 != null) {
                                        p52.q++;
                                        z = a2.h;
                                    }
                                }
                            }
                        }
                        z = z2;
                    }
                }
                a62 = new a62(this, i2, apiKey, z ? System.currentTimeMillis() : 0);
            }
            if (a62 != null) {
                wj4<TResult> wj4 = zi4.f4178a;
                Handler handler = this.n;
                handler.getClass();
                wj4.b.a(new lj4(new j52(handler), a62));
                wj4.x();
            }
        }
    }

    public final void d() {
        TelemetryData telemetryData = this.c;
        if (telemetryData != null) {
            if (telemetryData.f > 0 || g()) {
                if (this.d == null) {
                    this.d = new y82(this.e, k82.g);
                }
                ((y82) this.d).a(telemetryData);
            }
            this.c = null;
        }
    }

    public final void f(g42 g42) {
        synchronized (r) {
            if (this.k != g42) {
                this.k = g42;
                this.l.clear();
            }
            this.l.addAll(g42.k);
        }
    }

    public final boolean g() {
        if (this.b) {
            return false;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration = i82.a().f1489a;
        if (rootTelemetryConfiguration != null && !rootTelemetryConfiguration.g) {
            return false;
        }
        int i2 = this.g.f2341a.get(203390000, -1);
        if (i2 == -1 || i2 == 0) {
            return true;
        }
        return false;
    }

    public final boolean h(ConnectionResult connectionResult, int i2) {
        PendingIntent pendingIntent;
        q22 q22 = this.f;
        Context context = this.e;
        Objects.requireNonNull(q22);
        if (connectionResult.l1()) {
            pendingIntent = connectionResult.h;
        } else {
            Intent a2 = q22.a(context, connectionResult.g, null);
            if (a2 == null) {
                pendingIntent = null;
            } else {
                pendingIntent = PendingIntent.getActivity(context, 0, a2, 134217728);
            }
        }
        if (pendingIntent == null) {
            return false;
        }
        int i3 = connectionResult.g;
        int i4 = GoogleApiActivity.g;
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i2);
        intent.putExtra("notify_manager", true);
        q22.h(context, i3, null, PendingIntent.getActivity(context, 0, intent, 134217728));
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0115, code lost:
        r6 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(@androidx.annotation.RecentlyNonNull android.os.Message r11) {
        /*
        // Method dump skipped, instructions count: 1042
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o32.handleMessage(android.os.Message):boolean");
    }

    public final void i(@RecentlyNonNull ConnectionResult connectionResult, int i2) {
        if (!h(connectionResult, i2)) {
            Handler handler = this.n;
            handler.sendMessage(handler.obtainMessage(5, i2, 0, connectionResult));
        }
    }
}

package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Looper;
import android.os.SystemClock;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.android.gms.measurement.internal.zzz;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: re4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class re4 extends bc4 {
    public final lf4 c;
    public ja4 d;
    public volatile Boolean e;
    public final j64 f;
    public final fg4 g;
    public final List<Runnable> h = new ArrayList();
    public final j64 i;

    public re4(vb4 vb4) {
        super(vb4);
        this.g = new fg4(vb4.n);
        this.c = new lf4(this);
        this.f = new qe4(this, vb4);
        this.i = new af4(this, vb4);
    }

    public static void w(re4 re4, ComponentName componentName) {
        re4.b();
        if (re4.d != null) {
            re4.d = null;
            re4.g().n.b("Disconnected from device MeasurementService", componentName);
            re4.b();
            re4.B();
        }
    }

    public final boolean A() {
        b();
        s();
        return this.d != null;
    }

    public final void B() {
        b();
        s();
        if (!A()) {
            if (F()) {
                lf4 lf4 = this.c;
                lf4.c.b();
                Context context = lf4.c.f3331a.f3627a;
                synchronized (lf4) {
                    if (lf4.f2209a) {
                        lf4.c.g().n.a("Connection attempt already in progress");
                    } else if (lf4.b == null || (!lf4.b.isConnecting() && !lf4.b.isConnected())) {
                        lf4.b = new sa4(context, Looper.getMainLooper(), lf4, lf4);
                        lf4.c.g().n.a("Connecting to remote service");
                        lf4.f2209a = true;
                        lf4.b.checkAvailabilityAndConnect();
                    } else {
                        lf4.c.g().n.a("Already awaiting connection attempt");
                    }
                }
            } else if (!this.f3331a.g.B()) {
                List<ResolveInfo> queryIntentServices = this.f3331a.f3627a.getPackageManager().queryIntentServices(new Intent().setClassName(this.f3331a.f3627a, "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    intent.setComponent(new ComponentName(this.f3331a.f3627a, "com.google.android.gms.measurement.AppMeasurementService"));
                    lf4 lf42 = this.c;
                    lf42.c.b();
                    Context context2 = lf42.c.f3331a.f3627a;
                    za2 b = za2.b();
                    synchronized (lf42) {
                        if (lf42.f2209a) {
                            lf42.c.g().n.a("Connection attempt already in progress");
                            return;
                        }
                        lf42.c.g().n.a("Using local app measurement service");
                        lf42.f2209a = true;
                        b.a(context2, intent, lf42.c.c, 129);
                        return;
                    }
                }
                g().f.a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    public final void C() {
        b();
        s();
        lf4 lf4 = this.c;
        if (lf4.b != null && (lf4.b.isConnected() || lf4.b.isConnecting())) {
            lf4.b.disconnect();
        }
        lf4.b = null;
        try {
            za2.b().c(this.f3331a.f3627a, this.c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.d = null;
    }

    public final boolean D() {
        b();
        s();
        if (!this.f3331a.g.l(q64.J0)) {
            return false;
        }
        if (F() && h().x0() < q64.K0.a(null).intValue()) {
            return false;
        }
        return true;
    }

    public final void E() {
        b();
        fg4 fg4 = this.g;
        Objects.requireNonNull((db2) fg4.f1120a);
        fg4.b = SystemClock.elapsedRealtime();
        this.f.b(q64.J.a(null).longValue());
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean F() {
        /*
        // Method dump skipped, instructions count: 293
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.re4.F():boolean");
    }

    public final void G() {
        b();
        g().n.b("Processing queued up service tasks", Integer.valueOf(this.h.size()));
        for (Runnable runnable : this.h) {
            try {
                runnable.run();
            } catch (Exception e2) {
                g().f.b("Task exception while flushing queue", e2);
            }
        }
        this.h.clear();
        this.i.c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x021e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzn H(boolean r36) {
        /*
        // Method dump skipped, instructions count: 608
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.re4.H(boolean):com.google.android.gms.measurement.internal.zzn");
    }

    @Override // defpackage.bc4
    public final boolean u() {
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:64|65|66) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:38|39|40|185) */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r8.g().f.a("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00db, code lost:
        r15.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00de, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r8.g().f.a("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0106, code lost:
        r15.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0110, code lost:
        r15.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0113, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x012e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r8.g().f.a("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x013b, code lost:
        r15.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0145, code lost:
        r15.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0148, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00cb */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x00fb */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x0130 */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01c8 A[SYNTHETIC, Splitter:B:108:0x01c8] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0218 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0218 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0218 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v(defpackage.ja4 r28, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable r29, com.google.android.gms.measurement.internal.zzn r30) {
        /*
        // Method dump skipped, instructions count: 696
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.re4.v(ja4, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable, com.google.android.gms.measurement.internal.zzn):void");
    }

    public final void x(zzz zzz) {
        boolean z;
        b();
        s();
        na4 p = p();
        p.h();
        byte[] f0 = ug4.f0(zzz);
        if (f0.length > 131072) {
            p.g().g.a("Conditional user property too long for local database. Sending directly to service");
            z = false;
        } else {
            z = p.w(2, f0);
        }
        y(new hf4(this, z, new zzz(zzz), H(true), zzz));
    }

    public final void y(Runnable runnable) throws IllegalStateException {
        b();
        if (A()) {
            runnable.run();
        } else if (((long) this.h.size()) >= 1000) {
            g().f.a("Discarding data. Max runnable queue size reached");
        } else {
            this.h.add(runnable);
            this.i.b(DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
            B();
        }
    }

    public final void z(AtomicReference<String> atomicReference) {
        b();
        s();
        y(new we4(this, atomicReference, H(false)));
    }
}

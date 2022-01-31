package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: ac4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class ac4 extends ma4 {
    public final lg4 f;
    public Boolean g;
    public String h = null;

    public ac4(lg4 lg4) {
        Objects.requireNonNull(lg4, "null reference");
        this.f = lg4;
    }

    public final void C1(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.g == null) {
                        if (!"com.google.android.gms".equals(this.h) && !gj1.O(this.f.j.f3627a, Binder.getCallingUid())) {
                            if (!v22.a(this.f.j.f3627a).b(Binder.getCallingUid())) {
                                z2 = false;
                                this.g = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.g = Boolean.valueOf(z2);
                    }
                    if (this.g.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.f.g().f.b("Measurement Service called with invalid calling package. appId", ra4.q(str));
                    throw e;
                }
            }
            if (this.h == null && u22.uidHasPackageName(this.f.j.f3627a, Binder.getCallingUid(), str)) {
                this.h = str;
            }
            if (!str.equals(this.h)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
            }
            return;
        }
        this.f.g().f.a("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    public final void F(zzz zzz) {
        Objects.requireNonNull(zzz, "null reference");
        Objects.requireNonNull(zzz.h, "null reference");
        C1(zzz.f, true);
        L(new fc4(this, new zzz(zzz)));
    }

    @Override // defpackage.ja4
    public final void H2(zzaq zzaq, zzn zzn) {
        Objects.requireNonNull(zzaq, "null reference");
        M3(zzn);
        L(new kc4(this, zzaq, zzn));
    }

    public final void L(Runnable runnable) {
        if (this.f.f().x()) {
            runnable.run();
        } else {
            this.f.f().u(runnable);
        }
    }

    @Override // defpackage.ja4
    public final List<zzku> L1(String str, String str2, boolean z, zzn zzn) {
        M3(zzn);
        try {
            List<vg4> list = (List) ((FutureTask) this.f.f().s(new ec4(this, zzn, str, str2))).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (vg4 vg4 : list) {
                if (z || !ug4.q0(vg4.c)) {
                    arrayList.add(new zzku(vg4));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.f.g().f.c("Failed to query user properties. appId", ra4.q(zzn.f), e);
            return Collections.emptyList();
        }
    }

    public final void M3(zzn zzn) {
        Objects.requireNonNull(zzn, "null reference");
        C1(zzn.f, false);
        this.f.j.t().b0(zzn.g, zzn.w, zzn.A);
    }

    @Override // defpackage.ja4
    public final void N1(zzn zzn) {
        M3(zzn);
        L(new rc4(this, zzn));
    }

    @Override // defpackage.ja4
    public final String O0(zzn zzn) {
        M3(zzn);
        lg4 lg4 = this.f;
        try {
            return (String) ((FutureTask) lg4.j.f().s(new pg4(lg4, zzn))).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            lg4.j.g().f.c("Failed to get app instance id. appId", ra4.q(zzn.f), e);
            return null;
        }
    }

    @Override // defpackage.ja4
    public final void P2(Bundle bundle, zzn zzn) {
        if (f04.a() && this.f.j.g.l(q64.A0)) {
            M3(zzn);
            L(new zb4(this, zzn, bundle));
        }
    }

    @Override // defpackage.ja4
    public final byte[] R(zzaq zzaq, String str) {
        gj1.j(str);
        Objects.requireNonNull(zzaq, "null reference");
        C1(str, true);
        this.f.g().m.b("Log and bundle. event", this.f.O().t(zzaq.f));
        Objects.requireNonNull((db2) this.f.j.n);
        long nanoTime = System.nanoTime() / 1000000;
        sb4 f2 = this.f.f();
        mc4 mc4 = new mc4(this, zzaq, str);
        f2.l();
        tb4<?> tb4 = new tb4<>(f2, (Callable<?>) mc4, true, "Task exception on worker thread");
        if (Thread.currentThread() == f2.c) {
            tb4.run();
        } else {
            f2.t(tb4);
        }
        try {
            byte[] bArr = (byte[]) tb4.get();
            if (bArr == null) {
                this.f.g().f.b("Log and bundle returned null. appId", ra4.q(str));
                bArr = new byte[0];
            }
            Objects.requireNonNull((db2) this.f.j.n);
            this.f.g().m.d("Log and bundle processed. event, size, time_ms", this.f.O().t(zzaq.f), Integer.valueOf(bArr.length), Long.valueOf((System.nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.f.g().f.d("Failed to log and bundle. appId, event, error", ra4.q(str), this.f.O().t(zzaq.f), e);
            return null;
        }
    }

    @Override // defpackage.ja4
    public final void S(zzn zzn) {
        if (uy3.a() && this.f.j.g.l(q64.J0)) {
            gj1.j(zzn.f);
            Objects.requireNonNull(zzn.B, "null reference");
            lc4 lc4 = new lc4(this, zzn);
            if (this.f.f().x()) {
                lc4.run();
            } else {
                this.f.f().v(lc4);
            }
        }
    }

    @Override // defpackage.ja4
    public final void l1(long j, String str, String str2, String str3) {
        L(new qc4(this, str2, str3, str, j));
    }

    @Override // defpackage.ja4
    public final List<zzku> p0(String str, String str2, String str3, boolean z) {
        C1(str, true);
        try {
            List<vg4> list = (List) ((FutureTask) this.f.f().s(new hc4(this, str, str2, str3))).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (vg4 vg4 : list) {
                if (z || !ug4.q0(vg4.c)) {
                    arrayList.add(new zzku(vg4));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.f.g().f.c("Failed to get user properties as. appId", ra4.q(str), e);
            return Collections.emptyList();
        }
    }

    @Override // defpackage.ja4
    public final void p1(zzn zzn) {
        C1(zzn.f, false);
        L(new ic4(this, zzn));
    }

    @Override // defpackage.ja4
    public final List<zzz> q1(String str, String str2, String str3) {
        C1(str, true);
        try {
            return (List) ((FutureTask) this.f.f().s(new jc4(this, str, str2, str3))).get();
        } catch (InterruptedException | ExecutionException e) {
            this.f.g().f.b("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    @Override // defpackage.ja4
    public final void q2(zzn zzn) {
        M3(zzn);
        L(new dc4(this, zzn));
    }

    @Override // defpackage.ja4
    public final void q3(zzku zzku, zzn zzn) {
        Objects.requireNonNull(zzku, "null reference");
        M3(zzn);
        L(new pc4(this, zzku, zzn));
    }

    @Override // defpackage.ja4
    public final List<zzz> s1(String str, String str2, zzn zzn) {
        M3(zzn);
        try {
            return (List) ((FutureTask) this.f.f().s(new gc4(this, zzn, str, str2))).get();
        } catch (InterruptedException | ExecutionException e) {
            this.f.g().f.b("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // defpackage.ja4
    public final void v3(zzz zzz, zzn zzn) {
        Objects.requireNonNull(zzz, "null reference");
        Objects.requireNonNull(zzz.h, "null reference");
        M3(zzn);
        zzz zzz2 = new zzz(zzz);
        zzz2.f = zzn.f;
        L(new cc4(this, zzz2, zzn));
    }
}

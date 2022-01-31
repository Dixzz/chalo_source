package defpackage;

import android.content.SharedPreferences;
import java.util.Objects;

/* renamed from: vd3  reason: default package */
public final class vd3 extends yb3 {
    public SharedPreferences h;
    public long i;
    public long j = -1;
    public final xd3 k = new xd3(this, "monitoring", id3.C.f1906a.longValue(), null);

    public vd3(ac3 ac3) {
        super(ac3);
    }

    @Override // defpackage.yb3
    public final void a0() {
        this.h = this.f.f146a.getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final long i0() {
        jz1.c();
        g0();
        if (this.i == 0) {
            long j2 = this.h.getLong("first_run", 0);
            if (j2 != 0) {
                this.i = j2;
            } else {
                Objects.requireNonNull((db2) this.f.c);
                long currentTimeMillis = System.currentTimeMillis();
                SharedPreferences.Editor edit = this.h.edit();
                edit.putLong("first_run", currentTimeMillis);
                if (!edit.commit()) {
                    T("Failed to commit first run time");
                }
                this.i = currentTimeMillis;
            }
        }
        return this.i;
    }

    public final long j0() {
        jz1.c();
        g0();
        if (this.j == -1) {
            this.j = this.h.getLong("last_dispatch", 0);
        }
        return this.j;
    }

    public final void m0() {
        jz1.c();
        g0();
        Objects.requireNonNull((db2) this.f.c);
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = this.h.edit();
        edit.putLong("last_dispatch", currentTimeMillis);
        edit.apply();
        this.j = currentTimeMillis;
    }
}

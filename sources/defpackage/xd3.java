package defpackage;

import android.content.SharedPreferences;
import java.util.Objects;
import java.util.UUID;

/* renamed from: xd3  reason: default package */
public final class xd3 {

    /* renamed from: a  reason: collision with root package name */
    public final String f3916a;
    public final long b;
    public final /* synthetic */ vd3 c;

    public xd3(vd3 vd3, String str, long j, wd3 wd3) {
        this.c = vd3;
        gj1.j(str);
        gj1.b(j > 0);
        this.f3916a = str;
        this.b = j;
    }

    public final void a(String str) {
        if (c() == 0) {
            b();
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            long j = this.c.h.getLong(d(), 0);
            if (j <= 0) {
                SharedPreferences.Editor edit = this.c.h.edit();
                edit.putString(e(), str);
                edit.putLong(d(), 1);
                edit.apply();
                return;
            }
            long j2 = j + 1;
            boolean z = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / j2;
            SharedPreferences.Editor edit2 = this.c.h.edit();
            if (z) {
                edit2.putString(e(), str);
            }
            edit2.putLong(d(), j2);
            edit2.apply();
        }
    }

    public final void b() {
        Objects.requireNonNull((db2) this.c.f.c);
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = this.c.h.edit();
        edit.remove(d());
        edit.remove(e());
        edit.putLong(String.valueOf(this.f3916a).concat(":start"), currentTimeMillis);
        edit.commit();
    }

    public final long c() {
        return this.c.h.getLong(String.valueOf(this.f3916a).concat(":start"), 0);
    }

    public final String d() {
        return String.valueOf(this.f3916a).concat(":count");
    }

    public final String e() {
        return String.valueOf(this.f3916a).concat(":value");
    }
}

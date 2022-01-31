package defpackage;

import android.content.SharedPreferences;
import java.util.Objects;

/* renamed from: lb4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class lb4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2197a;
    public final String b;
    public final String c;
    public final long d;
    public final /* synthetic */ eb4 e;

    public lb4(eb4 eb4, String str, long j, hb4 hb4) {
        this.e = eb4;
        gj1.j(str);
        gj1.b(j > 0);
        this.f2197a = str.concat(":start");
        this.b = str.concat(":count");
        this.c = str.concat(":value");
        this.d = j;
    }

    public final void a() {
        this.e.b();
        Objects.requireNonNull((db2) this.e.f3331a.n);
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = this.e.v().edit();
        edit.remove(this.b);
        edit.remove(this.c);
        edit.putLong(this.f2197a, currentTimeMillis);
        edit.apply();
    }
}

package defpackage;

import android.content.SharedPreferences;

/* renamed from: ib4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ib4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1502a;
    public final long b;
    public boolean c;
    public long d;
    public final /* synthetic */ eb4 e;

    public ib4(eb4 eb4, String str, long j) {
        this.e = eb4;
        gj1.j(str);
        this.f1502a = str;
        this.b = j;
    }

    public final long a() {
        if (!this.c) {
            this.c = true;
            this.d = this.e.v().getLong(this.f1502a, this.b);
        }
        return this.d;
    }

    public final void b(long j) {
        SharedPreferences.Editor edit = this.e.v().edit();
        edit.putLong(this.f1502a, j);
        edit.apply();
        this.d = j;
    }
}

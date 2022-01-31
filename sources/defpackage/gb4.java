package defpackage;

import android.content.SharedPreferences;

/* renamed from: gb4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class gb4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1236a;
    public final boolean b;
    public boolean c;
    public boolean d;
    public final /* synthetic */ eb4 e;

    public gb4(eb4 eb4, String str, boolean z) {
        this.e = eb4;
        gj1.j(str);
        this.f1236a = str;
        this.b = z;
    }

    public final void a(boolean z) {
        SharedPreferences.Editor edit = this.e.v().edit();
        edit.putBoolean(this.f1236a, z);
        edit.apply();
        this.d = z;
    }

    public final boolean b() {
        if (!this.c) {
            this.c = true;
            this.d = this.e.v().getBoolean(this.f1236a, this.b);
        }
        return this.d;
    }
}

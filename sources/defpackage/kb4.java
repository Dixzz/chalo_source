package defpackage;

import android.content.SharedPreferences;

/* renamed from: kb4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class kb4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2045a;
    public boolean b;
    public String c;
    public final /* synthetic */ eb4 d;

    public kb4(eb4 eb4, String str) {
        this.d = eb4;
        gj1.j(str);
        this.f2045a = str;
    }

    public final String a() {
        if (!this.b) {
            this.b = true;
            this.c = this.d.v().getString(this.f2045a, null);
        }
        return this.c;
    }

    public final void b(String str) {
        SharedPreferences.Editor edit = this.d.v().edit();
        edit.putString(this.f2045a, str);
        edit.apply();
        this.c = str;
    }
}

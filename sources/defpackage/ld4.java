package defpackage;

import android.os.Bundle;

/* renamed from: ld4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ld4 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ long h;
    public final /* synthetic */ Bundle i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ boolean l;
    public final /* synthetic */ String m;
    public final /* synthetic */ dd4 n;

    public ld4(dd4 dd4, String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.n = dd4;
        this.f = str;
        this.g = str2;
        this.h = j2;
        this.i = bundle;
        this.j = z;
        this.k = z2;
        this.l = z3;
        this.m = str3;
    }

    public final void run() {
        this.n.E(this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
    }
}

package defpackage;

import android.app.Activity;
import android.os.Bundle;

/* renamed from: mc2  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class mc2 implements sc2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f2353a;
    public final /* synthetic */ Bundle b;
    public final /* synthetic */ Bundle c;
    public final /* synthetic */ hc2 d;

    public mc2(hc2 hc2, Activity activity, Bundle bundle, Bundle bundle2) {
        this.d = hc2;
        this.f2353a = activity;
        this.b = bundle;
        this.c = bundle2;
    }

    @Override // defpackage.sc2
    public final void a(jc2 jc2) {
        this.d.f1357a.L(this.f2353a, this.b, this.c);
    }

    @Override // defpackage.sc2
    public final int d() {
        return 0;
    }
}

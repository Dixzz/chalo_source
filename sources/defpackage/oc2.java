package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* renamed from: oc2  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class oc2 implements sc2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameLayout f2676a;
    public final /* synthetic */ LayoutInflater b;
    public final /* synthetic */ ViewGroup c;
    public final /* synthetic */ Bundle d;
    public final /* synthetic */ hc2 e;

    public oc2(hc2 hc2, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = hc2;
        this.f2676a = frameLayout;
        this.b = layoutInflater;
        this.c = viewGroup;
        this.d = bundle;
    }

    @Override // defpackage.sc2
    public final void a(jc2 jc2) {
        this.f2676a.removeAllViews();
        this.f2676a.addView(this.e.f1357a.M(this.b, this.c, this.d));
    }

    @Override // defpackage.sc2
    public final int d() {
        return 2;
    }
}

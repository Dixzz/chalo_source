package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: iv0  reason: default package */
/* compiled from: MySupportMapFragment.kt */
public class iv0 extends i44 {
    public View g;
    public wd1 h;

    @Override // androidx.fragment.app.Fragment
    public View getView() {
        return this.g;
    }

    @Override // defpackage.i44, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n86.e(layoutInflater, "inflater");
        View b = this.f.b(layoutInflater, viewGroup, bundle);
        b.setClickable(true);
        this.g = b;
        wd1 wd1 = new wd1(c());
        this.h = wd1;
        n86.c(wd1);
        wd1.addView(this.g);
        return this.h;
    }
}

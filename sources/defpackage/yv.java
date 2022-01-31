package defpackage;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;

/* renamed from: yv  reason: default package */
/* compiled from: ActivityCardRechargeBinding */
public final class yv implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f4087a;
    public final yw b;
    public final LinearLayout c;
    public final LinearLayout d;
    public final Toolbar e;

    public yv(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView, yw ywVar, LinearLayout linearLayout, LinearLayout linearLayout2, Toolbar toolbar) {
        this.f4087a = constraintLayout;
        this.b = ywVar;
        this.c = linearLayout;
        this.d = linearLayout2;
        this.e = toolbar;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f4087a;
    }
}

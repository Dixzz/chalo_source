package defpackage;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: dw  reason: default package */
/* compiled from: ActivityOnlineCardRechargeHistoryBinding */
public final class dw implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f894a;
    public final RecyclerView b;
    public final sw c;
    public final LinearLayout d;
    public final Toolbar e;

    public dw(ConstraintLayout constraintLayout, RecyclerView recyclerView, yw ywVar, LinearLayout linearLayout, sw swVar, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, Toolbar toolbar) {
        this.f894a = constraintLayout;
        this.b = recyclerView;
        this.c = swVar;
        this.d = linearLayout2;
        this.e = toolbar;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f894a;
    }
}

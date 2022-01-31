package defpackage;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.ui.views.ZophopFormInput;

/* renamed from: ix  reason: default package */
/* compiled from: FragmentCardRechargeAmountBinding */
public final class ix implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f1579a;
    public final TextView b;
    public final TextView c;
    public final ZophopFormInput d;
    public final TextView e;
    public final TextView f;
    public final RecyclerView g;

    public ix(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ZophopFormInput zophopFormInput, TextView textView3, Guideline guideline, Guideline guideline2, ScrollView scrollView, TextView textView4, RecyclerView recyclerView) {
        this.f1579a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = zophopFormInput;
        this.e = textView3;
        this.f = textView4;
        this.g = recyclerView;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f1579a;
    }
}

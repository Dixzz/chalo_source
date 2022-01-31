package defpackage;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.ui.views.ZophopFormInput;

/* renamed from: hx  reason: default package */
/* compiled from: FragmentCardDetailsBinding */
public final class hx implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f1438a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final ZophopFormInput f;
    public final TextView g;
    public final ZophopFormInput h;
    public final RecyclerView i;
    public final LinearLayout j;

    public hx(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ZophopFormInput zophopFormInput, TextView textView5, Guideline guideline, Guideline guideline2, ZophopFormInput zophopFormInput2, RecyclerView recyclerView, LinearLayout linearLayout, ScrollView scrollView) {
        this.f1438a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = textView4;
        this.f = zophopFormInput;
        this.g = textView5;
        this.h = zophopFormInput2;
        this.i = recyclerView;
        this.j = linearLayout;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f1438a;
    }
}

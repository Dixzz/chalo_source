package defpackage;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ux  reason: default package */
/* compiled from: FragmentUserProofsOverviewBinding */
public final class ux implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f3564a;
    public final TextView b;
    public final RecyclerView c;

    public ux(ConstraintLayout constraintLayout, TextView textView, View view, LinearLayout linearLayout, TextView textView2, Guideline guideline, Guideline guideline2, RecyclerView recyclerView) {
        this.f3564a = constraintLayout;
        this.b = textView2;
        this.c = recyclerView;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f3564a;
    }
}

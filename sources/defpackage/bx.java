package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.R;

/* renamed from: bx  reason: default package */
/* compiled from: FareBreakdownComponentViewBinding */
public final class bx implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f485a;
    public final TextView b;
    public final TextView c;

    public bx(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.f485a = constraintLayout;
        this.b = textView;
        this.c = textView2;
    }

    public static bx b(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fare_breakdown_component_view, (ViewGroup) null, false);
        int i = R.id.amount_text;
        TextView textView = (TextView) inflate.findViewById(R.id.amount_text);
        if (textView != null) {
            i = R.id.name_text;
            TextView textView2 = (TextView) inflate.findViewById(R.id.name_text);
            if (textView2 != null) {
                return new bx((ConstraintLayout) inflate, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // defpackage.qo
    public View a() {
        return this.f485a;
    }
}

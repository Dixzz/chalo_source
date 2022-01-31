package defpackage;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.zophop.ui.views.summary_card.LoaderView;

/* renamed from: ly  reason: default package */
/* compiled from: LoadingSpinnerFragmentLayoutBinding */
public final class ly implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f2292a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final LinearLayout e;
    public final TextView f;
    public final LoaderView g;

    public ly(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, RelativeLayout relativeLayout2, TextView textView4, LoaderView loaderView) {
        this.f2292a = relativeLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = linearLayout;
        this.f = textView4;
        this.g = loaderView;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f2292a;
    }
}

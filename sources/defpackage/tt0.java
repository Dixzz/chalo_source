package defpackage;

import android.view.View;
import app.zophop.ui.fragments.BusFrequencyActivity;
import java.util.Objects;

/* renamed from: tt0  reason: default package */
/* compiled from: BusRouteFragment */
public class tt0 implements View.OnClickListener {
    public final /* synthetic */ mt0 f;

    public tt0(mt0 mt0) {
        this.f = mt0;
    }

    public void onClick(View view) {
        BusFrequencyActivity.l0(this.f.getActivity(), this.f.g);
        Objects.requireNonNull(this.f);
        ed1 ed1 = new ed1("view schedule clicked", Long.MIN_VALUE);
        ed1.a("source", "route details list");
        jz5.b().g(ed1);
    }
}

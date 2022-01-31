package defpackage;

import android.view.View;
import app.zophop.models.Route;
import app.zophop.ui.fragments.BusFrequencyActivity;

/* renamed from: w61  reason: default package */
/* compiled from: StopEtaUtil */
public class w61 implements View.OnClickListener {
    public final /* synthetic */ Route f;
    public final /* synthetic */ x61 g;

    public w61(x61 x61, Route route) {
        this.g = x61;
        this.f = route;
    }

    public void onClick(View view) {
        BusFrequencyActivity.l0(this.g.b, this.f);
    }
}

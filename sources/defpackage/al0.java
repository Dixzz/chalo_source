package defpackage;

import android.app.Activity;
import android.util.Pair;
import android.view.View;
import app.zophop.ui.activities.TripPlanningActivity;
import java.util.Objects;

/* renamed from: al0  reason: default package */
/* compiled from: UniversalSearchAdapter */
public class al0 implements View.OnClickListener {
    public final /* synthetic */ Pair f;
    public final /* synthetic */ wk0 g;

    public al0(wk0 wk0, Pair pair) {
        this.g = wk0;
        this.f = pair;
    }

    public void onClick(View view) {
        wk0 wk0 = this.g;
        Pair pair = this.f;
        Objects.requireNonNull(wk0);
        md1 md1 = (md1) pair.first;
        mf1 mf1 = new mf1(md1.f2356a, md1.b);
        md1 md12 = (md1) pair.second;
        mf1 mf12 = new mf1(md12.f2356a, md12.b);
        xt.f3961a.X().a(mf1, mf12);
        TripPlanningActivity.m0((Activity) wk0.f, mf1, mf12, true);
        wk0.e(mf1.c, mf12.c, wk0.h);
    }
}

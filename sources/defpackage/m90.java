package defpackage;

import android.view.View;
import app.zophop.ui.activities.CityDiscontinuedActivity;

/* renamed from: m90  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class m90 implements View.OnClickListener {
    public final /* synthetic */ CityDiscontinuedActivity f;

    public /* synthetic */ m90(CityDiscontinuedActivity cityDiscontinuedActivity) {
        this.f = cityDiscontinuedActivity;
    }

    public final void onClick(View view) {
        CityDiscontinuedActivity cityDiscontinuedActivity = this.f;
        int i = CityDiscontinuedActivity.n;
        n86.e(cityDiscontinuedActivity, "this$0");
        jz5.b().g(new ed1("city discontinued change city clicked", Long.MIN_VALUE));
        cityDiscontinuedActivity.h0();
    }
}

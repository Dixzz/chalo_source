package defpackage;

import android.view.View;
import defpackage.gn0;
import defpackage.mt0;
import java.util.Objects;

/* renamed from: en0  reason: default package */
/* compiled from: ReportProblemDialog */
public class en0 implements View.OnClickListener {
    public final /* synthetic */ gn0 f;

    public en0(gn0 gn0) {
        this.f = gn0;
    }

    public void onClick(View view) {
        ed1 ed1 = new ed1("report problem cancelled", Long.MIN_VALUE);
        ed1.a("type", this.f.s);
        ed1.a("cityName", xt.f3961a.k().d().getName());
        jz5.b().g(ed1);
        gn0.a aVar = this.f.q;
        if (aVar != null) {
            Objects.requireNonNull((mt0.d) aVar);
        }
        this.f.dismiss();
    }
}

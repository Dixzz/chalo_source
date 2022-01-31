package defpackage;

import android.view.View;
import defpackage.gn0;
import defpackage.mt0;
import java.util.Objects;

/* renamed from: dn0  reason: default package */
/* compiled from: ReportProblemDialog */
public class dn0 implements View.OnClickListener {
    public final /* synthetic */ gn0 f;

    public dn0(gn0 gn0) {
        this.f = gn0;
    }

    public void onClick(View view) {
        this.f.dismiss();
        gn0.a aVar = this.f.q;
        if (aVar != null) {
            Objects.requireNonNull((mt0.d) aVar);
        }
    }
}

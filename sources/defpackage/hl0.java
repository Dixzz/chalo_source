package defpackage;

import android.app.Activity;
import android.view.View;
import app.zophop.models.Stop;
import defpackage.ig1;

/* renamed from: hl0  reason: default package */
/* compiled from: ZophopPickLocationDefaultAdapter */
public class hl0 implements View.OnClickListener {
    public final /* synthetic */ Stop f;
    public final /* synthetic */ gl0 g;

    public hl0(gl0 gl0, Stop stop) {
        this.g = gl0;
        this.f = stop;
    }

    public void onClick(View view) {
        pn0.c(((Activity) this.g.g).getFragmentManager(), new mf1(this.f.getName(), this.f.getLatLong()), ig1.a.RECENT);
    }
}

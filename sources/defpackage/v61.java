package defpackage;

import android.view.View;
import app.zophop.models.Route;
import app.zophop.models.Stop;
import app.zophop.ui.activities.BusEtaFrequencyActivity;
import java.util.List;

/* renamed from: v61  reason: default package */
/* compiled from: StopEtaUtil */
public class v61 implements View.OnClickListener {
    public final /* synthetic */ List f;
    public final /* synthetic */ Route g;
    public final /* synthetic */ Stop h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ x61 j;

    public v61(x61 x61, List list, Route route, Stop stop, boolean z) {
        this.j = x61;
        this.f = list;
        this.g = route;
        this.h = stop;
        this.i = z;
    }

    public void onClick(View view) {
        x61 x61 = this.j;
        BusEtaFrequencyActivity.n0(x61.b, this.f, null, this.g, this.h, this.i, x61.c);
        x61.a(this.j, this.g, this.h);
    }
}

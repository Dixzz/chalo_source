package defpackage;

import android.view.View;
import app.zophop.models.Route;
import app.zophop.models.Stop;
import app.zophop.ui.activities.BusEtaFrequencyActivity;
import java.util.Map;

/* renamed from: u61  reason: default package */
/* compiled from: StopEtaUtil */
public class u61 implements View.OnClickListener {
    public final /* synthetic */ Route f;
    public final /* synthetic */ Stop g;
    public final /* synthetic */ Map h;
    public final /* synthetic */ x61 i;

    public u61(x61 x61, Route route, Stop stop, Map map) {
        this.i = x61;
        this.f = route;
        this.g = stop;
        this.h = map;
    }

    public void onClick(View view) {
        x61.a(this.i, this.f, this.g);
        x61 x61 = this.i;
        BusEtaFrequencyActivity.n0(x61.b, null, this.h, this.f, x61.g, false, x61.c);
    }
}

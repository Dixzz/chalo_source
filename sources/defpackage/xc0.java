package defpackage;

import app.zophop.models.Stop;
import app.zophop.ui.activities.BusEtaFrequencyActivity;
import com.freshchat.consumer.sdk.beans.config.DefaultUserEventsConfig;
import defpackage.xt;
import java.util.Objects;

/* renamed from: xc0  reason: default package */
/* compiled from: BusEtaFrequencyActivity */
public class xc0 implements Runnable {
    public final /* synthetic */ Stop f;
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;
    public final /* synthetic */ BusEtaFrequencyActivity i;

    public xc0(BusEtaFrequencyActivity busEtaFrequencyActivity, Stop stop, int i2, int i3) {
        this.i = busEtaFrequencyActivity;
        this.f = stop;
        this.g = i2;
        this.h = i3;
    }

    public void run() {
        Stop stop = this.f;
        if (stop != null) {
            BusEtaFrequencyActivity busEtaFrequencyActivity = this.i;
            busEtaFrequencyActivity.z = true;
            int i2 = this.g;
            int i3 = this.h;
            Objects.requireNonNull(busEtaFrequencyActivity);
            xt.t1 t1Var = xt.f3961a;
            t1Var.c().q(hj1.B(t1Var), busEtaFrequencyActivity.m.getRouteId(), stop.getId(), busEtaFrequencyActivity.B, i2, i3);
            BusEtaFrequencyActivity busEtaFrequencyActivity2 = this.i;
            busEtaFrequencyActivity2.t.postDelayed(busEtaFrequencyActivity2.s, DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD);
        }
    }
}

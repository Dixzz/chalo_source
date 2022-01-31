package defpackage;

import android.view.View;
import android.widget.AdapterView;
import app.zophop.ui.activities.TripsSchedulesDirectionActivity;

/* renamed from: bh0  reason: default package */
/* compiled from: TripsSchedulesDirectionActivity */
public class bh0 implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ xi0 f;
    public final /* synthetic */ TripsSchedulesDirectionActivity g;

    public bh0(TripsSchedulesDirectionActivity tripsSchedulesDirectionActivity, xi0 xi0) {
        this.g = tripsSchedulesDirectionActivity;
        this.f = xi0;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        TripsSchedulesDirectionActivity tripsSchedulesDirectionActivity = this.g;
        tripsSchedulesDirectionActivity.k0(tripsSchedulesDirectionActivity.t.get(this.f.f.get(i)));
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        TripsSchedulesDirectionActivity tripsSchedulesDirectionActivity = this.g;
        tripsSchedulesDirectionActivity.k0(tripsSchedulesDirectionActivity.t.get("_all"));
    }
}

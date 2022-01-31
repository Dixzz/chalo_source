package defpackage;

import android.view.View;
import app.zophop.R;

/* renamed from: uk0  reason: default package */
/* compiled from: TripPlannerStopBasedResultsAdapter */
public class uk0 implements View.OnClickListener {
    public final /* synthetic */ Object f;
    public final /* synthetic */ tk0 g;

    public uk0(tk0 tk0, Object obj) {
        this.g = tk0;
        this.f = obj;
    }

    public void onClick(View view) {
        Object obj = this.f;
        if (obj instanceof String) {
            tk0 tk0 = this.g;
            z61 z61 = tk0.g;
            boolean z = !z61.h;
            boolean z2 = !z61.f4136a;
            if (((String) obj).equalsIgnoreCase(tk0.f.getString(R.string.STOPS_HEADER))) {
                z61 z612 = this.g.g;
                z612.h = z;
                z612.i();
            } else if (((String) this.f).equalsIgnoreCase(this.g.f.getString(R.string.Routes))) {
                z61 z613 = this.g.g;
                z613.f4136a = z2;
                z613.i();
            }
            this.g.notifyDataSetChanged();
        }
    }
}

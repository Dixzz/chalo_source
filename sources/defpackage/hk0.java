package defpackage;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.TransitMode;
import app.zophop.ui.fragments.SchedulerInputFormFragment;
import app.zophop.ui.fragments.SchedulerInputTripDetailsFragment;
import java.util.List;

/* renamed from: hk0  reason: default package */
/* compiled from: SchedularActivityTabAdapter */
public class hk0 extends ag1 {
    public final List<TransitMode> f;
    public final Favourite g;
    public final Context h;
    public final String i;

    public hk0(FragmentManager fragmentManager, Context context, List<TransitMode> list, Favourite favourite, String str) {
        super(fragmentManager);
        this.f = list;
        this.g = favourite;
        this.h = context;
        this.i = str;
    }

    @Override // defpackage.xf1
    public int a(int i2, boolean z) {
        return 0;
    }

    @Override // defpackage.ro
    public int d() {
        return this.f.size();
    }

    @Override // defpackage.ro
    public CharSequence e(int i2) {
        return this.h.getString(this.f.get(i2).get_resId()).toUpperCase();
    }

    @Override // defpackage.ag1
    public Fragment l(int i2) {
        TransitMode transitMode = this.f.get(i2);
        if (transitMode.equals(TransitMode.bus) || !ui1.Y()) {
            Favourite favourite = this.g;
            if (favourite == null || !favourite.getMode().equals(transitMode)) {
                SchedulerInputFormFragment schedulerInputFormFragment = new SchedulerInputFormFragment();
                Bundle bundle = new Bundle();
                SchedulerInputFormFragment.o(null, transitMode.toString(), null, bundle);
                schedulerInputFormFragment.setArguments(bundle);
                return schedulerInputFormFragment;
            }
            Favourite favourite2 = this.g;
            String str = this.i;
            SchedulerInputFormFragment schedulerInputFormFragment2 = new SchedulerInputFormFragment();
            Bundle bundle2 = new Bundle();
            SchedulerInputFormFragment.o(favourite2, null, str, bundle2);
            schedulerInputFormFragment2.setArguments(bundle2);
            return schedulerInputFormFragment2;
        }
        SchedulerInputTripDetailsFragment schedulerInputTripDetailsFragment = new SchedulerInputTripDetailsFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putString("extra_mode", transitMode.toString());
        schedulerInputTripDetailsFragment.setArguments(bundle3);
        return schedulerInputTripDetailsFragment;
    }
}

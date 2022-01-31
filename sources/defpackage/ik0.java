package defpackage;

import android.content.Context;
import android.view.View;
import app.zophop.models.TransitMode;
import java.util.List;

/* renamed from: ik0  reason: default package */
/* compiled from: SchedulerModePagerAdapter */
public class ik0 extends zf1 {
    public final Context c;
    public final List<TransitMode> d;
    public final ci1<TransitMode> e;

    public ik0(Context context, List<TransitMode> list, ci1<TransitMode> ci1) {
        this.d = list;
        this.c = context;
        this.e = ci1;
    }

    @Override // defpackage.ro
    public int d() {
        return this.d.size();
    }

    @Override // defpackage.ro
    public CharSequence e(int i) {
        return this.c.getString(this.d.get(i).get_resId()).toUpperCase();
    }

    @Override // defpackage.ro
    public boolean g(View view, Object obj) {
        return obj == view;
    }
}

package defpackage;

import app.zophop.models.UniversalSearchItem;
import app.zophop.ui.activities.UniversalPickerActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* renamed from: fh0  reason: default package */
/* compiled from: UniversalPickerActivity */
public class fh0 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ UniversalPickerActivity g;

    public fh0(UniversalPickerActivity universalPickerActivity, String str) {
        this.g = universalPickerActivity;
        this.f = str;
    }

    public void run() {
        UniversalPickerActivity universalPickerActivity = this.g;
        String str = this.f;
        int i = UniversalPickerActivity.s;
        if (vn.K0(universalPickerActivity)) {
            List<UniversalSearchItem> e = xt.f3961a.j0().e(str, "universalSearch", null, UUID.randomUUID().toString());
            if (((ArrayList) e).size() != 0) {
                wk0 wk0 = universalPickerActivity.m;
                wk0.g.j(e, str);
                wk0.h = str;
                wk0.notifyDataSetChanged();
            } else {
                universalPickerActivity.m.a();
            }
            universalPickerActivity.q = str;
            universalPickerActivity.m.f(true);
            return;
        }
        List<UniversalSearchItem> f2 = xt.f3961a.j0().f(str);
        wk0 wk02 = universalPickerActivity.m;
        wk02.g.j(f2, str);
        wk02.h = str;
        wk02.notifyDataSetChanged();
        universalPickerActivity.q = str;
        universalPickerActivity.j0();
        universalPickerActivity.m.f(false);
    }
}

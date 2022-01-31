package defpackage;

import android.view.View;
import com.google.android.material.R;

/* renamed from: yl4  reason: default package */
/* compiled from: MaterialCalendar */
public class yl4 extends z7 {
    public final /* synthetic */ wl4 d;

    public yl4(wl4 wl4) {
        this.d = wl4;
    }

    @Override // defpackage.z7
    public void d(View view, e9 e9Var) {
        String str;
        this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
        if (this.d.p.getVisibility() == 0) {
            str = this.d.getString(R.string.mtrl_picker_toggle_to_year_selection);
        } else {
            str = this.d.getString(R.string.mtrl_picker_toggle_to_day_selection);
        }
        e9Var.o(str);
    }
}

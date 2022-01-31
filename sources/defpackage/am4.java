package defpackage;

import android.view.View;
import defpackage.wl4;

/* renamed from: am4  reason: default package */
/* compiled from: MaterialCalendar */
public class am4 implements View.OnClickListener {
    public final /* synthetic */ wl4 f;

    public am4(wl4 wl4) {
        this.f = wl4;
    }

    public void onClick(View view) {
        wl4 wl4 = this.f;
        wl4.e eVar = wl4.k;
        wl4.e eVar2 = wl4.e.YEAR;
        if (eVar == eVar2) {
            wl4.h(wl4.e.DAY);
        } else if (eVar == wl4.e.DAY) {
            wl4.h(eVar2);
        }
    }
}

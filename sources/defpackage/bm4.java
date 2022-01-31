package defpackage;

import android.view.View;

/* renamed from: bm4  reason: default package */
/* compiled from: MaterialCalendar */
public class bm4 implements View.OnClickListener {
    public final /* synthetic */ km4 f;
    public final /* synthetic */ wl4 g;

    public bm4(wl4 wl4, km4 km4) {
        this.g = wl4;
        this.f = km4;
    }

    public void onClick(View view) {
        int v1 = this.g.e().v1() + 1;
        if (v1 < this.g.n.getAdapter().getItemCount()) {
            this.g.g(this.f.c(v1));
        }
    }
}

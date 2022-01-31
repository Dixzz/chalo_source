package defpackage;

import android.view.View;

/* renamed from: cm4  reason: default package */
/* compiled from: MaterialCalendar */
public class cm4 implements View.OnClickListener {
    public final /* synthetic */ km4 f;
    public final /* synthetic */ wl4 g;

    public cm4(wl4 wl4, km4 km4) {
        this.g = wl4;
        this.f = km4;
    }

    public void onClick(View view) {
        int w1 = this.g.e().w1() - 1;
        if (w1 >= 0) {
            this.g.g(this.f.c(w1));
        }
    }
}

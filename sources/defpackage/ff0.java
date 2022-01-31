package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.ui.activities.RenewMagicPassActivity;

/* renamed from: ff0  reason: default package */
/* compiled from: RenewMagicPassActivity */
public class ff0 implements View.OnClickListener {
    public final /* synthetic */ String f;
    public final /* synthetic */ int g;
    public final /* synthetic */ String h;

    public ff0(RenewMagicPassActivity renewMagicPassActivity, String str, int i, String str2) {
        this.f = str;
        this.g = i;
        this.h = str2;
    }

    public void onClick(View view) {
        ed1 ed1 = new ed1("radio button clicked", Long.MIN_VALUE);
        ed1.a("passenger type", this.f);
        ed1.a("num Days", Integer.valueOf(this.g));
        hj1.K0(ed1, SuperPassJsonKeys.FARE, this.h, ed1);
    }
}

package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.ActiveMTicketScreen;

/* renamed from: wb0  reason: default package */
/* compiled from: ActiveMTicketScreen */
public class wb0 implements View.OnClickListener {
    public final /* synthetic */ lm0 f;
    public final /* synthetic */ ActiveMTicketScreen g;

    public wb0(ActiveMTicketScreen activeMTicketScreen, lm0 lm0) {
        this.g = activeMTicketScreen;
        this.f = lm0;
    }

    public void onClick(View view) {
        this.g.startActivityForResult(new Intent("android.settings.DATE_SETTINGS"), 0);
        jz5.b().g(new ed1("settings_clicked", Long.MIN_VALUE));
        this.f.dismiss();
    }
}

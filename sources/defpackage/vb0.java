package defpackage;

import android.view.View;
import app.zophop.ui.activities.ActiveMTicketScreen;

/* renamed from: vb0  reason: default package */
/* compiled from: ActiveMTicketScreen */
public class vb0 implements View.OnClickListener {
    public final /* synthetic */ lm0 f;

    public vb0(ActiveMTicketScreen activeMTicketScreen, lm0 lm0) {
        this.f = lm0;
    }

    public void onClick(View view) {
        this.f.dismiss();
        jz5.b().g(new ed1("dismiss_clicked", Long.MIN_VALUE));
    }
}

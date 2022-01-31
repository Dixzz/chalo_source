package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.ActiveMTicketScreen;
import app.zophop.ui.activities.HomeActivity;

/* renamed from: bc0  reason: default package */
/* compiled from: ActiveMTicketScreen */
public class bc0 implements View.OnClickListener {
    public final /* synthetic */ ActiveMTicketScreen f;

    public bc0(ActiveMTicketScreen activeMTicketScreen) {
        this.f = activeMTicketScreen;
    }

    public void onClick(View view) {
        jz5.b().g(new ed1("activation duration expired dialog ok clicked", Long.MIN_VALUE));
        Intent intent = new Intent(this.f, HomeActivity.class);
        intent.setFlags(268468224);
        this.f.startActivity(intent);
    }
}

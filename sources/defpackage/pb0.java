package defpackage;

import android.text.TextUtils;
import android.view.View;
import app.zophop.ui.activities.ActivateMTicketScreen;

/* renamed from: pb0  reason: default package */
/* compiled from: ActivateMTicketScreen */
public class pb0 implements View.OnClickListener {
    public final /* synthetic */ ActivateMTicketScreen f;

    public pb0(ActivateMTicketScreen activateMTicketScreen) {
        this.f = activateMTicketScreen;
    }

    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.f.m)) {
            ActivateMTicketScreen activateMTicketScreen = this.f;
            activateMTicketScreen.j0(activateMTicketScreen.m, activateMTicketScreen.x);
        }
    }
}

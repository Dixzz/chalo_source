package defpackage;

import android.text.TextUtils;
import android.view.View;
import app.zophop.ui.activities.ActivatePassScreen;

/* renamed from: sb0  reason: default package */
/* compiled from: ActivatePassScreen */
public class sb0 implements View.OnClickListener {
    public final /* synthetic */ ActivatePassScreen f;

    public sb0(ActivatePassScreen activatePassScreen) {
        this.f = activatePassScreen;
    }

    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.f.s)) {
            ActivatePassScreen activatePassScreen = this.f;
            activatePassScreen.k0(activatePassScreen.s, activatePassScreen.F);
        }
    }
}

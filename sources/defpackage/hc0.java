package defpackage;

import android.text.TextUtils;
import android.view.View;
import app.zophop.ui.activities.ActivePassScreen;

/* renamed from: hc0  reason: default package */
/* compiled from: ActivePassScreen */
public class hc0 implements View.OnClickListener {
    public final /* synthetic */ ActivePassScreen f;

    public hc0(ActivePassScreen activePassScreen) {
        this.f = activePassScreen;
    }

    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.f.r)) {
            ActivePassScreen activePassScreen = this.f;
            activePassScreen.l0(activePassScreen.r, activePassScreen._profilePicView);
        }
    }
}

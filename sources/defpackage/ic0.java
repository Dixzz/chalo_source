package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.ActivePassScreen;
import app.zophop.ui.activities.HomeActivity;

/* renamed from: ic0  reason: default package */
/* compiled from: ActivePassScreen */
public class ic0 implements View.OnClickListener {
    public final /* synthetic */ ActivePassScreen f;

    public ic0(ActivePassScreen activePassScreen) {
        this.f = activePassScreen;
    }

    public void onClick(View view) {
        jz5.b().g(new ed1("activation duration expired dialog ok clicked", Long.MIN_VALUE));
        Intent intent = new Intent(this.f, HomeActivity.class);
        intent.setFlags(268468224);
        this.f.startActivity(intent);
    }
}

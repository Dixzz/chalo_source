package defpackage;

import android.app.ActionBar;
import android.content.IntentFilter;
import android.os.Bundle;
import defpackage.qo;

/* renamed from: tl0  reason: default package */
/* compiled from: BaseViewModelActivity.kt */
public abstract class tl0<T extends qo> extends ol0<T> {
    @Override // defpackage.ol0
    public void h0(Bundle bundle) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(false);
        }
        o0();
        r0();
        p0();
        q0();
    }

    @Override // defpackage.ol0
    public void j0() {
        registerReceiver(e0(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // defpackage.ol0
    public void n0() {
        unregisterReceiver(e0());
    }

    public abstract void o0();

    public abstract void p0();

    public abstract void q0();

    public abstract void r0();
}

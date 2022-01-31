package defpackage;

import android.content.IntentFilter;
import android.os.Bundle;
import defpackage.qo;

/* renamed from: sl0  reason: default package */
/* compiled from: BaseNavGraphActivity.kt */
public abstract class sl0<T extends qo> extends ol0<T> {
    @Override // defpackage.ol0
    public void h0(Bundle bundle) {
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

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        onSupportNavigateUp();
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve, defpackage.ol0
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o0();
        q0();
        p0();
    }

    public abstract void p0();

    public abstract void q0();
}

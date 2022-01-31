package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: cb4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public class cb4 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final lg4 f544a;
    public boolean b;
    public boolean c;

    public cb4(lg4 lg4) {
        this.f544a = lg4;
    }

    public final void a() {
        this.f544a.P();
        this.f544a.f().b();
        this.f544a.f().b();
        if (this.b) {
            this.f544a.g().n.a("Unregistering connectivity change receiver");
            this.b = false;
            this.c = false;
            try {
                this.f544a.j.f3627a.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.f544a.g().f.b("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        this.f544a.P();
        String action = intent.getAction();
        this.f544a.g().n.b("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean t = this.f544a.J().t();
            if (this.c != t) {
                this.c = t;
                this.f544a.f().u(new fb4(this, t));
                return;
            }
            return;
        }
        this.f544a.g().i.b("NetworkBroadcastReceiver received unknown action", action);
    }
}

package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* renamed from: v52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class v52 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public Context f3602a;
    public final u52 b;

    public v52(u52 u52) {
        this.b = u52;
    }

    public final synchronized void a() {
        Context context = this.f3602a;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.f3602a = null;
    }

    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.b.a();
            a();
        }
    }
}

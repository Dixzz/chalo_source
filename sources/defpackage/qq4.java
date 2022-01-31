package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.install.InstallState;

/* renamed from: qq4  reason: default package */
public final class qq4 extends gx4<InstallState> {
    public qq4(Context context) {
        super(new nv4("AppUpdateListenerRegistry"), new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), context);
    }

    @Override // defpackage.gx4
    public final void a(Context context, Intent intent) {
        if (!context.getPackageName().equals(intent.getStringExtra("package.name"))) {
            this.f1313a.b(3, "ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", new Object[]{intent.getStringExtra("package.name")});
            return;
        }
        this.f1313a.b(3, "List of extras in received intent:", new Object[0]);
        for (String str : intent.getExtras().keySet()) {
            this.f1313a.b(3, "Key: %s; value: %s", new Object[]{str, intent.getExtras().get(str)});
        }
        nv4 nv4 = this.f1313a;
        nv4.b(3, "List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
        nv4.b(3, "Key: %s; value: %s", new Object[]{"install.status", Integer.valueOf(intent.getIntExtra("install.status", 0))});
        nv4.b(3, "Key: %s; value: %s", new Object[]{"error.code", Integer.valueOf(intent.getIntExtra("error.code", 0))});
        gv4 gv4 = new gv4(intent.getIntExtra("install.status", 0), intent.getLongExtra("bytes.downloaded", 0), intent.getLongExtra("total.bytes.to.download", 0), intent.getIntExtra("error.code", 0), intent.getStringExtra("package.name"));
        this.f1313a.b(3, "ListenerRegistryBroadcastReceiver.onReceive: %s", new Object[]{gv4});
        c(gv4);
    }
}

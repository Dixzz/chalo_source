package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Objects;

/* renamed from: td3  reason: default package */
public class td3 extends BroadcastReceiver {
    public static final String d = td3.class.getName();

    /* renamed from: a  reason: collision with root package name */
    public final ac3 f3337a;
    public boolean b;
    public boolean c;

    public td3(ac3 ac3) {
        Objects.requireNonNull(ac3, "null reference");
        this.f3337a = ac3;
    }

    public final void a() {
        if (this.b) {
            this.f3337a.c().M("Unregistering connectivity change receiver");
            this.b = false;
            this.c = false;
            try {
                this.f3337a.f146a.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.f3337a.c().L("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public final void b() {
        Context context = this.f3337a.f146a;
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(d, true);
        context.sendOrderedBroadcast(intent, null);
    }

    public final boolean c() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f3337a.f146a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (SecurityException unused) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        this.f3337a.c();
        this.f3337a.e();
        String action = intent.getAction();
        this.f3337a.c().k("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean c2 = c();
            if (this.c != c2) {
                this.c = c2;
                sb3 e = this.f3337a.e();
                e.k("Network connectivity status changed", Boolean.valueOf(c2));
                e.w().b(new tb3(e, c2));
            }
        } else if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.f3337a.c().J("NetworkBroadcastReceiver received unknown action", action);
        } else if (!intent.hasExtra(d)) {
            sb3 e2 = this.f3337a.e();
            e2.M("Radio powered up");
            e2.m0();
        }
    }
}

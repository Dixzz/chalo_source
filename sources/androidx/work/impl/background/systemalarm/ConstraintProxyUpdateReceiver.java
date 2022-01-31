package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.ConstraintProxy;

public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f266a = tp.e("ConstrntProxyUpdtRecvr");

    public class a implements Runnable {
        public final /* synthetic */ Intent f;
        public final /* synthetic */ Context g;
        public final /* synthetic */ BroadcastReceiver.PendingResult h;

        public a(ConstraintProxyUpdateReceiver constraintProxyUpdateReceiver, Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.f = intent;
            this.g = context;
            this.h = pendingResult;
        }

        public void run() {
            try {
                boolean booleanExtra = this.f.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra2 = this.f.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                boolean booleanExtra3 = this.f.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra4 = this.f.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                tp.c().a(ConstraintProxyUpdateReceiver.f266a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)), new Throwable[0]);
                ct.a(this.g, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                ct.a(this.g, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                ct.a(this.g, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                ct.a(this.g, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                this.h.finish();
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            tp.c().a(f266a, String.format("Ignoring unknown action %s", action), new Throwable[0]);
            return;
        }
        BroadcastReceiver.PendingResult goAsync = goAsync();
        ((qt) pq.a(context).d).f2987a.execute(new a(this, intent, context, goAsync));
    }
}

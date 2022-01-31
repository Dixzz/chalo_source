package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: rr  reason: default package */
/* compiled from: BatteryNotLowTracker */
public class rr extends sr<Boolean> {
    public static final String i = tp.e("BatteryNotLowTracker");

    public rr(Context context, pt ptVar) {
        super(context, ptVar);
    }

    @Override // defpackage.tr
    public Object a() {
        Intent registerReceiver = this.b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver == null) {
            tp.c().b(i, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        float intExtra2 = ((float) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
        if (intExtra == 1 || intExtra2 > 0.15f) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // defpackage.sr
    public IntentFilter f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    @Override // defpackage.sr
    public void g(Context context, Intent intent) {
        if (intent.getAction() != null) {
            tp.c().a(i, String.format("Received %s", intent.getAction()), new Throwable[0]);
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("android.intent.action.BATTERY_OKAY")) {
                c(Boolean.TRUE);
            } else if (action.equals("android.intent.action.BATTERY_LOW")) {
                c(Boolean.FALSE);
            }
        }
    }
}

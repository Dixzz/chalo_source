package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;

/* renamed from: qr  reason: default package */
/* compiled from: BatteryChargingTracker */
public class qr extends sr<Boolean> {
    public static final String i = tp.e("BatteryChrgTracker");

    public qr(Context context, pt ptVar) {
        super(context, ptVar);
    }

    @Override // defpackage.tr
    public Object a() {
        int intExtra;
        Intent registerReceiver = this.b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver == null) {
            tp.c().b(i, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        if (Build.VERSION.SDK_INT < 23 ? registerReceiver.getIntExtra("plugged", 0) != 0 : (intExtra = registerReceiver.getIntExtra("status", -1)) == 2 || intExtra == 5) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // defpackage.sr
    public IntentFilter f() {
        IntentFilter intentFilter = new IntentFilter();
        if (Build.VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.CHARGING");
            intentFilter.addAction("android.os.action.DISCHARGING");
        } else {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        return intentFilter;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (r9.equals("android.intent.action.ACTION_POWER_DISCONNECTED") == false) goto L_0x0055;
     */
    @Override // defpackage.sr
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(android.content.Context r8, android.content.Intent r9) {
        /*
        // Method dump skipped, instructions count: 130
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qr.g(android.content.Context, android.content.Intent):void");
    }
}

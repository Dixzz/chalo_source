package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: vr  reason: default package */
/* compiled from: StorageNotLowTracker */
public class vr extends sr<Boolean> {
    public static final String i = tp.e("StorageNotLowTracker");

    public vr(Context context, pt ptVar) {
        super(context, ptVar);
    }

    @Override // defpackage.tr
    public Object a() {
        Boolean bool = Boolean.TRUE;
        Context context = this.b;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        Intent registerReceiver = context.registerReceiver(null, intentFilter);
        if (registerReceiver == null || registerReceiver.getAction() == null) {
            return bool;
        }
        String action = registerReceiver.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            return Boolean.FALSE;
        }
        if (!action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            return null;
        }
        return bool;
    }

    @Override // defpackage.sr
    public IntentFilter f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    @Override // defpackage.sr
    public void g(Context context, Intent intent) {
        if (intent.getAction() != null) {
            tp.c().a(i, String.format("Received %s", intent.getAction()), new Throwable[0]);
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                c(Boolean.FALSE);
            } else if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                c(Boolean.TRUE);
            }
        }
    }
}

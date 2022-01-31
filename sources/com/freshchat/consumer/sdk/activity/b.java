package com.freshchat.consumer.sdk.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ah;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.bg;

public abstract class b extends a {
    private ni bs;
    private BroadcastReceiver bt = new BroadcastReceiver() {
        /* class com.freshchat.consumer.sdk.activity.b.AnonymousClass1 */

        public void onReceive(Context context, Intent intent) {
            if (!"com.freshchat.consumer.sdk.actions.KillCurrentUserSession".equals(intent.getAction())) {
                if ("com.freshchat.consumer.sdk.actions.TokenWaitTimeout".equals(intent.getAction())) {
                    b.this.al();
                    return;
                } else if ("com.freshchat.consumer.sdk.actions.DismissFreshchatScreens".equals(intent.getAction())) {
                    b.this.gs();
                    return;
                } else if (!"com.freshchat.consumer.sdk.actions.FAQApiVersionChanged".equals(intent.getAction())) {
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && al.aS(context)) {
                        aa.c(context, true);
                    }
                    b.this.a(context, intent);
                    return;
                } else if (!b.this.bM()) {
                    return;
                }
            }
            b.this.finish();
        }
    };

    public ni D() {
        if (this.bs == null) {
            this.bs = ni.a(getApplicationContext());
        }
        return this.bs;
    }

    public abstract void a(Context context, Intent intent);

    public abstract String[] a();

    @Override // defpackage.f0
    public void attachBaseContext(Context context) {
        super.attachBaseContext(ah.bU(context));
    }

    public void finish() {
        super.finish();
    }

    @Override // androidx.activity.ComponentActivity, com.freshchat.consumer.sdk.activity.a
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // defpackage.ve
    public void onPause() {
        super.onPause();
        if (a().length > 0) {
            D().d(this.bt);
        }
        getContext().unregisterReceiver(this.bt);
    }

    @Override // defpackage.ve, com.freshchat.consumer.sdk.activity.a
    public void onResume() {
        super.onResume();
        bg.bL(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.freshchat.consumer.sdk.actions.KillCurrentUserSession");
        intentFilter.addAction("com.freshchat.consumer.sdk.actions.DismissFreshchatScreens");
        for (String str : a()) {
            intentFilter.addAction(str);
        }
        if (a().length > 0) {
            D().b(this.bt, intentFilter);
        }
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        getContext().registerReceiver(this.bt, intentFilter2);
    }
}

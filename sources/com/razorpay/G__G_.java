package com.razorpay;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: AdvertisingIdUtil */
public final class G__G_ implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private boolean f673a;
    private final LinkedBlockingQueue<IBinder> b;

    private G__G_() {
        this.f673a = false;
        this.b = new LinkedBlockingQueue<>(1);
    }

    public final IBinder a() {
        if (!this.f673a) {
            this.f673a = true;
        }
        return this.b.take();
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.b.put(iBinder);
        } catch (Exception e) {
            AnalyticsUtil.reportError(e, "error", e.getMessage());
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }

    public /* synthetic */ G__G_(byte b2) {
        this();
    }
}

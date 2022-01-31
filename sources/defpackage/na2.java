package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.Map;

/* renamed from: na2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class na2 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final Map<ServiceConnection, ServiceConnection> f2529a = new HashMap();
    public int b = 2;
    public boolean c;
    public IBinder d;
    public final ma2 e;
    public ComponentName f;
    public final /* synthetic */ pa2 g;

    public na2(pa2 pa2, ma2 ma2) {
        this.g = pa2;
        this.e = ma2;
    }

    public final void a(String str) {
        Bundle bundle;
        this.b = 3;
        pa2 pa2 = this.g;
        za2 za2 = pa2.f;
        Context context = pa2.d;
        ma2 ma2 = this.e;
        Intent intent = null;
        if (ma2.f2345a != null) {
            if (ma2.d) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("serviceActionBundleKey", ma2.f2345a);
                try {
                    bundle = context.getContentResolver().call(ma2.e, "serviceIntentCall", (String) null, bundle2);
                } catch (IllegalArgumentException e2) {
                    String.valueOf(e2).length();
                    bundle = null;
                }
                if (bundle != null) {
                    intent = (Intent) bundle.getParcelable("serviceResponseIntentKey");
                }
                if (intent == null) {
                    String valueOf = String.valueOf(ma2.f2345a);
                    if (valueOf.length() != 0) {
                        "Dynamic lookup for intent failed for action: ".concat(valueOf);
                    } else {
                        new String("Dynamic lookup for intent failed for action: ");
                    }
                }
            }
            if (intent == null) {
                intent = new Intent(ma2.f2345a).setPackage(ma2.b);
            }
        } else {
            intent = new Intent().setComponent(null);
        }
        boolean d2 = za2.d(context, str, intent, this, this.e.c, true);
        this.c = d2;
        if (d2) {
            Message obtainMessage = this.g.e.obtainMessage(1, this.e);
            pa2 pa22 = this.g;
            pa22.e.sendMessageDelayed(obtainMessage, pa22.h);
            return;
        }
        this.b = 2;
        try {
            pa2 pa23 = this.g;
            pa23.f.c(pa23.d, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.g.c) {
            this.g.e.removeMessages(1, this.e);
            this.d = iBinder;
            this.f = componentName;
            for (ServiceConnection serviceConnection : this.f2529a.values()) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.b = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.g.c) {
            this.g.e.removeMessages(1, this.e);
            this.d = null;
            this.f = componentName;
            for (ServiceConnection serviceConnection : this.f2529a.values()) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.b = 2;
        }
    }
}

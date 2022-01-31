package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import defpackage.nl1;
import defpackage.or1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: qr1  reason: default package */
/* compiled from: DefaultConnectivityMonitor */
public class qr1 implements or1 {
    public final Context f;
    public final or1.a g;
    public boolean h;
    public boolean i;
    public final BroadcastReceiver j = new a();

    /* renamed from: qr1$a */
    /* compiled from: DefaultConnectivityMonitor */
    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            qr1 qr1 = qr1.this;
            boolean z = qr1.h;
            qr1.h = qr1.c(context);
            qr1 qr12 = qr1.this;
            boolean z2 = qr12.h;
            if (z != z2) {
                nl1.c cVar = (nl1.c) qr12.g;
                Objects.requireNonNull(cVar);
                if (z2) {
                    zr1 zr1 = cVar.f2573a;
                    Iterator it = ((ArrayList) rt1.e(zr1.f4203a)).iterator();
                    while (it.hasNext()) {
                        os1 os1 = (os1) it.next();
                        if (!os1.f() && !os1.isCancelled()) {
                            os1.pause();
                            if (!zr1.c) {
                                os1.e();
                            } else {
                                zr1.b.add(os1);
                            }
                        }
                    }
                }
            }
        }
    }

    public qr1(Context context, or1.a aVar) {
        this.f = context.getApplicationContext();
        this.g = aVar;
    }

    public boolean c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // defpackage.ur1
    public void l() {
    }

    @Override // defpackage.ur1
    public void m() {
        if (this.i) {
            this.f.unregisterReceiver(this.j);
            this.i = false;
        }
    }

    @Override // defpackage.ur1
    public void n() {
        if (!this.i) {
            this.h = c(this.f);
            this.f.registerReceiver(this.j, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.i = true;
        }
    }
}

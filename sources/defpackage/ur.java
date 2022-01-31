package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

/* renamed from: ur  reason: default package */
/* compiled from: NetworkStateTracker */
public class ur extends tr<fr> {
    public static final String j = tp.e("NetworkStateTracker");
    public final ConnectivityManager g = ((ConnectivityManager) this.b.getSystemService("connectivity"));
    public b h;
    public a i;

    /* renamed from: ur$a */
    /* compiled from: NetworkStateTracker */
    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                tp.c().a(ur.j, "Network broadcast received", new Throwable[0]);
                ur urVar = ur.this;
                urVar.c(urVar.f());
            }
        }
    }

    /* renamed from: ur$b */
    /* compiled from: NetworkStateTracker */
    public class b extends ConnectivityManager.NetworkCallback {
        public b() {
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            tp.c().a(ur.j, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            ur urVar = ur.this;
            urVar.c(urVar.f());
        }

        public void onLost(Network network) {
            tp.c().a(ur.j, "Network connection lost", new Throwable[0]);
            ur urVar = ur.this;
            urVar.c(urVar.f());
        }
    }

    public ur(Context context, pt ptVar) {
        super(context, ptVar);
        if (g()) {
            this.h = new b();
        } else {
            this.i = new a();
        }
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.tr
    public fr a() {
        return f();
    }

    @Override // defpackage.tr
    public void d() {
        if (g()) {
            try {
                tp.c().a(j, "Registering network callback", new Throwable[0]);
                this.g.registerDefaultNetworkCallback(this.h);
            } catch (IllegalArgumentException | SecurityException e) {
                tp.c().b(j, "Received exception while registering network callback", e);
            }
        } else {
            tp.c().a(j, "Registering broadcast receiver", new Throwable[0]);
            this.b.registerReceiver(this.i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    @Override // defpackage.tr
    public void e() {
        if (g()) {
            try {
                tp.c().a(j, "Unregistering network callback", new Throwable[0]);
                this.g.unregisterNetworkCallback(this.h);
            } catch (IllegalArgumentException | SecurityException e) {
                tp.c().b(j, "Received exception while unregistering network callback", e);
            }
        } else {
            tp.c().a(j, "Unregistering broadcast receiver", new Throwable[0]);
            this.b.unregisterReceiver(this.i);
        }
    }

    public fr f() {
        boolean z;
        NetworkInfo activeNetworkInfo = this.g.getActiveNetworkInfo();
        boolean z2 = false;
        boolean z3 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                NetworkCapabilities networkCapabilities = this.g.getNetworkCapabilities(this.g.getActiveNetwork());
                if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
                    z = true;
                    boolean isActiveNetworkMetered = this.g.isActiveNetworkMetered();
                    if (activeNetworkInfo != null && !activeNetworkInfo.isRoaming()) {
                        z2 = true;
                    }
                    return new fr(z3, z, isActiveNetworkMetered, z2);
                }
            } catch (SecurityException e) {
                tp.c().b(j, "Unable to validate active network", e);
            }
        }
        z = false;
        boolean isActiveNetworkMetered2 = this.g.isActiveNetworkMetered();
        z2 = true;
        return new fr(z3, z, isActiveNetworkMetered2, z2);
    }
}

package defpackage;

import android.net.ConnectivityManager;
import android.net.Network;
import defpackage.mm5;

/* renamed from: kn5  reason: default package */
/* compiled from: NetworkMonitor */
public class kn5 {

    /* renamed from: a  reason: collision with root package name */
    public xy5 f2088a;
    public final ConnectivityManager.NetworkCallback b = new a();

    /* renamed from: kn5$a */
    /* compiled from: NetworkMonitor */
    public class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        public void onAvailable(Network network) {
            xy5 xy5 = kn5.this.f2088a;
            if (xy5 != null) {
                mm5 mm5 = mm5.this;
                if (mm5.h) {
                    mm5.m();
                }
            }
        }

        public void onLost(Network network) {
            xy5 xy5 = kn5.this.f2088a;
            if (xy5 != null) {
                mm5.o oVar = (mm5.o) xy5;
            }
        }
    }
}

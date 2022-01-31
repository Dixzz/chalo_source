package defpackage;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: da2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class da2 extends jl2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ w72 f813a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public da2(w72 w72, Looper looper) {
        super(looper);
        this.f813a = w72;
    }

    public static final boolean a(Message message) {
        int i = message.what;
        return i == 2 || i == 1 || i == 7;
    }

    public final void handleMessage(Message message) {
        TListener tlistener;
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        if (this.f813a.zzd.get() == message.arg1) {
            int i = message.what;
            if ((i == 1 || i == 7 || ((i == 4 && !this.f813a.enableLocalFallback()) || message.what == 5)) && !this.f813a.isConnecting()) {
                ea2 ea2 = (ea2) message.obj;
                ea2.a();
                ea2.c();
                return;
            }
            int i2 = message.what;
            PendingIntent pendingIntent = null;
            if (i2 == 4) {
                this.f813a.zzB = new ConnectionResult(message.arg2);
                if (!w72.zzg(this.f813a) || (this.f813a.zzC)) {
                    if (this.f813a.zzB != null) {
                        connectionResult2 = this.f813a.zzB;
                    } else {
                        connectionResult2 = new ConnectionResult(8);
                    }
                    this.f813a.zzc.a(connectionResult2);
                    this.f813a.onConnectionFailed(connectionResult2);
                    return;
                }
                this.f813a.zzp(3, null);
            } else if (i2 == 5) {
                if (this.f813a.zzB != null) {
                    connectionResult = this.f813a.zzB;
                } else {
                    connectionResult = new ConnectionResult(8);
                }
                this.f813a.zzc.a(connectionResult);
                this.f813a.onConnectionFailed(connectionResult);
            } else if (i2 == 3) {
                Object obj = message.obj;
                if (obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) obj;
                }
                ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, pendingIntent);
                this.f813a.zzc.a(connectionResult3);
                this.f813a.onConnectionFailed(connectionResult3);
            } else if (i2 == 6) {
                this.f813a.zzp(5, null);
                if (this.f813a.zzw != null) {
                    this.f813a.zzw.C(message.arg2);
                }
                this.f813a.onConnectionSuspended(message.arg2);
                w72.zzl(this.f813a, 5, 1, null);
            } else if (i2 == 2 && !this.f813a.isConnected()) {
                ea2 ea22 = (ea2) message.obj;
                ea22.a();
                ea22.c();
            } else if (a(message)) {
                ea2 ea23 = (ea2) message.obj;
                synchronized (ea23) {
                    tlistener = ea23.f948a;
                    if (ea23.b) {
                        String.valueOf(ea23).length();
                    }
                }
                if (tlistener != null) {
                    try {
                        ea23.b(tlistener);
                    } catch (RuntimeException e) {
                        throw e;
                    }
                }
                synchronized (ea23) {
                    ea23.b = true;
                }
                ea23.c();
            } else {
                Log.wtf("GmsClient", hj1.v(45, "Don't know how to handle message: ", message.what), new Exception());
            }
        } else if (a(message)) {
            ea2 ea24 = (ea2) message.obj;
            ea24.a();
            ea24.c();
        }
    }
}

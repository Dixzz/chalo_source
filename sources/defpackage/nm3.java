package defpackage;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzbd;
import com.google.android.gms.internal.location.zzbf;
import com.google.android.gms.internal.location.zzo;
import com.google.android.gms.location.LocationRequest;
import defpackage.t32;
import java.util.HashMap;
import java.util.Map;

/* renamed from: nm3  reason: default package */
public final class nm3 {

    /* renamed from: a  reason: collision with root package name */
    public final en3<jm3> f2575a;
    public final Context b;
    public boolean c = false;
    public final Map<t32.a<g34>, qm3> d = new HashMap();
    public final Map<t32.a<Object>, pm3> e = new HashMap();
    public final Map<t32.a<Object>, om3> f = new HashMap();

    public nm3(Context context, en3<jm3> en3) {
        this.b = context;
        this.f2575a = en3;
    }

    public final void a() throws RemoteException {
        synchronized (this.d) {
            for (qm3 qm3 : this.d.values()) {
                if (qm3 != null) {
                    ((jm3) this.f2575a.a()).F2(zzbf.l1(qm3, null));
                }
            }
            this.d.clear();
        }
        synchronized (this.f) {
            for (om3 om3 : this.f.values()) {
                if (om3 != null) {
                    ((jm3) this.f2575a.a()).F2(new zzbf(2, null, null, null, om3, null));
                }
            }
            this.f.clear();
        }
        synchronized (this.e) {
            for (pm3 pm3 : this.e.values()) {
                if (pm3 != null) {
                    ((jm3) this.f2575a.a()).E1(new zzo(2, null, pm3, null));
                }
            }
            this.e.clear();
        }
    }

    public final void b(LocationRequest locationRequest, t32<g34> t32, em3 em3) throws RemoteException {
        qm3 qm3;
        this.f2575a.f1004a.checkConnected();
        synchronized (this.d) {
            qm3 = this.d.get(t32.c);
            if (qm3 == null) {
                qm3 = new qm3(t32);
            }
            this.d.put(t32.c, qm3);
        }
        ((jm3) this.f2575a.a()).F2(new zzbf(1, new zzbd(locationRequest, zzbd.m, null, false, false, false, null), qm3, null, null, em3 != null ? em3.asBinder() : null));
    }

    public final void c() throws RemoteException {
        if (this.c) {
            this.f2575a.f1004a.checkConnected();
            ((jm3) this.f2575a.a()).y2(false);
            this.c = false;
        }
    }
}

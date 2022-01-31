package defpackage;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzbf;
import com.google.android.gms.internal.location.zzo;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzal;

/* renamed from: km3  reason: default package */
public final class km3 extends wl3 implements jm3 {
    public km3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // defpackage.jm3
    public final void C3(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, hm3 hm3) throws RemoteException {
        Parcel C = C();
        cn3.c(C, geofencingRequest);
        cn3.c(C, pendingIntent);
        cn3.b(C, hm3);
        F(57, C);
    }

    @Override // defpackage.jm3
    public final void E1(zzo zzo) throws RemoteException {
        Parcel C = C();
        cn3.c(C, zzo);
        F(75, C);
    }

    @Override // defpackage.jm3
    public final void F2(zzbf zzbf) throws RemoteException {
        Parcel C = C();
        cn3.c(C, zzbf);
        F(59, C);
    }

    @Override // defpackage.jm3
    public final void F3(LocationSettingsRequest locationSettingsRequest, lm3 lm3, String str) throws RemoteException {
        Parcel C = C();
        cn3.c(C, locationSettingsRequest);
        cn3.b(C, lm3);
        C.writeString(str);
        F(63, C);
    }

    @Override // defpackage.jm3
    public final void U1(zzal zzal, hm3 hm3) throws RemoteException {
        Parcel C = C();
        cn3.c(C, zzal);
        cn3.b(C, hm3);
        F(74, C);
    }

    @Override // defpackage.jm3
    public final void y2(boolean z) throws RemoteException {
        Parcel C = C();
        int i = cn3.f584a;
        C.writeInt(z ? 1 : 0);
        F(12, C);
    }

    @Override // defpackage.jm3
    public final Location zza(String str) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        C = Parcel.obtain();
        try {
            this.f.transact(21, C, C, 0);
            C.readException();
            C.recycle();
            return (Location) cn3.a(C, Location.CREATOR);
        } catch (RuntimeException e) {
            throw e;
        } finally {
            C.recycle();
        }
    }
}

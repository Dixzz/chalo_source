package defpackage;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzbf;
import com.google.android.gms.internal.location.zzo;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzal;

/* renamed from: jm3  reason: default package */
public interface jm3 extends IInterface {
    void C3(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, hm3 hm3) throws RemoteException;

    void E1(zzo zzo) throws RemoteException;

    void F2(zzbf zzbf) throws RemoteException;

    void F3(LocationSettingsRequest locationSettingsRequest, lm3 lm3, String str) throws RemoteException;

    void U1(zzal zzal, hm3 hm3) throws RemoteException;

    void y2(boolean z) throws RemoteException;

    Location zza(String str) throws RemoteException;
}

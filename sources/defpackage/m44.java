package defpackage;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;

/* renamed from: m44  reason: default package */
public interface m44 extends IInterface {
    void I() throws RemoteException;

    void K(Bundle bundle) throws RemoteException;

    void Q2(v44 v44) throws RemoteException;

    void S0(ic2 ic2, GoogleMapOptions googleMapOptions, Bundle bundle) throws RemoteException;

    ic2 Z0(ic2 ic2, ic2 ic22, Bundle bundle) throws RemoteException;

    void l() throws RemoteException;

    void m() throws RemoteException;

    void n() throws RemoteException;

    void onLowMemory() throws RemoteException;

    void u() throws RemoteException;

    void w() throws RemoteException;

    void z(Bundle bundle) throws RemoteException;
}

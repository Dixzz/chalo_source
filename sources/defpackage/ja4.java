package defpackage;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.util.List;

/* renamed from: ja4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public interface ja4 extends IInterface {
    void H2(zzaq zzaq, zzn zzn) throws RemoteException;

    List<zzku> L1(String str, String str2, boolean z, zzn zzn) throws RemoteException;

    void N1(zzn zzn) throws RemoteException;

    String O0(zzn zzn) throws RemoteException;

    void P2(Bundle bundle, zzn zzn) throws RemoteException;

    byte[] R(zzaq zzaq, String str) throws RemoteException;

    void S(zzn zzn) throws RemoteException;

    void l1(long j, String str, String str2, String str3) throws RemoteException;

    List<zzku> p0(String str, String str2, String str3, boolean z) throws RemoteException;

    void p1(zzn zzn) throws RemoteException;

    List<zzz> q1(String str, String str2, String str3) throws RemoteException;

    void q2(zzn zzn) throws RemoteException;

    void q3(zzku zzku, zzn zzn) throws RemoteException;

    List<zzz> s1(String str, String str2, zzn zzn) throws RemoteException;

    void v3(zzz zzz, zzn zzn) throws RemoteException;
}

package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzae;

/* renamed from: h24  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class h24 extends io3 implements f24 {
    public h24(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // defpackage.f24
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        C.writeLong(j);
        L(23, C);
    }

    @Override // defpackage.f24
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        C.writeString(str2);
        hp3.c(C, bundle);
        L(9, C);
    }

    @Override // defpackage.f24
    public final void clearMeasurementEnabled(long j) throws RemoteException {
        Parcel C = C();
        C.writeLong(j);
        L(43, C);
    }

    @Override // defpackage.f24
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        C.writeLong(j);
        L(24, C);
    }

    @Override // defpackage.f24
    public final void generateEventId(g24 g24) throws RemoteException {
        Parcel C = C();
        hp3.b(C, g24);
        L(22, C);
    }

    @Override // defpackage.f24
    public final void getAppInstanceId(g24 g24) throws RemoteException {
        Parcel C = C();
        hp3.b(C, g24);
        L(20, C);
    }

    @Override // defpackage.f24
    public final void getCachedAppInstanceId(g24 g24) throws RemoteException {
        Parcel C = C();
        hp3.b(C, g24);
        L(19, C);
    }

    @Override // defpackage.f24
    public final void getConditionalUserProperties(String str, String str2, g24 g24) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        C.writeString(str2);
        hp3.b(C, g24);
        L(10, C);
    }

    @Override // defpackage.f24
    public final void getCurrentScreenClass(g24 g24) throws RemoteException {
        Parcel C = C();
        hp3.b(C, g24);
        L(17, C);
    }

    @Override // defpackage.f24
    public final void getCurrentScreenName(g24 g24) throws RemoteException {
        Parcel C = C();
        hp3.b(C, g24);
        L(16, C);
    }

    @Override // defpackage.f24
    public final void getGmpAppId(g24 g24) throws RemoteException {
        Parcel C = C();
        hp3.b(C, g24);
        L(21, C);
    }

    @Override // defpackage.f24
    public final void getMaxUserProperties(String str, g24 g24) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        hp3.b(C, g24);
        L(6, C);
    }

    @Override // defpackage.f24
    public final void getTestFlag(g24 g24, int i) throws RemoteException {
        Parcel C = C();
        hp3.b(C, g24);
        C.writeInt(i);
        L(38, C);
    }

    @Override // defpackage.f24
    public final void getUserProperties(String str, String str2, boolean z, g24 g24) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        C.writeString(str2);
        ClassLoader classLoader = hp3.f1408a;
        C.writeInt(z ? 1 : 0);
        hp3.b(C, g24);
        L(5, C);
    }

    @Override // defpackage.f24
    public final void initialize(ic2 ic2, zzae zzae, long j) throws RemoteException {
        Parcel C = C();
        hp3.b(C, ic2);
        hp3.c(C, zzae);
        C.writeLong(j);
        L(1, C);
    }

    @Override // defpackage.f24
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        C.writeString(str2);
        hp3.c(C, bundle);
        C.writeInt(z ? 1 : 0);
        C.writeInt(z2 ? 1 : 0);
        C.writeLong(j);
        L(2, C);
    }

    @Override // defpackage.f24
    public final void logHealthData(int i, String str, ic2 ic2, ic2 ic22, ic2 ic23) throws RemoteException {
        Parcel C = C();
        C.writeInt(i);
        C.writeString(str);
        hp3.b(C, ic2);
        hp3.b(C, ic22);
        hp3.b(C, ic23);
        L(33, C);
    }

    @Override // defpackage.f24
    public final void onActivityCreated(ic2 ic2, Bundle bundle, long j) throws RemoteException {
        Parcel C = C();
        hp3.b(C, ic2);
        hp3.c(C, bundle);
        C.writeLong(j);
        L(27, C);
    }

    @Override // defpackage.f24
    public final void onActivityDestroyed(ic2 ic2, long j) throws RemoteException {
        Parcel C = C();
        hp3.b(C, ic2);
        C.writeLong(j);
        L(28, C);
    }

    @Override // defpackage.f24
    public final void onActivityPaused(ic2 ic2, long j) throws RemoteException {
        Parcel C = C();
        hp3.b(C, ic2);
        C.writeLong(j);
        L(29, C);
    }

    @Override // defpackage.f24
    public final void onActivityResumed(ic2 ic2, long j) throws RemoteException {
        Parcel C = C();
        hp3.b(C, ic2);
        C.writeLong(j);
        L(30, C);
    }

    @Override // defpackage.f24
    public final void onActivitySaveInstanceState(ic2 ic2, g24 g24, long j) throws RemoteException {
        Parcel C = C();
        hp3.b(C, ic2);
        hp3.b(C, g24);
        C.writeLong(j);
        L(31, C);
    }

    @Override // defpackage.f24
    public final void onActivityStarted(ic2 ic2, long j) throws RemoteException {
        Parcel C = C();
        hp3.b(C, ic2);
        C.writeLong(j);
        L(25, C);
    }

    @Override // defpackage.f24
    public final void onActivityStopped(ic2 ic2, long j) throws RemoteException {
        Parcel C = C();
        hp3.b(C, ic2);
        C.writeLong(j);
        L(26, C);
    }

    @Override // defpackage.f24
    public final void registerOnMeasurementEventListener(ko3 ko3) throws RemoteException {
        Parcel C = C();
        hp3.b(C, ko3);
        L(35, C);
    }

    @Override // defpackage.f24
    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel C = C();
        C.writeLong(j);
        L(12, C);
    }

    @Override // defpackage.f24
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel C = C();
        hp3.c(C, bundle);
        C.writeLong(j);
        L(8, C);
    }

    @Override // defpackage.f24
    public final void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        Parcel C = C();
        hp3.c(C, bundle);
        C.writeLong(j);
        L(45, C);
    }

    @Override // defpackage.f24
    public final void setCurrentScreen(ic2 ic2, String str, String str2, long j) throws RemoteException {
        Parcel C = C();
        hp3.b(C, ic2);
        C.writeString(str);
        C.writeString(str2);
        C.writeLong(j);
        L(15, C);
    }

    @Override // defpackage.f24
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel C = C();
        ClassLoader classLoader = hp3.f1408a;
        C.writeInt(z ? 1 : 0);
        L(39, C);
    }

    @Override // defpackage.f24
    public final void setDefaultEventParameters(Bundle bundle) throws RemoteException {
        Parcel C = C();
        hp3.c(C, bundle);
        L(42, C);
    }

    @Override // defpackage.f24
    public final void setEventInterceptor(ko3 ko3) throws RemoteException {
        Parcel C = C();
        hp3.b(C, ko3);
        L(34, C);
    }

    @Override // defpackage.f24
    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel C = C();
        ClassLoader classLoader = hp3.f1408a;
        C.writeInt(z ? 1 : 0);
        C.writeLong(j);
        L(11, C);
    }

    @Override // defpackage.f24
    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel C = C();
        C.writeLong(j);
        L(14, C);
    }

    @Override // defpackage.f24
    public final void setUserId(String str, long j) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        C.writeLong(j);
        L(7, C);
    }

    @Override // defpackage.f24
    public final void setUserProperty(String str, String str2, ic2 ic2, boolean z, long j) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        C.writeString(str2);
        hp3.b(C, ic2);
        C.writeInt(z ? 1 : 0);
        C.writeLong(j);
        L(4, C);
    }

    @Override // defpackage.f24
    public final void unregisterOnMeasurementEventListener(ko3 ko3) throws RemoteException {
        Parcel C = C();
        hp3.b(C, ko3);
        L(36, C);
    }
}

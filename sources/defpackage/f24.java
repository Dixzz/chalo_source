package defpackage;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Map;

/* renamed from: f24  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public interface f24 extends IInterface {
    void beginAdUnitExposure(String str, long j) throws RemoteException;

    void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException;

    void clearMeasurementEnabled(long j) throws RemoteException;

    void endAdUnitExposure(String str, long j) throws RemoteException;

    void generateEventId(g24 g24) throws RemoteException;

    void getAppInstanceId(g24 g24) throws RemoteException;

    void getCachedAppInstanceId(g24 g24) throws RemoteException;

    void getConditionalUserProperties(String str, String str2, g24 g24) throws RemoteException;

    void getCurrentScreenClass(g24 g24) throws RemoteException;

    void getCurrentScreenName(g24 g24) throws RemoteException;

    void getGmpAppId(g24 g24) throws RemoteException;

    void getMaxUserProperties(String str, g24 g24) throws RemoteException;

    void getTestFlag(g24 g24, int i) throws RemoteException;

    void getUserProperties(String str, String str2, boolean z, g24 g24) throws RemoteException;

    void initForTests(Map map) throws RemoteException;

    void initialize(ic2 ic2, zzae zzae, long j) throws RemoteException;

    void isDataCollectionEnabled(g24 g24) throws RemoteException;

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException;

    void logEventAndBundle(String str, String str2, Bundle bundle, g24 g24, long j) throws RemoteException;

    void logHealthData(int i, String str, ic2 ic2, ic2 ic22, ic2 ic23) throws RemoteException;

    void onActivityCreated(ic2 ic2, Bundle bundle, long j) throws RemoteException;

    void onActivityDestroyed(ic2 ic2, long j) throws RemoteException;

    void onActivityPaused(ic2 ic2, long j) throws RemoteException;

    void onActivityResumed(ic2 ic2, long j) throws RemoteException;

    void onActivitySaveInstanceState(ic2 ic2, g24 g24, long j) throws RemoteException;

    void onActivityStarted(ic2 ic2, long j) throws RemoteException;

    void onActivityStopped(ic2 ic2, long j) throws RemoteException;

    void performAction(Bundle bundle, g24 g24, long j) throws RemoteException;

    void registerOnMeasurementEventListener(ko3 ko3) throws RemoteException;

    void resetAnalyticsData(long j) throws RemoteException;

    void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException;

    void setConsent(Bundle bundle, long j) throws RemoteException;

    void setConsentThirdParty(Bundle bundle, long j) throws RemoteException;

    void setCurrentScreen(ic2 ic2, String str, String str2, long j) throws RemoteException;

    void setDataCollectionEnabled(boolean z) throws RemoteException;

    void setDefaultEventParameters(Bundle bundle) throws RemoteException;

    void setEventInterceptor(ko3 ko3) throws RemoteException;

    void setInstanceIdProvider(lo3 lo3) throws RemoteException;

    void setMeasurementEnabled(boolean z, long j) throws RemoteException;

    void setMinimumSessionDuration(long j) throws RemoteException;

    void setSessionTimeoutDuration(long j) throws RemoteException;

    void setUserId(String str, long j) throws RemoteException;

    void setUserProperty(String str, String str2, ic2 ic2, boolean z, long j) throws RemoteException;

    void unregisterOnMeasurementEventListener(ko3 ko3) throws RemoteException;
}

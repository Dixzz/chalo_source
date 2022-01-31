package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.freshchat.consumer.sdk.beans.config.DefaultUserEventsConfig;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.zzae;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.razorpay.AnalyticsConstants;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@DynamiteApi
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
public class AppMeasurementDynamiteService extends e24 {
    public vb4 f = null;
    public final Map<Integer, ad4> g = new n2();

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
    public class a implements xc4 {

        /* renamed from: a  reason: collision with root package name */
        public ko3 f607a;

        public a(ko3 ko3) {
            this.f607a = ko3;
        }

        public final void a(String str, String str2, Bundle bundle, long j) {
            try {
                this.f607a.a2(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.f.g().i.b("Event interceptor threw exception", e);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
    public class b implements ad4 {

        /* renamed from: a  reason: collision with root package name */
        public ko3 f608a;

        public b(ko3 ko3) {
            this.f608a = ko3;
        }

        @Override // defpackage.ad4
        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.f608a.a2(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.f.g().i.b("Event listener threw exception", e);
            }
        }
    }

    public final void F() {
        if (this.f == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // defpackage.f24
    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        F();
        this.f.A().u(str, j);
    }

    @Override // defpackage.f24
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        F();
        this.f.s().Q(str, str2, bundle);
    }

    @Override // defpackage.f24
    public void clearMeasurementEnabled(long j) throws RemoteException {
        F();
        dd4 s = this.f.s();
        s.s();
        s.f().u(new vd4(s, null));
    }

    @Override // defpackage.f24
    public void endAdUnitExposure(String str, long j) throws RemoteException {
        F();
        this.f.A().x(str, j);
    }

    @Override // defpackage.f24
    public void generateEventId(g24 g24) throws RemoteException {
        F();
        this.f.t().J(g24, this.f.t().s0());
    }

    @Override // defpackage.f24
    public void getAppInstanceId(g24 g24) throws RemoteException {
        F();
        this.f.f().u(new bd4(this, g24));
    }

    @Override // defpackage.f24
    public void getCachedAppInstanceId(g24 g24) throws RemoteException {
        F();
        this.f.t().L(g24, this.f.s().g.get());
    }

    @Override // defpackage.f24
    public void getConditionalUserProperties(String str, String str2, g24 g24) throws RemoteException {
        F();
        this.f.f().u(new ag4(this, g24, str, str2));
    }

    @Override // defpackage.f24
    public void getCurrentScreenClass(g24 g24) throws RemoteException {
        F();
        je4 je4 = this.f.s().f3331a.w().c;
        this.f.t().L(g24, je4 != null ? je4.b : null);
    }

    @Override // defpackage.f24
    public void getCurrentScreenName(g24 g24) throws RemoteException {
        F();
        je4 je4 = this.f.s().f3331a.w().c;
        this.f.t().L(g24, je4 != null ? je4.f1911a : null);
    }

    @Override // defpackage.f24
    public void getGmpAppId(g24 g24) throws RemoteException {
        F();
        this.f.t().L(g24, this.f.s().N());
    }

    @Override // defpackage.f24
    public void getMaxUserProperties(String str, g24 g24) throws RemoteException {
        F();
        this.f.s();
        gj1.j(str);
        this.f.t().I(g24, 25);
    }

    @Override // defpackage.f24
    public void getTestFlag(g24 g24, int i) throws RemoteException {
        F();
        if (i == 0) {
            ug4 t = this.f.t();
            dd4 s = this.f.s();
            Objects.requireNonNull(s);
            AtomicReference atomicReference = new AtomicReference();
            t.L(g24, (String) s.f().q(atomicReference, DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD, "String test flag value", new nd4(s, atomicReference)));
        } else if (i == 1) {
            ug4 t2 = this.f.t();
            dd4 s2 = this.f.s();
            Objects.requireNonNull(s2);
            AtomicReference atomicReference2 = new AtomicReference();
            t2.J(g24, ((Long) s2.f().q(atomicReference2, DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD, "long test flag value", new ud4(s2, atomicReference2))).longValue());
        } else if (i == 2) {
            ug4 t3 = this.f.t();
            dd4 s3 = this.f.s();
            Objects.requireNonNull(s3);
            AtomicReference atomicReference3 = new AtomicReference();
            double doubleValue = ((Double) s3.f().q(atomicReference3, DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD, "double test flag value", new wd4(s3, atomicReference3))).doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                g24.zza(bundle);
            } catch (RemoteException e) {
                t3.f3331a.g().i.b("Error returning double value to wrapper", e);
            }
        } else if (i == 3) {
            ug4 t4 = this.f.t();
            dd4 s4 = this.f.s();
            Objects.requireNonNull(s4);
            AtomicReference atomicReference4 = new AtomicReference();
            t4.I(g24, ((Integer) s4.f().q(atomicReference4, DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD, "int test flag value", new td4(s4, atomicReference4))).intValue());
        } else if (i == 4) {
            ug4 t5 = this.f.t();
            dd4 s5 = this.f.s();
            Objects.requireNonNull(s5);
            AtomicReference atomicReference5 = new AtomicReference();
            t5.N(g24, ((Boolean) s5.f().q(atomicReference5, DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD, "boolean test flag value", new ed4(s5, atomicReference5))).booleanValue());
        }
    }

    @Override // defpackage.f24
    public void getUserProperties(String str, String str2, boolean z, g24 g24) throws RemoteException {
        F();
        this.f.f().u(new be4(this, g24, str, str2, z));
    }

    @Override // defpackage.f24
    public void initForTests(Map map) throws RemoteException {
        F();
    }

    @Override // defpackage.f24
    public void initialize(ic2 ic2, zzae zzae, long j) throws RemoteException {
        Context context = (Context) kc2.L(ic2);
        vb4 vb4 = this.f;
        if (vb4 == null) {
            this.f = vb4.b(context, zzae, Long.valueOf(j));
        } else {
            vb4.g().i.a("Attempting to initialize multiple times");
        }
    }

    @Override // defpackage.f24
    public void isDataCollectionEnabled(g24 g24) throws RemoteException {
        F();
        this.f.f().u(new yg4(this, g24));
    }

    @Override // defpackage.f24
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        F();
        this.f.s().H(str, str2, bundle, z, z2, j);
    }

    @Override // defpackage.f24
    public void logEventAndBundle(String str, String str2, Bundle bundle, g24 g24, long j) throws RemoteException {
        Bundle bundle2;
        F();
        gj1.j(str2);
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString(CrashlyticsAnalyticsListener.EVENT_ORIGIN_KEY, SettingsJsonConstants.APP_KEY);
        this.f.f().u(new ze4(this, g24, new zzaq(str2, new zzap(bundle), SettingsJsonConstants.APP_KEY, j), str));
    }

    @Override // defpackage.f24
    public void logHealthData(int i, String str, ic2 ic2, ic2 ic22, ic2 ic23) throws RemoteException {
        Object obj;
        Object obj2;
        F();
        Object obj3 = null;
        if (ic2 == null) {
            obj = null;
        } else {
            obj = kc2.L(ic2);
        }
        if (ic22 == null) {
            obj2 = null;
        } else {
            obj2 = kc2.L(ic22);
        }
        if (ic23 != null) {
            obj3 = kc2.L(ic23);
        }
        this.f.g().v(i, true, false, str, obj, obj2, obj3);
    }

    @Override // defpackage.f24
    public void onActivityCreated(ic2 ic2, Bundle bundle, long j) throws RemoteException {
        F();
        zd4 zd4 = this.f.s().c;
        if (zd4 != null) {
            this.f.s().L();
            zd4.onActivityCreated((Activity) kc2.L(ic2), bundle);
        }
    }

    @Override // defpackage.f24
    public void onActivityDestroyed(ic2 ic2, long j) throws RemoteException {
        F();
        zd4 zd4 = this.f.s().c;
        if (zd4 != null) {
            this.f.s().L();
            zd4.onActivityDestroyed((Activity) kc2.L(ic2));
        }
    }

    @Override // defpackage.f24
    public void onActivityPaused(ic2 ic2, long j) throws RemoteException {
        F();
        zd4 zd4 = this.f.s().c;
        if (zd4 != null) {
            this.f.s().L();
            zd4.onActivityPaused((Activity) kc2.L(ic2));
        }
    }

    @Override // defpackage.f24
    public void onActivityResumed(ic2 ic2, long j) throws RemoteException {
        F();
        zd4 zd4 = this.f.s().c;
        if (zd4 != null) {
            this.f.s().L();
            zd4.onActivityResumed((Activity) kc2.L(ic2));
        }
    }

    @Override // defpackage.f24
    public void onActivitySaveInstanceState(ic2 ic2, g24 g24, long j) throws RemoteException {
        F();
        zd4 zd4 = this.f.s().c;
        Bundle bundle = new Bundle();
        if (zd4 != null) {
            this.f.s().L();
            zd4.onActivitySaveInstanceState((Activity) kc2.L(ic2), bundle);
        }
        try {
            g24.zza(bundle);
        } catch (RemoteException e) {
            this.f.g().i.b("Error returning bundle value to wrapper", e);
        }
    }

    @Override // defpackage.f24
    public void onActivityStarted(ic2 ic2, long j) throws RemoteException {
        F();
        if (this.f.s().c != null) {
            this.f.s().L();
            Activity activity = (Activity) kc2.L(ic2);
        }
    }

    @Override // defpackage.f24
    public void onActivityStopped(ic2 ic2, long j) throws RemoteException {
        F();
        if (this.f.s().c != null) {
            this.f.s().L();
            Activity activity = (Activity) kc2.L(ic2);
        }
    }

    @Override // defpackage.f24
    public void performAction(Bundle bundle, g24 g24, long j) throws RemoteException {
        F();
        g24.zza(null);
    }

    @Override // defpackage.f24
    public void registerOnMeasurementEventListener(ko3 ko3) throws RemoteException {
        ad4 ad4;
        F();
        synchronized (this.g) {
            ad4 = this.g.get(Integer.valueOf(ko3.zza()));
            if (ad4 == null) {
                ad4 = new b(ko3);
                this.g.put(Integer.valueOf(ko3.zza()), ad4);
            }
        }
        dd4 s = this.f.s();
        s.s();
        if (!s.e.add(ad4)) {
            s.g().i.a("OnEventListener already registered");
        }
    }

    @Override // defpackage.f24
    public void resetAnalyticsData(long j) throws RemoteException {
        F();
        dd4 s = this.f.s();
        s.g.set(null);
        s.f().u(new md4(s, j));
    }

    @Override // defpackage.f24
    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        F();
        if (bundle == null) {
            this.f.g().f.a("Conditional user property must not be null");
        } else {
            this.f.s().x(bundle, j);
        }
    }

    @Override // defpackage.f24
    public void setConsent(Bundle bundle, long j) throws RemoteException {
        F();
        dd4 s = this.f.s();
        if (uy3.a() && s.f3331a.g.t(null, q64.H0)) {
            s.w(bundle, 30, j);
        }
    }

    @Override // defpackage.f24
    public void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        F();
        dd4 s = this.f.s();
        if (uy3.a() && s.f3331a.g.t(null, q64.I0)) {
            s.w(bundle, 10, j);
        }
    }

    @Override // defpackage.f24
    public void setCurrentScreen(ic2 ic2, String str, String str2, long j) throws RemoteException {
        F();
        ie4 w = this.f.w();
        Activity activity = (Activity) kc2.L(ic2);
        if (!w.f3331a.g.y().booleanValue()) {
            w.g().k.a("setCurrentScreen cannot be called while screen reporting is disabled.");
        } else if (w.c == null) {
            w.g().k.a("setCurrentScreen cannot be called while no activity active");
        } else if (w.f.get(activity) == null) {
            w.g().k.a("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = ie4.w(activity.getClass().getCanonicalName());
            }
            boolean p0 = ug4.p0(w.c.b, str2);
            boolean p02 = ug4.p0(w.c.f1911a, str);
            if (p0 && p02) {
                w.g().k.a("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                w.g().k.b("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                w.g().n.c("Setting current screen to name, class", str == null ? AnalyticsConstants.NULL : str, str2);
                je4 je4 = new je4(str, str2, w.h().s0());
                w.f.put(activity, je4);
                w.y(activity, je4, true);
            } else {
                w.g().k.b("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    @Override // defpackage.f24
    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        F();
        dd4 s = this.f.s();
        s.s();
        s.f().u(new hd4(s, z));
    }

    @Override // defpackage.f24
    public void setDefaultEventParameters(Bundle bundle) {
        Bundle bundle2;
        F();
        dd4 s = this.f.s();
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        s.f().u(new cd4(s, bundle2));
    }

    @Override // defpackage.f24
    public void setEventInterceptor(ko3 ko3) throws RemoteException {
        F();
        a aVar = new a(ko3);
        if (this.f.f().x()) {
            this.f.s().A(aVar);
        } else {
            this.f.f().u(new xg4(this, aVar));
        }
    }

    @Override // defpackage.f24
    public void setInstanceIdProvider(lo3 lo3) throws RemoteException {
        F();
    }

    @Override // defpackage.f24
    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        F();
        dd4 s = this.f.s();
        Boolean valueOf = Boolean.valueOf(z);
        s.s();
        s.f().u(new vd4(s, valueOf));
    }

    @Override // defpackage.f24
    public void setMinimumSessionDuration(long j) throws RemoteException {
        F();
        dd4 s = this.f.s();
        s.f().u(new jd4(s, j));
    }

    @Override // defpackage.f24
    public void setSessionTimeoutDuration(long j) throws RemoteException {
        F();
        dd4 s = this.f.s();
        s.f().u(new id4(s, j));
    }

    @Override // defpackage.f24
    public void setUserId(String str, long j) throws RemoteException {
        F();
        this.f.s().K(null, "_id", str, true, j);
    }

    @Override // defpackage.f24
    public void setUserProperty(String str, String str2, ic2 ic2, boolean z, long j) throws RemoteException {
        F();
        this.f.s().K(str, str2, kc2.L(ic2), z, j);
    }

    @Override // defpackage.f24
    public void unregisterOnMeasurementEventListener(ko3 ko3) throws RemoteException {
        ad4 remove;
        F();
        synchronized (this.g) {
            remove = this.g.remove(Integer.valueOf(ko3.zza()));
        }
        if (remove == null) {
            remove = new b(ko3);
        }
        dd4 s = this.f.s();
        s.s();
        if (!s.e.remove(remove)) {
            s.g().i.a("OnEventListener had not been registered");
        }
    }
}

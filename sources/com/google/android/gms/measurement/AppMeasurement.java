package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.Keep;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.measurement.internal.zzku;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Deprecated
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public class AppMeasurement {
    public static volatile AppMeasurement d;

    /* renamed from: a  reason: collision with root package name */
    public final vb4 f606a;
    public final ce4 b;
    public final boolean c;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
    public static class ConditionalUserProperty {
        @Keep
        public boolean mActive;
        @Keep
        public String mAppId;
        @Keep
        public long mCreationTimestamp;
        @Keep
        public String mExpiredEventName;
        @Keep
        public Bundle mExpiredEventParams;
        @Keep
        public String mName;
        @Keep
        public String mOrigin;
        @Keep
        public long mTimeToLive;
        @Keep
        public String mTimedOutEventName;
        @Keep
        public Bundle mTimedOutEventParams;
        @Keep
        public String mTriggerEventName;
        @Keep
        public long mTriggerTimeout;
        @Keep
        public String mTriggeredEventName;
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        public long mTriggeredTimestamp;
        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            String str = this.mAppId;
            if (str != null) {
                bundle.putString("app_id", str);
            }
            String str2 = this.mOrigin;
            if (str2 != null) {
                bundle.putString(FirebaseAnalytics.Param.ORIGIN, str2);
            }
            String str3 = this.mName;
            if (str3 != null) {
                bundle.putString("name", str3);
            }
            Object obj = this.mValue;
            if (obj != null) {
                hd3.L3(bundle, obj);
            }
            String str4 = this.mTriggerEventName;
            if (str4 != null) {
                bundle.putString("trigger_event_name", str4);
            }
            bundle.putLong("trigger_timeout", this.mTriggerTimeout);
            String str5 = this.mTimedOutEventName;
            if (str5 != null) {
                bundle.putString("timed_out_event_name", str5);
            }
            Bundle bundle2 = this.mTimedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle("timed_out_event_params", bundle2);
            }
            String str6 = this.mTriggeredEventName;
            if (str6 != null) {
                bundle.putString("triggered_event_name", str6);
            }
            Bundle bundle3 = this.mTriggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle("triggered_event_params", bundle3);
            }
            bundle.putLong("time_to_live", this.mTimeToLive);
            String str7 = this.mExpiredEventName;
            if (str7 != null) {
                bundle.putString("expired_event_name", str7);
            }
            Bundle bundle4 = this.mExpiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle("expired_event_params", bundle4);
            }
            bundle.putLong("creation_timestamp", this.mCreationTimestamp);
            bundle.putBoolean("active", this.mActive);
            bundle.putLong("triggered_timestamp", this.mTriggeredTimestamp);
            return bundle;
        }

        public ConditionalUserProperty(Bundle bundle) {
            Objects.requireNonNull(bundle, "null reference");
            this.mAppId = (String) hd3.z3(bundle, "app_id", String.class, null);
            this.mOrigin = (String) hd3.z3(bundle, FirebaseAnalytics.Param.ORIGIN, String.class, null);
            this.mName = (String) hd3.z3(bundle, "name", String.class, null);
            this.mValue = hd3.z3(bundle, FirebaseAnalytics.Param.VALUE, Object.class, null);
            this.mTriggerEventName = (String) hd3.z3(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) hd3.z3(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) hd3.z3(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) hd3.z3(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) hd3.z3(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) hd3.z3(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) hd3.z3(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) hd3.z3(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) hd3.z3(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) hd3.z3(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) hd3.z3(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) hd3.z3(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        }
    }

    public AppMeasurement(vb4 vb4) {
        Objects.requireNonNull(vb4, "null reference");
        this.f606a = vb4;
        this.b = null;
        this.c = false;
    }

    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        ce4 ce4;
        if (d == null) {
            synchronized (AppMeasurement.class) {
                if (d == null) {
                    try {
                        ce4 = (ce4) Class.forName("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
                    } catch (ClassNotFoundException unused) {
                        ce4 = null;
                    }
                    if (ce4 != null) {
                        d = new AppMeasurement(ce4);
                    } else {
                        d = new AppMeasurement(vb4.b(context, new zzae(0, 0, true, null, null, null, null), null));
                    }
                }
            }
        }
        return d;
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        if (this.c) {
            this.b.zza(str);
            return;
        }
        b64 A = this.f606a.A();
        Objects.requireNonNull((db2) this.f606a.n);
        A.u(str, SystemClock.elapsedRealtime());
    }

    @Keep
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (this.c) {
            this.b.zzb(str, str2, bundle);
        } else {
            this.f606a.s().Q(str, str2, bundle);
        }
    }

    @Keep
    public void endAdUnitExposure(String str) {
        if (this.c) {
            this.b.zzb(str);
            return;
        }
        b64 A = this.f606a.A();
        Objects.requireNonNull((db2) this.f606a.n);
        A.x(str, SystemClock.elapsedRealtime());
    }

    @Keep
    public long generateEventId() {
        if (this.c) {
            return this.b.zze();
        }
        return this.f606a.t().s0();
    }

    @Keep
    public String getAppInstanceId() {
        if (this.c) {
            return this.b.zzc();
        }
        return this.f606a.s().g.get();
    }

    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List<Bundle> list;
        int i = 0;
        if (this.c) {
            list = this.b.zza(str, str2);
        } else {
            dd4 s = this.f606a.s();
            if (s.f().x()) {
                s.g().f.a("Cannot get conditional user properties from analytics worker thread");
                list = new ArrayList<>(0);
            } else if (hh4.a()) {
                s.g().f.a("Cannot get conditional user properties from main thread");
                list = new ArrayList<>(0);
            } else {
                AtomicReference atomicReference = new AtomicReference();
                s.f3331a.f().q(atomicReference, 5000, "get conditional user properties", new pd4(s, atomicReference, str, str2));
                List list2 = (List) atomicReference.get();
                if (list2 == null) {
                    s.g().f.b("Timed out waiting for get conditional user properties", null);
                    list = new ArrayList<>();
                } else {
                    list = ug4.i0(list2);
                }
            }
        }
        if (list != null) {
            i = list.size();
        }
        ArrayList arrayList = new ArrayList(i);
        for (Bundle bundle : list) {
            arrayList.add(new ConditionalUserProperty(bundle));
        }
        return arrayList;
    }

    @Keep
    public String getCurrentScreenClass() {
        if (this.c) {
            return this.b.zzb();
        }
        je4 je4 = this.f606a.s().f3331a.w().c;
        if (je4 != null) {
            return je4.b;
        }
        return null;
    }

    @Keep
    public String getCurrentScreenName() {
        if (this.c) {
            return this.b.zza();
        }
        je4 je4 = this.f606a.s().f3331a.w().c;
        if (je4 != null) {
            return je4.f1911a;
        }
        return null;
    }

    @Keep
    public String getGmpAppId() {
        if (this.c) {
            return this.b.zzd();
        }
        return this.f606a.s().N();
    }

    @Keep
    public int getMaxUserProperties(String str) {
        if (this.c) {
            return this.b.zzc(str);
        }
        this.f606a.s();
        gj1.j(str);
        return 25;
    }

    @Keep
    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        if (this.c) {
            return this.b.zza(str, str2, z);
        }
        dd4 s = this.f606a.s();
        if (s.f().x()) {
            s.g().f.a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (hh4.a()) {
            s.g().f.a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            s.f3331a.f().q(atomicReference, 5000, "get user properties", new sd4(s, atomicReference, str, str2, z));
            List<zzku> list = (List) atomicReference.get();
            if (list == null) {
                s.g().f.b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            n2 n2Var = new n2(list.size());
            for (zzku zzku : list) {
                n2Var.put(zzku.g, zzku.l1());
            }
            return n2Var;
        }
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (this.c) {
            this.b.zza(str, str2, bundle);
        } else {
            this.f606a.s().G(str, str2, bundle);
        }
    }

    @Keep
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        Objects.requireNonNull(conditionalUserProperty, "null reference");
        if (this.c) {
            this.b.zza(conditionalUserProperty.a());
            return;
        }
        dd4 s = this.f606a.s();
        Bundle a2 = conditionalUserProperty.a();
        Objects.requireNonNull((db2) s.f3331a.n);
        s.x(a2, System.currentTimeMillis());
    }

    public AppMeasurement(ce4 ce4) {
        Objects.requireNonNull(ce4, "null reference");
        this.b = ce4;
        this.f606a = null;
        this.c = true;
    }
}

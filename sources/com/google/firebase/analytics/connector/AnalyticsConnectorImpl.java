package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zza;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zzd;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzb;
    public final Map<String, zza> zza = new ConcurrentHashMap();
    private final a64 zzc;

    private AnalyticsConnectorImpl(a64 a64) {
        Objects.requireNonNull(a64, "null reference");
        this.zzc = a64;
    }

    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp, Context context, Subscriber subscriber) {
        Objects.requireNonNull(firebaseApp, "null reference");
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(subscriber, "null reference");
        Objects.requireNonNull(context.getApplicationContext(), "null reference");
        if (zzb == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (zzb == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.isDefaultApp()) {
                        subscriber.subscribe(DataCollectionDefaultChange.class, zzb.zza, zza.zza);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                    }
                    zzb = new AnalyticsConnectorImpl(oo3.a(context, null, null, null, bundle).d);
                }
            }
        }
        return zzb;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean zza(String str) {
        return !str.isEmpty() && this.zza.containsKey(str) && this.zza.get(str) != null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (str2 == null || zzd.zza(str2, bundle)) {
            oo3 oo3 = this.zzc.f127a;
            Objects.requireNonNull(oo3);
            oo3.c.execute(new to3(oo3, str, str2, bundle));
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : this.zzc.f127a.g(str, str2)) {
            arrayList.add(zzd.zza(bundle));
        }
        return arrayList;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public int getMaxUserProperties(String str) {
        return this.zzc.f127a.j(str);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public Map<String, Object> getUserProperties(boolean z) {
        return this.zzc.f127a.b(null, null, z);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void logEvent(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzd.zza(str) && zzd.zza(str2, bundle) && zzd.zza(str, str2, bundle)) {
            zzd.zzb(str, str2, bundle);
            this.zzc.f127a.e(str, str2, bundle, true, true, null);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(final String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        zza zza2;
        Objects.requireNonNull(analyticsConnectorListener, "null reference");
        if (!zzd.zza(str) || zza(str)) {
            return null;
        }
        a64 a64 = this.zzc;
        if (FirebaseABTesting.OriginService.INAPP_MESSAGING.equals(str)) {
            zza2 = new zzc(a64, analyticsConnectorListener);
        } else if ("crash".equals(str) || "clx".equals(str)) {
            zza2 = new zze(a64, analyticsConnectorListener);
        } else {
            zza2 = null;
        }
        if (zza2 == null) {
            return null;
        }
        this.zza.put(str, zza2);
        return new AnalyticsConnector.AnalyticsConnectorHandle() {
            /* class com.google.firebase.analytics.connector.AnalyticsConnectorImpl.AnonymousClass1 */

            @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
            public void registerEventNames(Set<String> set) {
                if (AnalyticsConnectorImpl.this.zza((AnalyticsConnectorImpl) str) && str.equals(FirebaseABTesting.OriginService.INAPP_MESSAGING) && set != null && !set.isEmpty()) {
                    AnalyticsConnectorImpl.this.zza.get(str).zza(set);
                }
            }

            @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
            public void unregister() {
                if (AnalyticsConnectorImpl.this.zza((AnalyticsConnectorImpl) str)) {
                    AnalyticsConnector.AnalyticsConnectorListener zza2 = AnalyticsConnectorImpl.this.zza.get(str).zza();
                    if (zza2 != null) {
                        zza2.onMessageTriggered(0, null);
                    }
                    AnalyticsConnectorImpl.this.zza.remove(str);
                }
            }

            @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
            public void unregisterEventNames() {
                if (AnalyticsConnectorImpl.this.zza((AnalyticsConnectorImpl) str) && str.equals(FirebaseABTesting.OriginService.INAPP_MESSAGING)) {
                    AnalyticsConnectorImpl.this.zza.get(str).zzb();
                }
            }
        };
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        if (zzd.zza(conditionalUserProperty)) {
            a64 a64 = this.zzc;
            Bundle zzb2 = zzd.zzb(conditionalUserProperty);
            oo3 oo3 = a64.f127a;
            Objects.requireNonNull(oo3);
            oo3.c.execute(new qo3(oo3, zzb2));
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setUserProperty(String str, String str2, Object obj) {
        if (zzd.zza(str) && zzd.zza(str, str2)) {
            this.zzc.f127a.f(str, str2, obj, true);
        }
    }

    public static final void zza(Event event) {
        boolean z = ((DataCollectionDefaultChange) event.getPayload()).enabled;
        synchronized (AnalyticsConnectorImpl.class) {
            oo3 oo3 = ((AnalyticsConnectorImpl) zzb).zzc.f127a;
            Objects.requireNonNull(oo3);
            oo3.c.execute(new qp3(oo3, z));
        }
    }

    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }
}

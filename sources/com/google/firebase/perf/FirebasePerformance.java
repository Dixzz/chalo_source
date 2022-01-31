package com.google.firebase.perf;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.PerfMetricValidator;
import com.google.firebase.perf.internal.RemoteConfigManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.HttpMetric;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.ImmutableBundle;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URL;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FirebasePerformance implements FirebasePerformanceAttributable {
    private static final int MAX_ATTRIBUTE_KEY_LENGTH = 40;
    private static final int MAX_ATTRIBUTE_VALUE_LENGTH = 100;
    private static final int MAX_TRACE_CUSTOM_ATTRIBUTES = 5;
    public static final int MAX_TRACE_NAME_LENGTH = 100;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final ConfigResolver configResolver;
    private final Map<String, String> mCustomAttributes;
    private final ImmutableBundle mMetadataBundle;
    private Boolean mPerformanceCollectionForceEnabledState;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpMethod {
        public static final String CONNECT = "CONNECT";
        public static final String DELETE = "DELETE";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final String OPTIONS = "OPTIONS";
        public static final String PATCH = "PATCH";
        public static final String POST = "POST";
        public static final String PUT = "PUT";
        public static final String TRACE = "TRACE";
    }

    public FirebasePerformance(FirebaseApp firebaseApp, Provider<RemoteConfigComponent> provider, FirebaseInstallationsApi firebaseInstallationsApi, Provider<eu1> provider2) {
        this(firebaseApp, provider, firebaseInstallationsApi, provider2, RemoteConfigManager.getInstance(), ConfigResolver.getInstance(), GaugeManager.getInstance());
    }

    private void checkAttribute(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Attribute must not have null key or value.");
        } else if (this.mCustomAttributes.containsKey(str) || this.mCustomAttributes.size() < 5) {
            String validateAttribute = PerfMetricValidator.validateAttribute(new AbstractMap.SimpleEntry(str, str2));
            if (validateAttribute != null) {
                throw new IllegalArgumentException(validateAttribute);
            }
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "Exceeds max limit of number of attributes - %d", 5));
        }
    }

    private static ImmutableBundle extractMetadata(Context context) {
        Bundle bundle;
        ImmutableBundle immutableBundle;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            e.getMessage();
            bundle = null;
        }
        if (bundle == null) {
            immutableBundle = new ImmutableBundle();
        }
        return immutableBundle;
    }

    public static FirebasePerformance getInstance() {
        return (FirebasePerformance) FirebaseApp.getInstance().get(FirebasePerformance.class);
    }

    public static Trace startTrace(String str) {
        Trace create = Trace.create(str);
        create.start();
        return create;
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public String getAttribute(String str) {
        return this.mCustomAttributes.get(str);
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public Map<String, String> getAttributes() {
        return new HashMap(this.mCustomAttributes);
    }

    public Boolean getPerformanceCollectionForceEnabledState() {
        return this.mPerformanceCollectionForceEnabledState;
    }

    public boolean isPerformanceCollectionEnabled() {
        Boolean bool = this.mPerformanceCollectionForceEnabledState;
        if (bool != null) {
            return bool.booleanValue();
        }
        return FirebaseApp.getInstance().isDataCollectionDefaultEnabled();
    }

    public HttpMetric newHttpMetric(String str, String str2) {
        return new HttpMetric(str, str2, TransportManager.getInstance(), new Timer());
    }

    public Trace newTrace(String str) {
        return Trace.create(str);
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void putAttribute(String str, String str2) {
        boolean z = true;
        try {
            str = str.trim();
            str2 = str2.trim();
            checkAttribute(str, str2);
        } catch (Exception e) {
            logger.error(String.format("Can not set attribute %s with value %s (%s)", str, str2, e.getMessage()), new Object[0]);
            z = false;
        }
        if (z) {
            this.mCustomAttributes.put(str, str2);
        }
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void removeAttribute(String str) {
        this.mCustomAttributes.remove(str);
    }

    public void setPerformanceCollectionEnabled(boolean z) {
        setPerformanceCollectionEnabled(Boolean.valueOf(z));
    }

    public HttpMetric newHttpMetric(URL url, String str) {
        return new HttpMetric(url, str, TransportManager.getInstance(), new Timer());
    }

    public synchronized void setPerformanceCollectionEnabled(Boolean bool) {
        try {
            FirebaseApp.getInstance();
            if (this.configResolver.getIsPerformanceCollectionDeactivated().booleanValue()) {
                logger.info("Firebase Performance is permanently disabled", new Object[0]);
                return;
            }
            this.configResolver.setIsPerformanceCollectionEnabled(bool);
            if (bool != null) {
                this.mPerformanceCollectionForceEnabledState = bool;
            } else {
                this.mPerformanceCollectionForceEnabledState = this.configResolver.getIsPerformanceCollectionEnabled();
            }
            if (Boolean.TRUE.equals(this.mPerformanceCollectionForceEnabledState)) {
                logger.info("Firebase Performance is Enabled", new Object[0]);
            } else if (Boolean.FALSE.equals(this.mPerformanceCollectionForceEnabledState)) {
                logger.info("Firebase Performance is Disabled", new Object[0]);
            }
        } catch (IllegalStateException unused) {
        }
    }

    public FirebasePerformance(FirebaseApp firebaseApp, Provider<RemoteConfigComponent> provider, FirebaseInstallationsApi firebaseInstallationsApi, Provider<eu1> provider2, RemoteConfigManager remoteConfigManager, ConfigResolver configResolver2, GaugeManager gaugeManager) {
        this.mCustomAttributes = new ConcurrentHashMap();
        this.mPerformanceCollectionForceEnabledState = null;
        if (firebaseApp == null) {
            this.mPerformanceCollectionForceEnabledState = Boolean.FALSE;
            this.configResolver = configResolver2;
            this.mMetadataBundle = new ImmutableBundle(new Bundle());
            return;
        }
        TransportManager.getInstance().initialize(firebaseApp, firebaseInstallationsApi, provider2);
        Context applicationContext = firebaseApp.getApplicationContext();
        ImmutableBundle extractMetadata = extractMetadata(applicationContext);
        this.mMetadataBundle = extractMetadata;
        remoteConfigManager.setFirebaseRemoteConfigProvider(provider);
        this.configResolver = configResolver2;
        configResolver2.setMetadataBundle(extractMetadata);
        configResolver2.setApplicationContext(applicationContext);
        gaugeManager.setApplicationContext(applicationContext);
        this.mPerformanceCollectionForceEnabledState = configResolver2.getIsPerformanceCollectionEnabled();
    }
}

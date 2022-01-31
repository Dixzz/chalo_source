package com.google.firebase;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R;
import java.util.Arrays;
import java.util.Objects;

public final class FirebaseOptions {
    private static final String API_KEY_RESOURCE_NAME = "google_api_key";
    private static final String APP_ID_RESOURCE_NAME = "google_app_id";
    private static final String DATABASE_URL_RESOURCE_NAME = "firebase_database_url";
    private static final String GA_TRACKING_ID_RESOURCE_NAME = "ga_trackingId";
    private static final String GCM_SENDER_ID_RESOURCE_NAME = "gcm_defaultSenderId";
    private static final String PROJECT_ID_RESOURCE_NAME = "project_id";
    private static final String STORAGE_BUCKET_RESOURCE_NAME = "google_storage_bucket";
    private final String apiKey;
    private final String applicationId;
    private final String databaseUrl;
    private final String gaTrackingId;
    private final String gcmSenderId;
    private final String projectId;
    private final String storageBucket;

    public static final class Builder {
        private String apiKey;
        private String applicationId;
        private String databaseUrl;
        private String gaTrackingId;
        private String gcmSenderId;
        private String projectId;
        private String storageBucket;

        public Builder() {
        }

        public FirebaseOptions build() {
            return new FirebaseOptions(this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId);
        }

        public Builder setApiKey(String str) {
            gj1.i(str, "ApiKey must be set.");
            this.apiKey = str;
            return this;
        }

        public Builder setApplicationId(String str) {
            gj1.i(str, "ApplicationId must be set.");
            this.applicationId = str;
            return this;
        }

        public Builder setDatabaseUrl(String str) {
            this.databaseUrl = str;
            return this;
        }

        public Builder setGaTrackingId(String str) {
            this.gaTrackingId = str;
            return this;
        }

        public Builder setGcmSenderId(String str) {
            this.gcmSenderId = str;
            return this;
        }

        public Builder setProjectId(String str) {
            this.projectId = str;
            return this;
        }

        public Builder setStorageBucket(String str) {
            this.storageBucket = str;
            return this;
        }

        public Builder(FirebaseOptions firebaseOptions) {
            this.applicationId = firebaseOptions.applicationId;
            this.apiKey = firebaseOptions.apiKey;
            this.databaseUrl = firebaseOptions.databaseUrl;
            this.gaTrackingId = firebaseOptions.gaTrackingId;
            this.gcmSenderId = firebaseOptions.gcmSenderId;
            this.storageBucket = firebaseOptions.storageBucket;
            this.projectId = firebaseOptions.projectId;
        }
    }

    public static FirebaseOptions fromResource(Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Objects.requireNonNull(context, "null reference");
        Resources resources = context.getResources();
        String resourcePackageName = resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
        int identifier = resources.getIdentifier(APP_ID_RESOURCE_NAME, "string", resourcePackageName);
        String str7 = null;
        if (identifier == 0) {
            str = null;
        } else {
            str = resources.getString(identifier);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int identifier2 = resources.getIdentifier(API_KEY_RESOURCE_NAME, "string", resourcePackageName);
        if (identifier2 == 0) {
            str2 = null;
        } else {
            str2 = resources.getString(identifier2);
        }
        int identifier3 = resources.getIdentifier(DATABASE_URL_RESOURCE_NAME, "string", resourcePackageName);
        if (identifier3 == 0) {
            str3 = null;
        } else {
            str3 = resources.getString(identifier3);
        }
        int identifier4 = resources.getIdentifier(GA_TRACKING_ID_RESOURCE_NAME, "string", resourcePackageName);
        if (identifier4 == 0) {
            str4 = null;
        } else {
            str4 = resources.getString(identifier4);
        }
        int identifier5 = resources.getIdentifier(GCM_SENDER_ID_RESOURCE_NAME, "string", resourcePackageName);
        if (identifier5 == 0) {
            str5 = null;
        } else {
            str5 = resources.getString(identifier5);
        }
        int identifier6 = resources.getIdentifier(STORAGE_BUCKET_RESOURCE_NAME, "string", resourcePackageName);
        if (identifier6 == 0) {
            str6 = null;
        } else {
            str6 = resources.getString(identifier6);
        }
        int identifier7 = resources.getIdentifier(PROJECT_ID_RESOURCE_NAME, "string", resourcePackageName);
        if (identifier7 != 0) {
            str7 = resources.getString(identifier7);
        }
        return new FirebaseOptions(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        if (!gj1.G(this.applicationId, firebaseOptions.applicationId) || !gj1.G(this.apiKey, firebaseOptions.apiKey) || !gj1.G(this.databaseUrl, firebaseOptions.databaseUrl) || !gj1.G(this.gaTrackingId, firebaseOptions.gaTrackingId) || !gj1.G(this.gcmSenderId, firebaseOptions.gcmSenderId) || !gj1.G(this.storageBucket, firebaseOptions.storageBucket) || !gj1.G(this.projectId, firebaseOptions.projectId)) {
            return false;
        }
        return true;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public String getDatabaseUrl() {
        return this.databaseUrl;
    }

    public String getGaTrackingId() {
        return this.gaTrackingId;
    }

    public String getGcmSenderId() {
        return this.gcmSenderId;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getStorageBucket() {
        return this.storageBucket;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId});
    }

    public String toString() {
        g82 g82 = new g82(this);
        g82.a("applicationId", this.applicationId);
        g82.a("apiKey", this.apiKey);
        g82.a("databaseUrl", this.databaseUrl);
        g82.a("gcmSenderId", this.gcmSenderId);
        g82.a("storageBucket", this.storageBucket);
        g82.a("projectId", this.projectId);
        return g82.toString();
    }

    private FirebaseOptions(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        gj1.o(!hb2.b(str), "ApplicationId must be set.");
        this.applicationId = str;
        this.apiKey = str2;
        this.databaseUrl = str3;
        this.gaTrackingId = str4;
        this.gcmSenderId = str5;
        this.storageBucket = str6;
        this.projectId = str7;
    }
}

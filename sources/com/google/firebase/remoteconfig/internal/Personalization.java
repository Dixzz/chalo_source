package com.google.firebase.remoteconfig.internal;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import org.json.JSONObject;

public class Personalization {
    public static final String ANALYTICS_ORIGIN_PERSONALIZATION = "fp";
    public static final String ANALYTICS_PULL_EVENT = "_fpc";
    public static final String ARM_KEY = "_fpid";
    public static final String ARM_VALUE = "_fpct";
    public static final String PERSONALIZATION_ID = "personalizationId";
    private final AnalyticsConnector analyticsConnector;

    public Personalization(AnalyticsConnector analyticsConnector2) {
        this.analyticsConnector = analyticsConnector2;
    }

    public void logArmActive(String str, ConfigContainer configContainer) {
        JSONObject optJSONObject;
        JSONObject personalizationMetadata = configContainer.getPersonalizationMetadata();
        if (personalizationMetadata.length() >= 1) {
            JSONObject configs = configContainer.getConfigs();
            if (configs.length() >= 1 && (optJSONObject = personalizationMetadata.optJSONObject(str)) != null) {
                Bundle bundle = new Bundle();
                bundle.putString(ARM_KEY, optJSONObject.optString(PERSONALIZATION_ID));
                bundle.putString(ARM_VALUE, configs.optString(str));
                this.analyticsConnector.logEvent(ANALYTICS_ORIGIN_PERSONALIZATION, ANALYTICS_PULL_EVENT, bundle);
            }
        }
    }
}

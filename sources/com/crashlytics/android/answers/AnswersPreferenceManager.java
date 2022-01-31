package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Objects;

public class AnswersPreferenceManager {
    public static final String PREFKEY_ANALYTICS_LAUNCHED = "analytics_launched";
    public static final String PREF_STORE_NAME = "settings";
    private final w16 prefStore;

    public AnswersPreferenceManager(w16 w16) {
        this.prefStore = w16;
    }

    public static AnswersPreferenceManager build(Context context) {
        return new AnswersPreferenceManager(new x16(context, PREF_STORE_NAME));
    }

    @SuppressLint({"CommitPrefEdits"})
    public boolean hasAnalyticsLaunched() {
        return ((x16) this.prefStore).f3871a.getBoolean(PREFKEY_ANALYTICS_LAUNCHED, false);
    }

    @SuppressLint({"CommitPrefEdits"})
    public void setAnalyticsLaunched() {
        w16 w16 = this.prefStore;
        SharedPreferences.Editor putBoolean = ((x16) w16).a().putBoolean(PREFKEY_ANALYTICS_LAUNCHED, true);
        Objects.requireNonNull((x16) w16);
        putBoolean.apply();
    }
}

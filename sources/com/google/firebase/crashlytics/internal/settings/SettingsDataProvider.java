package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;

public interface SettingsDataProvider {
    yi4<AppSettingsData> getAppSettings();

    Settings getSettings();
}

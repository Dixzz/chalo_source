package com.crashlytics.android.beta;

import java.io.IOException;
import org.json.JSONObject;

public class CheckForUpdatesResponseTransform {
    public static final String BUILD_VERSION = "build_version";
    public static final String DISPLAY_VERSION = "display_version";
    public static final String IDENTIFIER = "identifier";
    public static final String INSTANCE_IDENTIFIER = "instance_identifier";
    public static final String URL = "url";
    public static final String VERSION_STRING = "version_string";

    public CheckForUpdatesResponse fromJson(JSONObject jSONObject) throws IOException {
        if (jSONObject == null) {
            return null;
        }
        return new CheckForUpdatesResponse(jSONObject.optString("url", null), jSONObject.optString(VERSION_STRING, null), jSONObject.optString("display_version", null), jSONObject.optString("build_version", null), jSONObject.optString(IDENTIFIER, null), jSONObject.optString(INSTANCE_IDENTIFIER, null));
    }
}

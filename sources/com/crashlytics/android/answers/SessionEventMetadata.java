package com.crashlytics.android.answers;

public final class SessionEventMetadata {
    public final String advertisingId;
    public final String androidId;
    public final String appBundleId;
    public final String appVersionCode;
    public final String appVersionName;
    public final String betaDeviceToken;
    public final String buildId;
    public final String deviceModel;
    public final String executionId;
    public final String installationId;
    public final Boolean limitAdTrackingEnabled;
    public final String osVersion;
    private String stringRepresentation;

    public SessionEventMetadata(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.appBundleId = str;
        this.executionId = str2;
        this.installationId = str3;
        this.androidId = str4;
        this.advertisingId = str5;
        this.limitAdTrackingEnabled = bool;
        this.betaDeviceToken = str6;
        this.buildId = str7;
        this.osVersion = str8;
        this.deviceModel = str9;
        this.appVersionCode = str10;
        this.appVersionName = str11;
    }

    public String toString() {
        if (this.stringRepresentation == null) {
            StringBuilder i0 = hj1.i0("appBundleId=");
            i0.append(this.appBundleId);
            i0.append(", executionId=");
            i0.append(this.executionId);
            i0.append(", installationId=");
            i0.append(this.installationId);
            i0.append(", androidId=");
            i0.append(this.androidId);
            i0.append(", advertisingId=");
            i0.append(this.advertisingId);
            i0.append(", limitAdTrackingEnabled=");
            i0.append(this.limitAdTrackingEnabled);
            i0.append(", betaDeviceToken=");
            i0.append(this.betaDeviceToken);
            i0.append(", buildId=");
            i0.append(this.buildId);
            i0.append(", osVersion=");
            i0.append(this.osVersion);
            i0.append(", deviceModel=");
            i0.append(this.deviceModel);
            i0.append(", appVersionCode=");
            i0.append(this.appVersionCode);
            i0.append(", appVersionName=");
            i0.append(this.appVersionName);
            this.stringRepresentation = i0.toString();
        }
        return this.stringRepresentation;
    }
}

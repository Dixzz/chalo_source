package com.freshchat.consumer.sdk.beans;

import com.crashlytics.android.beta.CheckForUpdatesResponseTransform;
import com.freshchat.consumer.sdk.j.k;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

public class User {
    public static final String DEVICE_META_APP_VERSION_CODE = "app_version_code";
    public static final String DEVICE_META_APP_VERSION_NAME = "app_version";
    public static final String DEVICE_META_MANUFACTURER = "manufacturer";
    public static final String DEVICE_META_MODEL = "model";
    public static final String DEVICE_META_OS_NAME = "os";
    public static final String DEVICE_META_OS_VERSION_CODE = "os_version_code";
    public static final String DEVICE_META_OS_VERSION_NAME = "os_version";
    public static final String DEVICE_META_SDK_VERSION_CODE = "sdk_version_code";
    public static final int NOTIFICATION_TYPE_ANDROID = 1;
    public static final int NOTIFICATION_TYPE_IPHONE = 2;
    public static final int USER_TYPE_AGENT = 2;
    public static final int USER_TYPE_MOBILE = 0;
    public static final int USER_TYPE_OWNER = 1;
    private String alias;
    @SerializedName("deviceAndroidMeta")
    private Map<String, String> androidDeviceMeta = new HashMap();
    private String email;
    @SerializedName(CheckForUpdatesResponseTransform.IDENTIFIER)
    private String externalId;
    private String firstName;
    @SerializedName("jwtUserAuthToken")
    private String jwtIdToken;
    private String lastName;
    private String locale;
    private Map<String, String> meta = new HashMap();
    private String phone;
    private String phoneCountry;
    private String restoreId;

    public String getAlias() {
        return this.alias;
    }

    public Map<String, String> getAndroidDeviceMeta() {
        return this.androidDeviceMeta;
    }

    public String getEmail() {
        return this.email;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getJwtIdToken() {
        return this.jwtIdToken;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getLocale() {
        return this.locale;
    }

    public Map<String, String> getMeta() {
        return this.meta;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPhoneCountry() {
        return this.phoneCountry;
    }

    public String getRestoreId() {
        return this.restoreId;
    }

    public User setAlias(String str) {
        this.alias = str;
        return this;
    }

    public User setAndroidDeviceMeta(Map<String, String> map) {
        this.androidDeviceMeta = map;
        return this;
    }

    public User setEmail(String str) {
        this.email = str;
        return this;
    }

    public User setExternalId(String str) {
        this.externalId = str;
        return this;
    }

    public User setFirstName(String str) {
        this.firstName = str;
        return this;
    }

    public User setJwtIdToken(String str) {
        this.jwtIdToken = str;
        return this;
    }

    public User setLastName(String str) {
        this.lastName = str;
        return this;
    }

    public User setLocale(String str) {
        this.locale = str;
        return this;
    }

    public User setMeta(Map<String, String> map) {
        this.meta.clear();
        if (k.d(map)) {
            this.meta.putAll(map);
        }
        return this;
    }

    public User setPhone(String str) {
        this.phone = str;
        return this;
    }

    public User setPhoneCountry(String str) {
        this.phoneCountry = str;
        return this;
    }

    public User setRestoreId(String str) {
        this.restoreId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("User{");
        sb.append("alias='");
        hj1.U0(sb, this.alias, '\'', ", firstName='");
        hj1.U0(sb, this.firstName, '\'', ", lastName='");
        hj1.U0(sb, this.lastName, '\'', ", email='");
        hj1.U0(sb, this.email, '\'', ", phone='");
        hj1.U0(sb, this.phone, '\'', ", phoneCountry='");
        hj1.U0(sb, this.phoneCountry, '\'', ", externalId='");
        hj1.U0(sb, this.externalId, '\'', ", restoreId='");
        hj1.U0(sb, this.restoreId, '\'', ", androidDeviceMeta='");
        sb.append(this.androidDeviceMeta);
        sb.append('\'');
        sb.append(", meta=");
        sb.append(this.meta);
        sb.append('\'');
        sb.append(", locale=");
        hj1.U0(sb, this.locale, '\'', ", jwtIdToken=");
        return hj1.Z(sb, this.jwtIdToken, '}');
    }
}

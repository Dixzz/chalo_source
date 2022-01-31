package com.truecaller.android.sdk.models;

import android.os.Build;
import com.freshchat.consumer.sdk.beans.User;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CreateInstallationModel {
    public static final int ATTEMPT_1 = 1;
    public static final int ATTEMPT_2 = 2;
    private static final int CLIENT_ID = 15;
    private static final String CLIENT_OS = "android";
    private static final List<String> EMPTY_SIM_SERIALS;
    @SerializedName("clientId")
    private final int clientId;
    @SerializedName("countryCodeName")
    public final String countryCodeName;
    @SerializedName("deviceId")
    public final String deviceId;
    @SerializedName("hasTruecaller")
    public final boolean hasTruecaller;
    @SerializedName("language")
    private final String language = Locale.getDefault().getLanguage();
    @SerializedName(User.DEVICE_META_OS_NAME)
    private final String os;
    @SerializedName("phoneNumber")
    public final String phoneNumber;
    @SerializedName("phonePermission")
    private boolean phonePermission;
    @SerializedName("simSerial")
    public List<String> simSerialNumbers;
    @SerializedName("sequence")
    @VerificationAttempts
    private int verificationAttempt;
    @SerializedName("version")
    private final String version;

    static {
        ArrayList arrayList = new ArrayList(1);
        EMPTY_SIM_SERIALS = arrayList;
        arrayList.add("");
    }

    public CreateInstallationModel(String str, String str2, String str3, boolean z) {
        this.phoneNumber = str2;
        this.countryCodeName = str;
        this.deviceId = str3;
        this.clientId = 15;
        this.os = "android";
        this.version = Build.VERSION.RELEASE;
        this.simSerialNumbers = EMPTY_SIM_SERIALS;
        this.hasTruecaller = z;
    }

    public void setPhonePermission(boolean z) {
        this.phonePermission = z;
    }

    public void setSimSerialNumbers(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.simSerialNumbers = list;
        }
    }

    public void setVerificationAttempt(@VerificationAttempts int i) {
        this.verificationAttempt = i;
    }
}

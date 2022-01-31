package com.truecaller.android.sdk.models;

import com.google.gson.annotations.SerializedName;

public class VerifyInstallationModel {
    @SerializedName("countryCodeName")
    private final String mCountryCodeName;
    @SerializedName("phoneNumber")
    private final String mPhoneNumber;
    @SerializedName("secretToken")
    public final String mSecretToken;
    @SerializedName("verificationToken")
    private final String mVerificationToken;

    public VerifyInstallationModel(String str, String str2, String str3, String str4) {
        this.mVerificationToken = str;
        this.mPhoneNumber = str2;
        this.mCountryCodeName = str3;
        this.mSecretToken = str4;
    }
}

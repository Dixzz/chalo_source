package com.truecaller.android.sdk;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.Locale;
import java.util.UUID;

@Keep
public class PartnerInformation implements Parcelable {
    private static final String APP_FINGERPRINT = "PARTNERINFO_APP_FINGERPRINT";
    public static final Parcelable.Creator<PartnerInformation> CREATOR = new a();
    public static final String PACKAGE_NAME = "PARTNERINFO_PACKAGE_NAME";
    public static final String PARTNER_INFO_EXTRA = "PARTNER_INFO_EXTRA";
    private static final String PARTNER_KEY = "PARTNERINFO_PARTNER_KEY";
    private static final String REQ_NONCE = "PARTNERINFO_REQ_NONCE";
    private static final String SDK_LOCALE = "PARTNERINFO_LOCALE";
    private static final String SDK_THEME = "PARTNERINFO_THEME";
    private static final String SDK_VARIANT = "PARTNERINFO_SDK_VARIANT";
    private static final String SDK_VARIANT_VERSION = "PARTNERINFO_SDK_VARIANT_VERSION";
    public static final String TRUESDK_VERSION = "PARTNERINFO_TRUESDK_VERSION";
    public final String appFingerprint;
    public final Locale locale;
    public final String packageName;
    public final String partnerKey;
    public final String reqNonce;
    public String sdkVariant;
    public String sdkVariantVersion;
    public final int theme;
    public final String truesdkVersion;

    public static class a implements Parcelable.Creator<PartnerInformation> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public PartnerInformation createFromParcel(Parcel parcel) {
            return new PartnerInformation(parcel, null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public PartnerInformation[] newArray(int i) {
            return new PartnerInformation[i];
        }
    }

    public /* synthetic */ PartnerInformation(Parcel parcel, a aVar) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToBundle(Bundle bundle) {
        bundle.putString(TRUESDK_VERSION, this.truesdkVersion);
        bundle.putString(PARTNER_KEY, this.partnerKey);
        bundle.putString(PACKAGE_NAME, this.packageName);
        bundle.putString(APP_FINGERPRINT, this.appFingerprint);
        bundle.putString(REQ_NONCE, this.reqNonce);
        Locale locale2 = this.locale;
        if (locale2 != null) {
            bundle.putString(SDK_LOCALE, locale2.toString());
        }
        bundle.putInt(SDK_THEME, this.theme);
        bundle.putString(SDK_VARIANT, this.sdkVariant);
        bundle.putString(SDK_VARIANT_VERSION, this.sdkVariantVersion);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.partnerKey);
        parcel.writeString(this.packageName);
        parcel.writeString(this.appFingerprint);
    }

    public PartnerInformation(String str, String str2, String str3, String str4, String str5, Locale locale2, int i, String str6, String str7) {
        this.truesdkVersion = str;
        this.partnerKey = str2;
        this.packageName = str3;
        this.appFingerprint = str4;
        this.reqNonce = str5;
        this.locale = locale2;
        this.theme = i;
        this.sdkVariant = str6;
        this.sdkVariantVersion = str7;
    }

    public PartnerInformation(Bundle bundle) {
        this.truesdkVersion = bundle.getString(TRUESDK_VERSION, "");
        this.partnerKey = bundle.getString(PARTNER_KEY, "");
        this.packageName = bundle.getString(PACKAGE_NAME, "");
        this.appFingerprint = bundle.getString(APP_FINGERPRINT, "");
        this.reqNonce = bundle.getString(REQ_NONCE, "");
        this.locale = new Locale(bundle.getString(SDK_LOCALE, ""));
        this.theme = bundle.getInt(SDK_THEME, 0);
        this.sdkVariant = bundle.getString(SDK_VARIANT, "");
        this.sdkVariantVersion = bundle.getString(SDK_VARIANT_VERSION, "");
    }

    private PartnerInformation(Parcel parcel) {
        this.partnerKey = parcel.readString();
        this.packageName = parcel.readString();
        this.appFingerprint = parcel.readString();
        this.truesdkVersion = "0.4.2";
        this.reqNonce = UUID.randomUUID().toString();
        this.locale = Locale.ENGLISH;
        this.theme = 0;
    }
}

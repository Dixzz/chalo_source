package com.razorpay;

import android.os.Parcel;
import android.os.Parcelable;

public class ApplicationDetails implements Parcelable {
    public static final Parcelable.Creator<ApplicationDetails> CREATOR = new b__J_();
    private String appName;
    private String iconBase64;
    private String packageName;

    public ApplicationDetails(String str, String str2, String str3) {
        this.appName = str;
        this.iconBase64 = str2;
        this.packageName = str3;
    }

    public int describeContents() {
        return 0;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getIconBase64() {
        return this.iconBase64;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appName);
        parcel.writeString(this.iconBase64);
        parcel.writeString(this.packageName);
    }

    public ApplicationDetails(Parcel parcel) {
        this.appName = parcel.readString();
        this.iconBase64 = parcel.readString();
        this.packageName = parcel.readString();
    }
}

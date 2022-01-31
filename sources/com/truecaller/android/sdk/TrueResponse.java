package com.truecaller.android.sdk;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class TrueResponse implements Parcelable {
    public static final Parcelable.Creator<TrueResponse> CREATOR = new a();
    public static final String IS_SUCCESSFUL = "TRUERESPONSE_IS_SUCCESSFUL";
    public static final String TRUECALLER_RESPONSE_EXTRA = "TRUECALLER_RESPONSE_EXTRA";
    public static final String TRUESDK_VERSION = "TRUERESPONSE_TRUESDK_VERSION";
    public final boolean isSuccessful;
    public final TrueError trueError;
    public final TrueProfile trueProfile;
    private final String truesdkVersion;

    public static class a implements Parcelable.Creator<TrueResponse> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public TrueResponse createFromParcel(Parcel parcel) {
            return new TrueResponse(parcel, null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public TrueResponse[] newArray(int i) {
            return new TrueResponse[i];
        }
    }

    public /* synthetic */ TrueResponse(Parcel parcel, a aVar) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToBundle(Bundle bundle) {
        TrueProfile trueProfile2;
        bundle.putBoolean(IS_SUCCESSFUL, this.isSuccessful);
        bundle.putString(TRUESDK_VERSION, this.truesdkVersion);
        if (!this.isSuccessful || (trueProfile2 = this.trueProfile) == null) {
            TrueError trueError2 = this.trueError;
            if (trueError2 != null) {
                trueError2.writeToBundle(bundle);
                return;
            }
            return;
        }
        trueProfile2.writeToBundle(bundle);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.trueProfile, i);
        parcel.writeParcelable(this.trueError, i);
        parcel.writeString(String.valueOf(this.isSuccessful));
    }

    public TrueResponse(TrueProfile trueProfile2) {
        this.trueProfile = trueProfile2;
        this.trueError = null;
        this.isSuccessful = true;
        this.truesdkVersion = "2.6.0";
    }

    public TrueResponse(TrueError trueError2) {
        this.trueProfile = null;
        this.trueError = trueError2;
        this.isSuccessful = false;
        this.truesdkVersion = "2.6.0";
    }

    public TrueResponse(Bundle bundle) {
        boolean z = bundle.getBoolean(IS_SUCCESSFUL);
        this.isSuccessful = z;
        this.truesdkVersion = bundle.getString(TRUESDK_VERSION);
        if (z) {
            this.trueProfile = new TrueProfile(bundle);
            this.trueError = null;
            return;
        }
        this.trueProfile = null;
        this.trueError = new TrueError(bundle);
    }

    private TrueResponse(Parcel parcel) {
        this.trueProfile = (TrueProfile) parcel.readParcelable(TrueProfile.class.getClassLoader());
        this.trueError = (TrueError) parcel.readParcelable(TrueError.class.getClassLoader());
        this.isSuccessful = Boolean.valueOf(parcel.readString()).booleanValue();
        this.truesdkVersion = "0.4.2";
    }
}

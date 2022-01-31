package com.google.firebase.auth;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class PhoneMultiFactorInfo extends MultiFactorInfo {
    public static final Parcelable.Creator<PhoneMultiFactorInfo> CREATOR = new zzae();
    private final String zza;
    @Nullable
    private final String zzb;
    private final long zzc;
    private final String zzd;

    public PhoneMultiFactorInfo(String str, @Nullable String str2, long j, String str3) {
        gj1.j(str);
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        gj1.j(str3);
        this.zzd = str3;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    @Nullable
    public String getDisplayName() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public long getEnrollmentTimestamp() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public String getFactorId() {
        return "phone";
    }

    public String getPhoneNumber() {
        return this.zzd;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public String getUid() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    @Nullable
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MultiFactorInfo.FACTOR_ID_KEY, "phone");
            jSONObject.putOpt("uid", this.zza);
            jSONObject.putOpt(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME, this.zzb);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.zzc));
            jSONObject.putOpt("phoneNumber", this.zzd);
            return jSONObject;
        } catch (JSONException e) {
            throw new xx2(e);
        }
    }

    @SuppressLint({"FirebaseUnknownNullness"})
    public void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, getUid(), false);
        gj1.B0(parcel, 2, getDisplayName(), false);
        long enrollmentTimestamp = getEnrollmentTimestamp();
        parcel.writeInt(524291);
        parcel.writeLong(enrollmentTimestamp);
        gj1.B0(parcel, 4, getPhoneNumber(), false);
        gj1.H1(parcel, o1);
    }
}

package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.mpmetrics.InAppNotification;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniInAppNotification extends InAppNotification {
    public static final Parcelable.Creator<MiniInAppNotification> CREATOR = new a();
    public final String q;
    public final int r;
    public final int s;

    public class a implements Parcelable.Creator<MiniInAppNotification> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public MiniInAppNotification createFromParcel(Parcel parcel) {
            return new MiniInAppNotification(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public MiniInAppNotification[] newArray(int i) {
            return new MiniInAppNotification[i];
        }
    }

    public MiniInAppNotification(Parcel parcel) {
        super(parcel);
        this.q = parcel.readString();
        this.r = parcel.readInt();
        this.s = parcel.readInt();
    }

    @Override // com.mixpanel.android.mpmetrics.InAppNotification
    public InAppNotification.b b() {
        return InAppNotification.b.MINI;
    }

    @Override // com.mixpanel.android.mpmetrics.InAppNotification
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.q);
        parcel.writeInt(this.r);
        parcel.writeInt(this.s);
    }

    public MiniInAppNotification(JSONObject jSONObject) throws bc5 {
        super(jSONObject);
        try {
            this.q = hd3.n2(jSONObject, "cta_url");
            this.r = jSONObject.getInt("image_tint_color");
            this.s = jSONObject.getInt("border_color");
        } catch (JSONException e) {
            throw new bc5("Notification JSON was unexpected or bad", e);
        }
    }
}

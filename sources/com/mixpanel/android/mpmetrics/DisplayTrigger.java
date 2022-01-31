package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayTrigger implements Parcelable {
    public static final Parcelable.Creator<DisplayTrigger> CREATOR = new a();
    public final String f;
    public final JSONObject g;
    public final ad5 h;

    public class a implements Parcelable.Creator<DisplayTrigger> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public DisplayTrigger createFromParcel(Parcel parcel) {
            return new DisplayTrigger(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public DisplayTrigger[] newArray(int i) {
            return new DisplayTrigger[i];
        }
    }

    public DisplayTrigger(JSONObject jSONObject) throws bc5 {
        try {
            this.f = jSONObject.getString("event");
            JSONObject optJSONObject = jSONObject.optJSONObject("selector");
            this.g = optJSONObject;
            this.h = optJSONObject != null ? new ad5(optJSONObject) : null;
        } catch (JSONException e) {
            throw new bc5("Event triggered notification JSON was unexpected or bad", e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.g.toString());
    }

    public DisplayTrigger(Parcel parcel) {
        JSONObject jSONObject;
        this.f = parcel.readString();
        ad5 ad5 = null;
        try {
            jSONObject = new JSONObject(parcel.readString());
        } catch (JSONException unused) {
            jSONObject = null;
        }
        this.g = jSONObject;
        this.h = jSONObject != null ? new ad5(jSONObject) : ad5;
    }
}

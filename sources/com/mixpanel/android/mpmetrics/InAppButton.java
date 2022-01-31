package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppButton implements Parcelable {
    public static final Parcelable.Creator<InAppButton> CREATOR = new a();
    public JSONObject f;
    public String g;
    public int h;
    public int i;
    public int j;
    public String k;

    public class a implements Parcelable.Creator<InAppButton> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public InAppButton createFromParcel(Parcel parcel) {
            return new InAppButton(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public InAppButton[] newArray(int i) {
            return new InAppButton[i];
        }
    }

    public InAppButton(Parcel parcel) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = new JSONObject(parcel.readString());
        } catch (JSONException unused) {
        }
        this.f = jSONObject;
        this.g = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f.toString());
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
    }

    public InAppButton(JSONObject jSONObject) throws JSONException {
        this.f = jSONObject;
        this.g = jSONObject.getString("text");
        this.h = jSONObject.getInt("text_color");
        this.i = jSONObject.getInt("bg_color");
        this.j = jSONObject.getInt("border_color");
        this.k = jSONObject.getString("cta_url");
    }
}

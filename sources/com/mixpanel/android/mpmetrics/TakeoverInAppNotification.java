package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.mixpanel.android.mpmetrics.InAppNotification;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TakeoverInAppNotification extends InAppNotification {
    public static final Parcelable.Creator<TakeoverInAppNotification> CREATOR = new a();
    public final ArrayList<InAppButton> q;
    public final int r;
    public final String s;
    public final int t;
    public final boolean u;

    public class a implements Parcelable.Creator<TakeoverInAppNotification> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public TakeoverInAppNotification createFromParcel(Parcel parcel) {
            return new TakeoverInAppNotification(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public TakeoverInAppNotification[] newArray(int i) {
            return new TakeoverInAppNotification[i];
        }
    }

    public TakeoverInAppNotification(Parcel parcel) {
        super(parcel);
        this.q = parcel.createTypedArrayList(InAppButton.CREATOR);
        this.r = parcel.readInt();
        this.s = parcel.readString();
        this.t = parcel.readInt();
        this.u = parcel.readByte() != 0;
    }

    @Override // com.mixpanel.android.mpmetrics.InAppNotification
    public InAppNotification.b b() {
        return InAppNotification.b.TAKEOVER;
    }

    @Override // com.mixpanel.android.mpmetrics.InAppNotification
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.q);
        parcel.writeInt(this.r);
        parcel.writeString(this.s);
        parcel.writeInt(this.t);
        parcel.writeByte(this.u ? (byte) 1 : 0);
    }

    public TakeoverInAppNotification(JSONObject jSONObject) throws bc5 {
        super(jSONObject);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("buttons");
            this.q = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.q.add(new InAppButton((JSONObject) jSONArray.get(i)));
            }
            this.r = jSONObject.getInt("close_color");
            this.s = hd3.n2(jSONObject, ProductPromotionsObject.KEY_TITLE);
            this.t = jSONObject.optInt("title_color");
            this.u = this.g.getBoolean("image_fade");
        } catch (JSONException e) {
            throw new bc5("Notification JSON was unexpected or bad", e);
        }
    }
}

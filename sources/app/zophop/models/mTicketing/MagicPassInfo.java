package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MagicPassInfo implements Parcelable {
    public static final Parcelable.Creator<MagicPassInfo> CREATOR = new Parcelable.Creator<MagicPassInfo>() {
        /* class app.zophop.models.mTicketing.MagicPassInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public MagicPassInfo[] newArray(int i) {
            return new MagicPassInfo[0];
        }

        @Override // android.os.Parcelable.Creator
        public MagicPassInfo createFromParcel(Parcel parcel) {
            return new MagicPassInfo(parcel);
        }
    };
    private static String DUMMY_VALUE = "DUMMY_VALUE";
    private JSONObject _discountedfareMap;
    private JSONObject _fareMap;
    private boolean _isActive;
    private boolean _isRenewable;
    private String _passengerType;
    private JSONArray _verificationRequiredArray;

    public MagicPassInfo(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONArray jSONArray, boolean z, boolean z2) {
        this._passengerType = str;
        this._fareMap = jSONObject;
        this._discountedfareMap = jSONObject2;
        this._verificationRequiredArray = jSONArray;
        this._isActive = z;
        this._isRenewable = z2;
    }

    public int describeContents() {
        return 0;
    }

    public JSONObject getDiscountedfareMap() {
        return this._discountedfareMap;
    }

    public JSONObject getFareMap() {
        return this._fareMap;
    }

    public String getPassengerType() {
        return this._passengerType;
    }

    public JSONArray getVerificationRequiredArray() {
        return this._verificationRequiredArray;
    }

    public boolean isActive() {
        return this._isActive;
    }

    public boolean isRenewable() {
        return this._isRenewable;
    }

    public void setDiscountedfareMap(JSONObject jSONObject) {
        this._discountedfareMap = jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this._passengerType);
        if (this._fareMap == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this._fareMap.toString());
        }
        if (this._discountedfareMap == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this._discountedfareMap.toString());
        }
        if (this._verificationRequiredArray == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this._verificationRequiredArray.toString());
        }
        parcel.writeByte(this._isActive ? (byte) 1 : 0);
        parcel.writeByte(this._isRenewable ? (byte) 1 : 0);
    }

    public MagicPassInfo(Parcel parcel) {
        try {
            this._passengerType = parcel.readString();
            JSONArray jSONArray = null;
            this._fareMap = parcel.readByte() == 0 ? null : new JSONObject(parcel.readString());
            this._discountedfareMap = parcel.readByte() == 0 ? null : new JSONObject(parcel.readString());
            if (parcel.readByte() != 0) {
                jSONArray = new JSONArray(parcel.readString());
            }
            this._verificationRequiredArray = jSONArray;
            boolean z = true;
            this._isActive = parcel.readByte() != 0;
            if (parcel.readByte() == 0) {
                z = false;
            }
            this._isRenewable = z;
        } catch (JSONException unused) {
        }
    }
}

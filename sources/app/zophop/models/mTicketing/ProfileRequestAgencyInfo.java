package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

public class ProfileRequestAgencyInfo implements Parcelable {
    public static final Parcelable.Creator<ProfileRequestAgencyInfo> CREATOR = new Parcelable.Creator<ProfileRequestAgencyInfo>() {
        /* class app.zophop.models.mTicketing.ProfileRequestAgencyInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public ProfileRequestAgencyInfo createFromParcel(Parcel parcel) {
            return new ProfileRequestAgencyInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ProfileRequestAgencyInfo[] newArray(int i) {
            return new ProfileRequestAgencyInfo[i];
        }
    };
    private final String _agency;
    private Map<String, String> _agencyFields;
    private final String _city;
    private Map<String, String> _originalProofs;
    private final String _passengerType;
    private Map<String, String> _proofs;

    public ProfileRequestAgencyInfo(Map<String, String> map, Map<String, String> map2, Map<String, String> map3, String str, String str2, String str3) {
        this._agencyFields = map;
        this._proofs = map2;
        this._agency = str;
        this._city = str2;
        this._passengerType = str3;
        this._originalProofs = map3;
    }

    public int describeContents() {
        return 0;
    }

    public String getAgency() {
        return this._agency;
    }

    public Map<String, String> getAgencyFields() {
        return this._agencyFields;
    }

    public String getCity() {
        return this._city;
    }

    public Map<String, String> getOriginalProofs() {
        return this._originalProofs;
    }

    public String getPassengerType() {
        return this._passengerType;
    }

    public Map<String, String> getProofs() {
        return this._proofs;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._agency);
        parcel.writeString(this._city);
        parcel.writeValue(this._passengerType);
    }

    public ProfileRequestAgencyInfo(Parcel parcel) {
        this._agency = parcel.readString();
        this._city = parcel.readString();
        this._passengerType = parcel.readString();
    }
}

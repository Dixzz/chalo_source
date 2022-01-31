package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;

public class ProfileRequestInfo implements Parcelable {
    public static final Parcelable.Creator<ProfileRequestInfo> CREATOR = new Parcelable.Creator<ProfileRequestInfo>() {
        /* class app.zophop.models.mTicketing.ProfileRequestInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public ProfileRequestInfo createFromParcel(Parcel parcel) {
            return new ProfileRequestInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ProfileRequestInfo[] newArray(int i) {
            return new ProfileRequestInfo[i];
        }
    };
    private ProfileRequestAgencyInfo _agencyInfo;
    private MPass _mPass;
    private final BasicUserProfile _profile;

    public ProfileRequestInfo(BasicUserProfile basicUserProfile) {
        this._profile = basicUserProfile;
    }

    public int describeContents() {
        return 0;
    }

    public ProfileRequestAgencyInfo getAgencyInfo() {
        return this._agencyInfo;
    }

    public MPass getMagicPass() {
        return this._mPass;
    }

    public BasicUserProfile getProfile() {
        return this._profile;
    }

    public boolean hasAgencyInfo() {
        return this._agencyInfo != null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this._profile);
        parcel.writeValue(this._agencyInfo);
        parcel.writeValue(this._mPass);
    }

    public ProfileRequestInfo(BasicUserProfile basicUserProfile, ProfileRequestAgencyInfo profileRequestAgencyInfo) {
        this._profile = basicUserProfile;
        this._agencyInfo = profileRequestAgencyInfo;
    }

    public ProfileRequestInfo(BasicUserProfile basicUserProfile, ProfileRequestAgencyInfo profileRequestAgencyInfo, MPass mPass) {
        this._profile = basicUserProfile;
        this._agencyInfo = profileRequestAgencyInfo;
        this._mPass = mPass;
    }

    public ProfileRequestInfo(Parcel parcel) {
        this._profile = (BasicUserProfile) parcel.readValue(BasicUserProfile.class.getClassLoader());
        this._agencyInfo = (ProfileRequestAgencyInfo) parcel.readValue(ProfileRequestAgencyInfo.class.getClassLoader());
        this._mPass = (MPass) parcel.readValue(MPass.class.getClassLoader());
    }
}

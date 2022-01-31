package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.Gson;
import java.util.HashMap;

public class UserProfile implements Parcelable {
    public static final Parcelable.Creator<UserProfile> CREATOR = new Parcelable.Creator<UserProfile>() {
        /* class app.zophop.models.mTicketing.UserProfile.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public UserProfile[] newArray(int i) {
            return new UserProfile[0];
        }

        @Override // android.os.Parcelable.Creator
        public UserProfile createFromParcel(Parcel parcel) {
            return new UserProfile(parcel);
        }
    };
    private HashMap<String, UserAgencyInfo> _agencyInfo;
    private String _dateOfBirth;
    private String _emailId;
    private String _firstName;
    private Gender _gender;
    private String _lastName;
    private final String _phone;
    private String _profilePhoto;
    private String _userId;

    public UserProfile(String str) {
        this._phone = str;
        this._userId = str;
    }

    public static UserProfile fromJsonString(String str) {
        if (str == null) {
            return null;
        }
        return (UserProfile) hj1.s(str, UserProfile.class);
    }

    public static String toString(UserProfile userProfile) {
        if (userProfile == null) {
            return null;
        }
        return new Gson().toJson(userProfile);
    }

    public int describeContents() {
        return 0;
    }

    public HashMap<String, UserAgencyInfo> getAgencyInfo() {
        return this._agencyInfo;
    }

    public String getDateOfBirth() {
        return this._dateOfBirth;
    }

    public String getEmailId() {
        return this._emailId;
    }

    public String getFirstName() {
        return this._firstName;
    }

    public String getFullName() {
        if (TextUtils.isEmpty(this._lastName)) {
            if (TextUtils.isEmpty(this._firstName)) {
                return "";
            }
            return this._firstName;
        } else if (!TextUtils.isEmpty(this._firstName)) {
            return this._firstName + " " + this._lastName;
        } else if (TextUtils.isEmpty(this._lastName)) {
            return "";
        } else {
            return this._lastName;
        }
    }

    public Gender getGender() {
        return this._gender;
    }

    public String getLastName() {
        return this._lastName;
    }

    public String getPhone() {
        return this._phone;
    }

    public String getProfilePhoto() {
        return this._profilePhoto;
    }

    public String getUserId() {
        return this._userId;
    }

    public void setAgencyInfo(String str, UserAgencyInfo userAgencyInfo) {
        HashMap<String, UserAgencyInfo> hashMap = this._agencyInfo;
        if (hashMap != null) {
            hashMap.put(str, userAgencyInfo);
            return;
        }
        HashMap<String, UserAgencyInfo> hashMap2 = new HashMap<>();
        this._agencyInfo = hashMap2;
        hashMap2.put(str, userAgencyInfo);
    }

    public void setDateOfBirth(String str) {
        this._dateOfBirth = str;
    }

    public void setUserDetails(BasicProfileFields basicProfileFields) {
        this._firstName = basicProfileFields.getFirstName();
        this._lastName = basicProfileFields.getLastName();
        this._dateOfBirth = basicProfileFields.getDateOfBirth();
        this._gender = basicProfileFields.getGender();
    }

    public void setUserId(String str) {
        this._userId = str;
    }

    public void set_agencyInfo(HashMap<String, UserAgencyInfo> hashMap) {
        this._agencyInfo = hashMap;
    }

    public void set_profilePhoto(String str) {
        this._profilePhoto = str;
    }

    public void updateUserName(String str, String str2) {
        this._firstName = str;
        this._lastName = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._userId);
        parcel.writeString(this._firstName);
        parcel.writeString(this._lastName);
        parcel.writeString(this._gender.toString());
        parcel.writeString(this._dateOfBirth);
        parcel.writeString(this._emailId);
        parcel.writeString(this._phone);
        parcel.writeString(this._profilePhoto);
        parcel.writeMap(this._agencyInfo);
    }

    public UserProfile(String str, String str2, Gender gender, String str3, String str4, String str5, String str6, HashMap<String, UserAgencyInfo> hashMap) {
        this._firstName = str;
        this._lastName = str2;
        this._gender = gender;
        this._dateOfBirth = str3;
        this._emailId = str4;
        this._phone = str5;
        this._profilePhoto = str6;
        this._agencyInfo = hashMap;
    }

    public UserProfile(Parcel parcel) {
        this._userId = parcel.readString();
        this._firstName = parcel.readString();
        this._lastName = parcel.readString();
        this._gender = Gender.fromString(parcel.readString());
        this._dateOfBirth = parcel.readString();
        this._emailId = parcel.readString();
        this._phone = parcel.readString();
        this._profilePhoto = parcel.readString();
        this._agencyInfo = parcel.readHashMap(getClass().getClassLoader());
    }
}

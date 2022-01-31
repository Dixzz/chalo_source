package app.zophop.models.mTicketing.superPass;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.mTicketing.Gender;
import com.google.gson.Gson;

/* compiled from: SuperPassUserDetails.kt */
public final class SuperPassUserDetails implements Parcelable {
    public static final Parcelable.Creator<SuperPassUserDetails> CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    private String dateOfBirth;
    private String emailId;
    private String fullName;
    private Gender gender;
    private final String mobileNumber;
    private String profilePhoto;
    private final String userId;

    /* compiled from: SuperPassUserDetails.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j86 j86) {
            this();
        }

        public final String convertSuperPassUserDetailsToString(SuperPassUserDetails superPassUserDetails) {
            n86.e(superPassUserDetails, "lSuperPassUserDetails");
            String json = new Gson().toJson(superPassUserDetails);
            n86.d(json, "lGson.toJson(lSuperPassUserDetails)");
            return json;
        }

        public final SuperPassUserDetails getSuperPassUserDetailsFromString(String str) {
            n86.e(str, "lSuperPassUserDetailsString");
            Object fromJson = new Gson().fromJson(str, SuperPassUserDetails.class);
            n86.d(fromJson, "lGson.fromJson(lSuperPas…sUserDetails::class.java)");
            return (SuperPassUserDetails) fromJson;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0065  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x007f  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0085  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0093  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final app.zophop.models.mTicketing.superPass.SuperPassUserDetails getSuperPassUserDetailsFromUserProfile(app.zophop.models.mTicketing.UserProfile r13, app.zophop.models.mTicketing.superPass.SuperPassUserDetails r14) {
            /*
            // Method dump skipped, instructions count: 210
            */
            throw new UnsupportedOperationException("Method not decompiled: app.zophop.models.mTicketing.superPass.SuperPassUserDetails.Companion.getSuperPassUserDetailsFromUserProfile(app.zophop.models.mTicketing.UserProfile, app.zophop.models.mTicketing.superPass.SuperPassUserDetails):app.zophop.models.mTicketing.superPass.SuperPassUserDetails");
        }
    }

    /* compiled from: SuperPassUserDetails.kt */
    public static final class Creator implements Parcelable.Creator<SuperPassUserDetails> {
        @Override // android.os.Parcelable.Creator
        public final SuperPassUserDetails createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new SuperPassUserDetails(parcel.readString(), parcel.readString(), parcel.readString(), Gender.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final SuperPassUserDetails[] newArray(int i) {
            return new SuperPassUserDetails[i];
        }
    }

    public SuperPassUserDetails(String str, String str2, String str3, Gender gender2, String str4, String str5, String str6) {
        n86.e(str, "userId");
        n86.e(str2, SuperPassJsonKeys.MOBILE_NUMBER);
        n86.e(str3, "fullName");
        n86.e(gender2, SuperPassJsonKeys.GENDER);
        n86.e(str4, SuperPassJsonKeys.DATE_OF_BIRTH);
        n86.e(str5, "emailId");
        n86.e(str6, SuperPassJsonKeys.PROFILE_PHOTO);
        this.userId = str;
        this.mobileNumber = str2;
        this.fullName = str3;
        this.gender = gender2;
        this.dateOfBirth = str4;
        this.emailId = str5;
        this.profilePhoto = str6;
    }

    public static /* synthetic */ SuperPassUserDetails copy$default(SuperPassUserDetails superPassUserDetails, String str, String str2, String str3, Gender gender2, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = superPassUserDetails.userId;
        }
        if ((i & 2) != 0) {
            str2 = superPassUserDetails.mobileNumber;
        }
        if ((i & 4) != 0) {
            str3 = superPassUserDetails.fullName;
        }
        if ((i & 8) != 0) {
            gender2 = superPassUserDetails.gender;
        }
        if ((i & 16) != 0) {
            str4 = superPassUserDetails.dateOfBirth;
        }
        if ((i & 32) != 0) {
            str5 = superPassUserDetails.emailId;
        }
        if ((i & 64) != 0) {
            str6 = superPassUserDetails.profilePhoto;
        }
        return superPassUserDetails.copy(str, str2, str3, gender2, str4, str5, str6);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.mobileNumber;
    }

    public final String component3() {
        return this.fullName;
    }

    public final Gender component4() {
        return this.gender;
    }

    public final String component5() {
        return this.dateOfBirth;
    }

    public final String component6() {
        return this.emailId;
    }

    public final String component7() {
        return this.profilePhoto;
    }

    public final SuperPassUserDetails copy(String str, String str2, String str3, Gender gender2, String str4, String str5, String str6) {
        n86.e(str, "userId");
        n86.e(str2, SuperPassJsonKeys.MOBILE_NUMBER);
        n86.e(str3, "fullName");
        n86.e(gender2, SuperPassJsonKeys.GENDER);
        n86.e(str4, SuperPassJsonKeys.DATE_OF_BIRTH);
        n86.e(str5, "emailId");
        n86.e(str6, SuperPassJsonKeys.PROFILE_PHOTO);
        return new SuperPassUserDetails(str, str2, str3, gender2, str4, str5, str6);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperPassUserDetails)) {
            return false;
        }
        SuperPassUserDetails superPassUserDetails = (SuperPassUserDetails) obj;
        return n86.a(this.userId, superPassUserDetails.userId) && n86.a(this.mobileNumber, superPassUserDetails.mobileNumber) && n86.a(this.fullName, superPassUserDetails.fullName) && this.gender == superPassUserDetails.gender && n86.a(this.dateOfBirth, superPassUserDetails.dateOfBirth) && n86.a(this.emailId, superPassUserDetails.emailId) && n86.a(this.profilePhoto, superPassUserDetails.profilePhoto);
    }

    public final String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public final String getEmailId() {
        return this.emailId;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final Gender getGender() {
        return this.gender;
    }

    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    public final String getProfilePhoto() {
        return this.profilePhoto;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.fullName, hj1.r0(this.mobileNumber, this.userId.hashCode() * 31, 31), 31);
        return this.profilePhoto.hashCode() + hj1.r0(this.emailId, hj1.r0(this.dateOfBirth, (this.gender.hashCode() + r0) * 31, 31), 31);
    }

    public final void setDateOfBirth(String str) {
        n86.e(str, "<set-?>");
        this.dateOfBirth = str;
    }

    public final void setEmailId(String str) {
        n86.e(str, "<set-?>");
        this.emailId = str;
    }

    public final void setFullName(String str) {
        n86.e(str, "<set-?>");
        this.fullName = str;
    }

    public final void setGender(Gender gender2) {
        n86.e(gender2, "<set-?>");
        this.gender = gender2;
    }

    public final void setProfilePhoto(String str) {
        n86.e(str, "<set-?>");
        this.profilePhoto = str;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SuperPassUserDetails(userId=");
        i0.append(this.userId);
        i0.append(", mobileNumber=");
        i0.append(this.mobileNumber);
        i0.append(", fullName=");
        i0.append(this.fullName);
        i0.append(", gender=");
        i0.append(this.gender);
        i0.append(", dateOfBirth=");
        i0.append(this.dateOfBirth);
        i0.append(", emailId=");
        i0.append(this.emailId);
        i0.append(", profilePhoto=");
        return hj1.Z(i0, this.profilePhoto, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.userId);
        parcel.writeString(this.mobileNumber);
        parcel.writeString(this.fullName);
        this.gender.writeToParcel(parcel, i);
        parcel.writeString(this.dateOfBirth);
        parcel.writeString(this.emailId);
        parcel.writeString(this.profilePhoto);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuperPassUserDetails(String str, String str2, String str3, Gender gender2, String str4, String str5, String str6, int i, j86 j86) {
        this((i & 1) != 0 ? new String() : str, (i & 2) != 0 ? new String() : str2, (i & 4) != 0 ? new String() : str3, gender2, (i & 16) != 0 ? new String() : str4, (i & 32) != 0 ? new String() : str5, (i & 64) != 0 ? new String() : str6);
    }
}

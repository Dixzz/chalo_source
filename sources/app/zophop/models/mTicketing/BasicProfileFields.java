package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;

public class BasicProfileFields implements Parcelable {
    public static final Parcelable.Creator<BasicProfileFields> CREATOR = new Parcelable.Creator<BasicProfileFields>() {
        /* class app.zophop.models.mTicketing.BasicProfileFields.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public BasicProfileFields createFromParcel(Parcel parcel) {
            return new BasicProfileFields(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BasicProfileFields[] newArray(int i) {
            return new BasicProfileFields[i];
        }
    };
    private final String _dateOfBirth;
    private final String _emailId;
    private final String _firstName;
    private final Gender _gender;
    private final String _lastName;
    private final String _phone;

    public static class Builder {
        private String _dateOfBirth;
        private String _emailId;
        private String _firstName;
        private Gender _gender;
        private String _lastName;
        private String _phone;

        public BasicProfileFields build() {
            return new BasicProfileFields(this._firstName, this._lastName, this._gender, this._dateOfBirth, this._emailId, this._phone);
        }

        public Builder withDateOfBirth(String str) {
            this._dateOfBirth = str;
            return this;
        }

        public Builder withEmailId(String str) {
            this._emailId = str;
            return this;
        }

        public Builder withFirstName(String str) {
            this._firstName = str;
            return this;
        }

        public Builder withGender(Gender gender) {
            this._gender = gender;
            return this;
        }

        public Builder withLastName(String str) {
            this._lastName = str;
            return this;
        }

        public Builder withPhone(String str) {
            this._phone = str;
            return this;
        }
    }

    public int describeContents() {
        return 0;
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

    public Gender getGender() {
        return this._gender;
    }

    public String getLastName() {
        return this._lastName;
    }

    public String getPhone() {
        return this._phone;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._firstName);
        parcel.writeString(this._lastName);
        parcel.writeValue(this._gender);
        parcel.writeString(this._dateOfBirth);
        parcel.writeString(this._emailId);
        parcel.writeString(this._phone);
    }

    private BasicProfileFields(String str, String str2, Gender gender, String str3, String str4, String str5) {
        this._dateOfBirth = str3;
        this._emailId = str4;
        this._firstName = str;
        this._lastName = str2;
        this._gender = gender;
        this._phone = str5;
    }

    public BasicProfileFields(Parcel parcel) {
        this._firstName = parcel.readString();
        this._lastName = parcel.readString();
        this._gender = (Gender) parcel.readValue(Gender.class.getClassLoader());
        this._dateOfBirth = parcel.readString();
        this._emailId = parcel.readString();
        this._phone = parcel.readString();
    }
}

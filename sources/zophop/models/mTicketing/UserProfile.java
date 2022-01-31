package zophop.models.mTicketing;

import java.util.Map;

public class UserProfile {
    public String _dateOfBirth;
    public String _emailId;
    public String _firstName;
    public Gender _gender;
    public String _lastName;
    public String _mobileNumber;
    public PassengerType _passengerType;
    public String _profilePhoto;
    public Map _proofs;
    public String _userId;

    public UserProfile(String str, String str2, String str3, Gender gender, String str4, String str5, String str6, String str7, Map map, PassengerType passengerType) {
        this._userId = str;
        this._firstName = str2;
        this._lastName = str3;
        this._gender = gender;
        this._dateOfBirth = str4;
        this._emailId = str5;
        this._mobileNumber = str6;
        this._profilePhoto = str7;
        this._passengerType = passengerType;
        this._proofs = map;
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

    public String getMobileNumber() {
        return this._mobileNumber;
    }

    public PassengerType getPassengerType() {
        return this._passengerType;
    }

    public String getProfilePhoto() {
        return this._profilePhoto;
    }

    public Map getProofs() {
        return this._proofs;
    }

    public String getUserId() {
        return this._userId;
    }

    public void setUserId(String str) {
        this._userId = str;
    }
}

package app.zophop.models.mTicketing;

public class PayuUser {
    private final String _email;
    private final String _firstName;
    private final String _phoneNumber;

    public PayuUser(String str, String str2, String str3) {
        this._email = str;
        this._firstName = str2;
        this._phoneNumber = str3;
    }

    public String getEmail() {
        return this._email;
    }

    public String getFirstName() {
        return this._firstName;
    }

    public String getPhoneNumber() {
        return this._phoneNumber;
    }
}

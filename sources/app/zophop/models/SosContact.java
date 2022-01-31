package app.zophop.models;

public class SosContact {
    private final String _contactId;
    private final String _contactName;
    private final String _phoneNumber;

    public SosContact(String str, String str2, String str3) {
        this._contactId = str;
        this._contactName = str2;
        this._phoneNumber = str3;
    }

    public String getContactId() {
        return this._contactId;
    }

    public String getContactName() {
        return this._contactName;
    }

    public String getPhoneNumber() {
        return this._phoneNumber;
    }
}

package app.zophop.models;

import android.os.Parcel;
import android.os.Parcelable;

public class SavedCardDetails implements Parcelable {
    public static final Parcelable.Creator<SavedCardDetails> CREATOR = new Parcelable.Creator<SavedCardDetails>() {
        /* class app.zophop.models.SavedCardDetails.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public SavedCardDetails createFromParcel(Parcel parcel) {
            return new SavedCardDetails(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SavedCardDetails[] newArray(int i) {
            return new SavedCardDetails[i];
        }
    };
    private String entity;
    private int expiryMonth;
    private int expiryYear;
    private boolean isOnEmi;
    private String issuer;
    private String lastFourDigits;
    private String name;
    private String network;

    public SavedCardDetails(Parcel parcel) {
        this.entity = parcel.readString();
        this.name = parcel.readString();
        this.lastFourDigits = parcel.readString();
        this.network = parcel.readString();
        this.expiryMonth = parcel.readInt();
        this.expiryYear = parcel.readInt();
        this.isOnEmi = parcel.readByte() != 0;
        this.issuer = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getEntity() {
        return this.entity;
    }

    public int getExpiryMonth() {
        return this.expiryMonth;
    }

    public int getExpiryYear() {
        return this.expiryYear;
    }

    public String getIssuer() {
        return this.issuer;
    }

    public String getLastFourDigits() {
        return this.lastFourDigits;
    }

    public String getName() {
        return this.name;
    }

    public String getNetwork() {
        return this.network;
    }

    public boolean isOnEmi() {
        return this.isOnEmi;
    }

    public void setEntity(String str) {
        this.entity = str;
    }

    public void setExpiryMonth(int i) {
        this.expiryMonth = i;
    }

    public void setExpiryYear(int i) {
        this.expiryYear = i;
    }

    public void setIssuer(String str) {
        this.issuer = str;
    }

    public void setLastFourDigits(String str) {
        this.lastFourDigits = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNetwork(String str) {
        this.network = str;
    }

    public void setOnEmi(boolean z) {
        this.isOnEmi = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.entity);
        parcel.writeString(this.name);
        parcel.writeString(this.lastFourDigits);
        parcel.writeString(this.network);
        parcel.writeInt(this.expiryMonth);
        parcel.writeInt(this.expiryYear);
        parcel.writeByte(this.isOnEmi ? (byte) 1 : 0);
        parcel.writeString(this.issuer);
    }

    public SavedCardDetails() {
    }
}

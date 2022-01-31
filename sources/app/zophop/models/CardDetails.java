package app.zophop.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;

public class CardDetails implements Parcelable {
    public static final Parcelable.Creator<CardDetails> CREATOR = new Parcelable.Creator<CardDetails>() {
        /* class app.zophop.models.CardDetails.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public CardDetails createFromParcel(Parcel parcel) {
            return new CardDetails(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CardDetails[] newArray(int i) {
            return new CardDetails[i];
        }
    };
    private long createdAt;
    private String entity;
    private String method;
    private SavedCardDetails savedCard;
    private String token;
    private String tokenId;
    private long usedAt;

    public CardDetails(Parcel parcel) {
        this.tokenId = parcel.readString();
        this.token = parcel.readString();
        this.entity = parcel.readString();
        this.method = parcel.readString();
        this.savedCard = (SavedCardDetails) parcel.readValue(SavedCardDetails.class.getClassLoader());
        this.usedAt = parcel.readLong();
        this.createdAt = parcel.readLong();
    }

    public static CardDetails fromString(String str) {
        if (str == null) {
            return null;
        }
        return (CardDetails) hj1.s(str, CardDetails.class);
    }

    public static String toString(CardDetails cardDetails) {
        if (cardDetails == null) {
            return null;
        }
        return new Gson().toJson(cardDetails);
    }

    public int describeContents() {
        return 0;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getEntity() {
        return this.entity;
    }

    public String getMethod() {
        return this.method;
    }

    public SavedCardDetails getSavedCard() {
        return this.savedCard;
    }

    public String getToken() {
        return this.token;
    }

    public String getTokenId() {
        return this.tokenId;
    }

    public long getUsedAt() {
        return this.usedAt;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public void setEntity(String str) {
        this.entity = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setSavedCard(SavedCardDetails savedCardDetails) {
        this.savedCard = savedCardDetails;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTokenId(String str) {
        this.tokenId = str;
    }

    public void setUsedAt(long j) {
        this.usedAt = j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.tokenId);
        parcel.writeString(this.token);
        parcel.writeString(this.entity);
        parcel.writeString(this.method);
        parcel.writeValue(this.savedCard);
        parcel.writeLong(this.usedAt);
        parcel.writeLong(this.createdAt);
    }

    public CardDetails() {
    }
}

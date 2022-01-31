package app.zophop.models.mTicketing.cardRecharge;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: CardProperties.kt */
public final class CardProperties implements Parcelable {
    public static final Parcelable.Creator<CardProperties> CREATOR = new Creator();
    private final String agency;
    private final String cardNo;
    private final String city;

    /* compiled from: CardProperties.kt */
    public static final class Creator implements Parcelable.Creator<CardProperties> {
        @Override // android.os.Parcelable.Creator
        public final CardProperties createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new CardProperties(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final CardProperties[] newArray(int i) {
            return new CardProperties[i];
        }
    }

    public CardProperties(String str, String str2, String str3) {
        n86.e(str, CardRechargeJsonKeys.CARD_NO);
        n86.e(str2, "city");
        n86.e(str3, "agency");
        this.cardNo = str;
        this.city = str2;
        this.agency = str3;
    }

    public static /* synthetic */ CardProperties copy$default(CardProperties cardProperties, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cardProperties.cardNo;
        }
        if ((i & 2) != 0) {
            str2 = cardProperties.city;
        }
        if ((i & 4) != 0) {
            str3 = cardProperties.agency;
        }
        return cardProperties.copy(str, str2, str3);
    }

    public final String component1() {
        return this.cardNo;
    }

    public final String component2() {
        return this.city;
    }

    public final String component3() {
        return this.agency;
    }

    public final CardProperties copy(String str, String str2, String str3) {
        n86.e(str, CardRechargeJsonKeys.CARD_NO);
        n86.e(str2, "city");
        n86.e(str3, "agency");
        return new CardProperties(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardProperties)) {
            return false;
        }
        CardProperties cardProperties = (CardProperties) obj;
        return n86.a(this.cardNo, cardProperties.cardNo) && n86.a(this.city, cardProperties.city) && n86.a(this.agency, cardProperties.agency);
    }

    public final String getAgency() {
        return this.agency;
    }

    public final String getCardNo() {
        return this.cardNo;
    }

    public final String getCity() {
        return this.city;
    }

    public int hashCode() {
        return this.agency.hashCode() + hj1.r0(this.city, this.cardNo.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CardProperties(cardNo=");
        i0.append(this.cardNo);
        i0.append(", city=");
        i0.append(this.city);
        i0.append(", agency=");
        return hj1.Z(i0, this.agency, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.cardNo);
        parcel.writeString(this.city);
        parcel.writeString(this.agency);
    }
}

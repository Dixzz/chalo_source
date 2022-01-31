package app.zophop.pubsub.eventbus.events;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRechargeOrderDetails;

/* compiled from: OnlineCardRechargeOrderCreationEvent.kt */
public final class OnlineCardRechargeOrderCreationEvent implements Parcelable {
    public static final Parcelable.Creator<OnlineCardRechargeOrderCreationEvent> CREATOR = new Creator();
    private final String message;
    private final OnlineCardRechargeOrderDetails onlineCardRechargeOrderDetails;
    private final ad1 responseType;

    /* compiled from: OnlineCardRechargeOrderCreationEvent.kt */
    public static final class Creator implements Parcelable.Creator<OnlineCardRechargeOrderCreationEvent> {
        @Override // android.os.Parcelable.Creator
        public final OnlineCardRechargeOrderCreationEvent createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new OnlineCardRechargeOrderCreationEvent(ad1.valueOf(parcel.readString()), parcel.readString(), parcel.readInt() == 0 ? null : OnlineCardRechargeOrderDetails.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final OnlineCardRechargeOrderCreationEvent[] newArray(int i) {
            return new OnlineCardRechargeOrderCreationEvent[i];
        }
    }

    public OnlineCardRechargeOrderCreationEvent(ad1 ad1, String str, OnlineCardRechargeOrderDetails onlineCardRechargeOrderDetails2) {
        n86.e(ad1, "responseType");
        n86.e(str, "message");
        this.responseType = ad1;
        this.message = str;
        this.onlineCardRechargeOrderDetails = onlineCardRechargeOrderDetails2;
    }

    public static /* synthetic */ OnlineCardRechargeOrderCreationEvent copy$default(OnlineCardRechargeOrderCreationEvent onlineCardRechargeOrderCreationEvent, ad1 ad1, String str, OnlineCardRechargeOrderDetails onlineCardRechargeOrderDetails2, int i, Object obj) {
        if ((i & 1) != 0) {
            ad1 = onlineCardRechargeOrderCreationEvent.responseType;
        }
        if ((i & 2) != 0) {
            str = onlineCardRechargeOrderCreationEvent.message;
        }
        if ((i & 4) != 0) {
            onlineCardRechargeOrderDetails2 = onlineCardRechargeOrderCreationEvent.onlineCardRechargeOrderDetails;
        }
        return onlineCardRechargeOrderCreationEvent.copy(ad1, str, onlineCardRechargeOrderDetails2);
    }

    public final ad1 component1() {
        return this.responseType;
    }

    public final String component2() {
        return this.message;
    }

    public final OnlineCardRechargeOrderDetails component3() {
        return this.onlineCardRechargeOrderDetails;
    }

    public final OnlineCardRechargeOrderCreationEvent copy(ad1 ad1, String str, OnlineCardRechargeOrderDetails onlineCardRechargeOrderDetails2) {
        n86.e(ad1, "responseType");
        n86.e(str, "message");
        return new OnlineCardRechargeOrderCreationEvent(ad1, str, onlineCardRechargeOrderDetails2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnlineCardRechargeOrderCreationEvent)) {
            return false;
        }
        OnlineCardRechargeOrderCreationEvent onlineCardRechargeOrderCreationEvent = (OnlineCardRechargeOrderCreationEvent) obj;
        return this.responseType == onlineCardRechargeOrderCreationEvent.responseType && n86.a(this.message, onlineCardRechargeOrderCreationEvent.message) && n86.a(this.onlineCardRechargeOrderDetails, onlineCardRechargeOrderCreationEvent.onlineCardRechargeOrderDetails);
    }

    public final String getMessage() {
        return this.message;
    }

    public final OnlineCardRechargeOrderDetails getOnlineCardRechargeOrderDetails() {
        return this.onlineCardRechargeOrderDetails;
    }

    public final ad1 getResponseType() {
        return this.responseType;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.message, this.responseType.hashCode() * 31, 31);
        OnlineCardRechargeOrderDetails onlineCardRechargeOrderDetails2 = this.onlineCardRechargeOrderDetails;
        return r0 + (onlineCardRechargeOrderDetails2 == null ? 0 : onlineCardRechargeOrderDetails2.hashCode());
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("OnlineCardRechargeOrderCreationEvent(responseType=");
        i0.append(this.responseType);
        i0.append(", message=");
        i0.append(this.message);
        i0.append(", onlineCardRechargeOrderDetails=");
        i0.append(this.onlineCardRechargeOrderDetails);
        i0.append(')');
        return i0.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.responseType.name());
        parcel.writeString(this.message);
        OnlineCardRechargeOrderDetails onlineCardRechargeOrderDetails2 = this.onlineCardRechargeOrderDetails;
        if (onlineCardRechargeOrderDetails2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        onlineCardRechargeOrderDetails2.writeToParcel(parcel, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OnlineCardRechargeOrderCreationEvent(ad1 ad1, String str, OnlineCardRechargeOrderDetails onlineCardRechargeOrderDetails2, int i, j86 j86) {
        this(ad1, (i & 2) != 0 ? new String() : str, onlineCardRechargeOrderDetails2);
    }
}

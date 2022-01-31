package app.zophop.pubsub.eventbus.events;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.mTicketing.superPass.SuperPassOrderDetails;

/* compiled from: SuperPassOrderCreationEvent.kt */
public final class SuperPassOrderCreationEvent implements Parcelable {
    public static final Parcelable.Creator<SuperPassOrderCreationEvent> CREATOR = new Creator();
    private final String message;
    private final ad1 responseType;
    private final SuperPassOrderDetails superPassOrderDetails;

    /* compiled from: SuperPassOrderCreationEvent.kt */
    public static final class Creator implements Parcelable.Creator<SuperPassOrderCreationEvent> {
        @Override // android.os.Parcelable.Creator
        public final SuperPassOrderCreationEvent createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new SuperPassOrderCreationEvent(ad1.valueOf(parcel.readString()), parcel.readString(), parcel.readInt() == 0 ? null : SuperPassOrderDetails.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final SuperPassOrderCreationEvent[] newArray(int i) {
            return new SuperPassOrderCreationEvent[i];
        }
    }

    public SuperPassOrderCreationEvent(ad1 ad1, String str, SuperPassOrderDetails superPassOrderDetails2) {
        n86.e(ad1, "responseType");
        n86.e(str, "message");
        this.responseType = ad1;
        this.message = str;
        this.superPassOrderDetails = superPassOrderDetails2;
    }

    public static /* synthetic */ SuperPassOrderCreationEvent copy$default(SuperPassOrderCreationEvent superPassOrderCreationEvent, ad1 ad1, String str, SuperPassOrderDetails superPassOrderDetails2, int i, Object obj) {
        if ((i & 1) != 0) {
            ad1 = superPassOrderCreationEvent.responseType;
        }
        if ((i & 2) != 0) {
            str = superPassOrderCreationEvent.message;
        }
        if ((i & 4) != 0) {
            superPassOrderDetails2 = superPassOrderCreationEvent.superPassOrderDetails;
        }
        return superPassOrderCreationEvent.copy(ad1, str, superPassOrderDetails2);
    }

    public final ad1 component1() {
        return this.responseType;
    }

    public final String component2() {
        return this.message;
    }

    public final SuperPassOrderDetails component3() {
        return this.superPassOrderDetails;
    }

    public final SuperPassOrderCreationEvent copy(ad1 ad1, String str, SuperPassOrderDetails superPassOrderDetails2) {
        n86.e(ad1, "responseType");
        n86.e(str, "message");
        return new SuperPassOrderCreationEvent(ad1, str, superPassOrderDetails2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperPassOrderCreationEvent)) {
            return false;
        }
        SuperPassOrderCreationEvent superPassOrderCreationEvent = (SuperPassOrderCreationEvent) obj;
        return this.responseType == superPassOrderCreationEvent.responseType && n86.a(this.message, superPassOrderCreationEvent.message) && n86.a(this.superPassOrderDetails, superPassOrderCreationEvent.superPassOrderDetails);
    }

    public final String getMessage() {
        return this.message;
    }

    public final ad1 getResponseType() {
        return this.responseType;
    }

    public final SuperPassOrderDetails getSuperPassOrderDetails() {
        return this.superPassOrderDetails;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.message, this.responseType.hashCode() * 31, 31);
        SuperPassOrderDetails superPassOrderDetails2 = this.superPassOrderDetails;
        return r0 + (superPassOrderDetails2 == null ? 0 : superPassOrderDetails2.hashCode());
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SuperPassOrderCreationEvent(responseType=");
        i0.append(this.responseType);
        i0.append(", message=");
        i0.append(this.message);
        i0.append(", superPassOrderDetails=");
        i0.append(this.superPassOrderDetails);
        i0.append(')');
        return i0.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.responseType.name());
        parcel.writeString(this.message);
        SuperPassOrderDetails superPassOrderDetails2 = this.superPassOrderDetails;
        if (superPassOrderDetails2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        superPassOrderDetails2.writeToParcel(parcel, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuperPassOrderCreationEvent(ad1 ad1, String str, SuperPassOrderDetails superPassOrderDetails2, int i, j86 j86) {
        this(ad1, (i & 2) != 0 ? new String() : str, superPassOrderDetails2);
    }
}

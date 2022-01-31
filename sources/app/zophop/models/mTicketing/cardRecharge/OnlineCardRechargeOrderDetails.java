package app.zophop.models.mTicketing.cardRecharge;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.CardDetails;
import app.zophop.models.RecentPaymentMethod;
import app.zophop.pubsub.eventbus.events.RazorPayOrderData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OnlineCardRechargeOrderDetails.kt */
public final class OnlineCardRechargeOrderDetails implements Parcelable {
    public static final Parcelable.Creator<OnlineCardRechargeOrderDetails> CREATOR = new Creator();
    private final long bookingTime;
    private final List<CardDetails> cardDetailsList;
    private final boolean isLPEligible;
    private final String lPEligibilityResponseId;
    private final String razorPayCustomerId;
    private final RazorPayOrderData razorPayOrderData;
    private final List<RecentPaymentMethod> recentPaymentMethodsList;
    private final String referenceId;
    private final String transactionId;

    /* compiled from: OnlineCardRechargeOrderDetails.kt */
    public static final class Creator implements Parcelable.Creator<OnlineCardRechargeOrderDetails> {
        @Override // android.os.Parcelable.Creator
        public final OnlineCardRechargeOrderDetails createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(parcel.readParcelable(OnlineCardRechargeOrderDetails.class.getClassLoader()));
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            for (int i2 = 0; i2 != readInt2; i2++) {
                arrayList2.add(parcel.readParcelable(OnlineCardRechargeOrderDetails.class.getClassLoader()));
            }
            return new OnlineCardRechargeOrderDetails(arrayList, arrayList2, parcel.readString(), parcel.readString(), parcel.readString(), (RazorPayOrderData) parcel.readParcelable(OnlineCardRechargeOrderDetails.class.getClassLoader()), parcel.readInt() != 0, parcel.readString(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final OnlineCardRechargeOrderDetails[] newArray(int i) {
            return new OnlineCardRechargeOrderDetails[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends app.zophop.models.CardDetails> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends app.zophop.models.RecentPaymentMethod> */
    /* JADX WARN: Multi-variable type inference failed */
    public OnlineCardRechargeOrderDetails(List<? extends CardDetails> list, List<? extends RecentPaymentMethod> list2, String str, String str2, String str3, RazorPayOrderData razorPayOrderData2, boolean z, String str4, long j) {
        n86.e(list, "cardDetailsList");
        n86.e(list2, "recentPaymentMethodsList");
        n86.e(str3, "transactionId");
        n86.e(razorPayOrderData2, "razorPayOrderData");
        this.cardDetailsList = list;
        this.recentPaymentMethodsList = list2;
        this.razorPayCustomerId = str;
        this.referenceId = str2;
        this.transactionId = str3;
        this.razorPayOrderData = razorPayOrderData2;
        this.isLPEligible = z;
        this.lPEligibilityResponseId = str4;
        this.bookingTime = j;
    }

    public static /* synthetic */ OnlineCardRechargeOrderDetails copy$default(OnlineCardRechargeOrderDetails onlineCardRechargeOrderDetails, List list, List list2, String str, String str2, String str3, RazorPayOrderData razorPayOrderData2, boolean z, String str4, long j, int i, Object obj) {
        return onlineCardRechargeOrderDetails.copy((i & 1) != 0 ? onlineCardRechargeOrderDetails.cardDetailsList : list, (i & 2) != 0 ? onlineCardRechargeOrderDetails.recentPaymentMethodsList : list2, (i & 4) != 0 ? onlineCardRechargeOrderDetails.razorPayCustomerId : str, (i & 8) != 0 ? onlineCardRechargeOrderDetails.referenceId : str2, (i & 16) != 0 ? onlineCardRechargeOrderDetails.transactionId : str3, (i & 32) != 0 ? onlineCardRechargeOrderDetails.razorPayOrderData : razorPayOrderData2, (i & 64) != 0 ? onlineCardRechargeOrderDetails.isLPEligible : z, (i & 128) != 0 ? onlineCardRechargeOrderDetails.lPEligibilityResponseId : str4, (i & 256) != 0 ? onlineCardRechargeOrderDetails.bookingTime : j);
    }

    public final List<CardDetails> component1() {
        return this.cardDetailsList;
    }

    public final List<RecentPaymentMethod> component2() {
        return this.recentPaymentMethodsList;
    }

    public final String component3() {
        return this.razorPayCustomerId;
    }

    public final String component4() {
        return this.referenceId;
    }

    public final String component5() {
        return this.transactionId;
    }

    public final RazorPayOrderData component6() {
        return this.razorPayOrderData;
    }

    public final boolean component7() {
        return this.isLPEligible;
    }

    public final String component8() {
        return this.lPEligibilityResponseId;
    }

    public final long component9() {
        return this.bookingTime;
    }

    public final OnlineCardRechargeOrderDetails copy(List<? extends CardDetails> list, List<? extends RecentPaymentMethod> list2, String str, String str2, String str3, RazorPayOrderData razorPayOrderData2, boolean z, String str4, long j) {
        n86.e(list, "cardDetailsList");
        n86.e(list2, "recentPaymentMethodsList");
        n86.e(str3, "transactionId");
        n86.e(razorPayOrderData2, "razorPayOrderData");
        return new OnlineCardRechargeOrderDetails(list, list2, str, str2, str3, razorPayOrderData2, z, str4, j);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnlineCardRechargeOrderDetails)) {
            return false;
        }
        OnlineCardRechargeOrderDetails onlineCardRechargeOrderDetails = (OnlineCardRechargeOrderDetails) obj;
        return n86.a(this.cardDetailsList, onlineCardRechargeOrderDetails.cardDetailsList) && n86.a(this.recentPaymentMethodsList, onlineCardRechargeOrderDetails.recentPaymentMethodsList) && n86.a(this.razorPayCustomerId, onlineCardRechargeOrderDetails.razorPayCustomerId) && n86.a(this.referenceId, onlineCardRechargeOrderDetails.referenceId) && n86.a(this.transactionId, onlineCardRechargeOrderDetails.transactionId) && n86.a(this.razorPayOrderData, onlineCardRechargeOrderDetails.razorPayOrderData) && this.isLPEligible == onlineCardRechargeOrderDetails.isLPEligible && n86.a(this.lPEligibilityResponseId, onlineCardRechargeOrderDetails.lPEligibilityResponseId) && this.bookingTime == onlineCardRechargeOrderDetails.bookingTime;
    }

    public final long getBookingTime() {
        return this.bookingTime;
    }

    public final List<CardDetails> getCardDetailsList() {
        return this.cardDetailsList;
    }

    public final String getLPEligibilityResponseId() {
        return this.lPEligibilityResponseId;
    }

    public final String getRazorPayCustomerId() {
        return this.razorPayCustomerId;
    }

    public final RazorPayOrderData getRazorPayOrderData() {
        return this.razorPayOrderData;
    }

    public final List<RecentPaymentMethod> getRecentPaymentMethodsList() {
        return this.recentPaymentMethodsList;
    }

    public final String getReferenceId() {
        return this.referenceId;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public int hashCode() {
        int hashCode = (this.recentPaymentMethodsList.hashCode() + (this.cardDetailsList.hashCode() * 31)) * 31;
        String str = this.razorPayCustomerId;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.referenceId;
        int hashCode3 = (this.razorPayOrderData.hashCode() + hj1.r0(this.transactionId, (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31, 31)) * 31;
        boolean z = this.isLPEligible;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode3 + i2) * 31;
        String str3 = this.lPEligibilityResponseId;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return d.a(this.bookingTime) + ((i5 + i) * 31);
    }

    public final boolean isLPEligible() {
        return this.isLPEligible;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("OnlineCardRechargeOrderDetails(cardDetailsList=");
        i0.append(this.cardDetailsList);
        i0.append(", recentPaymentMethodsList=");
        i0.append(this.recentPaymentMethodsList);
        i0.append(", razorPayCustomerId=");
        i0.append((Object) this.razorPayCustomerId);
        i0.append(", referenceId=");
        i0.append((Object) this.referenceId);
        i0.append(", transactionId=");
        i0.append(this.transactionId);
        i0.append(", razorPayOrderData=");
        i0.append(this.razorPayOrderData);
        i0.append(", isLPEligible=");
        i0.append(this.isLPEligible);
        i0.append(", lPEligibilityResponseId=");
        i0.append((Object) this.lPEligibilityResponseId);
        i0.append(", bookingTime=");
        i0.append(this.bookingTime);
        i0.append(')');
        return i0.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        List<CardDetails> list = this.cardDetailsList;
        parcel.writeInt(list.size());
        for (CardDetails cardDetails : list) {
            parcel.writeParcelable(cardDetails, i);
        }
        List<RecentPaymentMethod> list2 = this.recentPaymentMethodsList;
        parcel.writeInt(list2.size());
        for (RecentPaymentMethod recentPaymentMethod : list2) {
            parcel.writeParcelable(recentPaymentMethod, i);
        }
        parcel.writeString(this.razorPayCustomerId);
        parcel.writeString(this.referenceId);
        parcel.writeString(this.transactionId);
        parcel.writeParcelable(this.razorPayOrderData, i);
        parcel.writeInt(this.isLPEligible ? 1 : 0);
        parcel.writeString(this.lPEligibilityResponseId);
        parcel.writeLong(this.bookingTime);
    }
}

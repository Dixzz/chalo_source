package app.zophop.pubsub.eventbus.events;

import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;

/* compiled from: CashPaymentInfoFetchedEvent.kt */
public final class CashPaymentInfoFetchedEvent {
    private final double amount;
    private final String message;
    private final String referenceId;
    private final ad1 responseType;
    private final String userId;

    public CashPaymentInfoFetchedEvent(String str, String str2, double d, ad1 ad1, String str3) {
        n86.e(str, "userId");
        n86.e(str2, SuperPassJsonKeys.REFERENCE_ID);
        n86.e(ad1, "responseType");
        n86.e(str3, "message");
        this.userId = str;
        this.referenceId = str2;
        this.amount = d;
        this.responseType = ad1;
        this.message = str3;
    }

    public static /* synthetic */ CashPaymentInfoFetchedEvent copy$default(CashPaymentInfoFetchedEvent cashPaymentInfoFetchedEvent, String str, String str2, double d, ad1 ad1, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cashPaymentInfoFetchedEvent.userId;
        }
        if ((i & 2) != 0) {
            str2 = cashPaymentInfoFetchedEvent.referenceId;
        }
        if ((i & 4) != 0) {
            d = cashPaymentInfoFetchedEvent.amount;
        }
        if ((i & 8) != 0) {
            ad1 = cashPaymentInfoFetchedEvent.responseType;
        }
        if ((i & 16) != 0) {
            str3 = cashPaymentInfoFetchedEvent.message;
        }
        return cashPaymentInfoFetchedEvent.copy(str, str2, d, ad1, str3);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.referenceId;
    }

    public final double component3() {
        return this.amount;
    }

    public final ad1 component4() {
        return this.responseType;
    }

    public final String component5() {
        return this.message;
    }

    public final CashPaymentInfoFetchedEvent copy(String str, String str2, double d, ad1 ad1, String str3) {
        n86.e(str, "userId");
        n86.e(str2, SuperPassJsonKeys.REFERENCE_ID);
        n86.e(ad1, "responseType");
        n86.e(str3, "message");
        return new CashPaymentInfoFetchedEvent(str, str2, d, ad1, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CashPaymentInfoFetchedEvent)) {
            return false;
        }
        CashPaymentInfoFetchedEvent cashPaymentInfoFetchedEvent = (CashPaymentInfoFetchedEvent) obj;
        return n86.a(this.userId, cashPaymentInfoFetchedEvent.userId) && n86.a(this.referenceId, cashPaymentInfoFetchedEvent.referenceId) && n86.a(Double.valueOf(this.amount), Double.valueOf(cashPaymentInfoFetchedEvent.amount)) && this.responseType == cashPaymentInfoFetchedEvent.responseType && n86.a(this.message, cashPaymentInfoFetchedEvent.message);
    }

    public final double getAmount() {
        return this.amount;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getReferenceId() {
        return this.referenceId;
    }

    public final ad1 getResponseType() {
        return this.responseType;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.referenceId, this.userId.hashCode() * 31, 31);
        int hashCode = this.responseType.hashCode();
        return this.message.hashCode() + ((hashCode + ((Double.doubleToLongBits(this.amount) + r0) * 31)) * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CashPaymentInfoFetchedEvent(userId=");
        i0.append(this.userId);
        i0.append(", referenceId=");
        i0.append(this.referenceId);
        i0.append(", amount=");
        i0.append(this.amount);
        i0.append(", responseType=");
        i0.append(this.responseType);
        i0.append(", message=");
        return hj1.Z(i0, this.message, ')');
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CashPaymentInfoFetchedEvent(String str, String str2, double d, ad1 ad1, String str3, int i, j86 j86) {
        this((i & 1) != 0 ? new String() : str, (i & 2) != 0 ? new String() : str2, (i & 4) != 0 ? -1.0d : d, ad1, (i & 16) != 0 ? new String() : str3);
    }
}

package app.zophop.pubsub.eventbus.events;

/* compiled from: DigitalTripReceiptHistoryFetchedEvent.kt */
public final class DigitalTripReceiptHistoryFetchedEvent {
    private final String message;
    private final ad1 responseType;

    public DigitalTripReceiptHistoryFetchedEvent(ad1 ad1, String str) {
        n86.e(ad1, "responseType");
        n86.e(str, "message");
        this.responseType = ad1;
        this.message = str;
    }

    public static /* synthetic */ DigitalTripReceiptHistoryFetchedEvent copy$default(DigitalTripReceiptHistoryFetchedEvent digitalTripReceiptHistoryFetchedEvent, ad1 ad1, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            ad1 = digitalTripReceiptHistoryFetchedEvent.responseType;
        }
        if ((i & 2) != 0) {
            str = digitalTripReceiptHistoryFetchedEvent.message;
        }
        return digitalTripReceiptHistoryFetchedEvent.copy(ad1, str);
    }

    public final ad1 component1() {
        return this.responseType;
    }

    public final String component2() {
        return this.message;
    }

    public final DigitalTripReceiptHistoryFetchedEvent copy(ad1 ad1, String str) {
        n86.e(ad1, "responseType");
        n86.e(str, "message");
        return new DigitalTripReceiptHistoryFetchedEvent(ad1, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DigitalTripReceiptHistoryFetchedEvent)) {
            return false;
        }
        DigitalTripReceiptHistoryFetchedEvent digitalTripReceiptHistoryFetchedEvent = (DigitalTripReceiptHistoryFetchedEvent) obj;
        return this.responseType == digitalTripReceiptHistoryFetchedEvent.responseType && n86.a(this.message, digitalTripReceiptHistoryFetchedEvent.message);
    }

    public final String getMessage() {
        return this.message;
    }

    public final ad1 getResponseType() {
        return this.responseType;
    }

    public int hashCode() {
        return this.message.hashCode() + (this.responseType.hashCode() * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("DigitalTripReceiptHistoryFetchedEvent(responseType=");
        i0.append(this.responseType);
        i0.append(", message=");
        return hj1.Z(i0, this.message, ')');
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DigitalTripReceiptHistoryFetchedEvent(ad1 ad1, String str, int i, j86 j86) {
        this(ad1, (i & 2) != 0 ? "" : str);
    }
}

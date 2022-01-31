package app.zophop.pubsub.eventbus.events;

/* compiled from: SuperPassApplicationSubmissionEvent.kt */
public final class SuperPassApplicationSubmissionEvent {
    private final String message;
    private final ad1 responseType;

    public SuperPassApplicationSubmissionEvent(ad1 ad1, String str) {
        n86.e(ad1, "responseType");
        n86.e(str, "message");
        this.responseType = ad1;
        this.message = str;
    }

    public static /* synthetic */ SuperPassApplicationSubmissionEvent copy$default(SuperPassApplicationSubmissionEvent superPassApplicationSubmissionEvent, ad1 ad1, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            ad1 = superPassApplicationSubmissionEvent.responseType;
        }
        if ((i & 2) != 0) {
            str = superPassApplicationSubmissionEvent.message;
        }
        return superPassApplicationSubmissionEvent.copy(ad1, str);
    }

    public final ad1 component1() {
        return this.responseType;
    }

    public final String component2() {
        return this.message;
    }

    public final SuperPassApplicationSubmissionEvent copy(ad1 ad1, String str) {
        n86.e(ad1, "responseType");
        n86.e(str, "message");
        return new SuperPassApplicationSubmissionEvent(ad1, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperPassApplicationSubmissionEvent)) {
            return false;
        }
        SuperPassApplicationSubmissionEvent superPassApplicationSubmissionEvent = (SuperPassApplicationSubmissionEvent) obj;
        return this.responseType == superPassApplicationSubmissionEvent.responseType && n86.a(this.message, superPassApplicationSubmissionEvent.message);
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
        StringBuilder i0 = hj1.i0("SuperPassApplicationSubmissionEvent(responseType=");
        i0.append(this.responseType);
        i0.append(", message=");
        return hj1.Z(i0, this.message, ')');
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuperPassApplicationSubmissionEvent(ad1 ad1, String str, int i, j86 j86) {
        this(ad1, (i & 2) != 0 ? new String() : str);
    }
}

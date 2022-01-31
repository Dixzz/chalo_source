package app.zophop.pubsub.eventbus.events;

/* compiled from: CardValidityCheckEvent.kt */
public final class CardValidityCheckEvent {
    public static final Companion Companion = new Companion(null);
    private static final String GENERIC_ERROR_MESSAGE = "Something went wrong";
    public static final String VALIDITY_CHECK_ERROR = "ERROR";
    public static final String VALIDITY_STATUS_INVALID = "INVALID";
    public static final String VALIDITY_STATUS_VALID = "VALID";
    private final String message;
    private final long rechargeLimit;
    private final String requestId;
    private final String status;

    /* compiled from: CardValidityCheckEvent.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j86 j86) {
            this();
        }
    }

    public CardValidityCheckEvent(String str, String str2, String str3, long j) {
        n86.e(str, "requestId");
        n86.e(str2, "status");
        n86.e(str3, "message");
        this.requestId = str;
        this.status = str2;
        this.rechargeLimit = j;
        this.message = str3;
    }

    public final String getMessage() {
        if (this.message.length() == 0) {
            return GENERIC_ERROR_MESSAGE;
        }
        return this.message;
    }

    public final long getRechargeLimit() {
        return this.rechargeLimit;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardValidityCheckEvent(String str, String str2, String str3, long j, int i, j86 j86) {
        this(str, str2, str3, (i & 8) != 0 ? -1 : j);
    }
}

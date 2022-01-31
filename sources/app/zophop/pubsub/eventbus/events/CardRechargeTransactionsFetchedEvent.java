package app.zophop.pubsub.eventbus.events;

import app.zophop.models.mTicketing.ProductConfigurationMap;
import org.json.JSONArray;

/* compiled from: CardRechargeTransactionsFetchedEvent.kt */
public final class CardRechargeTransactionsFetchedEvent {
    public static final Companion Companion = new Companion(null);
    private static final String GENERIC_ERROR_MESSAGE = "Something went wrong";
    private final ProductConfigurationMap configurationsMap;
    private final String message;
    private final String requestId;
    private final ad1 responseType;
    private final JSONArray transactionsArray;

    /* compiled from: CardRechargeTransactionsFetchedEvent.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j86 j86) {
            this();
        }
    }

    public CardRechargeTransactionsFetchedEvent(String str, ad1 ad1, String str2, ProductConfigurationMap productConfigurationMap, JSONArray jSONArray) {
        n86.e(str, "requestId");
        n86.e(ad1, "responseType");
        n86.e(str2, "message");
        this.requestId = str;
        this.responseType = ad1;
        this.configurationsMap = productConfigurationMap;
        this.transactionsArray = jSONArray;
        this.message = str2;
    }

    public final ProductConfigurationMap getConfigurationsMap() {
        return this.configurationsMap;
    }

    public final String getMessage() {
        if (this.message.length() == 0) {
            return GENERIC_ERROR_MESSAGE;
        }
        return this.message;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final ad1 getResponseType() {
        return this.responseType;
    }

    public final JSONArray getTransactionsArray() {
        return this.transactionsArray;
    }
}

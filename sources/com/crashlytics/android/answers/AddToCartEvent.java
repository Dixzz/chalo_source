package com.crashlytics.android.answers;

import java.math.BigDecimal;
import java.util.Currency;

public class AddToCartEvent extends PredefinedEvent<AddToCartEvent> {
    public static final String CURRENCY_ATTRIBUTE = "currency";
    public static final String ITEM_ID_ATTRIBUTE = "itemId";
    public static final String ITEM_NAME_ATTRIBUTE = "itemName";
    public static final String ITEM_PRICE_ATTRIBUTE = "itemPrice";
    public static final String ITEM_TYPE_ATTRIBUTE = "itemType";
    public static final BigDecimal MICRO_CONSTANT = BigDecimal.valueOf(1000000L);
    public static final String TYPE = "addToCart";

    @Override // com.crashlytics.android.answers.PredefinedEvent
    public String getPredefinedType() {
        return TYPE;
    }

    public long priceToMicros(BigDecimal bigDecimal) {
        return MICRO_CONSTANT.multiply(bigDecimal).longValue();
    }

    public AddToCartEvent putCurrency(Currency currency) {
        if (!this.validator.isNull(currency, "currency")) {
            this.predefinedAttributes.put("currency", currency.getCurrencyCode());
        }
        return this;
    }

    public AddToCartEvent putItemId(String str) {
        this.predefinedAttributes.put("itemId", str);
        return this;
    }

    public AddToCartEvent putItemName(String str) {
        this.predefinedAttributes.put("itemName", str);
        return this;
    }

    public AddToCartEvent putItemPrice(BigDecimal bigDecimal) {
        if (!this.validator.isNull(bigDecimal, "itemPrice")) {
            this.predefinedAttributes.put("itemPrice", Long.valueOf(priceToMicros(bigDecimal)));
        }
        return this;
    }

    public AddToCartEvent putItemType(String str) {
        this.predefinedAttributes.put("itemType", str);
        return this;
    }
}

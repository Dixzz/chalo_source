package app.zophop.models.mTicketing;

import app.zophop.models.mTicketing.superPass.SuperPassPaymentConstants;

public enum PaymentMode {
    ONLINE("online"),
    CASH(SuperPassPaymentConstants.PAYMENT_MODE_CASH);
    
    private final String _value;

    private PaymentMode(String str) {
        this._value = str;
    }

    public static PaymentMode getPaymentModeFromString(String str) {
        if (str == null) {
            return ONLINE;
        }
        PaymentMode[] values = values();
        for (int i = 0; i < 2; i++) {
            PaymentMode paymentMode = values[i];
            if (paymentMode.toString().equals(str)) {
                return paymentMode;
            }
        }
        return ONLINE;
    }

    public String toString() {
        return this._value;
    }
}

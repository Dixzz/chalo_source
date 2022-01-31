package com.razorpay;

import java.util.Map;

public interface ValidationListener {
    void onValidationError(Map<String, String> map);

    void onValidationSuccess();
}

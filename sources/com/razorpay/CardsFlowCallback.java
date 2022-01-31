package com.razorpay;

public interface CardsFlowCallback {
    void isNativeOtpEnabled(boolean z);

    void onOtpSubmitError(boolean z);

    void otpGenerateResponse(boolean z);

    void otpResendResponse(boolean z);
}

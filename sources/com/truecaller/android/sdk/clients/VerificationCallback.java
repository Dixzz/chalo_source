package com.truecaller.android.sdk.clients;

import com.truecaller.android.sdk.TrueException;

public interface VerificationCallback {
    public static final int TYPE_MISSED_CALL_INITIATED = 3;
    public static final int TYPE_MISSED_CALL_RECEIVED = 4;
    public static final int TYPE_OTP_INITIATED = 1;
    public static final int TYPE_OTP_RECEIVED = 2;
    public static final int TYPE_PROFILE_VERIFIED_BEFORE = 6;
    public static final int TYPE_VERIFICATION_COMPLETE = 5;

    void onRequestFailure(int i, TrueException trueException);

    void onRequestSuccess(int i, bh5 bh5);
}

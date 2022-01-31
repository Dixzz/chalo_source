package com.truecaller.android.sdk;

import androidx.annotation.Keep;

@Keep
public interface ITrueCallback {
    void onFailureProfileShared(TrueError trueError);

    void onSuccessProfileShared(TrueProfile trueProfile);

    void onVerificationRequired(TrueError trueError);
}

package com.google.firebase.database.android;

import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.core.AuthTokenProvider;

/* compiled from: AndroidAuthTokenProvider */
public final /* synthetic */ class AndroidAuthTokenProvider$1$$Lambda$1 implements vi4 {
    private final AuthTokenProvider.GetTokenCompletionListener arg$1;

    private AndroidAuthTokenProvider$1$$Lambda$1(AuthTokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        this.arg$1 = getTokenCompletionListener;
    }

    public static vi4 lambdaFactory$(AuthTokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        return new AndroidAuthTokenProvider$1$$Lambda$1(getTokenCompletionListener);
    }

    @Override // defpackage.vi4
    public void onSuccess(Object obj) {
        this.arg$1.onSuccess(((GetTokenResult) obj).getToken());
    }
}

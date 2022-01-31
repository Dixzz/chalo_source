package com.google.firebase.database.android;

import com.google.firebase.database.android.AndroidAuthTokenProvider;
import com.google.firebase.database.core.AuthTokenProvider;

/* compiled from: AndroidAuthTokenProvider */
public final /* synthetic */ class AndroidAuthTokenProvider$1$$Lambda$2 implements ui4 {
    private final AuthTokenProvider.GetTokenCompletionListener arg$1;

    private AndroidAuthTokenProvider$1$$Lambda$2(AuthTokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        this.arg$1 = getTokenCompletionListener;
    }

    public static ui4 lambdaFactory$(AuthTokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        return new AndroidAuthTokenProvider$1$$Lambda$2(getTokenCompletionListener);
    }

    @Override // defpackage.ui4
    public void onFailure(Exception exc) {
        AndroidAuthTokenProvider.AnonymousClass1.lambda$getToken$1(this.arg$1, exc);
    }
}

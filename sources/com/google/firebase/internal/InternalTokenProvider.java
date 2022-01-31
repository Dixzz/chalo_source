package com.google.firebase.internal;

import com.google.firebase.auth.GetTokenResult;

/* compiled from: com.google.firebase:firebase-auth-interop@@19.0.0 */
public interface InternalTokenProvider {
    yi4<GetTokenResult> getAccessToken(boolean z);

    String getUid();
}

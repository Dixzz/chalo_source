package com.google.firebase.auth.internal;

import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.internal.InternalTokenProvider;

/* compiled from: com.google.firebase:firebase-auth-interop@@19.0.0 */
public interface InternalAuthProvider extends InternalTokenProvider {
    void addIdTokenListener(IdTokenListener idTokenListener);

    @Override // com.google.firebase.internal.InternalTokenProvider
    yi4<GetTokenResult> getAccessToken(boolean z);

    @Override // com.google.firebase.internal.InternalTokenProvider
    String getUid();

    void removeIdTokenListener(IdTokenListener idTokenListener);
}

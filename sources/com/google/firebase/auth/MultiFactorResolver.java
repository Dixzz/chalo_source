package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class MultiFactorResolver extends AbstractSafeParcelable {
    public abstract FirebaseAuth getFirebaseAuth();

    public abstract List<MultiFactorInfo> getHints();

    public abstract MultiFactorSession getSession();

    public abstract yi4<AuthResult> resolveSignIn(MultiFactorAssertion multiFactorAssertion);
}
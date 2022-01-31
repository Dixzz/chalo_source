package com.google.firebase.auth;

import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class MultiFactor {
    public abstract yi4<Void> enroll(MultiFactorAssertion multiFactorAssertion, String str);

    public abstract List<MultiFactorInfo> getEnrolledFactors();

    public abstract yi4<MultiFactorSession> getSession();

    public abstract yi4<Void> unenroll(MultiFactorInfo multiFactorInfo);

    public abstract yi4<Void> unenroll(String str);
}

package com.google.firebase.auth.internal;

import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.MultiFactorSession;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzab implements qi4<GetTokenResult, yi4<MultiFactorSession>> {
    public zzab(zzac zzac) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [yi4] */
    @Override // defpackage.qi4
    public final /* bridge */ /* synthetic */ yi4<MultiFactorSession> then(yi4<GetTokenResult> yi4) throws Exception {
        return !yi4.q() ? hd3.V0(yi4.l()) : hd3.W0(zzag.zza(yi4.m().getToken()));
    }
}

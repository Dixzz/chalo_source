package com.google.firebase.iid;

import android.util.Pair;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
public final /* synthetic */ class RequestDeduplicator$$Lambda$0 implements qi4 {
    private final RequestDeduplicator arg$1;
    private final Pair arg$2;

    public RequestDeduplicator$$Lambda$0(RequestDeduplicator requestDeduplicator, Pair pair) {
        this.arg$1 = requestDeduplicator;
        this.arg$2 = pair;
    }

    @Override // defpackage.qi4
    public Object then(yi4 yi4) {
        this.arg$1.lambda$getOrStartGetTokenRequest$0$RequestDeduplicator(this.arg$2, yi4);
        return yi4;
    }
}

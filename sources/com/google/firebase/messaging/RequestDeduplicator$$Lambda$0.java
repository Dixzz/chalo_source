package com.google.firebase.messaging;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final /* synthetic */ class RequestDeduplicator$$Lambda$0 implements qi4 {
    private final RequestDeduplicator arg$1;
    private final String arg$2;

    public RequestDeduplicator$$Lambda$0(RequestDeduplicator requestDeduplicator, String str) {
        this.arg$1 = requestDeduplicator;
        this.arg$2 = str;
    }

    @Override // defpackage.qi4
    public Object then(yi4 yi4) {
        this.arg$1.lambda$getOrStartGetTokenRequest$0$RequestDeduplicator(this.arg$2, yi4);
        return yi4;
    }
}

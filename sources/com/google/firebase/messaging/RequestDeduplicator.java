package com.google.firebase.messaging;

import android.util.Log;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public class RequestDeduplicator {
    private final Executor executor;
    @GuardedBy("this")
    private final Map<String, yi4<String>> getTokenRequests = new n2();

    /* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
    public interface GetTokenRequest {
        yi4<String> start();
    }

    public RequestDeduplicator(Executor executor2) {
        this.executor = executor2;
    }

    public synchronized yi4<String> getOrStartGetTokenRequest(String str, GetTokenRequest getTokenRequest) {
        yi4<String> yi4 = this.getTokenRequests.get(str);
        if (yi4 != null) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    "Joining ongoing request for: ".concat(valueOf);
                } else {
                    new String("Joining ongoing request for: ");
                }
            }
            return yi4;
        }
        if (Log.isLoggable(Constants.TAG, 3)) {
            String valueOf2 = String.valueOf(str);
            if (valueOf2.length() != 0) {
                "Making new request for: ".concat(valueOf2);
            } else {
                new String("Making new request for: ");
            }
        }
        yi4<TContinuationResult> k = getTokenRequest.start().k(this.executor, new RequestDeduplicator$$Lambda$0(this, str));
        this.getTokenRequests.put(str, k);
        return k;
    }

    public final /* synthetic */ yi4 lambda$getOrStartGetTokenRequest$0$RequestDeduplicator(String str, yi4 yi4) throws Exception {
        synchronized (this) {
            this.getTokenRequests.remove(str);
        }
        return yi4;
    }
}

package com.google.firebase.iid;

import android.util.Log;
import android.util.Pair;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
public class RequestDeduplicator {
    private final Executor executor;
    @GuardedBy("this")
    private final Map<Pair<String, String>, yi4<InstanceIdResult>> getTokenRequests = new n2();

    /* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
    public interface GetTokenRequest {
        yi4<InstanceIdResult> start();
    }

    public RequestDeduplicator(Executor executor2) {
        this.executor = executor2;
    }

    public synchronized yi4<InstanceIdResult> getOrStartGetTokenRequest(String str, String str2, GetTokenRequest getTokenRequest) {
        Pair<String, String> pair = new Pair<>(str, str2);
        yi4<InstanceIdResult> yi4 = this.getTokenRequests.get(pair);
        if (yi4 != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String.valueOf(pair).length();
            }
            return yi4;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String.valueOf(pair).length();
        }
        yi4<TContinuationResult> k = getTokenRequest.start().k(this.executor, new RequestDeduplicator$$Lambda$0(this, pair));
        this.getTokenRequests.put(pair, k);
        return k;
    }

    public final /* synthetic */ yi4 lambda$getOrStartGetTokenRequest$0$RequestDeduplicator(Pair pair, yi4 yi4) throws Exception {
        synchronized (this) {
            this.getTokenRequests.remove(pair);
        }
        return yi4;
    }
}

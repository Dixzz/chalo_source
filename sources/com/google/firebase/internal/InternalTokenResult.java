package com.google.firebase.internal;

import com.razorpay.AnalyticsConstants;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth-interop@@19.0.0 */
public class InternalTokenResult {
    private String zza;

    public InternalTokenResult(String str) {
        this.zza = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InternalTokenResult)) {
            return false;
        }
        return gj1.G(this.zza, ((InternalTokenResult) obj).zza);
    }

    public String getToken() {
        return this.zza;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public String toString() {
        g82 g82 = new g82(this);
        g82.a(AnalyticsConstants.TOKEN, this.zza);
        return g82.toString();
    }
}

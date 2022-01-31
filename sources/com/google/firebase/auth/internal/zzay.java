package com.google.firebase.auth.internal;

import com.google.firebase.auth.GetTokenResult;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzay {
    private static final wa2 zza = new wa2("GetTokenResultFactory", new String[0]);

    public static GetTokenResult zza(String str) {
        Map map;
        try {
            map = zzaz.zza(str);
        } catch (xx2 unused) {
            zza.b("Error parsing token claims", new Object[0]);
            map = new HashMap();
        }
        return new GetTokenResult(str, map);
    }
}

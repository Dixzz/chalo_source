package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: sn2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public enum sn2 {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(g93.g),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzj;

    private sn2(Object obj) {
        this.zzj = obj;
    }
}

package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: bl3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public enum bl3 {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(xg3.g),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzlq;

    private bl3(Object obj) {
        this.zzlq = obj;
    }
}

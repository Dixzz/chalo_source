package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: wj2  reason: default package */
public enum wj2 {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(uf2.g),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzlj;

    private wj2(Object obj) {
        this.zzlj = obj;
    }
}

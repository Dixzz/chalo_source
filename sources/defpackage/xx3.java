package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: xx3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public enum xx3 {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(qt3.g),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzj;

    private xx3(Object obj) {
        this.zzj = obj;
    }
}

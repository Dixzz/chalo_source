package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX WARN: Init of enum zzb can be incorrect */
/* JADX WARN: Init of enum zzi can be incorrect */
/* renamed from: na3  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public enum na3 {
    VOID(Void.class, Void.class, null),
    INT(r1, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(g93.class, g93.class, g93.g),
    ENUM(r1, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzk;
    private final Class<?> zzl;
    private final Object zzm;

    /* access modifiers changed from: public */
    static {
        Class cls = Integer.TYPE;
    }

    private na3(Class cls, Class cls2, Object obj) {
        this.zzk = cls;
        this.zzl = cls2;
        this.zzm = obj;
    }

    public final Class<?> zza() {
        return this.zzl;
    }
}

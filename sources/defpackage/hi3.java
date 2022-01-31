package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX WARN: Init of enum zzlf can be incorrect */
/* JADX WARN: Init of enum zzlm can be incorrect */
/* renamed from: hi3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public enum hi3 {
    VOID(Void.class, Void.class, null),
    INT(r1, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(xg3.class, xg3.class, xg3.g),
    ENUM(r1, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzlo;
    private final Class<?> zzlp;
    private final Object zzlq;

    /* access modifiers changed from: public */
    static {
        Class cls = Integer.TYPE;
    }

    private hi3(Class cls, Class cls2, Object obj) {
        this.zzlo = cls;
        this.zzlp = cls2;
        this.zzlq = obj;
    }

    public final Class<?> zzcb() {
        return this.zzlp;
    }
}

package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX WARN: Init of enum zzky can be incorrect */
/* JADX WARN: Init of enum zzlf can be incorrect */
/* renamed from: ch2  reason: default package */
public enum ch2 {
    VOID(Void.class, Void.class, null),
    INT(r1, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(uf2.class, uf2.class, uf2.g),
    ENUM(r1, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzlh;
    private final Class<?> zzli;
    private final Object zzlj;

    /* access modifiers changed from: public */
    static {
        Class cls = Integer.TYPE;
    }

    private ch2(Class cls, Class cls2, Object obj) {
        this.zzlh = cls;
        this.zzli = cls2;
        this.zzlj = obj;
    }

    public final Class<?> zzbq() {
        return this.zzli;
    }
}

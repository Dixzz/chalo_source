package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX WARN: Init of enum zzb can be incorrect */
/* JADX WARN: Init of enum zzi can be incorrect */
/* renamed from: ev3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public enum ev3 {
    VOID(Void.class, Void.class, null),
    INT(r1, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(qt3.class, qt3.class, qt3.g),
    ENUM(r1, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzk;
    private final Class<?> zzl;
    private final Object zzm;

    /* access modifiers changed from: public */
    static {
        Class cls = Integer.TYPE;
    }

    private ev3(Class cls, Class cls2, Object obj) {
        this.zzk = cls;
        this.zzl = cls2;
        this.zzm = obj;
    }

    public final Class<?> zza() {
        return this.zzl;
    }
}

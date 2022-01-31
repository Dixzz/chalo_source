package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: ge  reason: default package */
/* compiled from: WireFormat */
public enum ge {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(ub.g),
    ENUM(null),
    MESSAGE(null);
    
    private final Object defaultDefault;

    private ge(Object obj) {
        this.defaultDefault = obj;
    }

    public Object getDefaultDefault() {
        return this.defaultDefault;
    }
}

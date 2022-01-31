package defpackage;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import java.util.Map;

/* renamed from: ua3  reason: default package */
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class ua3 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, ObjectEncoder<?>> f3482a;
    public final Map<Class<?>, ValueEncoder<?>> b;
    public final ObjectEncoder<Object> c;

    public ua3(Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        this.f3482a = map;
        this.b = map2;
        this.c = objectEncoder;
    }
}

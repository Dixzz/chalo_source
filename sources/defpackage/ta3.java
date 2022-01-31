package defpackage;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.EncoderConfig;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ta3  reason: default package */
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class ta3 implements EncoderConfig<ta3> {
    public static final ObjectEncoder<Object> d = sa3.f3202a;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, ObjectEncoder<?>> f3326a = new HashMap();
    public final Map<Class<?>, ValueEncoder<?>> b = new HashMap();
    public final ObjectEncoder<Object> c = sa3.f3202a;

    /* Return type fixed from 'com.google.firebase.encoders.config.EncoderConfig' to match base method */
    @Override // com.google.firebase.encoders.config.EncoderConfig
    public final /* bridge */ /* synthetic */ ta3 registerEncoder(Class cls, ObjectEncoder objectEncoder) {
        this.f3326a.put(cls, objectEncoder);
        this.b.remove(cls);
        return this;
    }

    /* Return type fixed from 'com.google.firebase.encoders.config.EncoderConfig' to match base method */
    @Override // com.google.firebase.encoders.config.EncoderConfig
    public final /* bridge */ /* synthetic */ ta3 registerEncoder(Class cls, ValueEncoder valueEncoder) {
        this.b.put(cls, valueEncoder);
        this.f3326a.remove(cls);
        return this;
    }
}

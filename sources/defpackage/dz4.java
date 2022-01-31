package defpackage;

import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;

/* renamed from: dz4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class dz4 implements ValueEncoder {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ dz4 f907a = new dz4();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ValueEncoderContext valueEncoderContext) {
        int i = JsonDataEncoderBuilder.f659a;
        valueEncoderContext.add(((Boolean) obj).booleanValue());
    }
}

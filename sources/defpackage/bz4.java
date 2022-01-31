package defpackage;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;

/* renamed from: bz4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class bz4 implements ObjectEncoder {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ bz4 f496a = new bz4();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        int i = JsonDataEncoderBuilder.f659a;
        StringBuilder i0 = hj1.i0("Couldn't find encoder for type ");
        i0.append(obj.getClass().getCanonicalName());
        throw new EncodingException(i0.toString());
    }
}

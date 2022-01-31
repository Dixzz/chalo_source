package defpackage;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: sa3  reason: default package */
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final /* synthetic */ class sa3 implements ObjectEncoder {

    /* renamed from: a  reason: collision with root package name */
    public static final ObjectEncoder f3202a = new sa3();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoder<Object> objectEncoder = ta3.d;
        String valueOf = String.valueOf(obj.getClass().getCanonicalName());
        throw new EncodingException(valueOf.length() != 0 ? "Couldn't find encoder for type ".concat(valueOf) : new String("Couldn't find encoder for type "));
    }
}

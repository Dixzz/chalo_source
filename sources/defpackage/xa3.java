package defpackage;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* renamed from: xa3  reason: default package */
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class xa3 implements ObjectEncoder<ya3> {

    /* renamed from: a  reason: collision with root package name */
    public static final xa3 f3909a = new xa3();
    public static final FieldDescriptor b = FieldDescriptor.of("messagingClientEventExtension");

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(b, ((ya3) obj).a());
    }
}

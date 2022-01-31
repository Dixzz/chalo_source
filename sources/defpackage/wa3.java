package defpackage;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.io.IOException;

/* renamed from: wa3  reason: default package */
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class wa3 implements ObjectEncoder<MessagingClientEventExtension> {

    /* renamed from: a  reason: collision with root package name */
    public static final wa3 f3752a = new wa3();
    public static final FieldDescriptor b = FieldDescriptor.builder("messagingClientEvent").withProperty(new kb3(1, nb3.DEFAULT)).build();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(b, ((MessagingClientEventExtension) obj).getMessagingClientEventInternal());
    }
}

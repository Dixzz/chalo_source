package defpackage;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.util.Map;

/* renamed from: qa3  reason: default package */
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final /* synthetic */ class qa3 implements ObjectEncoder {

    /* renamed from: a  reason: collision with root package name */
    public static final ObjectEncoder f2918a = new qa3();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        Map.Entry entry = (Map.Entry) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(ra3.g, entry.getKey());
        objectEncoderContext2.add(ra3.h, entry.getValue());
    }
}

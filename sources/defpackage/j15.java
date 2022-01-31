package defpackage;

import java.io.IOException;

/* renamed from: j15  reason: default package */
/* compiled from: MessageLite */
public interface j15 extends k15 {

    /* renamed from: j15$a */
    /* compiled from: MessageLite */
    public interface a extends k15, Cloneable {
        j15 build();

        j15 buildPartial();

        a mergeFrom(j15 j15);
    }

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    a05 toByteString();

    void writeTo(d05 d05) throws IOException;
}

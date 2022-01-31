package defpackage;

import java.io.IOException;

/* renamed from: dd  reason: default package */
/* compiled from: MessageLite */
public interface dd extends ed {

    /* renamed from: dd$a */
    /* compiled from: MessageLite */
    public interface a extends ed, Cloneable {
    }

    void a(xb xbVar) throws IOException;

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    ub toByteString();
}

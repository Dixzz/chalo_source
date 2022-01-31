package defpackage;

import defpackage.ba3;
import defpackage.ea3;

/* renamed from: ba3  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class ba3<MessageType extends ea3<MessageType, BuilderType>, BuilderType extends ba3<MessageType, BuilderType>> extends r83<MessageType, BuilderType> {
    public final MessageType f;
    public MessageType g;
    public boolean h = false;

    public ba3(MessageType messagetype) {
        this.f = messagetype;
        this.g = (MessageType) ((ea3) messagetype.i(4, null, null));
    }

    public void a() {
        MessageType messagetype = (MessageType) ((ea3) this.g.i(4, null, null));
        im2.c.a(messagetype.getClass()).h(messagetype, this.g);
        this.g = messagetype;
    }

    public MessageType b() {
        if (this.h) {
            return this.g;
        }
        MessageType messagetype = this.g;
        im2.c.a(messagetype.getClass()).d(messagetype);
        this.h = true;
        return this.g;
    }

    public final MessageType c() {
        MessageType b = b();
        if (b.o()) {
            return b;
        }
        throw new ym2();
    }

    @Override // java.lang.Object
    public final Object clone() throws CloneNotSupportedException {
        ba3 ba3 = (ba3) this.f.i(5, null, null);
        ba3.e(b());
        return ba3;
    }

    @Override // defpackage.cm2
    public final /* bridge */ /* synthetic */ bm2 d() {
        return this.f;
    }

    public final BuilderType e(MessageType messagetype) {
        if (this.h) {
            a();
            this.h = false;
        }
        MessageType messagetype2 = this.g;
        im2.c.a(messagetype2.getClass()).h(messagetype2, messagetype);
        return this;
    }
}

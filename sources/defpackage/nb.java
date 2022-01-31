package defpackage;

import defpackage.dd;
import defpackage.nb;
import defpackage.nb.a;
import defpackage.ub;
import defpackage.xb;
import java.io.IOException;
import java.util.logging.Logger;

/* renamed from: nb  reason: default package */
/* compiled from: AbstractMessageLite */
public abstract class nb<MessageType extends nb<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> implements dd {
    public int memoizedHashCode = 0;

    /* renamed from: nb$a */
    /* compiled from: AbstractMessageLite */
    public static abstract class a<MessageType extends nb<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> implements dd.a {
    }

    public int b() {
        throw new UnsupportedOperationException();
    }

    public int c(rd rdVar) {
        int b = b();
        if (b != -1) {
            return b;
        }
        int g = rdVar.g(this);
        d(g);
        return g;
    }

    public void d(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.dd
    public ub toByteString() {
        kc kcVar = (kc) this;
        try {
            int serializedSize = kcVar.getSerializedSize();
            ub ubVar = ub.g;
            byte[] bArr = new byte[serializedSize];
            Logger logger = xb.b;
            xb.c cVar = new xb.c(bArr, 0, serializedSize);
            kcVar.a(cVar);
            if (cVar.b0() == 0) {
                return new ub.e(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            StringBuilder i0 = hj1.i0("Serializing ");
            i0.append(getClass().getName());
            i0.append(" to a ");
            i0.append("ByteString");
            i0.append(" threw an IOException (should never happen).");
            throw new RuntimeException(i0.toString(), e);
        }
    }
}

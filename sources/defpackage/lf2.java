package defpackage;

import defpackage.bg2;
import defpackage.lf2;
import defpackage.mf2;
import java.io.IOException;
import java.util.logging.Logger;

/* renamed from: lf2  reason: default package */
public abstract class lf2<MessageType extends lf2<MessageType, BuilderType>, BuilderType extends mf2<MessageType, BuilderType>> implements zh2 {
    private static boolean zzey = false;
    public int zzex = 0;

    @Override // defpackage.zh2
    public final uf2 a() {
        ug2 ug2 = (ug2) this;
        try {
            int e = ug2.e();
            uf2 uf2 = uf2.g;
            byte[] bArr = new byte[e];
            Logger logger = bg2.b;
            bg2.a aVar = new bg2.a(bArr, 0, e);
            ug2.c(aVar);
            if (aVar.k() == 0) {
                return new yf2(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 62 + 10);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public void g(int i) {
        throw new UnsupportedOperationException();
    }

    public int h() {
        throw new UnsupportedOperationException();
    }
}

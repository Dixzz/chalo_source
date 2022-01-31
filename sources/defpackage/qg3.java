package defpackage;

import defpackage.hh3;
import defpackage.qg3;
import defpackage.sg3;
import java.io.IOException;
import java.util.logging.Logger;

/* renamed from: qg3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public abstract class qg3<MessageType extends qg3<MessageType, BuilderType>, BuilderType extends sg3<MessageType, BuilderType>> implements gj3 {
    public int zzga = 0;

    public final byte[] b() {
        uh3 uh3 = (uh3) this;
        try {
            int r = uh3.r();
            byte[] bArr = new byte[r];
            Logger logger = hh3.b;
            hh3.b bVar = new hh3.b(bArr, r);
            uh3.t(bVar);
            if (bVar.h() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(10 + name.length() + 62);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public int c() {
        throw new UnsupportedOperationException();
    }

    public void d(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.gj3
    public final xg3 q() {
        uh3 uh3 = (uh3) this;
        try {
            int r = uh3.r();
            xg3 xg3 = xg3.g;
            byte[] bArr = new byte[r];
            Logger logger = hh3.b;
            hh3.b bVar = new hh3.b(bArr, r);
            uh3.t(bVar);
            if (bVar.h() == 0) {
                return new eh3(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 62 + 10);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }
}

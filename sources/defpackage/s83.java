package defpackage;

import defpackage.r83;
import defpackage.s83;
import java.io.IOException;
import java.util.logging.Logger;

/* renamed from: s83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class s83<MessageType extends s83<MessageType, BuilderType>, BuilderType extends r83<MessageType, BuilderType>> implements bm2 {
    public int zza = 0;

    public final byte[] a() {
        ea3 ea3 = (ea3) this;
        try {
            int k = ea3.k();
            byte[] bArr = new byte[k];
            Logger logger = n93.b;
            k93 k93 = new k93(bArr, 0, k);
            ea3.p(k93);
            if (k93.p() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            hj1.V0(sb, "Serializing ", name, " to a ", "byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public int b() {
        throw null;
    }

    public void c(int i) {
        throw null;
    }

    @Override // defpackage.bm2
    public final g93 j() {
        ea3 ea3 = (ea3) this;
        try {
            int k = ea3.k();
            g93 g93 = g93.g;
            byte[] bArr = new byte[k];
            Logger logger = n93.b;
            k93 k93 = new k93(bArr, 0, bArr.length);
            ea3.p(k93);
            if (k93.p() == 0) {
                return new e93(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            hj1.V0(sb, "Serializing ", name, " to a ", "ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }
}

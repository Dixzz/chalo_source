package defpackage;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: yo1  reason: default package */
/* compiled from: ByteBufferEncoder */
public class yo1 implements am1<ByteBuffer> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.io.File, fm1] */
    @Override // defpackage.am1
    public boolean a(ByteBuffer byteBuffer, File file, fm1 fm1) {
        try {
            kt1.b(byteBuffer, file);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}

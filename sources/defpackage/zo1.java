package defpackage;

import android.util.Log;
import defpackage.ip1;
import defpackage.km1;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: zo1  reason: default package */
/* compiled from: ByteBufferFileLoader */
public class zo1 implements ip1<File, ByteBuffer> {

    /* renamed from: zo1$a */
    /* compiled from: ByteBufferFileLoader */
    public static class a implements km1<ByteBuffer> {
        public final File f;

        public a(File file) {
            this.f = file;
        }

        @Override // defpackage.km1
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // defpackage.km1
        public void b() {
        }

        @Override // defpackage.km1
        public void cancel() {
        }

        @Override // defpackage.km1
        public xl1 d() {
            return xl1.LOCAL;
        }

        @Override // defpackage.km1
        public void e(kl1 kl1, km1.a<? super ByteBuffer> aVar) {
            try {
                aVar.g(kt1.a(this.f));
            } catch (IOException e) {
                Log.isLoggable("ByteBufferFileLoader", 3);
                aVar.c(e);
            }
        }
    }

    /* renamed from: zo1$b */
    /* compiled from: ByteBufferFileLoader */
    public static class b implements jp1<File, ByteBuffer> {
        @Override // defpackage.jp1
        public ip1<File, ByteBuffer> b(mp1 mp1) {
            return new zo1();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ip1
    public /* bridge */ /* synthetic */ boolean a(File file) {
        return true;
    }

    /* Return type fixed from 'ip1$a' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.ip1
    public ip1.a<ByteBuffer> b(File file, int i, int i2, fm1 fm1) {
        File file2 = file;
        return new ip1.a(new jt1(file2), new a(file2));
    }
}

package defpackage;

import defpackage.ip1;
import defpackage.km1;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: xo1  reason: default package */
/* compiled from: ByteArrayLoader */
public class xo1<Data> implements ip1<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    public final b<Data> f3946a;

    /* renamed from: xo1$a */
    /* compiled from: ByteArrayLoader */
    public static class a implements jp1<byte[], ByteBuffer> {

        /* renamed from: xo1$a$a  reason: collision with other inner class name */
        /* compiled from: ByteArrayLoader */
        public class C0067a implements b<ByteBuffer> {
            public C0067a(a aVar) {
            }

            @Override // defpackage.xo1.b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // defpackage.xo1.b
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // defpackage.jp1
        public ip1<byte[], ByteBuffer> b(mp1 mp1) {
            return new xo1(new C0067a(this));
        }
    }

    /* renamed from: xo1$b */
    /* compiled from: ByteArrayLoader */
    public interface b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    /* renamed from: xo1$c */
    /* compiled from: ByteArrayLoader */
    public static class c<Data> implements km1<Data> {
        public final byte[] f;
        public final b<Data> g;

        public c(byte[] bArr, b<Data> bVar) {
            this.f = bArr;
            this.g = bVar;
        }

        @Override // defpackage.km1
        public Class<Data> a() {
            return this.g.a();
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
        public void e(kl1 kl1, km1.a<? super Data> aVar) {
            aVar.g(this.g.b(this.f));
        }
    }

    /* renamed from: xo1$d */
    /* compiled from: ByteArrayLoader */
    public static class d implements jp1<byte[], InputStream> {

        /* renamed from: xo1$d$a */
        /* compiled from: ByteArrayLoader */
        public class a implements b<InputStream> {
            public a(d dVar) {
            }

            @Override // defpackage.xo1.b
            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // defpackage.xo1.b
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // defpackage.jp1
        public ip1<byte[], InputStream> b(mp1 mp1) {
            return new xo1(new a(this));
        }
    }

    public xo1(b<Data> bVar) {
        this.f3946a = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ip1
    public /* bridge */ /* synthetic */ boolean a(byte[] bArr) {
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.ip1
    public ip1.a b(byte[] bArr, int i, int i2, fm1 fm1) {
        it1 it1 = it1.b;
        return new ip1.a(it1.b, new c(bArr, this.f3946a));
    }
}

package defpackage;

import defpackage.lm1;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: sq1  reason: default package */
/* compiled from: ByteBufferRewinder */
public class sq1 implements lm1<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f3243a;

    /* renamed from: sq1$a */
    /* compiled from: ByteBufferRewinder */
    public static class a implements lm1.a<ByteBuffer> {
        @Override // defpackage.lm1.a
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        /* Return type fixed from 'lm1' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.lm1.a
        public lm1<ByteBuffer> b(ByteBuffer byteBuffer) {
            return new sq1(byteBuffer);
        }
    }

    public sq1(ByteBuffer byteBuffer) {
        this.f3243a = byteBuffer;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.lm1
    public ByteBuffer a() throws IOException {
        this.f3243a.position(0);
        return this.f3243a;
    }

    @Override // defpackage.lm1
    public void b() {
    }
}

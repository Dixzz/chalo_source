package defpackage;

import defpackage.lm1;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: rm1  reason: default package */
/* compiled from: InputStreamRewinder */
public final class rm1 implements lm1<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final oq1 f3097a;

    /* renamed from: rm1$a */
    /* compiled from: InputStreamRewinder */
    public static final class a implements lm1.a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final xn1 f3098a;

        public a(xn1 xn1) {
            this.f3098a = xn1;
        }

        @Override // defpackage.lm1.a
        public Class<InputStream> a() {
            return InputStream.class;
        }

        /* Return type fixed from 'lm1' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.lm1.a
        public lm1<InputStream> b(InputStream inputStream) {
            return new rm1(inputStream, this.f3098a);
        }
    }

    public rm1(InputStream inputStream, xn1 xn1) {
        oq1 oq1 = new oq1(inputStream, xn1);
        this.f3097a = oq1;
        oq1.mark(5242880);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.lm1
    public InputStream a() throws IOException {
        this.f3097a.reset();
        return this.f3097a;
    }

    @Override // defpackage.lm1
    public void b() {
        this.f3097a.c();
    }
}

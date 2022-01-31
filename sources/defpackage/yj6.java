package defpackage;

import defpackage.ci6;
import defpackage.ei6;
import defpackage.ji6;
import defpackage.ni6;
import java.io.IOException;
import java.util.List;

/* renamed from: yj6  reason: default package */
/* compiled from: BridgeInterceptor.kt */
public final class yj6 implements ei6 {

    /* renamed from: a  reason: collision with root package name */
    public final th6 f4060a;

    public yj6(th6 th6) {
        n86.f(th6, "cookieJar");
        this.f4060a = th6;
    }

    @Override // defpackage.ei6
    public ni6 a(ei6.a aVar) throws IOException {
        boolean z;
        oi6 oi6;
        n86.f(aVar, "chain");
        ek6 ek6 = (ek6) aVar;
        ji6 ji6 = ek6.f;
        ji6.a aVar2 = new ji6.a(ji6);
        mi6 mi6 = ji6.e;
        if (mi6 != null) {
            fi6 contentType = mi6.contentType();
            if (contentType != null) {
                aVar2.d("Content-Type", contentType.f1129a);
            }
            long contentLength = mi6.contentLength();
            if (contentLength != -1) {
                aVar2.d("Content-Length", String.valueOf(contentLength));
                aVar2.g("Transfer-Encoding");
            } else {
                aVar2.d("Transfer-Encoding", "chunked");
                aVar2.g("Content-Length");
            }
        }
        int i = 0;
        if (ji6.b("Host") == null) {
            aVar2.d("Host", vi6.x(ji6.b, false));
        }
        if (ji6.b("Connection") == null) {
            aVar2.d("Connection", "Keep-Alive");
        }
        if (ji6.b("Accept-Encoding") == null && ji6.b("Range") == null) {
            aVar2.d("Accept-Encoding", "gzip");
            z = true;
        } else {
            z = false;
        }
        List<rh6> b = this.f4060a.b(ji6.b);
        if (!b.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (T t : b) {
                int i2 = i + 1;
                if (i >= 0) {
                    T t2 = t;
                    if (i > 0) {
                        sb.append("; ");
                    }
                    sb.append(t2.f3082a);
                    sb.append('=');
                    sb.append(t2.b);
                    i = i2;
                } else {
                    y56.w();
                    throw null;
                }
            }
            String sb2 = sb.toString();
            n86.b(sb2, "StringBuilder().apply(builderAction).toString()");
            aVar2.d("Cookie", sb2);
        }
        if (ji6.b("User-Agent") == null) {
            aVar2.d("User-Agent", "okhttp/4.8.0");
        }
        ni6 a2 = ek6.a(aVar2.b());
        ck6.d(this.f4060a, ji6.b, a2.l);
        ni6.a aVar3 = new ni6.a(a2);
        aVar3.g(ji6);
        if (z && ea6.f("gzip", ni6.c(a2, "Content-Encoding", null, 2), true) && ck6.a(a2) && (oi6 = a2.m) != null) {
            en6 en6 = new en6(oi6.source());
            ci6.a e = a2.l.e();
            e.f("Content-Encoding");
            e.f("Content-Length");
            aVar3.d(e.d());
            String c = ni6.c(a2, "Content-Type", null, 2);
            n86.f(en6, "$this$buffer");
            aVar3.g = new fk6(c, -1, new kn6(en6));
        }
        return aVar3.a();
    }
}

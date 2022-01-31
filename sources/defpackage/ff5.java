package defpackage;

import android.net.NetworkInfo;
import android.os.Handler;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.squareup.picasso.Picasso;
import defpackage.ji6;
import defpackage.lf5;
import java.io.IOException;

/* renamed from: ff5  reason: default package */
/* compiled from: NetworkRequestHandler */
public class ff5 extends lf5 {

    /* renamed from: a  reason: collision with root package name */
    public final ue5 f1117a;
    public final nf5 b;

    /* renamed from: ff5$a */
    /* compiled from: NetworkRequestHandler */
    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    /* renamed from: ff5$b */
    /* compiled from: NetworkRequestHandler */
    public static final class b extends IOException {
        public final int f;
        public final int g;

        public b(int i, int i2) {
            super(hj1.I("HTTP ", i));
            this.f = i;
            this.g = i2;
        }
    }

    public ff5(ue5 ue5, nf5 nf5) {
        this.f1117a = ue5;
        this.b = nf5;
    }

    @Override // defpackage.lf5
    public boolean c(jf5 jf5) {
        String scheme = jf5.c.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    @Override // defpackage.lf5
    public int e() {
        return 2;
    }

    @Override // defpackage.lf5
    public lf5.a f(jf5 jf5, int i) throws IOException {
        hh6 hh6;
        if (i != 0) {
            hh6 = ef5.isOfflineOnly(i) ? hh6.n : new hh6(!ef5.shouldReadFromDiskCache(i), !ef5.shouldWriteToDiskCache(i), -1, -1, false, false, false, -1, -1, false, false, false, null, null);
        } else {
            hh6 = null;
        }
        ji6.a aVar = new ji6.a();
        aVar.i(jf5.c.toString());
        if (hh6 != null) {
            aVar.c(hh6);
        }
        ni6 execute = FirebasePerfOkHttpClient.execute(((gf5) this.f1117a).f1254a.a(aVar.b()));
        oi6 oi6 = execute.m;
        if (execute.e()) {
            Picasso.d dVar = execute.o == null ? Picasso.d.NETWORK : Picasso.d.DISK;
            if (dVar == Picasso.d.DISK && oi6.contentLength() == 0) {
                oi6.close();
                throw new a("Received response with 0 content-length header.");
            }
            if (dVar == Picasso.d.NETWORK && oi6.contentLength() > 0) {
                nf5 nf5 = this.b;
                long contentLength = oi6.contentLength();
                Handler handler = nf5.c;
                handler.sendMessage(handler.obtainMessage(4, Long.valueOf(contentLength)));
            }
            return new lf5.a(oi6.source(), dVar);
        }
        oi6.close();
        throw new b(execute.j, 0);
    }

    @Override // defpackage.lf5
    public boolean g(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    @Override // defpackage.lf5
    public boolean h() {
        return true;
    }
}

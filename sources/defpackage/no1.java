package defpackage;

import android.util.Log;
import defpackage.jo1;
import defpackage.lo1;
import defpackage.pl1;
import java.io.File;
import java.io.IOException;

/* renamed from: no1  reason: default package */
/* compiled from: DiskLruCacheWrapper */
public class no1 implements jo1 {
    public static no1 f;

    /* renamed from: a  reason: collision with root package name */
    public final to1 f2579a;
    public final File b;
    public final int c;
    public final lo1 d = new lo1();
    public pl1 e;

    public no1(File file, int i) {
        this.b = file;
        this.c = i;
        this.f2579a = new to1();
    }

    @Override // defpackage.jo1
    public void a(dm1 dm1, jo1.b bVar) {
        lo1.a aVar;
        lo1 lo1 = this.d;
        synchronized (lo1) {
            aVar = lo1.f2246a.get(dm1);
            if (aVar == null) {
                lo1.b bVar2 = lo1.b;
                synchronized (bVar2.f2248a) {
                    aVar = bVar2.f2248a.poll();
                }
                if (aVar == null) {
                    aVar = new lo1.a();
                }
                lo1.f2246a.put(dm1, aVar);
            }
            aVar.b++;
        }
        aVar.f2247a.lock();
        try {
            String a2 = this.f2579a.a(dm1);
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                String str = "Put: Obtained: " + a2 + " for for Key: " + dm1;
            }
            try {
                pl1 c2 = c();
                if (c2.g(a2) == null) {
                    pl1.c f2 = c2.f(a2);
                    if (f2 != null) {
                        try {
                            bn1 bn1 = (bn1) bVar;
                            if (bn1.f453a.a(bn1.b, f2.b(0), bn1.c)) {
                                pl1.a(pl1.this, f2, true);
                                f2.c = true;
                            }
                            if (!f2.c) {
                                f2.a();
                            }
                        } catch (Throwable th) {
                            if (!f2.c) {
                                try {
                                    f2.a();
                                } catch (IOException unused) {
                                }
                            }
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("Had two simultaneous puts for: " + a2);
                    }
                }
            } catch (IOException unused2) {
            }
        } finally {
            this.d.a(dm1);
        }
    }

    @Override // defpackage.jo1
    public File b(dm1 dm1) {
        String a2 = this.f2579a.a(dm1);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            String str = "Get: Obtained: " + a2 + " for for Key: " + dm1;
        }
        try {
            pl1.e g = c().g(a2);
            if (g != null) {
                return g.f2822a[0];
            }
            return null;
        } catch (IOException unused) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
            return null;
        }
    }

    public final synchronized pl1 c() throws IOException {
        if (this.e == null) {
            this.e = pl1.i(this.b, 1, 1, (long) this.c);
        }
        return this.e;
    }
}

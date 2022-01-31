package defpackage;

import defpackage.jo1;
import java.io.File;

/* renamed from: mo1  reason: default package */
/* compiled from: DiskLruCacheFactory */
public class mo1 implements jo1.a {

    /* renamed from: a  reason: collision with root package name */
    public final int f2418a;
    public final a b;

    /* renamed from: mo1$a */
    /* compiled from: DiskLruCacheFactory */
    public interface a {
    }

    public mo1(a aVar, int i) {
        this.f2418a = i;
        this.b = aVar;
    }

    public jo1 a() {
        no1 no1;
        oo1 oo1 = (oo1) this.b;
        File cacheDir = oo1.f2718a.getCacheDir();
        if (cacheDir == null) {
            cacheDir = null;
        } else if (oo1.b != null) {
            cacheDir = new File(cacheDir, oo1.b);
        }
        if (cacheDir == null) {
            return null;
        }
        if (!cacheDir.mkdirs() && (!cacheDir.exists() || !cacheDir.isDirectory())) {
            return null;
        }
        int i = this.f2418a;
        synchronized (no1.class) {
            if (no1.f == null) {
                no1.f = new no1(cacheDir, i);
            }
            no1 = no1.f;
        }
        return no1;
    }
}

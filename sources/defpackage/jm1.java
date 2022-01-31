package defpackage;

import android.content.res.AssetManager;
import android.util.Log;
import defpackage.km1;
import java.io.IOException;

/* renamed from: jm1  reason: default package */
/* compiled from: AssetPathFetcher */
public abstract class jm1<T> implements km1<T> {
    public final String f;
    public final AssetManager g;
    public T h;

    public jm1(AssetManager assetManager, String str) {
        this.g = assetManager;
        this.f = str;
    }

    @Override // defpackage.km1
    public void b() {
        T t = this.h;
        if (t != null) {
            try {
                c(t);
            } catch (IOException unused) {
            }
        }
    }

    public abstract void c(T t) throws IOException;

    @Override // defpackage.km1
    public void cancel() {
    }

    @Override // defpackage.km1
    public xl1 d() {
        return xl1.LOCAL;
    }

    @Override // defpackage.km1
    public void e(kl1 kl1, km1.a<? super T> aVar) {
        try {
            T f2 = f(this.g, this.f);
            this.h = f2;
            aVar.g(f2);
        } catch (IOException e) {
            Log.isLoggable("AssetPathFetcher", 3);
            aVar.c(e);
        }
    }

    public abstract T f(AssetManager assetManager, String str) throws IOException;
}

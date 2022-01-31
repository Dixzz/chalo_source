package defpackage;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import defpackage.km1;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: sm1  reason: default package */
/* compiled from: LocalUriFetcher */
public abstract class sm1<T> implements km1<T> {
    public final Uri f;
    public final ContentResolver g;
    public T h;

    public sm1(ContentResolver contentResolver, Uri uri) {
        this.g = contentResolver;
        this.f = uri;
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
    public final void e(kl1 kl1, km1.a<? super T> aVar) {
        try {
            T f2 = f(this.f, this.g);
            this.h = f2;
            aVar.g(f2);
        } catch (FileNotFoundException e) {
            Log.isLoggable("LocalUriFetcher", 3);
            aVar.c(e);
        }
    }

    public abstract T f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;
}

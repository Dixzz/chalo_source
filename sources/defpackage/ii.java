package defpackage;

import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: ii  reason: default package */
/* compiled from: LoaderManager */
public abstract class ii {

    /* renamed from: ii$a */
    /* compiled from: LoaderManager */
    public interface a<D> {
        li<D> onCreateLoader(int i, Bundle bundle);

        void onLoadFinished(li<D> liVar, D d);

        void onLoaderReset(li<D> liVar);
    }

    public static <T extends fh & hi> ii b(T t) {
        return new ji(t, t.getViewModelStore());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract <D> li<D> c(int i, Bundle bundle, a<D> aVar);

    public abstract <D> li<D> d(int i, Bundle bundle, a<D> aVar);
}

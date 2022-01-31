package defpackage;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: ro  reason: default package */
/* compiled from: PagerAdapter */
public abstract class ro {

    /* renamed from: a  reason: collision with root package name */
    public final DataSetObservable f3106a = new DataSetObservable();
    public DataSetObserver b;

    public void b(ViewGroup viewGroup, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void c(ViewGroup viewGroup) {
    }

    public abstract int d();

    public abstract CharSequence e(int i);

    public Object f(ViewGroup viewGroup, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public abstract boolean g(View view, Object obj);

    public void h(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable i() {
        return null;
    }

    public void j(ViewGroup viewGroup, int i, Object obj) {
    }

    public void k(ViewGroup viewGroup) {
    }
}

package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.navigation.common.R;
import defpackage.ej;
import j$.lang.Iterable;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;

/* renamed from: gj  reason: default package */
/* compiled from: NavGraph */
public class gj extends ej implements Iterable<ej>, Iterable {
    public final v2<ej> n = new v2<>();
    public int o;
    public String p;

    /* renamed from: gj$a */
    /* compiled from: NavGraph */
    public class a implements Iterator<ej>, j$.util.Iterator {
        public int f = -1;
        public boolean g = false;

        public a() {
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            return this.f + 1 < gj.this.n.h();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // j$.util.Iterator, java.util.Iterator
        public ej next() {
            if (hasNext()) {
                this.g = true;
                v2<ej> v2Var = gj.this.n;
                int i = this.f + 1;
                this.f = i;
                return v2Var.i(i);
            }
            throw new NoSuchElementException();
        }

        @Override // j$.util.Iterator
        public void remove() {
            if (this.g) {
                gj.this.n.i(this.f).g = null;
                v2<ej> v2Var = gj.this.n;
                int i = this.f;
                Object[] objArr = v2Var.h;
                Object obj = objArr[i];
                Object obj2 = v2.j;
                if (obj != obj2) {
                    objArr[i] = obj2;
                    v2Var.f = true;
                }
                this.f = i - 1;
                this.g = false;
                return;
            }
            throw new IllegalStateException("You must call next() before you can remove an element");
        }
    }

    public gj(mj<? extends gj> mjVar) {
        super(mjVar);
    }

    public final void A(int i) {
        if (i != this.h) {
            this.o = i;
            this.p = null;
            return;
        }
        throw new IllegalArgumentException("Start destination " + i + " cannot use the same id as the graph " + this);
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public final java.util.Iterator<ej> iterator() {
        return new a();
    }

    @Override // defpackage.ej
    public ej.a n(dj djVar) {
        ej.a n2 = super.n(djVar);
        a aVar = new a();
        while (aVar.hasNext()) {
            ej.a n3 = ((ej) aVar.next()).n(djVar);
            if (n3 != null && (n2 == null || n3.compareTo(n2) > 0)) {
                n2 = n3;
            }
        }
        return n2;
    }

    @Override // defpackage.ej
    public void s(Context context, AttributeSet attributeSet) {
        super.s(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.NavGraphNavigator);
        A(obtainAttributes.getResourceId(R.styleable.NavGraphNavigator_startDestination, 0));
        this.p = ej.k(context, this.o);
        obtainAttributes.recycle();
    }

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<ej> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    @Override // defpackage.ej
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" startDestination=");
        ej y = y(this.o);
        if (y == null) {
            String str = this.p;
            if (str == null) {
                sb.append("0x");
                sb.append(Integer.toHexString(this.o));
            } else {
                sb.append(str);
            }
        } else {
            sb.append("{");
            sb.append(y.toString());
            sb.append("}");
        }
        return sb.toString();
    }

    public final void v(ej ejVar) {
        int i = ejVar.h;
        if (i == 0) {
            throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
        } else if (i != this.h) {
            ej d = this.n.d(i);
            if (d != ejVar) {
                if (ejVar.g == null) {
                    if (d != null) {
                        d.g = null;
                    }
                    ejVar.g = this;
                    this.n.g(ejVar.h, ejVar);
                    return;
                }
                throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
            }
        } else {
            throw new IllegalArgumentException("Destination " + ejVar + " cannot have the same id as graph " + this);
        }
    }

    public final ej y(int i) {
        return z(i, true);
    }

    public final ej z(int i, boolean z) {
        gj gjVar;
        ej e = this.n.e(i, null);
        if (e != null) {
            return e;
        }
        if (!z || (gjVar = this.g) == null) {
            return null;
        }
        return gjVar.y(i);
    }
}

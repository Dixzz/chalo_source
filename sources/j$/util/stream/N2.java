package j$.util.stream;

import j$.time.chrono.b;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

final class N2<T> extends F2<T> {
    private ArrayList d;

    N2(A2 a2, Comparator comparator) {
        super(a2, comparator);
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        this.d.add(obj);
    }

    @Override // j$.util.stream.A2.d, j$.util.stream.A2
    public void m() {
        b.H(this.d, this.b);
        this.f1692a.n((long) this.d.size());
        if (!this.c) {
            ArrayList arrayList = this.d;
            A2 a2 = this.f1692a;
            Objects.requireNonNull(a2);
            b.y(arrayList, new C0138b(a2));
        } else {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (this.f1692a.p()) {
                    break;
                }
                this.f1692a.accept(next);
            }
        }
        this.f1692a.m();
        this.d = null;
    }

    @Override // j$.util.stream.A2.d, j$.util.stream.A2
    public void n(long j) {
        ArrayList arrayList;
        if (j < 2147483639) {
            if (j >= 0) {
                int i = (int) j;
            } else {
                arrayList = new ArrayList();
            }
            this.d = arrayList;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }
}

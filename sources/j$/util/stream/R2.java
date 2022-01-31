package j$.util.stream;

import java.util.Arrays;
import java.util.Comparator;

final class R2<T> extends F2<T> {
    private Object[] d;
    private int e;

    R2(A2 a2, Comparator comparator) {
        super(a2, comparator);
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        Object[] objArr = this.d;
        int i = this.e;
        this.e = i + 1;
        objArr[i] = obj;
    }

    @Override // j$.util.stream.A2.d, j$.util.stream.A2
    public void m() {
        int i = 0;
        Arrays.sort(this.d, 0, this.e, this.b);
        this.f1692a.n((long) this.e);
        if (!this.c) {
            while (i < this.e) {
                this.f1692a.accept(this.d[i]);
                i++;
            }
        } else {
            while (i < this.e && !this.f1692a.p()) {
                this.f1692a.accept(this.d[i]);
                i++;
            }
        }
        this.f1692a.m();
        this.d = null;
    }

    @Override // j$.util.stream.A2.d, j$.util.stream.A2
    public void n(long j) {
        if (j < 2147483639) {
            this.d = new Object[((int) j)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }
}

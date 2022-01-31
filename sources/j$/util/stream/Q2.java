package j$.util.stream;

import java.util.Arrays;

final class Q2 extends E2 {
    private long[] c;
    private int d;

    Q2(A2 a2) {
        super(a2);
    }

    @Override // j$.util.function.C, j$.util.stream.A2.g, j$.util.stream.A2
    public void accept(long j) {
        long[] jArr = this.c;
        int i = this.d;
        this.d = i + 1;
        jArr[i] = j;
    }

    @Override // j$.util.stream.A2.c, j$.util.stream.A2
    public void m() {
        int i = 0;
        Arrays.sort(this.c, 0, this.d);
        this.f1691a.n((long) this.d);
        if (!this.b) {
            while (i < this.d) {
                this.f1691a.accept(this.c[i]);
                i++;
            }
        } else {
            while (i < this.d && !this.f1691a.p()) {
                this.f1691a.accept(this.c[i]);
                i++;
            }
        }
        this.f1691a.m();
        this.c = null;
    }

    @Override // j$.util.stream.A2.c, j$.util.stream.A2
    public void n(long j) {
        if (j < 2147483639) {
            this.c = new long[((int) j)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }
}

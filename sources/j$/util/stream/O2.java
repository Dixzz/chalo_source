package j$.util.stream;

import java.util.Arrays;

final class O2 extends C2 {
    private double[] c;
    private int d;

    O2(A2 a2) {
        super(a2);
    }

    @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.A2
    public void accept(double d2) {
        double[] dArr = this.c;
        int i = this.d;
        this.d = i + 1;
        dArr[i] = d2;
    }

    @Override // j$.util.stream.A2.a, j$.util.stream.A2
    public void m() {
        int i = 0;
        Arrays.sort(this.c, 0, this.d);
        this.f1689a.n((long) this.d);
        if (!this.b) {
            while (i < this.d) {
                this.f1689a.accept(this.c[i]);
                i++;
            }
        } else {
            while (i < this.d && !this.f1689a.p()) {
                this.f1689a.accept(this.c[i]);
                i++;
            }
        }
        this.f1689a.m();
        this.c = null;
    }

    @Override // j$.util.stream.A2.a, j$.util.stream.A2
    public void n(long j) {
        if (j < 2147483639) {
            this.c = new double[((int) j)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }
}

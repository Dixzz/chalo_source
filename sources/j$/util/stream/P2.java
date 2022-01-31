package j$.util.stream;

import java.util.Arrays;

final class P2 extends D2 {
    private int[] c;
    private int d;

    P2(A2 a2) {
        super(a2);
    }

    @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
    public void accept(int i) {
        int[] iArr = this.c;
        int i2 = this.d;
        this.d = i2 + 1;
        iArr[i2] = i;
    }

    @Override // j$.util.stream.A2.b, j$.util.stream.A2
    public void m() {
        int i = 0;
        Arrays.sort(this.c, 0, this.d);
        this.f1690a.n((long) this.d);
        if (!this.b) {
            while (i < this.d) {
                this.f1690a.accept(this.c[i]);
                i++;
            }
        } else {
            while (i < this.d && !this.f1690a.p()) {
                this.f1690a.accept(this.c[i]);
                i++;
            }
        }
        this.f1690a.m();
        this.c = null;
    }

    @Override // j$.util.stream.A2.b, j$.util.stream.A2
    public void n(long j) {
        if (j < 2147483639) {
            this.c = new int[((int) j)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }
}

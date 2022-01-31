package j$.util.stream;

import j$.util.stream.S2;
import java.util.Arrays;

final class I2 extends E2 {
    private S2.d c;

    I2(A2 a2) {
        super(a2);
    }

    @Override // j$.util.function.C, j$.util.stream.A2.g, j$.util.stream.A2
    public void accept(long j) {
        this.c.accept(j);
    }

    @Override // j$.util.stream.A2.c, j$.util.stream.A2
    public void m() {
        long[] jArr = (long[]) this.c.e();
        Arrays.sort(jArr);
        this.f1691a.n((long) jArr.length);
        int i = 0;
        if (!this.b) {
            int length = jArr.length;
            while (i < length) {
                this.f1691a.accept(jArr[i]);
                i++;
            }
        } else {
            int length2 = jArr.length;
            while (i < length2) {
                long j = jArr[i];
                if (this.f1691a.p()) {
                    break;
                }
                this.f1691a.accept(j);
                i++;
            }
        }
        this.f1691a.m();
    }

    @Override // j$.util.stream.A2.c, j$.util.stream.A2
    public void n(long j) {
        S2.d dVar;
        if (j < 2147483639) {
            if (j > 0) {
                int i = (int) j;
            } else {
                dVar = new S2.d();
            }
            this.c = dVar;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }
}

package j$.util.stream;

import j$.util.stream.S2;
import java.util.Arrays;

final class G2 extends C2 {
    private S2.b c;

    G2(A2 a2) {
        super(a2);
    }

    @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.A2
    public void accept(double d) {
        this.c.accept(d);
    }

    @Override // j$.util.stream.A2.a, j$.util.stream.A2
    public void m() {
        double[] dArr = (double[]) this.c.e();
        Arrays.sort(dArr);
        this.f1689a.n((long) dArr.length);
        int i = 0;
        if (!this.b) {
            int length = dArr.length;
            while (i < length) {
                this.f1689a.accept(dArr[i]);
                i++;
            }
        } else {
            int length2 = dArr.length;
            while (i < length2) {
                double d = dArr[i];
                if (this.f1689a.p()) {
                    break;
                }
                this.f1689a.accept(d);
                i++;
            }
        }
        this.f1689a.m();
    }

    @Override // j$.util.stream.A2.a, j$.util.stream.A2
    public void n(long j) {
        S2.b bVar;
        if (j < 2147483639) {
            if (j > 0) {
                int i = (int) j;
            } else {
                bVar = new S2.b();
            }
            this.c = bVar;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }
}

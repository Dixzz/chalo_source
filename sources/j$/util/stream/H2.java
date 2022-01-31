package j$.util.stream;

import j$.util.stream.S2;
import java.util.Arrays;

final class H2 extends D2 {
    private S2.c c;

    H2(A2 a2) {
        super(a2);
    }

    @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
    public void accept(int i) {
        this.c.accept(i);
    }

    @Override // j$.util.stream.A2.b, j$.util.stream.A2
    public void m() {
        int[] iArr = (int[]) this.c.e();
        Arrays.sort(iArr);
        this.f1690a.n((long) iArr.length);
        int i = 0;
        if (!this.b) {
            int length = iArr.length;
            while (i < length) {
                this.f1690a.accept(iArr[i]);
                i++;
            }
        } else {
            int length2 = iArr.length;
            while (i < length2) {
                int i2 = iArr[i];
                if (this.f1690a.p()) {
                    break;
                }
                this.f1690a.accept(i2);
                i++;
            }
        }
        this.f1690a.m();
    }

    @Override // j$.util.stream.A2.b, j$.util.stream.A2
    public void n(long j) {
        S2.c cVar;
        if (j < 2147483639) {
            if (j > 0) {
                int i = (int) j;
            } else {
                cVar = new S2.c();
            }
            this.c = cVar;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }
}

package defpackage;

/* renamed from: c95  reason: default package */
/* compiled from: ErrorCorrectionLevel */
public enum c95 {
    L(1),
    M(0),
    Q(3),
    H(2);
    
    private static final c95[] FOR_BITS;
    private final int bits;

    /* access modifiers changed from: public */
    static {
        c95 c95;
        c95 c952;
        c95 c953;
        c95 c954;
        FOR_BITS = new c95[]{c952, c95, c954, c953};
    }

    private c95(int i) {
        this.bits = i;
    }

    public static c95 forBits(int i) {
        if (i >= 0) {
            c95[] c95Arr = FOR_BITS;
            if (i < c95Arr.length) {
                return c95Arr[i];
            }
        }
        throw new IllegalArgumentException();
    }

    public int getBits() {
        return this.bits;
    }
}

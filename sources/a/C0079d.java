package a;

/* renamed from: a.d  reason: case insensitive filesystem */
public /* synthetic */ class C0079d {
    public static /* synthetic */ long a(long j, long j2) {
        long j3 = j + j2;
        boolean z = true;
        boolean z2 = (j2 ^ j) < 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        if (z2 || z) {
            return j3;
        }
        throw new ArithmeticException();
    }
}

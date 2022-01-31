package a;

/* renamed from: a.f  reason: case insensitive filesystem */
public /* synthetic */ class C0083f {
    public static /* synthetic */ long a(long j, long j2) {
        long j3 = j % j2;
        if (j3 == 0) {
            return 0;
        }
        return (((j ^ j2) >> 63) | 1) > 0 ? j3 : j3 + j2;
    }
}

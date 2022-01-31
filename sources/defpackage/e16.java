package defpackage;

/* renamed from: e16  reason: default package */
/* compiled from: ExponentialBackoff */
public class e16 implements c16 {
    public e16(long j, int i) {
    }

    @Override // defpackage.c16
    public long getDelayMillis(int i) {
        return (long) (Math.pow((double) 8, (double) i) * ((double) 1000));
    }
}

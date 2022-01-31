package j$.util.stream;

/* access modifiers changed from: package-private */
/* renamed from: j$.util.stream.j1  reason: case insensitive filesystem */
public abstract class AbstractC0172j1 {

    /* renamed from: a  reason: collision with root package name */
    protected final int f1800a;
    protected int b;
    protected int c;
    protected long[] d;

    protected AbstractC0172j1() {
        this.f1800a = 4;
    }

    protected AbstractC0172j1(int i) {
        if (i >= 0) {
            this.f1800a = Math.max(4, 32 - Integer.numberOfLeadingZeros(i - 1));
            return;
        }
        throw new IllegalArgumentException("Illegal Capacity: " + i);
    }

    public abstract void clear();

    public long count() {
        int i = this.c;
        return i == 0 ? (long) this.b : this.d[i] + ((long) this.b);
    }

    /* access modifiers changed from: protected */
    public int s(int i) {
        return 1 << ((i == 0 || i == 1) ? this.f1800a : Math.min((this.f1800a + i) - 1, 30));
    }
}

package defpackage;

/* renamed from: lg6  reason: default package */
/* compiled from: Dispatcher.kt */
public final class lg6 extends mg6 {
    public static final lg6 l;
    public static final kb6 m;

    static {
        lg6 lg6 = new lg6();
        l = lg6;
        int i = eg6.f971a;
        m = new og6(lg6, ec6.F("kotlinx.coroutines.io.parallelism", 64 < i ? i : 64, 0, 0, 12, null), "Dispatchers.IO", 1);
    }

    public lg6() {
        super(0, 0, null, 7);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // defpackage.kb6
    public String toString() {
        return "Dispatchers.Default";
    }
}

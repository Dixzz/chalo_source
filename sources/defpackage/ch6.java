package defpackage;

/* renamed from: ch6  reason: default package */
/* compiled from: Mutex.kt */
public final class ch6 {

    /* renamed from: a  reason: collision with root package name */
    public static final dg6 f566a = new dg6("UNLOCK_FAIL");
    public static final dg6 b;
    public static final dg6 c;
    public static final xg6 d;
    public static final xg6 e;

    static {
        dg6 dg6 = new dg6("LOCKED");
        b = dg6;
        dg6 dg62 = new dg6("UNLOCKED");
        c = dg62;
        d = new xg6(dg6);
        e = new xg6(dg62);
    }
}

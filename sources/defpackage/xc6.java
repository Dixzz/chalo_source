package defpackage;

/* renamed from: xc6  reason: default package */
/* compiled from: JobSupport.kt */
public final class xc6 {

    /* renamed from: a  reason: collision with root package name */
    public static final dg6 f3914a = new dg6("COMPLETING_ALREADY");
    public static final dg6 b = new dg6("COMPLETING_WAITING_CHILDREN");
    public static final dg6 c = new dg6("COMPLETING_RETRY");
    public static final dg6 d = new dg6("TOO_LATE_TO_CANCEL");
    public static final dg6 e = new dg6("SEALED");
    public static final ac6 f = new ac6(false);
    public static final ac6 g = new ac6(true);

    public static final Object a(Object obj) {
        mc6 mc6;
        nc6 nc6 = obj instanceof nc6 ? (nc6) obj : null;
        return (nc6 == null || (mc6 = nc6.f2537a) == null) ? obj : mc6;
    }
}

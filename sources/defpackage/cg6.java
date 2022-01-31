package defpackage;

/* renamed from: cg6  reason: default package */
/* compiled from: StackTraceRecovery.kt */
public final class cg6 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f563a;
    public static final String b;

    static {
        Object obj;
        Object obj2;
        try {
            obj = Class.forName("u66").getCanonicalName();
        } catch (Throwable th) {
            obj = hd3.Z(th);
        }
        if (n56.a(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f563a = (String) obj;
        try {
            obj2 = Class.forName("cg6").getCanonicalName();
        } catch (Throwable th2) {
            obj2 = hd3.Z(th2);
        }
        if (n56.a(obj2) != null) {
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        b = (String) obj2;
    }
}

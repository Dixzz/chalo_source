package defpackage;

/* renamed from: e76  reason: default package */
/* compiled from: JDK7PlatformImplementations.kt */
public class e76 extends c76 {
    @Override // defpackage.c76
    public void a(Throwable th, Throwable th2) {
        n86.e(th, "cause");
        n86.e(th2, "exception");
        th.addSuppressed(th2);
    }
}

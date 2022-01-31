package defpackage;

/* renamed from: v66  reason: default package */
/* compiled from: ContinuationImpl.kt */
public final class v66 implements k66<Object> {
    public static final v66 f = new v66();

    @Override // defpackage.k66
    public m66 getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // defpackage.k66
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}

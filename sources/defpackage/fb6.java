package defpackage;

/* renamed from: fb6  reason: default package */
/* compiled from: CompletionState.kt */
public final class fb6 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1110a;
    public final s76<Throwable, s56> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: s76<? super java.lang.Throwable, s56> */
    /* JADX WARN: Multi-variable type inference failed */
    public fb6(Object obj, s76<? super Throwable, s56> s76) {
        this.f1110a = obj;
        this.b = s76;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fb6)) {
            return false;
        }
        fb6 fb6 = (fb6) obj;
        return n86.a(this.f1110a, fb6.f1110a) && n86.a(this.b, fb6.b);
    }

    public int hashCode() {
        Object obj = this.f1110a;
        return this.b.hashCode() + ((obj == null ? 0 : obj.hashCode()) * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CompletedWithCancellation(result=");
        i0.append(this.f1110a);
        i0.append(", onCancellation=");
        i0.append(this.b);
        i0.append(')');
        return i0.toString();
    }
}

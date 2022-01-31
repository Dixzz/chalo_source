package defpackage;

/* renamed from: bg6  reason: default package */
/* compiled from: Scopes.kt */
public class bg6<T> extends ka6<T> implements x66 {
    public final k66<T> h;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: k66<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public bg6(m66 m66, k66<? super T> k66) {
        super(m66, true, true);
        this.h = k66;
    }

    @Override // defpackage.wc6
    public final boolean N() {
        return true;
    }

    @Override // defpackage.ka6
    public void c0(Object obj) {
        k66<T> k66 = this.h;
        k66.resumeWith(hd3.B2(obj, k66));
    }

    @Override // defpackage.x66
    public final x66 getCallerFrame() {
        k66<T> k66 = this.h;
        if (k66 instanceof x66) {
            return (x66) k66;
        }
        return null;
    }

    @Override // defpackage.wc6
    public void u(Object obj) {
        rf6.b(hd3.B1(this.h), hd3.B2(obj, this.h), null, 2);
    }
}

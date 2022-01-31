package defpackage;

/* renamed from: ll2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ll2 extends in2 {
    public final /* synthetic */ r43 k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ll2(un2 un2, CharSequence charSequence, r43 r43) {
        super(un2, charSequence);
        this.k = r43;
    }

    @Override // defpackage.in2
    public final int a(int i) {
        if (this.k.f3039a.find(i)) {
            return this.k.f3039a.start();
        }
        return -1;
    }

    @Override // defpackage.in2
    public final int b(int i) {
        return this.k.f3039a.end();
    }
}

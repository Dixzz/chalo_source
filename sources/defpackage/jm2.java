package defpackage;

import java.util.Iterator;

/* renamed from: jm2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class jm2 implements tn2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q33 f1957a;

    public jm2(q33 q33) {
        this.f1957a = q33;
    }

    @Override // defpackage.tn2
    public final Iterator a(un2 un2, CharSequence charSequence) {
        return new ll2(un2, charSequence, new r43(((q53) this.f1957a).f.matcher(charSequence)));
    }
}

package defpackage;

import defpackage.d6;
import defpackage.y5;

/* renamed from: a7  reason: default package */
/* compiled from: CallbackWithHandler */
public class a7 implements Runnable {
    public final /* synthetic */ l7 f;
    public final /* synthetic */ int g;

    public a7(b7 b7Var, l7 l7Var, int i) {
        this.f = l7Var;
        this.g = i;
    }

    public void run() {
        l7 l7Var = this.f;
        int i = this.g;
        y5.c cVar = ((d6.a) l7Var).f793a;
        if (cVar != null) {
            cVar.onFontRetrievalFailed(i);
        }
    }
}

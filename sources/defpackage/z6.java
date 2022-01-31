package defpackage;

import android.graphics.Typeface;
import defpackage.d6;
import defpackage.y5;

/* renamed from: z6  reason: default package */
/* compiled from: CallbackWithHandler */
public class z6 implements Runnable {
    public final /* synthetic */ l7 f;
    public final /* synthetic */ Typeface g;

    public z6(b7 b7Var, l7 l7Var, Typeface typeface) {
        this.f = l7Var;
        this.g = typeface;
    }

    public void run() {
        l7 l7Var = this.f;
        Typeface typeface = this.g;
        y5.c cVar = ((d6.a) l7Var).f793a;
        if (cVar != null) {
            cVar.onFontRetrieved(typeface);
        }
    }
}

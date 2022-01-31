package defpackage;

import android.os.Handler;
import defpackage.i7;

/* renamed from: b7  reason: default package */
/* compiled from: CallbackWithHandler */
public class b7 {

    /* renamed from: a  reason: collision with root package name */
    public final l7 f388a;
    public final Handler b;

    public b7(l7 l7Var, Handler handler) {
        this.f388a = l7Var;
        this.b = handler;
    }

    public void a(i7.a aVar) {
        int i = aVar.b;
        if (i == 0) {
            this.b.post(new z6(this, this.f388a, aVar.f1485a));
            return;
        }
        this.b.post(new a7(this, this.f388a, i));
    }
}

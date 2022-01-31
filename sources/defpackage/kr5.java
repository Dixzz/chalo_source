package defpackage;

import com.urbanairship.iam.InAppMessage;
import defpackage.bz5;
import defpackage.gm5;

/* renamed from: kr5  reason: default package */
/* compiled from: InAppMessageManager */
public class kr5 implements bz5.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2111a;
    public final /* synthetic */ wq5 b;
    public final /* synthetic */ gm5.b c;
    public final /* synthetic */ jr5 d;

    public kr5(jr5 jr5, String str, wq5 wq5, gm5.b bVar) {
        this.d = jr5;
        this.f2111a = str;
        this.b = wq5;
        this.c = bVar;
    }

    @Override // defpackage.bz5.c
    public int run() {
        int i;
        bs5 bs5 = this.d.i;
        String str = this.f2111a;
        InAppMessage inAppMessage = this.b.b;
        ds5 ds5 = bs5.f471a;
        if (ds5 != null) {
            i = ((zr5) ds5).b(str, inAppMessage, bs5.b.a(str));
        } else {
            i = 0;
        }
        if (i == 0) {
            yj5.a("Assets prepared for schedule %s.", this.f2111a);
            return 0;
        } else if (i != 1) {
            yj5.a("Assets failed to prepare. Cancelling display for schedule %s.", this.f2111a);
            this.d.i.a(this.f2111a, this.b.b);
            this.c.a(1);
            return 2;
        } else {
            yj5.a("Assets failed to prepare for schedule %s. Will retry.", this.f2111a);
            return 1;
        }
    }
}

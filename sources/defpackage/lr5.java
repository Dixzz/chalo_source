package defpackage;

import android.content.Context;
import com.urbanairship.iam.assets.Assets;
import defpackage.bz5;
import defpackage.gm5;
import java.util.Objects;

/* renamed from: lr5  reason: default package */
/* compiled from: InAppMessageManager */
public class lr5 implements bz5.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ wq5 f2260a;
    public final /* synthetic */ String b;
    public final /* synthetic */ gm5.b c;
    public final /* synthetic */ jr5 d;

    public lr5(jr5 jr5, wq5 wq5, String str, gm5.b bVar) {
        this.d = jr5;
        this.f2260a = wq5;
        this.b = str;
        this.c = bVar;
    }

    @Override // defpackage.bz5.c
    public int run() {
        int i;
        wq5 wq5 = this.f2260a;
        jr5 jr5 = this.d;
        Context context = jr5.j;
        bs5 bs5 = jr5.i;
        Assets a2 = bs5.b.a(this.b);
        Objects.requireNonNull(wq5);
        try {
            yj5.a("Preparing message for schedule %s", wq5.f3828a);
            i = wq5.c.b(context, a2);
        } catch (Exception e) {
            yj5.e(e, "AdapterWrapper - Exception during prepare(Context).", new Object[0]);
            i = 1;
        }
        if (i == 0) {
            yj5.a("Adapter prepared schedule %s.", this.b);
            this.d.f1974a.put(this.b, this.f2260a);
            this.c.a(0);
            return 0;
        } else if (i != 1) {
            yj5.a("Adapter failed to prepare. Cancelling display for schedule %s.", this.b);
            this.c.a(1);
            return 2;
        } else {
            yj5.a("Adapter failed to prepare schedule %s. Will retry.", this.b);
            return 1;
        }
    }
}

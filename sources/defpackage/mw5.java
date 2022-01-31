package defpackage;

import android.content.Context;
import android.graphics.BitmapFactory;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.urbanairship.json.JsonValue;

/* renamed from: mw5  reason: default package */
/* compiled from: PublicNotificationExtender */
public class mw5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2454a;
    public final ew5 b;
    public int c;
    public int d;
    public int e;

    public mw5(Context context, ew5 ew5) {
        this.f2454a = context;
        this.b = ew5;
        this.d = context.getApplicationInfo().icon;
    }

    public f5 a(f5 f5Var) {
        if (hd3.G1(this.b.d.g.get("com.urbanairship.public_notification"))) {
            return f5Var;
        }
        try {
            zt5 n = JsonValue.p(this.b.d.g.get("com.urbanairship.public_notification")).n();
            f5 f5Var2 = new f5(this.f2454a, this.b.b);
            f5Var2.g(n.u(ProductPromotionsObject.KEY_TITLE).o());
            f5Var2.f(n.u("alert").o());
            f5Var2.q = this.c;
            f5Var2.i(16, true);
            f5Var2.v.icon = this.d;
            if (this.e != 0) {
                f5Var2.j(BitmapFactory.decodeResource(this.f2454a.getResources(), this.e));
            }
            if (n.f.containsKey("summary")) {
                f5Var2.m(n.u("summary").o());
            }
            f5Var.s = f5Var2.b();
        } catch (xt5 e2) {
            yj5.e(e2, "Failed to parse public notification.", new Object[0]);
        }
        return f5Var;
    }
}

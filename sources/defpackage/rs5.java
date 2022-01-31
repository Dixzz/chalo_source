package defpackage;

import android.content.Context;
import android.content.Intent;
import com.urbanairship.UAirship;
import com.urbanairship.iam.DisplayHandler;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.iam.assets.Assets;
import com.urbanairship.iam.html.HtmlActivity;

/* renamed from: rs5  reason: default package */
/* compiled from: HtmlDisplayAdapter */
public class rs5 extends cr5 {

    /* renamed from: a  reason: collision with root package name */
    public final InAppMessage f3125a;
    public final ss5 b;

    public rs5(InAppMessage inAppMessage, ss5 ss5) {
        this.f3125a = inAppMessage;
        this.b = ss5;
    }

    @Override // defpackage.gr5
    public void a(Context context) {
    }

    @Override // defpackage.gr5
    public int b(Context context, Assets assets) {
        if (UAirship.l().k.d(this.b.f, 2)) {
            return 0;
        }
        yj5.c("HTML in-app message URL is not allowed. Unable to display message.", new Object[0]);
        return 2;
    }

    @Override // defpackage.gr5
    public boolean c(Context context) {
        er5 f = er5.f(context);
        if (!(!f.f1021a.c(f.d).isEmpty())) {
            return false;
        }
        if (!this.b.n || hd3.E1()) {
            return true;
        }
        return false;
    }

    @Override // defpackage.gr5
    public void d(Context context, DisplayHandler displayHandler) {
        context.startActivity(new Intent(context, HtmlActivity.class).setFlags(268435456).putExtra("display_handler", displayHandler).putExtra("in_app_message", this.f3125a));
    }
}

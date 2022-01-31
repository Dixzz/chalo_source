package defpackage;

import android.content.Context;
import com.urbanairship.iam.DisplayHandler;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.json.JsonValue;

/* renamed from: wq5  reason: default package */
/* compiled from: AdapterWrapper */
public final class wq5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f3828a;
    public final InAppMessage b;
    public final gr5 c;
    public final ar5 d;
    public boolean e = false;
    public final JsonValue f;

    /* renamed from: wq5$a */
    /* compiled from: AdapterWrapper */
    public static class a extends Exception {
        public a(String str, Exception exc) {
            super(str, exc);
        }
    }

    public wq5(String str, JsonValue jsonValue, InAppMessage inAppMessage, gr5 gr5, ar5 ar5) {
        this.f3828a = str;
        this.f = jsonValue;
        this.b = inAppMessage;
        this.c = gr5;
        this.d = ar5;
    }

    public void a(Context context) {
        yj5.a("Adapter finished for schedule %s", this.f3828a);
        try {
            this.c.a(context);
        } catch (Exception e2) {
            yj5.e(e2, "AdapterWrapper - Exception during finish().", new Object[0]);
        }
    }

    public void b(Context context) throws a {
        yj5.a("Displaying message for schedule %s", this.f3828a);
        this.e = true;
        try {
            this.c.d(context, new DisplayHandler(this.f3828a));
            this.d.c(this.b);
        } catch (Exception e2) {
            throw new a("Adapter onDisplay(Activity, boolean, DisplayHandler) unexpected exception", e2);
        }
    }
}

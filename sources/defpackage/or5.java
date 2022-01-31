package defpackage;

import com.urbanairship.iam.InAppMessage;
import com.urbanairship.json.JsonValue;

/* renamed from: or5  reason: default package */
/* compiled from: InAppMessageManager */
public class or5 implements Runnable {
    public final /* synthetic */ InAppMessage f;
    public final /* synthetic */ String g;
    public final /* synthetic */ JsonValue h;
    public final /* synthetic */ jr5 i;

    public or5(jr5 jr5, InAppMessage inAppMessage, String str, JsonValue jsonValue) {
        this.i = jr5;
        this.f = inAppMessage;
        this.g = str;
        this.h = jsonValue;
    }

    public void run() {
        InAppMessage inAppMessage = this.f;
        if (inAppMessage == null) {
            this.i.d.i(wr5.j(this.g, "remote-data", xr5.c(), 0, this.h));
        } else if (inAppMessage.l) {
            this.i.d.i(wr5.j(this.g, "remote-data", xr5.c(), 0, this.h));
        }
    }
}

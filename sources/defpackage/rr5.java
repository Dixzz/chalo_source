package defpackage;

import com.urbanairship.iam.InAppMessage;
import java.util.Objects;

/* renamed from: rr5  reason: default package */
/* compiled from: InAppMessageManager */
public class rr5 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ InAppMessage g;
    public final /* synthetic */ jr5 h;

    public rr5(jr5 jr5, String str, InAppMessage inAppMessage) {
        this.h = jr5;
        this.f = str;
        this.g = inAppMessage;
    }

    public void run() {
        Objects.requireNonNull(this.h.i);
    }
}

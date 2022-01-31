package defpackage;

import android.content.Context;
import android.content.Intent;
import com.urbanairship.iam.DisplayHandler;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.iam.fullscreen.FullScreenActivity;

/* renamed from: ls5  reason: default package */
/* compiled from: FullScreenAdapter */
public class ls5 extends ur5 {
    public ls5(InAppMessage inAppMessage, ns5 ns5) {
        super(inAppMessage, ns5.h);
    }

    @Override // defpackage.gr5
    public void d(Context context, DisplayHandler displayHandler) {
        context.startActivity(new Intent(context, FullScreenActivity.class).setFlags(268435456).putExtra("display_handler", displayHandler).putExtra("in_app_message", this.f3548a).putExtra("assets", this.c));
    }
}

package defpackage;

import android.content.Context;
import android.content.Intent;
import com.urbanairship.iam.DisplayHandler;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.iam.modal.ModalActivity;

/* renamed from: us5  reason: default package */
/* compiled from: ModalAdapter */
public class us5 extends ur5 {
    public us5(InAppMessage inAppMessage, ws5 ws5) {
        super(inAppMessage, ws5.h);
    }

    @Override // defpackage.gr5
    public void d(Context context, DisplayHandler displayHandler) {
        context.startActivity(new Intent(context, ModalActivity.class).setFlags(268435456).putExtra("display_handler", displayHandler).putExtra("in_app_message", this.f3548a).putExtra("assets", this.c));
    }
}

package defpackage;

import android.content.Context;
import android.view.View;
import app.zophop.ui.activities.ConfirmMagicPassActivity;
import app.zophop.ui.activities.UserDetailsActivity;

/* renamed from: yd0  reason: default package */
/* compiled from: ConfirmMagicPassActivity */
public class yd0 implements View.OnClickListener {
    public final /* synthetic */ ConfirmMagicPassActivity f;

    public yd0(ConfirmMagicPassActivity confirmMagicPassActivity) {
        this.f = confirmMagicPassActivity;
    }

    public void onClick(View view) {
        Context context = view.getContext();
        ConfirmMagicPassActivity confirmMagicPassActivity = this.f;
        UserDetailsActivity.i0(context, confirmMagicPassActivity.q, confirmMagicPassActivity.r, ConfirmMagicPassActivity.v, confirmMagicPassActivity.p, ConfirmMagicPassActivity.w, "edit proof attachments");
    }
}

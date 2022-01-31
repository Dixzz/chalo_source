package defpackage;

import android.view.View;
import app.zophop.ui.activities.ConfirmMagicPassActivity;

/* renamed from: ud0  reason: default package */
/* compiled from: ConfirmMagicPassActivity */
public class ud0 implements View.OnClickListener {
    public final /* synthetic */ ConfirmMagicPassActivity f;

    public ud0(ConfirmMagicPassActivity confirmMagicPassActivity) {
        this.f = confirmMagicPassActivity;
    }

    public void onClick(View view) {
        this.f.onBackPressed();
    }
}

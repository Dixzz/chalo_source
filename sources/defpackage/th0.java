package defpackage;

import android.view.View;
import android.widget.PopupWindow;
import app.zophop.models.SosContact;
import app.zophop.ui.activities.ZophopSosActivity;

/* renamed from: th0  reason: default package */
/* compiled from: ZophopSosActivity */
public class th0 implements View.OnClickListener {
    public final /* synthetic */ SosContact f;
    public final /* synthetic */ PopupWindow g;
    public final /* synthetic */ ZophopSosActivity h;

    public th0(ZophopSosActivity zophopSosActivity, SosContact sosContact, PopupWindow popupWindow) {
        this.h = zophopSosActivity;
        this.f = sosContact;
        this.g = popupWindow;
    }

    public void onClick(View view) {
        this.h.k.b(this.f);
        this.h.i0();
        this.h.j0();
        this.g.dismiss();
    }
}

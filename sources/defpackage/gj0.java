package defpackage;

import android.app.Activity;
import android.view.View;
import android.widget.PopupWindow;
import defpackage.ig1;

/* renamed from: gj0  reason: default package */
/* compiled from: FavoriteListAdapter */
public class gj0 implements View.OnClickListener {
    public final /* synthetic */ PopupWindow f;
    public final /* synthetic */ mf1 g;
    public final /* synthetic */ bj0 h;

    public gj0(bj0 bj0, PopupWindow popupWindow, mf1 mf1) {
        this.h = bj0;
        this.f = popupWindow;
        this.g = mf1;
    }

    public void onClick(View view) {
        this.f.dismiss();
        pn0.c(((Activity) this.h.g).getFragmentManager(), this.g, ig1.a.EDIT_FAVORITE);
    }
}

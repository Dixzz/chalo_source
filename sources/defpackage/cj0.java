package defpackage;

import android.view.View;
import android.widget.PopupWindow;

/* renamed from: cj0  reason: default package */
/* compiled from: FavoriteListAdapter */
public class cj0 implements View.OnClickListener {
    public final /* synthetic */ View.OnClickListener f;
    public final /* synthetic */ View g;
    public final /* synthetic */ PopupWindow h;
    public final /* synthetic */ bj0 i;

    public cj0(bj0 bj0, View.OnClickListener onClickListener, View view, PopupWindow popupWindow) {
        this.i = bj0;
        this.f = onClickListener;
        this.g = view;
        this.h = popupWindow;
    }

    public void onClick(View view) {
        this.f.onClick(this.g);
        bj0 bj0 = this.i;
        bj0.l();
        bj0.notifyDataSetChanged();
        this.h.dismiss();
    }
}

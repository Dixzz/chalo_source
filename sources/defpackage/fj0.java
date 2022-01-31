package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;
import app.zophop.R;

/* renamed from: fj0  reason: default package */
/* compiled from: FavoriteListAdapter */
public class fj0 implements View.OnClickListener {
    public final /* synthetic */ mf1 f;
    public final /* synthetic */ PopupWindow g;
    public final /* synthetic */ bj0 h;

    public fj0(bj0 bj0, mf1 mf1, PopupWindow popupWindow) {
        this.h = bj0;
        this.f = mf1;
        this.g = popupWindow;
    }

    public void onClick(View view) {
        b60 Y = xt.f3961a.Y();
        if (Y.j(this.f)) {
            Y.k(this.f);
        } else if (this.f.c.equals("Home")) {
            Y.b("home");
        } else if (this.f.c.equals("Work")) {
            Y.b("work");
        }
        Y.a(this.f, System.currentTimeMillis());
        Context context = this.h.g;
        Toast.makeText(context, context.getString(R.string.fav_removed), 0).show();
        this.g.dismiss();
        bj0 bj0 = this.h;
        bj0.l();
        bj0.notifyDataSetChanged();
    }
}

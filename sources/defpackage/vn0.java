package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.activities.ZophopSosActivity;

/* renamed from: vn0  reason: default package */
/* compiled from: ZophopSosDialog */
public class vn0 implements View.OnClickListener {
    public final /* synthetic */ xn0 f;

    public vn0(xn0 xn0) {
        this.f = xn0;
    }

    public void onClick(View view) {
        if (this.f.h.equals(HomeActivity.class.getName())) {
            this.f.startActivity(new Intent(view.getContext(), ZophopSosActivity.class));
        }
        this.f.getDialog().dismiss();
    }
}

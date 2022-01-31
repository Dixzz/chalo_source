package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.ui.activities.PickLocationActivity;

/* renamed from: ll0  reason: default package */
/* compiled from: ZophopPickLocationDefaultAdapter */
public class ll0 implements View.OnClickListener {
    public final /* synthetic */ mf1 f;
    public final /* synthetic */ gl0 g;

    public ll0(gl0 gl0, mf1 mf1) {
        this.g = gl0;
        this.f = mf1;
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
        Context context = this.g.g;
        Toast.makeText(context, context.getString(R.string.fav_removed), 0).show();
        this.g.j.dismiss();
        ((PickLocationActivity) this.g.g).q0();
    }
}

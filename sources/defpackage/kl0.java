package defpackage;

import android.app.Activity;
import android.view.View;
import defpackage.ig1;

/* renamed from: kl0  reason: default package */
/* compiled from: ZophopPickLocationDefaultAdapter */
public class kl0 implements View.OnClickListener {
    public final /* synthetic */ mf1 f;
    public final /* synthetic */ gl0 g;

    public kl0(gl0 gl0, mf1 mf1) {
        this.g = gl0;
        this.f = mf1;
    }

    public void onClick(View view) {
        this.g.j.dismiss();
        pn0.c(((Activity) this.g.g).getFragmentManager(), this.f, ig1.a.EDIT_FAVORITE);
    }
}

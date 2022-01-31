package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.PickLocationActivity;

/* renamed from: il0  reason: default package */
/* compiled from: ZophopPickLocationDefaultAdapter */
public class il0 implements View.OnClickListener {
    public final /* synthetic */ int f;
    public final /* synthetic */ gl0 g;

    public il0(gl0 gl0, int i) {
        this.g = gl0;
        this.f = i;
    }

    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), PickLocationActivity.class);
        intent.putExtra("home_or_work", this.f);
        intent.putExtra("extra:source", this.g.f);
        ((Activity) this.g.g).startActivityForResult(intent, this.f);
    }
}

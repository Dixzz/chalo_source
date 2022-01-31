package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.PickLocationActivity;

/* renamed from: dj0  reason: default package */
/* compiled from: FavoriteListAdapter */
public class dj0 implements View.OnClickListener {
    public final /* synthetic */ int f;
    public final /* synthetic */ bj0 g;

    public dj0(bj0 bj0, int i) {
        this.g = bj0;
        this.f = i;
    }

    public void onClick(View view) {
        xh1 xh1 = this.g.j;
        if (xh1 != null) {
            int i = this.f;
            be0 be0 = (be0) xh1;
            Intent intent = new Intent(be0.f415a, PickLocationActivity.class);
            intent.putExtra("home_or_work", i);
            intent.putExtra("extra:source", "favoriteList");
            be0.f415a.startActivityForResult(intent, i);
        }
    }
}

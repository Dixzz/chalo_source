package defpackage;

import android.view.View;
import android.widget.AbsListView;

/* renamed from: gv5  reason: default package */
/* compiled from: MessageListFragment */
public class gv5 implements View.OnClickListener {
    public final /* synthetic */ int f;
    public final /* synthetic */ hv5 g;

    public gv5(hv5 hv5, int i) {
        this.g = hv5;
        this.f = i;
    }

    public void onClick(View view) {
        AbsListView absListView = this.g.i.g;
        if (absListView != null) {
            int i = this.f;
            absListView.setItemChecked(i, !absListView.isItemChecked(i));
        }
    }
}

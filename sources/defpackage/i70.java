package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.products.PassSelectionActivity;
import java.util.List;

/* renamed from: i70  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class i70 implements Runnable {
    public final /* synthetic */ List f;
    public final /* synthetic */ PassSelectionActivity g;

    public /* synthetic */ i70(List list, PassSelectionActivity passSelectionActivity) {
        this.f = list;
        this.g = passSelectionActivity;
    }

    public final void run() {
        RecyclerView.a0 F;
        View view;
        List list = this.f;
        PassSelectionActivity passSelectionActivity = this.g;
        int i = PassSelectionActivity.n;
        n86.e(list, "$lRelevantBookableConfigList");
        n86.e(passSelectionActivity, "this$0");
        if (((BookableSuperPassConfiguration) list.get(0)).isBookablePassConfigActive() && (F = ((fw) passSelectionActivity.f0()).f.F(0)) != null && (view = F.itemView) != null) {
            view.performClick();
        }
    }
}

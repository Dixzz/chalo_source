package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.products.CategorySelectionActivity;
import java.util.List;

/* renamed from: o70  reason: default package */
/* compiled from: CategorySelectionActivity */
public class o70 implements View.OnClickListener {
    public final /* synthetic */ int f;
    public final /* synthetic */ CategorySelectionActivity g;

    /* renamed from: o70$a */
    /* compiled from: CategorySelectionActivity */
    public class a implements Runnable {
        public final /* synthetic */ List f;

        public a(List list) {
            this.f = list;
        }

        public void run() {
            RecyclerView recyclerView = o70.this.g.y;
            if (recyclerView != null && recyclerView.F(0) != null && ((ProductFareMapping) this.f.get(0)).getLegacyIsActive().booleanValue() && ((ProductFareMapping) this.f.get(0)).getProductDuration().getIsActive()) {
                o70.this.g.y.F(0).itemView.performClick();
            }
        }
    }

    public o70(CategorySelectionActivity categorySelectionActivity, int i) {
        this.g = categorySelectionActivity;
        this.f = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0221, code lost:
        r0 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r12) {
        /*
        // Method dump skipped, instructions count: 675
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o70.onClick(android.view.View):void");
    }
}

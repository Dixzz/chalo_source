package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.products.CategorySelectionActivity;
import app.zophop.ui.activities.PickRouteLocationActivity;
import java.util.ArrayList;

/* renamed from: m70  reason: default package */
/* compiled from: CategorySelectionActivity */
public class m70 implements View.OnClickListener {
    public final /* synthetic */ CategorySelectionActivity f;

    public m70(CategorySelectionActivity categorySelectionActivity) {
        this.f = categorySelectionActivity;
    }

    public void onClick(View view) {
        CategorySelectionActivity categorySelectionActivity = this.f;
        if (!categorySelectionActivity.U.isVisible()) {
            categorySelectionActivity.U.show(categorySelectionActivity.getFragmentManager(), "loader_tag");
        }
        Intent intent = new Intent(this.f, PickRouteLocationActivity.class);
        intent.putExtra("src", "routePass");
        intent.putExtra("productId", this.f.l);
        intent.putStringArrayListExtra("productIds", (ArrayList) this.f.u);
        intent.putParcelableArrayListExtra("routePassIds", new ArrayList<>());
        intent.putExtra("is_for_result", String.valueOf(true));
        intent.putExtra("is_for_route_pass", String.valueOf(true));
        this.f.startActivityForResult(intent, 123);
    }
}

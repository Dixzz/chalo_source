package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.products.ProductSelectionActivity;
import app.zophop.ui.activities.ProductHistoryActivity;
import java.util.HashMap;
import java.util.Objects;

/* renamed from: s70  reason: default package */
/* compiled from: ProductSelectionActivity */
public class s70 implements View.OnClickListener {
    public final /* synthetic */ ProductSelectionActivity f;

    public s70(ProductSelectionActivity productSelectionActivity) {
        this.f = productSelectionActivity;
    }

    public void onClick(View view) {
        ProductSelectionActivity productSelectionActivity = this.f;
        int i = ProductSelectionActivity.D;
        Objects.requireNonNull(productSelectionActivity);
        ProductSelectionActivity.s0("recent product see all clicked", new HashMap());
        Intent intent = new Intent(productSelectionActivity, ProductHistoryActivity.class);
        intent.putExtra("source", "product_selection_recent_products");
        productSelectionActivity.startActivity(intent);
    }
}

package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.products.ProductSelectionActivity;
import app.zophop.ui.activities.CitySelectionActivity;

/* renamed from: v70  reason: default package */
/* compiled from: ProductSelectionActivity */
public class v70 implements View.OnClickListener {
    public final /* synthetic */ du0 f;
    public final /* synthetic */ ProductSelectionActivity g;

    public v70(ProductSelectionActivity productSelectionActivity, du0 du0) {
        this.g = productSelectionActivity;
        this.f = du0;
    }

    public void onClick(View view) {
        this.f.dismiss();
        this.f.f = true;
        this.g.startActivity(new Intent(this.g, CitySelectionActivity.class));
    }
}

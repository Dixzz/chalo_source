package defpackage;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.ProductSubCategory;
import app.zophop.products.PassSelectionActivity;
import java.util.Map;
import java.util.Objects;

/* renamed from: j70  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class j70 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ PassSelectionActivity f;
    public final /* synthetic */ qu g;

    public /* synthetic */ j70(PassSelectionActivity passSelectionActivity, qu quVar) {
        this.f = passSelectionActivity;
        this.g = quVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        PassSelectionActivity passSelectionActivity = this.f;
        qu quVar = this.g;
        int i2 = PassSelectionActivity.n;
        n86.e(passSelectionActivity, "this$0");
        n86.e(quVar, "$lSubCategoryAdapter");
        Object tag = view.findViewById(R.id.sub_category_name).getTag();
        Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.String");
        String str = (String) tag;
        ca1 ca1 = passSelectionActivity.l;
        if (ca1 != null) {
            n86.e(str, "lSelectedSubCatId");
            Map<String, ? extends Map<Integer, BookableSuperPassConfiguration>> map = ca1.k;
            if (map != null) {
                Map<String, Map<Integer, BookableSuperPassConfiguration>> b = t60.b(str, map);
                n86.e(b, "<set-?>");
                ca1.l = b;
                ed1 ed1 = new ed1("subCategory selected", Long.MIN_VALUE);
                ca1 ca12 = passSelectionActivity.l;
                if (ca12 != null) {
                    ed1.a("configId", ca12.d().getProductId());
                    ed1.a("selected subCategory", str);
                    hj1.J0(ed1, "isSuperPass", Boolean.TRUE, ed1);
                    ca1 ca13 = passSelectionActivity.l;
                    if (ca13 != null) {
                        ca13.n = str;
                        ProductSubCategory productSubCategory = ca13.g().get(str);
                        boolean z = false;
                        if (productSubCategory != null && productSubCategory.isActive()) {
                            z = true;
                        }
                        if (z) {
                            view.findViewById(R.id.sub_category_name).setBackground(passSelectionActivity.getResources().getDrawable(R.drawable.orange_capsule));
                            View findViewById = view.findViewById(R.id.sub_category_name);
                            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
                            ((TextView) findViewById).setTextColor(passSelectionActivity.getResources().getColor(R.color.white));
                            view.findViewById(R.id.sub_category_name).setPadding((int) ui1.n(16.0f, passSelectionActivity), (int) ui1.n(10.0f, passSelectionActivity), (int) ui1.n(16.0f, passSelectionActivity), (int) ui1.n(10.0f, passSelectionActivity));
                            passSelectionActivity.w0();
                            quVar.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    n86.l("viewModel");
                    throw null;
                }
                n86.l("viewModel");
                throw null;
            }
            n86.l("masterBookablePassConfigMap");
            throw null;
        }
        n86.l("viewModel");
        throw null;
    }
}

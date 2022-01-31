package app.zophop.products;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import butterknife.ButterKnife;

public class ProductSelectionActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder finder, ProductSelectionActivity productSelectionActivity, Object obj) {
        productSelectionActivity._productSelectionNestedScrollView = (NestedScrollView) finder.findRequiredView(obj, R.id.product_selection_nested_scroll_view, "field '_productSelectionNestedScrollView'");
        productSelectionActivity.recyclerView = (RecyclerView) finder.findRequiredView(obj, R.id.product_recycler_view, "field 'recyclerView'");
        productSelectionActivity.recentPurchasesHeader = (LinearLayout) finder.findRequiredView(obj, R.id.recent_purchases_header, "field 'recentPurchasesHeader'");
        productSelectionActivity.recentPurchasesSeeAllButton = (TextView) finder.findRequiredView(obj, R.id.recent_purchases_see_all, "field 'recentPurchasesSeeAllButton'");
        productSelectionActivity.recentPurchasesLinearLayout = (LinearLayout) finder.findRequiredView(obj, R.id.recent_purchases_layout, "field 'recentPurchasesLinearLayout'");
        productSelectionActivity.allProductsDisabledBanner = (LinearLayout) finder.findRequiredView(obj, R.id.multiple_products_disabled_banner_product_selection, "field 'allProductsDisabledBanner'");
        productSelectionActivity.allProductsDisabledTextview = (TextView) finder.findRequiredView(obj, R.id.product_selection_disabled_textview, "field 'allProductsDisabledTextview'");
    }

    public static void reset(ProductSelectionActivity productSelectionActivity) {
        productSelectionActivity._productSelectionNestedScrollView = null;
        productSelectionActivity.recyclerView = null;
        productSelectionActivity.recentPurchasesHeader = null;
        productSelectionActivity.recentPurchasesSeeAllButton = null;
        productSelectionActivity.recentPurchasesLinearLayout = null;
        productSelectionActivity.allProductsDisabledBanner = null;
        productSelectionActivity.allProductsDisabledTextview = null;
    }
}

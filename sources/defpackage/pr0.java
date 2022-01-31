package defpackage;

import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import app.zophop.ui.fragments.ProductHistoryFragment;

/* renamed from: pr0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class pr0 implements View.OnClickListener {
    public final /* synthetic */ ProductHistoryFragment f;

    public /* synthetic */ pr0(ProductHistoryFragment productHistoryFragment) {
        this.f = productHistoryFragment;
    }

    public final void onClick(View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        ProductHistoryFragment productHistoryFragment = this.f;
        int i = ProductHistoryFragment.g;
        n86.e(productHistoryFragment, "this$0");
        ve activity = productHistoryFragment.c();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.b();
        }
    }
}

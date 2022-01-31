package defpackage;

import android.content.Context;
import app.zophop.R;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: qu0  reason: default package */
/* compiled from: HomeScreenMainFragment.kt */
public final class qu0 extends o86 implements w76<String, String, s56> {
    public final /* synthetic */ HomeScreenMainFragment f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public qu0(HomeScreenMainFragment homeScreenMainFragment) {
        super(2);
        this.f = homeScreenMainFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public s56 invoke(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        n86.e(str3, "lInactiveReason");
        n86.e(str4, "lSource");
        Context context = this.f.getContext();
        if (context != null) {
            String string = context.getString(R.string.recent_products_disabled_dialog_title);
            n86.d(string, "lContext.getString(R.str…ts_disabled_dialog_title)");
            if (n86.a(str3, context.getString(R.string.recent_products_not_available_dialog_copy))) {
                string = context.getString(R.string.recent_products_not_available_dialog_title);
                n86.d(string, "lContext.getString(R.str…t_available_dialog_title)");
            } else if (n86.a(str3, context.getString(R.string.validity_expired_desc_recent_products))) {
                string = context.getString(R.string.validity_expired_title_recent_products);
                n86.d(string, "lContext.getString(R.str…ed_title_recent_products)");
            }
            jm0.e(((f0) context).getSupportFragmentManager(), new pu0(str4), str4, str3, string, false);
        }
        return s56.f3190a;
    }
}

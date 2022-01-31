package defpackage;

import androidx.fragment.app.FragmentManager;
import app.zophop.R;

/* renamed from: fl0  reason: default package */
/* compiled from: YourPlansAdapter.kt */
public final class fl0 extends o86 implements s76<String, s56> {
    public final /* synthetic */ dl0 f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public fl0(dl0 dl0) {
        super(1);
        this.f = dl0;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.s76
    public s56 invoke(String str) {
        String str2 = str;
        n86.e(str2, "lInactiveReason");
        String string = this.f.c.getString(R.string.recent_products_disabled_dialog_title);
        n86.d(string, "context.getString(R.stri…ts_disabled_dialog_title)");
        if (n86.a(str2, this.f.c.getString(R.string.recent_products_not_available_dialog_copy))) {
            string = this.f.c.getString(R.string.recent_products_not_available_dialog_title);
            n86.d(string, "context.getString(R.stri…t_available_dialog_title)");
        } else if (n86.a(str2, this.f.c.getString(R.string.validity_expired_desc_recent_products))) {
            string = this.f.c.getString(R.string.validity_expired_title_recent_products);
            n86.d(string, "context.getString(R.stri…ed_title_recent_products)");
        }
        FragmentManager supportFragmentManager = ((f0) this.f.c).getSupportFragmentManager();
        dl0 dl0 = this.f;
        jm0.e(supportFragmentManager, new el0(dl0), dl0.f, str2, string, false);
        return s56.f3190a;
    }
}

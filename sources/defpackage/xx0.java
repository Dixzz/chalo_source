package defpackage;

import android.widget.Toast;
import app.zophop.ui.fragments.cardRecharge.CardDetailsFragment;

/* renamed from: xx0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class xx0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CardDetailsFragment f3975a;

    public /* synthetic */ xx0(CardDetailsFragment cardDetailsFragment) {
        this.f3975a = cardDetailsFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        CardDetailsFragment cardDetailsFragment = this.f3975a;
        String str = (String) obj;
        int i = CardDetailsFragment.l;
        n86.e(cardDetailsFragment, "this$0");
        ve activity = cardDetailsFragment.c();
        if (activity != null) {
            n86.d(str, "lToastMessage");
            if (str.length() > 0) {
                Toast.makeText(activity, str, 0).show();
            }
        }
    }
}

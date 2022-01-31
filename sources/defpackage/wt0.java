package defpackage;

import androidx.activity.OnBackPressedDispatcher;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.ui.fragments.CitySelectionFragment;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: wt0  reason: default package */
/* compiled from: CitySelectionFragment.kt */
public final class wt0 extends o86 implements s76<l, s56> {
    public final /* synthetic */ CitySelectionFragment f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public wt0(CitySelectionFragment citySelectionFragment) {
        super(1);
        this.f = citySelectionFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.s76
    public s56 invoke(l lVar) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        l lVar2 = lVar;
        n86.e(lVar2, "$this$addCallback");
        CitySelectionFragment citySelectionFragment = this.f;
        int i = CitySelectionFragment.k;
        T t = citySelectionFragment.f;
        n86.c(t);
        if (((uw) t).c.getVisibility() == 0) {
            CitySelectionFragment citySelectionFragment2 = this.f;
            T t2 = citySelectionFragment2.f;
            n86.c(t2);
            ((uw) t2).i.c(true, true, true);
            T t3 = citySelectionFragment2.f;
            n86.c(t3);
            RecyclerView recyclerView = ((uw) t3).b;
            AtomicInteger atomicInteger = r8.f3055a;
            recyclerView.setNestedScrollingEnabled(true);
            citySelectionFragment2.g();
            T t4 = citySelectionFragment2.f;
            n86.c(t4);
            ((uw) t4).c.setText("");
            T t5 = citySelectionFragment2.f;
            n86.c(t5);
            ((uw) t5).c.setVisibility(8);
            T t6 = citySelectionFragment2.f;
            n86.c(t6);
            ((uw) t6).g.setVisibility(0);
            T t7 = citySelectionFragment2.f;
            n86.c(t7);
            ((uw) t7).e.setVisibility(0);
        } else {
            lVar2.f2142a = false;
            ve activity = this.f.c();
            if (!(activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null)) {
                onBackPressedDispatcher.b();
            }
        }
        return s56.f3190a;
    }
}

package defpackage;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import java.util.List;

/* renamed from: jp0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class jp0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f1964a;

    public /* synthetic */ jp0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f1964a = homeScreenMainFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        HomeScreenMainFragment homeScreenMainFragment = this.f1964a;
        List list = (List) obj;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        n86.d(list, "it");
        if (!list.isEmpty()) {
            Context requireContext = homeScreenMainFragment.requireContext();
            n86.d(requireContext, "requireContext()");
            ak0 ak0 = new ak0(requireContext, new iu0(homeScreenMainFragment));
            T t = homeScreenMainFragment.f;
            n86.c(t);
            ((cy) t).w.setAdapter(ak0);
            if (list.size() == 1) {
                T t2 = homeScreenMainFragment.f;
                n86.c(t2);
                ((cy) t2).w.setLayoutManager(new GridLayoutManager(homeScreenMainFragment.getContext(), 1));
            } else {
                T t3 = homeScreenMainFragment.f;
                n86.c(t3);
                ((cy) t3).w.setLayoutManager(new GridLayoutManager(homeScreenMainFragment.getContext(), 2));
            }
            ak0.f2701a.b(list, new fq0(homeScreenMainFragment, list));
            return;
        }
        T t4 = homeScreenMainFragment.f;
        n86.c(t4);
        ((cy) t4).z.b.setVisibility(8);
        T t5 = homeScreenMainFragment.f;
        n86.c(t5);
        ((cy) t5).y.c.setVisibility(8);
        T t6 = homeScreenMainFragment.f;
        n86.c(t6);
        ((cy) t6).w.setVisibility(8);
        T t7 = homeScreenMainFragment.f;
        n86.c(t7);
        if (((cy) t7).C.getVisibility() != 0) {
            T t8 = homeScreenMainFragment.f;
            n86.c(t8);
            ((cy) t8).x.setVisibility(8);
            T t9 = homeScreenMainFragment.f;
            n86.c(t9);
            ((cy) t9).e.setVisibility(8);
        }
    }
}

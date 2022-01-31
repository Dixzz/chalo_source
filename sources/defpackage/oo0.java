package defpackage;

import app.zophop.ui.fragments.CitySelectionFragment;
import java.util.List;

/* renamed from: oo0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class oo0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CitySelectionFragment f2717a;

    public /* synthetic */ oo0(CitySelectionFragment citySelectionFragment) {
        this.f2717a = citySelectionFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        CitySelectionFragment citySelectionFragment = this.f2717a;
        List list = (List) obj;
        int i = CitySelectionFragment.k;
        n86.e(citySelectionFragment, "this$0");
        wi0 wi0 = citySelectionFragment.g;
        if (wi0 != null) {
            wi0.f2701a.b(list, null);
        } else {
            n86.l("citySelectionListAdapter");
            throw null;
        }
    }
}

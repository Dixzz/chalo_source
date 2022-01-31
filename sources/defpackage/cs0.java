package defpackage;

import androidx.fragment.app.FragmentManager;
import defpackage.mw0;

/* renamed from: cs0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class cs0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ mw0 f749a;

    public /* synthetic */ cs0(mw0 mw0) {
        this.f749a = mw0;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        mw0 mw0 = this.f749a;
        Boolean bool = (Boolean) obj;
        mw0.a aVar = mw0.j;
        n86.e(mw0, "this$0");
        n86.d(bool, "isGranted");
        if (bool.booleanValue()) {
            hj1.R0("sound permission granted", "lName", "Sound info fragment", "lSource", "sound permission granted", Long.MIN_VALUE, "source", "Sound info fragment");
            mw0.g();
            return;
        }
        mw0.dismiss();
        FragmentManager parentFragmentManager = mw0.getParentFragmentManager();
        n86.d(parentFragmentManager, "parentFragmentManager");
        n86.e(parentFragmentManager, "lFragmentManager");
        n86.e("Sound info fragment", "lSource");
        nw0 nw0 = new nw0();
        nw0.setStyle(0, 16974402);
        nw0.g = "Sound info fragment";
        nw0.setCancelable(false);
        nw0.show(parentFragmentManager, "sound info rationale fragment");
        n86.e("sound permission denied", "lName");
        n86.e("Sound info fragment", "lSource");
        hj1.P0("sound permission denied", Long.MIN_VALUE, "source", "Sound info fragment");
    }
}

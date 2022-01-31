package defpackage;

import android.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import app.zophop.R;
import app.zophop.models.Guidelines;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.ProofViewInfo;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import defpackage.gb1;
import defpackage.xt;
import java.util.Map;
import java.util.Objects;

/* renamed from: eb1  reason: default package */
/* compiled from: MagicProofsListView */
public class eb1 implements View.OnClickListener {
    public final /* synthetic */ View f;
    public final /* synthetic */ ProofViewInfo g;
    public final /* synthetic */ int h;
    public final /* synthetic */ gb1 i;

    public eb1(gb1 gb1, View view, ProofViewInfo proofViewInfo, int i2) {
        this.i = gb1;
        this.f = view;
        this.g = proofViewInfo;
        this.h = i2;
    }

    public void onClick(View view) {
        Guidelines u;
        gb1.a aVar = this.i.h;
        if (aVar != null) {
            View view2 = this.f;
            ProofViewInfo proofViewInfo = this.g;
            jx0 jx0 = (jx0) aVar;
            Objects.requireNonNull(jx0);
            xt.t1 t1Var = xt.f3961a;
            String C = hj1.C(t1Var);
            ImageView imageView = (ImageView) view2.findViewById(R.id.card_view).findViewById(R.id.add_image_view);
            Map<String, String> map = jx0.f1990a.E;
            String name = (map == null || !map.containsKey(proofViewInfo.getName())) ? proofViewInfo.getName() : jx0.f1990a.E.get(proofViewInfo.getName());
            if (imageView.getVisibility() == 0 && jx0.f1990a.f != null && (u = t1Var.c().u(C, jx0.f1990a.f.getAgencyName(), name)) != null) {
                ed1 l = hj1.l("guidelines clicked", Long.MIN_VALUE, "guideline group id", name);
                l.a("guideline name", proofViewInfo.getName());
                MPass mPass = jx0.f1990a.K;
                if (mPass != null) {
                    l.a("passengerType", mPass.getPassengerType());
                    l.a("startDate", jh1.d(jx0.f1990a.F.getTimeInMillis()));
                    l.a(SuperPassJsonKeys.FARE, jx0.f1990a.K.getFare() + "");
                    l.a("numDays", Integer.valueOf(jx0.f1990a.K.getNoOfDays()));
                }
                jz5.b().g(l);
                FragmentManager fragmentManager = jx0.f1990a.getFragmentManager();
                nm0 nm0 = new nm0(u, new ix0(jx0));
                nm0.show(fragmentManager, nm0.h);
                nm0.setCancelable(false);
            }
        }
    }
}

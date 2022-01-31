package defpackage;

import android.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import app.zophop.R;
import app.zophop.models.Guidelines;
import app.zophop.models.mTicketing.ProofViewInfo;
import app.zophop.ui.fragments.UserDetailsFragment;
import defpackage.gb1;
import defpackage.xt;
import java.util.Map;
import java.util.Objects;

/* renamed from: db1  reason: default package */
/* compiled from: MagicProofsListView */
public class db1 implements View.OnClickListener {
    public final /* synthetic */ View f;
    public final /* synthetic */ ProofViewInfo g;
    public final /* synthetic */ int h;
    public final /* synthetic */ gb1 i;

    public db1(gb1 gb1, View view, ProofViewInfo proofViewInfo, int i2) {
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
            int i2 = this.h;
            jx0 jx0 = (jx0) aVar;
            Objects.requireNonNull(jx0);
            ed1 ed1 = new ed1("proof clicked", Long.MIN_VALUE);
            ed1.a("proofPosition", Integer.valueOf(i2));
            jz5.b().g(ed1);
            UserDetailsFragment userDetailsFragment = jx0.f1990a;
            userDetailsFragment.D = view2;
            if (userDetailsFragment.o) {
                userDetailsFragment.z = i2;
                boolean z = true;
                xt.t1 t1Var = xt.f3961a;
                String C = hj1.C(t1Var);
                ImageView imageView = (ImageView) view2.findViewById(R.id.add_image_view);
                Map<String, String> map = jx0.f1990a.E;
                String name = (map == null || !map.containsKey(proofViewInfo.getName())) ? proofViewInfo.getName() : jx0.f1990a.E.get(proofViewInfo.getName());
                if (!(imageView.getVisibility() != 0 || jx0.f1990a.f == null || (u = t1Var.c().u(C, jx0.f1990a.f.getAgencyName(), name)) == null)) {
                    FragmentManager fragmentManager = jx0.f1990a.getFragmentManager();
                    nm0 nm0 = new nm0(u, new hx0(jx0, C, name));
                    nm0.show(fragmentManager, nm0.h);
                    nm0.setCancelable(false);
                    z = false;
                }
                if (z && UserDetailsFragment.a(jx0.f1990a)) {
                    UserDetailsFragment userDetailsFragment2 = jx0.f1990a;
                    userDetailsFragment2.y = vn.S0(userDetailsFragment2);
                }
            } else if (proofViewInfo.getImage() != null) {
                UserDetailsFragment userDetailsFragment3 = jx0.f1990a;
                String url = proofViewInfo.getUrl();
                View findViewById = view.findViewById(R.id.proof_image);
                proofViewInfo.getName();
                userDetailsFragment3.q(url, findViewById);
            }
        }
    }
}

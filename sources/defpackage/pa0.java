package defpackage;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.activities.SuperPassValidationActivity;
import defpackage.ut;
import defpackage.xt;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: pa0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class pa0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassValidationActivity f2787a;

    public /* synthetic */ pa0(SuperPassValidationActivity superPassValidationActivity) {
        this.f2787a = superPassValidationActivity;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        int i;
        boolean z;
        SuperPassValidationActivity superPassValidationActivity = this.f2787a;
        SuperPass superPass = (SuperPass) obj;
        int i2 = SuperPassValidationActivity.l;
        n86.e(superPassValidationActivity, "this$0");
        y91 o0 = superPassValidationActivity.o0();
        n86.d(superPass, "lSuperPass");
        Objects.requireNonNull(o0);
        n86.e(superPass, "lSuperPass");
        if (!superPass.isSuperPassActivationValid()) {
            i = R.id.activateSuperPassFragment;
        } else if (ui1.B0()) {
            i = R.id.soundFragmentSuperPass;
        } else {
            ut.a aVar = ut.f3552a;
            xt.t1 t1Var = xt.f3961a;
            String f = t1Var.t().f("visualValidationCityList");
            String D = hj1.D(t1Var);
            if (f != null) {
                try {
                    JSONArray jSONArray = new JSONArray(f);
                    int length = jSONArray.length();
                    if (length > 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            String string = jSONArray.getString(i3);
                            if (string != null && ea6.f(string, D, true)) {
                                z = true;
                                break;
                            } else if (i4 >= length) {
                                break;
                            } else {
                                i3 = i4;
                            }
                        }
                    }
                } catch (JSONException e) {
                    b00 b00 = b00.f358a;
                    hj1.X0(e, b00.a());
                }
            }
            z = false;
            i = z ? R.id.activeSuperPassVisualValidationFragment : R.id.activeSuperPassFragment;
        }
        if (i == R.id.soundFragmentSuperPass) {
            superPassValidationActivity.q0();
        }
        Fragment H = superPassValidationActivity.getSupportFragmentManager().H(R.id.nav_host_fragment_validate_super_pass);
        Objects.requireNonNull(H, "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        NavHostFragment navHostFragment = (NavHostFragment) H;
        NavController e2 = navHostFragment.e();
        n86.d(e2, "lNavHostFragment.navController");
        jj e3 = navHostFragment.e().e();
        n86.d(e3, "lNavHostFragment.navController.navInflater");
        gj c = e3.c(R.navigation.nav_graph_validate_super_pass);
        n86.d(c, "lNavGraphInflater.inflat…raph_validate_super_pass)");
        c.A(i);
        e2.i(c, h.j(new m56("arg_source", "super pass validation activity")));
    }
}

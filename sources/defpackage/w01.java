package defpackage;

import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassFragment;

/* renamed from: w01  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class w01 implements View.OnClickListener {
    public final /* synthetic */ SuperPass f;
    public final /* synthetic */ ActiveSuperPassFragment g;

    public /* synthetic */ w01(SuperPass superPass, ActiveSuperPassFragment activeSuperPassFragment) {
        this.f = superPass;
        this.g = activeSuperPassFragment;
    }

    public final void onClick(View view) {
        SuperPass superPass = this.f;
        ActiveSuperPassFragment activeSuperPassFragment = this.g;
        ActiveSuperPassFragment.a aVar = ActiveSuperPassFragment.i;
        n86.e(superPass, "$lSuperPass");
        n86.e(activeSuperPassFragment, "this$0");
        ed1 ed1 = new ed1("super pass qr code zoomed", Long.MIN_VALUE);
        ed1.a("date", jh1.c(ui1.Q()));
        ed1.a("time", jh1.g(ui1.Q()));
        gi1.f1265a.d(ed1, superPass);
        ui1.m0(ed1);
        vh1 vh1 = vh1.f3649a;
        n86.f(activeSuperPassFragment, "$this$findNavController");
        NavController d = NavHostFragment.d(activeSuperPassFragment);
        n86.b(d, "NavHostFragment.findNavController(this)");
        e31 e31 = new e31(null);
        e31.f918a.put("arg_source", "Active Super Pass Fragment");
        n86.d(e31, "actionActiveSuperPassFra…AME\n                    )");
        vh1.a(d, e31);
    }
}

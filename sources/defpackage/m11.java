package defpackage;

import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassVisualValidationFragment;

/* renamed from: m11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class m11 implements View.OnClickListener {
    public final /* synthetic */ ActiveSuperPassVisualValidationFragment f;

    public /* synthetic */ m11(ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment) {
        this.f = activeSuperPassVisualValidationFragment;
    }

    public final void onClick(View view) {
        ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment = this.f;
        ActiveSuperPassVisualValidationFragment.a aVar = ActiveSuperPassVisualValidationFragment.i;
        n86.e(activeSuperPassVisualValidationFragment, "this$0");
        SuperPassSubType superPassSubType = activeSuperPassVisualValidationFragment.g().f;
        String str = activeSuperPassVisualValidationFragment.g().e;
        ed1 ed1 = new ed1("super pass qr code zoomed", Long.MIN_VALUE);
        ed1.a("date", jh1.c(ui1.Q()));
        ed1.a("time", jh1.g(ui1.Q()));
        n86.e(ed1, "lEvent");
        n86.e(superPassSubType, "superPassSubType");
        n86.e(str, "superPassId");
        hj1.I0(ed1, "isSuperPass", Boolean.TRUE, superPassSubType, "productSubType");
        ed1.a("passId", str);
        ui1.m0(ed1);
        vh1 vh1 = vh1.f3649a;
        n86.f(activeSuperPassVisualValidationFragment, "$this$findNavController");
        NavController d = NavHostFragment.d(activeSuperPassVisualValidationFragment);
        n86.b(d, "NavHostFragment.findNavController(this)");
        s31 s31 = new s31(null);
        s31.f3178a.put("arg_source", "Active Super Pass Visual validation Fragment");
        n86.d(s31, "actionActiveSuperPassVis…AME\n                    )");
        vh1.a(d, s31);
    }
}

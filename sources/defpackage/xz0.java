package defpackage;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.ui.fragments.superPassHistory.SuperPassTripReceiptFragment;

/* renamed from: xz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class xz0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassTripReceiptFragment f3982a;

    public /* synthetic */ xz0(SuperPassTripReceiptFragment superPassTripReceiptFragment) {
        this.f3982a = superPassTripReceiptFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        SuperPassTripReceiptFragment superPassTripReceiptFragment = this.f3982a;
        SuperPass superPass = (SuperPass) obj;
        int i = SuperPassTripReceiptFragment.j;
        n86.e(superPassTripReceiptFragment, "this$0");
        n86.d(superPass, "lSuperPass");
        ed1 ed1 = new ed1("superPass trip receipt Screen opened", Long.MIN_VALUE);
        superPassTripReceiptFragment.i(ed1);
        gi1.f1265a.f(ed1, superPass);
        ui1.m0(ed1);
        SuperPassUserDetails superPassUserDetails = superPass.getSuperPassUIProperties().getSuperPassUserDetails();
        T t = superPassTripReceiptFragment.f;
        n86.c(t);
        pz pzVar = ((rx) t).j;
        pzVar.f.setText(superPassUserDetails.getFullName());
        pzVar.b.setText(superPassUserDetails.getDateOfBirth());
        pzVar.c.setText(superPassTripReceiptFragment.getString(superPassUserDetails.getGender().getResId()));
        if (superPassUserDetails.getProfilePhoto().length() > 0) {
            ProgressBar progressBar = pzVar.d;
            n86.d(progressBar, "passProfilePicProgressbar");
            progressBar.setVisibility(0);
            ml1<Bitmap> j = gl1.g(superPassTripReceiptFragment.c()).j();
            j.h(superPassUserDetails.getProfilePhoto());
            j.a(new rs1().q(50000));
            j.f(new k01(superPassTripReceiptFragment, pzVar));
            pzVar.e.setOnClickListener(new yz0(superPassTripReceiptFragment, pzVar, superPassUserDetails));
        }
        ((u91) superPassTripReceiptFragment.g.getValue()).d(superPass);
    }
}

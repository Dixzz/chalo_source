package defpackage;

import android.view.View;
import android.widget.ImageView;
import app.zophop.models.mTicketing.ProofUploadDetails;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.fragments.superpassPurchase.ConfirmSuperPassPurchaseFragment;
import defpackage.ru;

/* renamed from: x51  reason: default package */
/* compiled from: ConfirmSuperPassPurchaseFragment.kt */
public final class x51 implements ru.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfirmSuperPassPurchaseFragment f3887a;

    public x51(ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment) {
        this.f3887a = confirmSuperPassPurchaseFragment;
    }

    @Override // defpackage.ru.a
    public void a(View view, ProofUploadDetails proofUploadDetails) {
        n86.e(view, "lThumbView");
        n86.e(proofUploadDetails, "proofUploadDetails");
        if (this.f3887a.c() != null) {
            ZoomedImageViewActivity.i0(this.f3887a.c(), (ImageView) view, proofUploadDetails.getProofImageLocalUri(), null, true);
        }
    }
}

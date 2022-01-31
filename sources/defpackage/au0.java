package defpackage;

import android.view.View;
import android.widget.ImageView;
import app.zophop.models.mTicketing.ProofUploadDetails;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.fragments.ConfirmMPassPurchaseFragment;
import defpackage.ru;

/* renamed from: au0  reason: default package */
/* compiled from: ConfirmMPassPurchaseFragment.kt */
public final class au0 implements ru.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfirmMPassPurchaseFragment f331a;

    public au0(ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment) {
        this.f331a = confirmMPassPurchaseFragment;
    }

    @Override // defpackage.ru.a
    public void a(View view, ProofUploadDetails proofUploadDetails) {
        n86.e(view, "lThumbView");
        n86.e(proofUploadDetails, "proofUploadDetails");
        if (this.f331a.c() != null) {
            ZoomedImageViewActivity.i0(this.f331a.c(), (ImageView) view, proofUploadDetails.getProofImageLocalUri(), null, true);
        }
    }
}

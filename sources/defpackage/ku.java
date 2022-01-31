package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.ProofRejectionReason;
import com.google.android.material.imageview.ShapeableImageView;
import defpackage.uu;

/* renamed from: ku  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ku implements View.OnClickListener {
    public final /* synthetic */ uu f;
    public final /* synthetic */ ProofRejectionReason g;
    public final /* synthetic */ uy h;

    public /* synthetic */ ku(uu uuVar, ProofRejectionReason proofRejectionReason, uy uyVar) {
        this.f = uuVar;
        this.g = proofRejectionReason;
        this.h = uyVar;
    }

    public final void onClick(View view) {
        uu uuVar = this.f;
        ProofRejectionReason proofRejectionReason = this.g;
        uy uyVar = this.h;
        n86.e(uuVar, "this$0");
        n86.e(uyVar, "$lItemBinding");
        uu.a aVar = uuVar.f;
        String lProofUrl = proofRejectionReason.getLProofUrl();
        ShapeableImageView shapeableImageView = uyVar.l;
        n86.d(shapeableImageView, "lItemBinding.rejectedProofThumbnail");
        aVar.d(lProofUrl, shapeableImageView, true);
    }
}

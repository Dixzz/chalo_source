package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.ProofUploadDetails;
import com.google.android.material.imageview.ShapeableImageView;
import defpackage.uu;

/* renamed from: ju  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ju implements View.OnClickListener {
    public final /* synthetic */ uu f;
    public final /* synthetic */ ProofUploadDetails g;
    public final /* synthetic */ uy h;

    public /* synthetic */ ju(uu uuVar, ProofUploadDetails proofUploadDetails, uy uyVar) {
        this.f = uuVar;
        this.g = proofUploadDetails;
        this.h = uyVar;
    }

    public final void onClick(View view) {
        uu uuVar = this.f;
        ProofUploadDetails proofUploadDetails = this.g;
        uy uyVar = this.h;
        n86.e(uuVar, "this$0");
        n86.e(proofUploadDetails, "$lProofUploadDetails");
        n86.e(uyVar, "$this_apply");
        uu.a aVar = uuVar.f;
        String proofImageLocalUri = proofUploadDetails.getProofImageLocalUri();
        ShapeableImageView shapeableImageView = uyVar.g;
        n86.d(shapeableImageView, "proofImage");
        aVar.d(proofImageLocalUri, shapeableImageView, false);
    }
}

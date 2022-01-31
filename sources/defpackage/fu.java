package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.ProofUploadDetails;
import com.google.android.material.imageview.ShapeableImageView;
import defpackage.ru;

/* renamed from: fu  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class fu implements View.OnClickListener {
    public final /* synthetic */ ru f;
    public final /* synthetic */ ru.b g;
    public final /* synthetic */ ProofUploadDetails h;

    public /* synthetic */ fu(ru ruVar, ru.b bVar, ProofUploadDetails proofUploadDetails) {
        this.f = ruVar;
        this.g = bVar;
        this.h = proofUploadDetails;
    }

    public final void onClick(View view) {
        ru ruVar = this.f;
        ru.b bVar = this.g;
        ProofUploadDetails proofUploadDetails = this.h;
        n86.e(ruVar, "this$0");
        n86.e(bVar, "this$1");
        n86.e(proofUploadDetails, "$lProofUploadDetails");
        ru.a aVar = ruVar.c;
        ShapeableImageView shapeableImageView = bVar.f3132a.b;
        n86.d(shapeableImageView, "itemBinding.proofImage");
        aVar.a(shapeableImageView, proofUploadDetails);
    }
}

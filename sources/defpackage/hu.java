package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.ProofDocumentProps;

/* renamed from: hu  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class hu implements View.OnClickListener {
    public final /* synthetic */ uu f;
    public final /* synthetic */ ProofDocumentProps g;

    public /* synthetic */ hu(uu uuVar, ProofDocumentProps proofDocumentProps) {
        this.f = uuVar;
        this.g = proofDocumentProps;
    }

    public final void onClick(View view) {
        uu uuVar = this.f;
        ProofDocumentProps proofDocumentProps = this.g;
        n86.e(uuVar, "this$0");
        n86.e(proofDocumentProps, "$lProofDocumentProps");
        uuVar.f.b(proofDocumentProps, false);
    }
}

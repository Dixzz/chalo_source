package defpackage;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import app.zophop.models.mTicketing.ProofDocumentProps;

/* renamed from: vu  reason: default package */
/* compiled from: UserProofsOverviewAdapter.kt */
public final class vu extends ClickableSpan {
    public final /* synthetic */ uu f;
    public final /* synthetic */ ProofDocumentProps g;

    public vu(uu uuVar, ProofDocumentProps proofDocumentProps) {
        this.f = uuVar;
        this.g = proofDocumentProps;
    }

    public void onClick(View view) {
        n86.e(view, "widget");
        this.f.f.b(this.g, true);
    }

    public void updateDrawState(TextPaint textPaint) {
        n86.e(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}

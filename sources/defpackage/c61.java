package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import app.zophop.models.mTicketing.ProofDocumentProps;
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofUploadFragment;
import java.util.Objects;

/* renamed from: c61  reason: default package */
/* compiled from: SuperPassUserProofUploadFragment.kt */
public final class c61 extends ClickableSpan {
    public final /* synthetic */ SuperPassUserProofUploadFragment f;
    public final /* synthetic */ ProofDocumentProps g;

    public c61(SuperPassUserProofUploadFragment superPassUserProofUploadFragment, ProofDocumentProps proofDocumentProps) {
        this.f = superPassUserProofUploadFragment;
        this.g = proofDocumentProps;
    }

    public void onClick(View view) {
        n86.e(view, "widget");
        SuperPassUserProofUploadFragment superPassUserProofUploadFragment = this.f;
        String formUrl = this.g.getFormUrl();
        int i = SuperPassUserProofUploadFragment.m;
        Objects.requireNonNull(superPassUserProofUploadFragment);
        ed1 ed1 = new ed1("download sample form clicked", Long.MIN_VALUE);
        ed1.a("url", formUrl);
        superPassUserProofUploadFragment.i(ed1);
        ui1.m0(ed1);
        SuperPassUserProofUploadFragment superPassUserProofUploadFragment2 = this.f;
        ProofDocumentProps proofDocumentProps = this.g;
        Objects.requireNonNull(superPassUserProofUploadFragment2);
        superPassUserProofUploadFragment2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(proofDocumentProps.getFormUrl())));
    }

    public void updateDrawState(TextPaint textPaint) {
        n86.e(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}

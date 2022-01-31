package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import app.zophop.models.mTicketing.ProofDocumentProps;
import app.zophop.ui.fragments.UserProofUploadFragment;
import java.util.Objects;

/* renamed from: kx0  reason: default package */
/* compiled from: UserProofUploadFragment.kt */
public final class kx0 extends ClickableSpan {
    public final /* synthetic */ UserProofUploadFragment f;
    public final /* synthetic */ ProofDocumentProps g;

    public kx0(UserProofUploadFragment userProofUploadFragment, ProofDocumentProps proofDocumentProps) {
        this.f = userProofUploadFragment;
        this.g = proofDocumentProps;
    }

    public void onClick(View view) {
        n86.e(view, "widget");
        UserProofUploadFragment userProofUploadFragment = this.f;
        String formUrl = this.g.getFormUrl();
        int i = UserProofUploadFragment.m;
        Objects.requireNonNull(userProofUploadFragment);
        ed1 ed1 = new ed1("download sample form clicked", Long.MIN_VALUE);
        ed1.a("url", formUrl);
        userProofUploadFragment.i(ed1);
        ui1.m0(ed1);
        UserProofUploadFragment userProofUploadFragment2 = this.f;
        ProofDocumentProps proofDocumentProps = this.g;
        Objects.requireNonNull(userProofUploadFragment2);
        userProofUploadFragment2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(proofDocumentProps.getFormUrl())));
    }

    public void updateDrawState(TextPaint textPaint) {
        n86.e(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}

package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import app.zophop.models.mTicketing.ProofDocumentProps;
import app.zophop.models.mTicketing.ProofUploadDetails;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.fragments.UserProofsOverviewFragment;
import com.razorpay.AnalyticsConstants;
import defpackage.uu;
import java.util.Map;
import java.util.Objects;

/* renamed from: nx0  reason: default package */
/* compiled from: UserProofsOverviewFragment.kt */
public final class nx0 implements uu.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProofsOverviewFragment f2616a;

    public nx0(UserProofsOverviewFragment userProofsOverviewFragment) {
        this.f2616a = userProofsOverviewFragment;
    }

    @Override // defpackage.uu.a
    public void a(ProofDocumentProps proofDocumentProps) {
        n86.e(proofDocumentProps, "lProofDocumentProps");
        String formUrl = proofDocumentProps.getFormUrl();
        UserProofsOverviewFragment userProofsOverviewFragment = this.f2616a;
        int i = UserProofsOverviewFragment.m;
        Objects.requireNonNull(userProofsOverviewFragment);
        ed1 ed1 = new ed1("download sample form clicked", Long.MIN_VALUE);
        ed1.a("url", formUrl);
        ed1.a(AnalyticsConstants.FLOW, userProofsOverviewFragment.j().f);
        userProofsOverviewFragment.i(ed1);
        ui1.m0(ed1);
        this.f2616a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(formUrl)));
    }

    @Override // defpackage.uu.a
    public void b(ProofDocumentProps proofDocumentProps, boolean z) {
        n86.e(proofDocumentProps, "lProofDocumentProps");
        if (z) {
            UserProofsOverviewFragment userProofsOverviewFragment = this.f2616a;
            int i = UserProofsOverviewFragment.m;
            ed1 ed1 = new ed1("proof guidelines btn clicked", Long.MIN_VALUE);
            ed1.a(AnalyticsConstants.FLOW, userProofsOverviewFragment.j().f);
            userProofsOverviewFragment.i(ed1);
            ui1.m0(ed1);
        } else {
            UserProofsOverviewFragment userProofsOverviewFragment2 = this.f2616a;
            int i2 = UserProofsOverviewFragment.m;
            ed1 ed12 = new ed1("add photo btn clicked", Long.MIN_VALUE);
            ed12.a(AnalyticsConstants.FLOW, userProofsOverviewFragment2.j().f);
            userProofsOverviewFragment2.i(ed12);
            ui1.m0(ed12);
        }
        px0 px0 = new px0(proofDocumentProps, null);
        n86.d(px0, "actionUserProofsOverview…ment(lProofDocumentProps)");
        vh1.f3649a.a(h.H(this.f2616a), px0);
    }

    @Override // defpackage.uu.a
    public void c(ProofDocumentProps proofDocumentProps) {
        n86.e(proofDocumentProps, "lProofDocumentProps");
        UserProofsOverviewFragment userProofsOverviewFragment = this.f2616a;
        String proofId = proofDocumentProps.getProofId();
        int i = UserProofsOverviewFragment.m;
        Objects.requireNonNull(userProofsOverviewFragment);
        ed1 ed1 = new ed1("edit uploaded proof image clicked", Long.MIN_VALUE);
        ed1.a("proofId", proofId);
        ed1.a(AnalyticsConstants.FLOW, userProofsOverviewFragment.j().f);
        userProofsOverviewFragment.i(ed1);
        ui1.m0(ed1);
        g91 g91 = this.f2616a.g;
        if (g91 != null) {
            String proofId2 = proofDocumentProps.getProofId();
            n86.e(proofId2, "lEditedProofId");
            g91.d = proofId2;
            g91.e = new ProofUploadDetails(null, null, null, null, false, 31, null);
            g91.c.b("keyEditedProofId", proofId2);
            g91.c.b("keyEditedProofUploadDetails", g91.e);
            UserProofsOverviewFragment userProofsOverviewFragment2 = this.f2616a;
            if (ui1.T(userProofsOverviewFragment2.c(), "android.permission.CAMERA")) {
                userProofsOverviewFragment2.k();
            } else if (Build.VERSION.SDK_INT >= 23) {
                r<String> rVar = userProofsOverviewFragment2.j;
                if (rVar != null) {
                    rVar.a("android.permission.CAMERA", null);
                } else {
                    n86.l("requestCameraPermission");
                    throw null;
                }
            } else {
                Toast.makeText(userProofsOverviewFragment2.c(), "Please give camera permission", 1).show();
            }
        } else {
            n86.l("viewModel");
            throw null;
        }
    }

    @Override // defpackage.uu.a
    public void d(String str, View view, boolean z) {
        n86.e(str, "lLocalImageUri");
        n86.e(view, "lView");
        if (this.f2616a.c() != null) {
            UserProofsOverviewFragment userProofsOverviewFragment = this.f2616a;
            int i = UserProofsOverviewFragment.m;
            ed1 ed1 = new ed1("uploaded proof zoomed", Long.MIN_VALUE);
            ed1.a(AnalyticsConstants.FLOW, userProofsOverviewFragment.j().f);
            ed1.a("isRejectedProofImage", Boolean.valueOf(z));
            userProofsOverviewFragment.i(ed1);
            ui1.m0(ed1);
            ZoomedImageViewActivity.i0(userProofsOverviewFragment.c(), (ImageView) view, str, null, true);
        }
    }

    @Override // defpackage.uu.a
    public void e(ProofDocumentProps proofDocumentProps) {
        n86.e(proofDocumentProps, "lProofDocumentProps");
        UserProofsOverviewFragment userProofsOverviewFragment = this.f2616a;
        String proofId = proofDocumentProps.getProofId();
        int i = UserProofsOverviewFragment.m;
        Objects.requireNonNull(userProofsOverviewFragment);
        ed1 ed1 = new ed1("cancel proof image upload clicked", Long.MIN_VALUE);
        ed1.a("proofId", proofId);
        ed1.a(AnalyticsConstants.FLOW, userProofsOverviewFragment.j().f);
        userProofsOverviewFragment.i(ed1);
        ui1.m0(ed1);
        p81 j = this.f2616a.j();
        String proofId2 = proofDocumentProps.getProofId();
        Objects.requireNonNull(j);
        n86.e(proofId2, "lProofId");
        Map<String, ProofUploadDetails> d = j.e().d();
        if (d != null) {
            d.put(proofId2, new ProofUploadDetails(null, null, null, null, false, 31, null));
            j.c.b("keyProofUploadDetailsMap", d);
        }
    }
}

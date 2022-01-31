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
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofsOverviewFragment;
import app.zophop.ui.viewmodels.superpassPurchase.SuperPassPurchaseSharedViewModel;
import com.razorpay.AnalyticsConstants;
import defpackage.uu;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* renamed from: f61  reason: default package */
/* compiled from: SuperPassUserProofsOverviewFragment.kt */
public final class f61 implements uu.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassUserProofsOverviewFragment f1094a;

    public f61(SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment) {
        this.f1094a = superPassUserProofsOverviewFragment;
    }

    @Override // defpackage.uu.a
    public void a(ProofDocumentProps proofDocumentProps) {
        n86.e(proofDocumentProps, "lProofDocumentProps");
        String formUrl = proofDocumentProps.getFormUrl();
        SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment = this.f1094a;
        int i = SuperPassUserProofsOverviewFragment.m;
        Objects.requireNonNull(superPassUserProofsOverviewFragment);
        ed1 ed1 = new ed1("download sample form clicked", Long.MIN_VALUE);
        ed1.a("url", formUrl);
        ed1.a(AnalyticsConstants.FLOW, superPassUserProofsOverviewFragment.j().f);
        superPassUserProofsOverviewFragment.i(ed1);
        ui1.m0(ed1);
        this.f1094a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(formUrl)));
    }

    @Override // defpackage.uu.a
    public void b(ProofDocumentProps proofDocumentProps, boolean z) {
        n86.e(proofDocumentProps, "lProofDocumentProps");
        if (z) {
            SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment = this.f1094a;
            int i = SuperPassUserProofsOverviewFragment.m;
            ed1 ed1 = new ed1("proof guidelines btn clicked", Long.MIN_VALUE);
            ed1.a(AnalyticsConstants.FLOW, superPassUserProofsOverviewFragment.j().f);
            superPassUserProofsOverviewFragment.i(ed1);
            ui1.m0(ed1);
        } else {
            SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment2 = this.f1094a;
            int i2 = SuperPassUserProofsOverviewFragment.m;
            ed1 ed12 = new ed1("add photo btn clicked", Long.MIN_VALUE);
            ed12.a(AnalyticsConstants.FLOW, superPassUserProofsOverviewFragment2.j().f);
            superPassUserProofsOverviewFragment2.i(ed12);
            ui1.m0(ed12);
        }
        h61 h61 = new h61(proofDocumentProps, null);
        n86.d(h61, "actionSuperPassUserProof…ment(lProofDocumentProps)");
        vh1.f3649a.a(h.H(this.f1094a), h61);
    }

    @Override // defpackage.uu.a
    public void c(ProofDocumentProps proofDocumentProps) {
        n86.e(proofDocumentProps, "lProofDocumentProps");
        SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment = this.f1094a;
        String proofId = proofDocumentProps.getProofId();
        int i = SuperPassUserProofsOverviewFragment.m;
        Objects.requireNonNull(superPassUserProofsOverviewFragment);
        ed1 ed1 = new ed1("edit uploaded proof image clicked", Long.MIN_VALUE);
        ed1.a("proofId", proofId);
        ed1.a(AnalyticsConstants.FLOW, superPassUserProofsOverviewFragment.j().f);
        superPassUserProofsOverviewFragment.i(ed1);
        ui1.m0(ed1);
        ga1 ga1 = this.f1094a.g;
        if (ga1 != null) {
            String proofId2 = proofDocumentProps.getProofId();
            n86.e(proofId2, "lEditedProofId");
            ga1.d = proofId2;
            ga1.e = new ProofUploadDetails(null, null, null, null, false, 31, null);
            ga1.c.b("keyEditedProofId", proofId2);
            ga1.c.b("keyEditedProofUploadDetails", ga1.e);
            SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment2 = this.f1094a;
            String[] strArr = {"android.permission.CAMERA"};
            if (ui1.T(superPassUserProofsOverviewFragment2.c(), (String[]) Arrays.copyOf(strArr, 1))) {
                superPassUserProofsOverviewFragment2.k();
            } else if (Build.VERSION.SDK_INT >= 23) {
                r<String[]> rVar = superPassUserProofsOverviewFragment2.j;
                if (rVar != null) {
                    rVar.a(strArr, null);
                } else {
                    n86.l("requestCameraPermission");
                    throw null;
                }
            } else {
                Toast.makeText(superPassUserProofsOverviewFragment2.c(), "Please give camera and storage permissions", 1).show();
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
        if (this.f1094a.c() != null) {
            SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment = this.f1094a;
            int i = SuperPassUserProofsOverviewFragment.m;
            ed1 ed1 = new ed1("uploaded proof zoomed", Long.MIN_VALUE);
            ed1.a(AnalyticsConstants.FLOW, superPassUserProofsOverviewFragment.j().f);
            ed1.a("isRejectedProofImage", Boolean.valueOf(z));
            superPassUserProofsOverviewFragment.i(ed1);
            ui1.m0(ed1);
            ZoomedImageViewActivity.i0(superPassUserProofsOverviewFragment.c(), (ImageView) view, str, null, true);
        }
    }

    @Override // defpackage.uu.a
    public void e(ProofDocumentProps proofDocumentProps) {
        n86.e(proofDocumentProps, "lProofDocumentProps");
        SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment = this.f1094a;
        String proofId = proofDocumentProps.getProofId();
        int i = SuperPassUserProofsOverviewFragment.m;
        Objects.requireNonNull(superPassUserProofsOverviewFragment);
        ed1 ed1 = new ed1("cancel proof image upload clicked", Long.MIN_VALUE);
        ed1.a("proofId", proofId);
        ed1.a(AnalyticsConstants.FLOW, superPassUserProofsOverviewFragment.j().f);
        superPassUserProofsOverviewFragment.i(ed1);
        ui1.m0(ed1);
        SuperPassPurchaseSharedViewModel j = this.f1094a.j();
        String proofId2 = proofDocumentProps.getProofId();
        Objects.requireNonNull(j);
        n86.e(proofId2, "lProofId");
        Map<String, ProofUploadDetails> d = j.d().d();
        if (d != null) {
            d.put(proofId2, new ProofUploadDetails(null, null, null, null, false, 31, null));
            j.c.b("keyProofUploadDetailsMap", d);
        }
    }
}

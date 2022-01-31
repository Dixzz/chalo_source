package defpackage;

import app.zophop.models.mTicketing.ProofUploadDetails;
import app.zophop.models.mTicketing.ProofUploadStatus;
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofsOverviewFragment;
import java.util.Map;

/* renamed from: p51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class p51 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassUserProofsOverviewFragment f2768a;

    public /* synthetic */ p51(SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment) {
        this.f2768a = superPassUserProofsOverviewFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment = this.f2768a;
        Map map = (Map) obj;
        int i = SuperPassUserProofsOverviewFragment.m;
        n86.e(superPassUserProofsOverviewFragment, "this$0");
        uu uuVar = superPassUserProofsOverviewFragment.i;
        if (uuVar != null) {
            uuVar.notifyDataSetChanged();
        }
        ga1 ga1 = superPassUserProofsOverviewFragment.g;
        if (ga1 != null) {
            n86.d(map, "lProofUploadDetailsMap");
            n86.e(map, "lProofUploadDetailsMap");
            for (Map.Entry entry : map.entrySet()) {
                if (((ProofUploadDetails) entry.getValue()).getProofUploadStatus() != ProofUploadStatus.UPLOAD_SUCCESSFUL) {
                    ga1.c.b("keyAreAllProofsUploaded", Boolean.FALSE);
                    return;
                }
            }
            ga1.c.b("keyAreAllProofsUploaded", Boolean.TRUE);
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}

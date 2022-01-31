package defpackage;

import app.zophop.models.mTicketing.ProofUploadDetails;
import app.zophop.models.mTicketing.ProofUploadStatus;
import app.zophop.ui.fragments.UserProofsOverviewFragment;
import java.util.Map;

/* renamed from: zs0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class zs0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProofsOverviewFragment f4205a;

    public /* synthetic */ zs0(UserProofsOverviewFragment userProofsOverviewFragment) {
        this.f4205a = userProofsOverviewFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        UserProofsOverviewFragment userProofsOverviewFragment = this.f4205a;
        Map map = (Map) obj;
        int i = UserProofsOverviewFragment.m;
        n86.e(userProofsOverviewFragment, "this$0");
        uu uuVar = userProofsOverviewFragment.i;
        if (uuVar != null) {
            uuVar.notifyDataSetChanged();
        }
        g91 g91 = userProofsOverviewFragment.g;
        if (g91 != null) {
            n86.d(map, "lProofUploadDetailsMap");
            n86.e(map, "lProofUploadDetailsMap");
            for (Map.Entry entry : map.entrySet()) {
                if (((ProofUploadDetails) entry.getValue()).getProofUploadStatus() != ProofUploadStatus.UPLOAD_SUCCESSFUL) {
                    g91.c.b("keyAreAllProofsUploaded", Boolean.FALSE);
                    return;
                }
            }
            g91.c.b("keyAreAllProofsUploaded", Boolean.TRUE);
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}

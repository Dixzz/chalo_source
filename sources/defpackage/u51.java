package defpackage;

import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResult;
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofsOverviewFragment;
import com.theartofdev.edmodo.cropper.CropImageOptions;

/* renamed from: u51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class u51 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassUserProofsOverviewFragment f3455a;

    public /* synthetic */ u51(SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment) {
        this.f3455a = superPassUserProofsOverviewFragment;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment = this.f3455a;
        ActivityResult activityResult = (ActivityResult) obj;
        int i = SuperPassUserProofsOverviewFragment.m;
        n86.e(superPassUserProofsOverviewFragment, "this$0");
        if (activityResult.f == -1) {
            Intent intent = activityResult.g;
            if (intent != null) {
                ga1 ga1 = superPassUserProofsOverviewFragment.g;
                if (ga1 != null) {
                    ga1.e.setProofImageLocalUri(String.valueOf(intent.getData()));
                } else {
                    n86.l("viewModel");
                    throw null;
                }
            }
            ga1 ga12 = superPassUserProofsOverviewFragment.g;
            if (ga12 != null) {
                Uri parse = Uri.parse(ga12.e.getProofImageLocalUri());
                ve activity = superPassUserProofsOverviewFragment.c();
                if (activity != null) {
                    wf5 h = hd3.h(parse);
                    CropImageOptions cropImageOptions = h.b;
                    cropImageOptions.T = true;
                    cropImageOptions.U = false;
                    cropImageOptions.Z = "Done";
                    Intent a2 = h.a(activity);
                    r<Intent> rVar = superPassUserProofsOverviewFragment.l;
                    if (rVar != null) {
                        rVar.a(a2, null);
                    } else {
                        n86.l("photoCropper");
                        throw null;
                    }
                }
            } else {
                n86.l("viewModel");
                throw null;
            }
        }
    }
}

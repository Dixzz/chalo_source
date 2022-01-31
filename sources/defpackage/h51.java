package defpackage;

import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResult;
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofUploadFragment;
import com.theartofdev.edmodo.cropper.CropImageOptions;

/* renamed from: h51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class h51 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassUserProofUploadFragment f1341a;

    public /* synthetic */ h51(SuperPassUserProofUploadFragment superPassUserProofUploadFragment) {
        this.f1341a = superPassUserProofUploadFragment;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        SuperPassUserProofUploadFragment superPassUserProofUploadFragment = this.f1341a;
        ActivityResult activityResult = (ActivityResult) obj;
        int i = SuperPassUserProofUploadFragment.m;
        n86.e(superPassUserProofUploadFragment, "this$0");
        if (activityResult.f == -1) {
            Intent intent = activityResult.g;
            if (intent != null) {
                fa1 fa1 = superPassUserProofUploadFragment.g;
                if (fa1 != null) {
                    fa1.d(String.valueOf(intent.getData()));
                } else {
                    n86.l("viewModel");
                    throw null;
                }
            }
            fa1 fa12 = superPassUserProofUploadFragment.g;
            if (fa12 != null) {
                Uri parse = Uri.parse(fa12.e);
                ve activity = superPassUserProofUploadFragment.c();
                if (activity != null) {
                    wf5 h = hd3.h(parse);
                    CropImageOptions cropImageOptions = h.b;
                    cropImageOptions.T = true;
                    cropImageOptions.U = false;
                    cropImageOptions.Z = "Done";
                    Intent a2 = h.a(activity);
                    r<Intent> rVar = superPassUserProofUploadFragment.l;
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

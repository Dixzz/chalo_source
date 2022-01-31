package defpackage;

import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResult;
import app.zophop.ui.fragments.UserProofUploadFragment;
import com.theartofdev.edmodo.cropper.CropImageOptions;

/* renamed from: qs0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class qs0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProofUploadFragment f2985a;

    public /* synthetic */ qs0(UserProofUploadFragment userProofUploadFragment) {
        this.f2985a = userProofUploadFragment;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        UserProofUploadFragment userProofUploadFragment = this.f2985a;
        ActivityResult activityResult = (ActivityResult) obj;
        int i = UserProofUploadFragment.m;
        n86.e(userProofUploadFragment, "this$0");
        if (activityResult.f == -1) {
            Intent intent = activityResult.g;
            if (intent != null) {
                f91 f91 = userProofUploadFragment.g;
                if (f91 != null) {
                    f91.d(String.valueOf(intent.getData()));
                } else {
                    n86.l("viewModel");
                    throw null;
                }
            }
            f91 f912 = userProofUploadFragment.g;
            if (f912 != null) {
                Uri parse = Uri.parse(f912.e);
                ve activity = userProofUploadFragment.c();
                if (activity != null) {
                    wf5 h = hd3.h(parse);
                    CropImageOptions cropImageOptions = h.b;
                    cropImageOptions.T = true;
                    cropImageOptions.U = false;
                    Intent a2 = h.a(activity);
                    r<Intent> rVar = userProofUploadFragment.l;
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

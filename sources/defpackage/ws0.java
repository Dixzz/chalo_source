package defpackage;

import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResult;
import app.zophop.ui.fragments.UserProofsOverviewFragment;
import com.theartofdev.edmodo.cropper.CropImageOptions;

/* renamed from: ws0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ws0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProofsOverviewFragment f3832a;

    public /* synthetic */ ws0(UserProofsOverviewFragment userProofsOverviewFragment) {
        this.f3832a = userProofsOverviewFragment;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        UserProofsOverviewFragment userProofsOverviewFragment = this.f3832a;
        ActivityResult activityResult = (ActivityResult) obj;
        int i = UserProofsOverviewFragment.m;
        n86.e(userProofsOverviewFragment, "this$0");
        if (activityResult.f == -1) {
            Intent intent = activityResult.g;
            if (intent != null) {
                g91 g91 = userProofsOverviewFragment.g;
                if (g91 != null) {
                    g91.e.setProofImageLocalUri(String.valueOf(intent.getData()));
                } else {
                    n86.l("viewModel");
                    throw null;
                }
            }
            g91 g912 = userProofsOverviewFragment.g;
            if (g912 != null) {
                Uri parse = Uri.parse(g912.e.getProofImageLocalUri());
                ve activity = userProofsOverviewFragment.c();
                if (activity != null) {
                    wf5 h = hd3.h(parse);
                    CropImageOptions cropImageOptions = h.b;
                    cropImageOptions.T = true;
                    cropImageOptions.U = false;
                    cropImageOptions.Z = "Done";
                    Intent a2 = h.a(activity);
                    r<Intent> rVar = userProofsOverviewFragment.l;
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

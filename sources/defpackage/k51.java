package defpackage;

import android.os.Build;
import android.view.View;
import android.widget.Toast;
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofUploadFragment;
import java.util.Arrays;

/* renamed from: k51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class k51 implements View.OnClickListener {
    public final /* synthetic */ SuperPassUserProofUploadFragment f;

    public /* synthetic */ k51(SuperPassUserProofUploadFragment superPassUserProofUploadFragment) {
        this.f = superPassUserProofUploadFragment;
    }

    public final void onClick(View view) {
        SuperPassUserProofUploadFragment superPassUserProofUploadFragment = this.f;
        int i = SuperPassUserProofUploadFragment.m;
        n86.e(superPassUserProofUploadFragment, "this$0");
        ed1 ed1 = new ed1("upload proof button clicked", Long.MIN_VALUE);
        superPassUserProofUploadFragment.i(ed1);
        ui1.m0(ed1);
        String[] strArr = {"android.permission.CAMERA"};
        if (ui1.T(superPassUserProofUploadFragment.c(), (String[]) Arrays.copyOf(strArr, 1))) {
            superPassUserProofUploadFragment.k();
        } else if (Build.VERSION.SDK_INT >= 23) {
            r<String[]> rVar = superPassUserProofUploadFragment.j;
            if (rVar != null) {
                rVar.a(strArr, null);
                ed1 ed12 = new ed1("camera permission requested", Long.MIN_VALUE);
                superPassUserProofUploadFragment.i(ed12);
                ui1.m0(ed12);
                return;
            }
            n86.l("requestCameraPermission");
            throw null;
        } else {
            Toast.makeText(superPassUserProofUploadFragment.c(), "Please give camera and storage permissions", 1).show();
        }
    }
}

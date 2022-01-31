package defpackage;

import android.app.AlertDialog;
import app.zophop.R;
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofUploadFragment;
import java.util.Map;

/* renamed from: i51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class i51 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassUserProofUploadFragment f1479a;

    public /* synthetic */ i51(SuperPassUserProofUploadFragment superPassUserProofUploadFragment) {
        this.f1479a = superPassUserProofUploadFragment;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        SuperPassUserProofUploadFragment superPassUserProofUploadFragment = this.f1479a;
        Map map = (Map) obj;
        int i = SuperPassUserProofUploadFragment.m;
        n86.e(superPassUserProofUploadFragment, "this$0");
        if (n86.a(map.get("android.permission.CAMERA"), Boolean.TRUE)) {
            superPassUserProofUploadFragment.k();
        } else if (n86.a(map.get("android.permission.CAMERA"), Boolean.FALSE)) {
            ve activity = superPassUserProofUploadFragment.c();
            n86.c(activity);
            if (!t4.d(activity, "android.permission.CAMERA")) {
                String string = superPassUserProofUploadFragment.getString(R.string.camera_storage_prompt);
                n86.d(string, "getString(R.string.camera_storage_prompt)");
                ve activity2 = superPassUserProofUploadFragment.c();
                if (activity2 != null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity2);
                    builder.setMessage(string).setCancelable(true).setPositiveButton(superPassUserProofUploadFragment.getString(R.string.settings), new l51(superPassUserProofUploadFragment, activity2)).setNegativeButton(superPassUserProofUploadFragment.getString(R.string.cancel), new m51(superPassUserProofUploadFragment));
                    builder.create().show();
                }
            }
        }
    }
}

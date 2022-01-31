package defpackage;

import android.app.AlertDialog;
import app.zophop.R;
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofsOverviewFragment;
import java.util.Map;

/* renamed from: v51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class v51 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassUserProofsOverviewFragment f3601a;

    public /* synthetic */ v51(SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment) {
        this.f3601a = superPassUserProofsOverviewFragment;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment = this.f3601a;
        Map map = (Map) obj;
        int i = SuperPassUserProofsOverviewFragment.m;
        n86.e(superPassUserProofsOverviewFragment, "this$0");
        if (n86.a(map.get("android.permission.CAMERA"), Boolean.TRUE)) {
            superPassUserProofsOverviewFragment.k();
        } else if (n86.a(map.get("android.permission.CAMERA"), Boolean.FALSE)) {
            ve activity = superPassUserProofsOverviewFragment.c();
            n86.c(activity);
            if (!t4.d(activity, "android.permission.CAMERA")) {
                String string = superPassUserProofsOverviewFragment.getString(R.string.camera_storage_prompt);
                n86.d(string, "getString(R.string.camera_storage_prompt)");
                ve activity2 = superPassUserProofsOverviewFragment.c();
                if (activity2 != null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity2);
                    builder.setMessage(string).setCancelable(true).setPositiveButton(superPassUserProofsOverviewFragment.getString(R.string.settings), new t51(superPassUserProofsOverviewFragment, activity2)).setNegativeButton(superPassUserProofsOverviewFragment.getString(R.string.cancel), new o51(superPassUserProofsOverviewFragment));
                    builder.create().show();
                }
            }
        }
    }
}

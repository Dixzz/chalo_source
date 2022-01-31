package defpackage;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;

/* renamed from: wr0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class wr0 implements View.OnClickListener {
    public final /* synthetic */ kv0 f;

    public /* synthetic */ wr0(kv0 kv0) {
        this.f = kv0;
    }

    public final void onClick(View view) {
        kv0 kv0 = this.f;
        int i = kv0.n;
        n86.e(kv0, "this$0");
        FragmentManager parentFragmentManager = kv0.getParentFragmentManager();
        String string = kv0.getString(R.string.dialog_message_confirm_reclaim_pass);
        String string2 = kv0.getResources().getString(R.string.yes);
        String string3 = kv0.getResources().getString(R.string.no);
        n86.e("reclaim bookings", "tag");
        hm0 hm0 = null;
        if (parentFragmentManager != null) {
            Fragment I = parentFragmentManager.I("reclaim bookings");
            boolean z = false;
            if (I != null && I.isVisible()) {
                z = true;
            }
            if (!z) {
                hm0 hm02 = new hm0(null);
                Bundle c = hj1.c("extra:message_copy", string, "extra:postive_action_copy", string2);
                if (string3 != null) {
                    c.putString("extra:negative_action_copy", string3);
                }
                hm02.setArguments(c);
                hm02.show(parentFragmentManager, "reclaim bookings");
                hm0 = hm02;
            }
        }
        if (hm0 != null) {
            hm0.m = new ur0(hm0, kv0);
        }
        if (hm0 != null) {
            hm0.n = new sr0(hm0);
        }
    }
}

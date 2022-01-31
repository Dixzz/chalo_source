package defpackage;

import android.content.DialogInterface;
import com.urbanairship.actions.RateAppActivity;

/* renamed from: zk5  reason: default package */
/* compiled from: RateAppActivity */
public class zk5 implements DialogInterface.OnCancelListener {
    public final /* synthetic */ RateAppActivity f;

    public zk5(RateAppActivity rateAppActivity) {
        this.f = rateAppActivity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        dialogInterface.cancel();
        this.f.finish();
    }
}

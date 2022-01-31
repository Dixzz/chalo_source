package defpackage;

import android.content.DialogInterface;
import com.urbanairship.actions.RateAppActivity;

/* renamed from: yk5  reason: default package */
/* compiled from: RateAppActivity */
public class yk5 implements DialogInterface.OnClickListener {
    public final /* synthetic */ RateAppActivity f;

    public yk5(RateAppActivity rateAppActivity) {
        this.f = rateAppActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        this.f.finish();
    }
}

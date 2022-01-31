package defpackage;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.urbanairship.actions.RateAppActivity;

/* renamed from: xk5  reason: default package */
/* compiled from: RateAppActivity */
public class xk5 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Uri f;
    public final /* synthetic */ RateAppActivity g;

    public xk5(RateAppActivity rateAppActivity, Uri uri) {
        this.g = rateAppActivity;
        this.f = uri;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.g.startActivity(new Intent("android.intent.action.VIEW", this.f));
        } catch (ActivityNotFoundException e) {
            yj5.e(e, "No web browser available to handle request to open the store link.", new Object[0]);
        }
        dialogInterface.cancel();
        this.g.finish();
    }
}

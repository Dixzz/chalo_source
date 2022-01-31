package defpackage;

import android.os.Bundle;
import com.urbanairship.Autopilot;
import com.urbanairship.iam.DisplayHandler;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.iam.assets.Assets;

/* renamed from: fr5  reason: default package */
/* compiled from: InAppMessageActivity */
public abstract class fr5 extends dl5 {
    public DisplayHandler h;
    public InAppMessage i;
    public Assets j;
    public long k = 0;
    public long l = 0;

    public long d0() {
        long j2 = this.l;
        return this.k > 0 ? j2 + (System.currentTimeMillis() - this.k) : j2;
    }

    public abstract void e0(Bundle bundle);

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        super.onBackPressed();
        this.h.a(xr5.c(), d0());
        finish();
    }

    @Override // androidx.activity.ComponentActivity, defpackage.dl5, defpackage.ve, defpackage.y4
    public void onCreate(Bundle bundle) {
        Autopilot.e(getApplicationContext());
        super.onCreate(bundle);
        if (getIntent() == null || getIntent().getExtras() == null) {
            finish();
            return;
        }
        this.h = (DisplayHandler) getIntent().getParcelableExtra("display_handler");
        this.i = (InAppMessage) getIntent().getParcelableExtra("in_app_message");
        this.j = (Assets) getIntent().getParcelableExtra("assets");
        DisplayHandler displayHandler = this.h;
        if (displayHandler == null || this.i == null) {
            yj5.c("%s unable to show message. Missing display handler or in-app message", getClass());
            finish();
        } else if (!displayHandler.c(this)) {
            finish();
        } else {
            if (bundle != null) {
                this.l = bundle.getLong("display_time", 0);
            }
            e0(bundle);
        }
    }

    @Override // defpackage.ve
    public void onPause() {
        super.onPause();
        this.l = (System.currentTimeMillis() - this.k) + this.l;
        this.k = 0;
    }

    @Override // defpackage.dl5
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (!this.h.c(this)) {
            finish();
        }
    }

    @Override // defpackage.ve
    public void onResume() {
        super.onResume();
        this.k = System.currentTimeMillis();
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("display_time", this.l);
    }
}

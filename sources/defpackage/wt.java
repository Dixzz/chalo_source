package defpackage;

import android.os.Bundle;
import android.view.MenuItem;

/* renamed from: wt  reason: default package */
/* compiled from: DeepLinkedActivity */
public abstract class wt extends au {
    public p5 k;

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        ui1.F0(this.k);
        super.onBackPressed();
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve, defpackage.au
    public void onCreate(Bundle bundle) {
        this.k = new p5(this);
        if (new g30(getIntent()).a()) {
            this.k.b(h.R(this));
        }
        super.onCreate(bundle);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        ui1.F0(this.k);
        finish();
        return true;
    }
}

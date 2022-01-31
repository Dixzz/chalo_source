package defpackage;

import android.os.Bundle;
import android.view.MenuItem;
import defpackage.qo;

/* renamed from: xl0  reason: default package */
/* compiled from: DeepLinkedBaseViewModelActivity.kt */
public abstract class xl0<T extends qo> extends tl0<T> {
    public p5 k;

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        ui1.F0(this.k);
        super.onBackPressed();
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve, defpackage.ol0
    public void onCreate(Bundle bundle) {
        this.k = new p5(this);
        if (new g30(getIntent()).a()) {
            this.k.b(h.R(this));
        }
        super.onCreate(bundle);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        n86.e(menuItem, "lItem");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        ui1.F0(this.k);
        finish();
        return true;
    }
}

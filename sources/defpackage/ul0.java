package defpackage;

import android.os.Bundle;
import android.view.View;
import defpackage.qo;

/* renamed from: ul0  reason: default package */
/* compiled from: BaseViewModelFragment.kt */
public abstract class ul0<T extends qo> extends rl0<T> {
    public abstract void f();

    public abstract void g();

    public abstract void h();

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        f();
        h();
        g();
    }
}

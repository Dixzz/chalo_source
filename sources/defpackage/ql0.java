package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import defpackage.qo;

/* renamed from: ql0  reason: default package */
/* compiled from: BaseDialogFragment.kt */
public abstract class ql0<T extends qo> extends ue {
    public T f;

    public abstract T d(LayoutInflater layoutInflater);

    public abstract void e();

    public abstract void f();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n86.e(layoutInflater, "inflater");
        ui1.g(getContext(), xt.f3961a.z().b());
        T d = d(layoutInflater);
        this.f = d;
        if (d == null) {
            return null;
        }
        return d.a();
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        e();
        f();
    }
}

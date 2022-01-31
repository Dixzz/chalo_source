package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import defpackage.qo;

/* renamed from: im0  reason: default package */
/* compiled from: ChaloOrderedDialogFragment.kt */
public abstract class im0<T extends qo> extends ue {
    public final String f;
    public T g;

    public im0() {
        this.f = null;
    }

    public abstract T d(LayoutInflater layoutInflater);

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n86.e(layoutInflater, "inflater");
        ui1.g(getContext(), xt.f3961a.z().b());
        T d = d(layoutInflater);
        this.g = d;
        if (d == null) {
            return null;
        }
        return d.a();
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.g = null;
        if (this.f != null) {
            xt.f3961a.o().a(this.f, true);
        }
    }

    public im0(String str) {
        this.f = str;
    }
}

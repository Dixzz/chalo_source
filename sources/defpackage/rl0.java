package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import defpackage.qo;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: rl0  reason: default package */
/* compiled from: BaseFragment.kt */
public abstract class rl0<T extends qo> extends Fragment {
    public T f;

    public static final m66 d(rl0 rl0) {
        xb6 xb6 = xb6.f3911a;
        return hj1.t0(CoroutineExceptionHandler.a.f, xf6.c);
    }

    public abstract T e();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n86.e(layoutInflater, "inflater");
        ui1.g(getContext(), xt.f3961a.z().b());
        T e = e();
        this.f = e;
        if (e == null) {
            return null;
        }
        return e.a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f = null;
        super.onDestroyView();
    }
}

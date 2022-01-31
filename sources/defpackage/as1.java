package defpackage;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import java.util.HashSet;

/* renamed from: as1  reason: default package */
/* compiled from: SupportRequestManagerFragment */
public class as1 extends Fragment {
    public final mr1 f;
    public final yr1 g = new a();
    public final HashSet<as1> h = new HashSet<>();
    public as1 i;
    public nl1 j;
    public Fragment k;

    /* renamed from: as1$a */
    /* compiled from: SupportRequestManagerFragment */
    public class a implements yr1 {
        public a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + as1.this + "}";
        }
    }

    public as1() {
        mr1 mr1 = new mr1();
        this.f = mr1;
    }

    public final void d(ve veVar) {
        e();
        as1 f2 = gl1.b(veVar).k.f(veVar.getSupportFragmentManager(), null);
        this.i = f2;
        if (f2 != this) {
            f2.h.add(this);
        }
    }

    public final void e() {
        as1 as1 = this.i;
        if (as1 != null) {
            as1.h.remove(this);
            this.i = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            d(c());
        } catch (IllegalStateException unused) {
            Log.isLoggable("SupportRMFragment", 5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f.c();
        e();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.k = null;
        e();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f.e();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.k;
        }
        return hj1.Y(sb, parentFragment, "}");
    }
}

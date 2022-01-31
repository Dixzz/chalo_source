package defpackage;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import java.util.HashSet;

/* renamed from: wr1  reason: default package */
/* compiled from: RequestManagerFragment */
public class wr1 extends Fragment {
    public final mr1 f;
    public final yr1 g = new a();
    public final HashSet<wr1> h = new HashSet<>();
    public nl1 i;
    public wr1 j;
    public Fragment k;

    /* renamed from: wr1$a */
    /* compiled from: RequestManagerFragment */
    public class a implements yr1 {
        public a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + wr1.this + "}";
        }
    }

    public wr1() {
        mr1 mr1 = new mr1();
        this.f = mr1;
    }

    public final void a(Activity activity) {
        b();
        wr1 e = gl1.b(activity).k.e(activity.getFragmentManager(), null);
        this.j = e;
        if (e != this) {
            e.h.add(this);
        }
    }

    public final void b() {
        wr1 wr1 = this.j;
        if (wr1 != null) {
            wr1.h.remove(this);
            this.j = null;
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException unused) {
            Log.isLoggable("RMFragment", 5);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f.c();
        b();
    }

    public void onDetach() {
        super.onDetach();
        b();
    }

    public void onStart() {
        super.onStart();
        this.f.d();
    }

    public void onStop() {
        super.onStop();
        this.f.e();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.k;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }
}

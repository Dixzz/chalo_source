package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import defpackage.b1;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* renamed from: h0  reason: default package */
/* compiled from: AppCompatDelegate */
public abstract class h0 {
    public static final p2<WeakReference<h0>> f = new p2<>(0);
    public static final Object g = new Object();

    public static void r(h0 h0Var) {
        synchronized (g) {
            Iterator<WeakReference<h0>> it = f.iterator();
            while (it.hasNext()) {
                h0 h0Var2 = it.next().get();
                if (h0Var2 == h0Var || h0Var2 == null) {
                    it.remove();
                }
            }
        }
    }

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public Context b(Context context) {
        return context;
    }

    public abstract <T extends View> T c(int i);

    public abstract y d();

    public int e() {
        return -100;
    }

    public abstract MenuInflater f();

    public abstract x g();

    public abstract void h();

    public abstract void i();

    public abstract void j(Configuration configuration);

    public abstract void k(Bundle bundle);

    public abstract void l();

    public abstract void m(Bundle bundle);

    public abstract void n();

    public abstract void o(Bundle bundle);

    public abstract void p();

    public abstract void q();

    public abstract boolean s(int i);

    public abstract void t(int i);

    public abstract void u(View view);

    public abstract void v(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void w(Toolbar toolbar);

    public void x(int i) {
    }

    public abstract void y(CharSequence charSequence);

    public abstract b1 z(b1.a aVar);
}

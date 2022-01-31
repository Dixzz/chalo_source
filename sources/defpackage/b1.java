package defpackage;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: b1  reason: default package */
/* compiled from: ActionMode */
public abstract class b1 {
    public Object f;
    public boolean g;

    /* renamed from: b1$a */
    /* compiled from: ActionMode */
    public interface a {
        void a(b1 b1Var);

        boolean b(b1 b1Var, Menu menu);

        boolean c(b1 b1Var, Menu menu);

        boolean d(b1 b1Var, MenuItem menuItem);
    }

    public abstract void a();

    public abstract View b();

    public abstract Menu c();

    public abstract MenuInflater d();

    public abstract CharSequence e();

    public abstract CharSequence f();

    public abstract void g();

    public abstract boolean h();

    public abstract void i(View view);

    public abstract void j(int i);

    public abstract void k(CharSequence charSequence);

    public abstract void l(int i);

    public abstract void m(CharSequence charSequence);

    public abstract void n(boolean z);
}

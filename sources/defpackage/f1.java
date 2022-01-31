package defpackage;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import defpackage.b1;
import java.util.ArrayList;

/* renamed from: f1  reason: default package */
/* compiled from: SupportActionModeWrapper */
public class f1 extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1055a;
    public final b1 b;

    /* renamed from: f1$a */
    /* compiled from: SupportActionModeWrapper */
    public static class a implements b1.a {

        /* renamed from: a  reason: collision with root package name */
        public final ActionMode.Callback f1056a;
        public final Context b;
        public final ArrayList<f1> c = new ArrayList<>();
        public final u2<Menu, Menu> d = new u2<>();

        public a(Context context, ActionMode.Callback callback) {
            this.b = context;
            this.f1056a = callback;
        }

        @Override // defpackage.b1.a
        public void a(b1 b1Var) {
            this.f1056a.onDestroyActionMode(e(b1Var));
        }

        @Override // defpackage.b1.a
        public boolean b(b1 b1Var, Menu menu) {
            return this.f1056a.onCreateActionMode(e(b1Var), f(menu));
        }

        @Override // defpackage.b1.a
        public boolean c(b1 b1Var, Menu menu) {
            return this.f1056a.onPrepareActionMode(e(b1Var), f(menu));
        }

        @Override // defpackage.b1.a
        public boolean d(b1 b1Var, MenuItem menuItem) {
            return this.f1056a.onActionItemClicked(e(b1Var), new s1(this.b, (r6) menuItem));
        }

        public ActionMode e(b1 b1Var) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                f1 f1Var = this.c.get(i);
                if (f1Var != null && f1Var.b == b1Var) {
                    return f1Var;
                }
            }
            f1 f1Var2 = new f1(this.b, b1Var);
            this.c.add(f1Var2);
            return f1Var2;
        }

        public final Menu f(Menu menu) {
            Menu orDefault = this.d.getOrDefault(menu, null);
            if (orDefault != null) {
                return orDefault;
            }
            x1 x1Var = new x1(this.b, (q6) menu);
            this.d.put(menu, x1Var);
            return x1Var;
        }
    }

    public f1(Context context, b1 b1Var) {
        this.f1055a = context;
        this.b = b1Var;
    }

    public void finish() {
        this.b.a();
    }

    public View getCustomView() {
        return this.b.b();
    }

    public Menu getMenu() {
        return new x1(this.f1055a, (q6) this.b.c());
    }

    public MenuInflater getMenuInflater() {
        return this.b.d();
    }

    public CharSequence getSubtitle() {
        return this.b.e();
    }

    public Object getTag() {
        return this.b.f;
    }

    public CharSequence getTitle() {
        return this.b.f();
    }

    public boolean getTitleOptionalHint() {
        return this.b.g;
    }

    public void invalidate() {
        this.b.g();
    }

    public boolean isTitleOptional() {
        return this.b.h();
    }

    public void setCustomView(View view) {
        this.b.i(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.b.k(charSequence);
    }

    public void setTag(Object obj) {
        this.b.f = obj;
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.b.m(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.b.n(z);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.b.j(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.b.l(i);
    }
}

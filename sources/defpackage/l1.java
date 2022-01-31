package defpackage;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: l1  reason: default package */
/* compiled from: BaseMenuWrapper */
public abstract class l1 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2148a;
    public u2<r6, MenuItem> b;
    public u2<s6, SubMenu> c;

    public l1(Context context) {
        this.f2148a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof r6)) {
            return menuItem;
        }
        r6 r6Var = (r6) menuItem;
        if (this.b == null) {
            this.b = new u2<>();
        }
        MenuItem orDefault = this.b.getOrDefault(menuItem, null);
        if (orDefault != null) {
            return orDefault;
        }
        s1 s1Var = new s1(this.f2148a, r6Var);
        this.b.put(r6Var, s1Var);
        return s1Var;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof s6)) {
            return subMenu;
        }
        s6 s6Var = (s6) subMenu;
        if (this.c == null) {
            this.c = new u2<>();
        }
        SubMenu subMenu2 = this.c.get(s6Var);
        if (subMenu2 != null) {
            return subMenu2;
        }
        b2 b2Var = new b2(this.f2148a, s6Var);
        this.c.put(s6Var, b2Var);
        return b2Var;
    }
}

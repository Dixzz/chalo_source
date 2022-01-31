package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import defpackage.a8;
import java.util.Objects;

/* renamed from: r1  reason: default package */
/* compiled from: MenuItemImpl */
public final class r1 implements r6 {
    public a8 A;
    public MenuItem.OnActionExpandListener B;
    public boolean C = false;
    public ContextMenu.ContextMenuInfo D;

    /* renamed from: a  reason: collision with root package name */
    public final int f3022a;
    public final int b;
    public final int c;
    public final int d;
    public CharSequence e;
    public CharSequence f;
    public Intent g;
    public char h;
    public int i = 4096;
    public char j;
    public int k = 4096;
    public Drawable l;
    public int m = 0;
    public p1 n;
    public a2 o;
    public MenuItem.OnMenuItemClickListener p;
    public CharSequence q;
    public CharSequence r;
    public ColorStateList s = null;
    public PorterDuff.Mode t = null;
    public boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public int x = 16;
    public int y = 0;
    public View z;

    /* renamed from: r1$a */
    /* compiled from: MenuItemImpl */
    public class a implements a8.b {
        public a() {
        }
    }

    public r1(p1 p1Var, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.n = p1Var;
        this.f3022a = i3;
        this.b = i2;
        this.c = i4;
        this.d = i5;
        this.e = charSequence;
        this.y = i6;
    }

    public static void c(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    @Override // defpackage.r6
    public r6 a(a8 a8Var) {
        a8 a8Var2 = this.A;
        if (a8Var2 != null) {
            a8Var2.reset();
        }
        this.z = null;
        this.A = a8Var;
        this.n.q(true);
        a8 a8Var3 = this.A;
        if (a8Var3 != null) {
            a8Var3.setVisibilityListener(new a());
        }
        return this;
    }

    @Override // defpackage.r6
    public a8 b() {
        return this.A;
    }

    @Override // defpackage.r6
    public boolean collapseActionView() {
        if ((this.y & 8) == 0) {
            return false;
        }
        if (this.z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.d(this);
        }
        return false;
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.w && (this.u || this.v)) {
            drawable = h.H0(drawable).mutate();
            if (this.u) {
                drawable.setTintList(this.s);
            }
            if (this.v) {
                drawable.setTintMode(this.t);
            }
            this.w = false;
        }
        return drawable;
    }

    public char e() {
        return this.n.n() ? this.j : this.h;
    }

    @Override // defpackage.r6
    public boolean expandActionView() {
        if (!f()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.n.f(this);
        }
        return false;
    }

    public boolean f() {
        a8 a8Var;
        if ((this.y & 8) == 0) {
            return false;
        }
        if (this.z == null && (a8Var = this.A) != null) {
            this.z = a8Var.onCreateActionView(this);
        }
        if (this.z != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        return (this.x & 32) == 32;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // defpackage.r6
    public View getActionView() {
        View view = this.z;
        if (view != null) {
            return view;
        }
        a8 a8Var = this.A;
        if (a8Var == null) {
            return null;
        }
        View onCreateActionView = a8Var.onCreateActionView(this);
        this.z = onCreateActionView;
        return onCreateActionView;
    }

    @Override // defpackage.r6
    public int getAlphabeticModifiers() {
        return this.k;
    }

    public char getAlphabeticShortcut() {
        return this.j;
    }

    @Override // defpackage.r6
    public CharSequence getContentDescription() {
        return this.q;
    }

    public int getGroupId() {
        return this.b;
    }

    public Drawable getIcon() {
        Drawable drawable = this.l;
        if (drawable != null) {
            return d(drawable);
        }
        int i2 = this.m;
        if (i2 == 0) {
            return null;
        }
        Drawable b2 = u0.b(this.n.f2757a, i2);
        this.m = 0;
        this.l = b2;
        return d(b2);
    }

    @Override // defpackage.r6
    public ColorStateList getIconTintList() {
        return this.s;
    }

    @Override // defpackage.r6
    public PorterDuff.Mode getIconTintMode() {
        return this.t;
    }

    public Intent getIntent() {
        return this.g;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f3022a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.D;
    }

    @Override // defpackage.r6
    public int getNumericModifiers() {
        return this.i;
    }

    public char getNumericShortcut() {
        return this.h;
    }

    public int getOrder() {
        return this.c;
    }

    public SubMenu getSubMenu() {
        return this.o;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f;
        return charSequence != null ? charSequence : this.e;
    }

    @Override // defpackage.r6
    public CharSequence getTooltipText() {
        return this.r;
    }

    public boolean h() {
        return (this.x & 4) != 0;
    }

    public boolean hasSubMenu() {
        return this.o != null;
    }

    public r6 i(View view) {
        int i2;
        this.z = view;
        this.A = null;
        if (view != null && view.getId() == -1 && (i2 = this.f3022a) > 0) {
            view.setId(i2);
        }
        this.n.p();
        return this;
    }

    @Override // defpackage.r6
    public boolean isActionViewExpanded() {
        return this.C;
    }

    public boolean isCheckable() {
        return (this.x & 1) == 1;
    }

    public boolean isChecked() {
        return (this.x & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.x & 16) != 0;
    }

    public boolean isVisible() {
        a8 a8Var = this.A;
        if (a8Var == null || !a8Var.overridesItemVisibility()) {
            if ((this.x & 8) == 0) {
                return true;
            }
            return false;
        } else if ((this.x & 8) != 0 || !this.A.isVisible()) {
            return false;
        } else {
            return true;
        }
    }

    public void j(boolean z2) {
        int i2 = this.x;
        int i3 = (z2 ? 2 : 0) | (i2 & -3);
        this.x = i3;
        if (i2 != i3) {
            this.n.q(false);
        }
    }

    public void k(boolean z2) {
        if (z2) {
            this.x |= 32;
        } else {
            this.x &= -33;
        }
    }

    public boolean l(boolean z2) {
        int i2 = this.x;
        int i3 = (z2 ? 0 : 8) | (i2 & -9);
        this.x = i3;
        if (i2 != i3) {
            return true;
        }
        return false;
    }

    public boolean m() {
        return this.n.o() && e() != 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // defpackage.r6, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        i(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.j == c2) {
            return this;
        }
        this.j = Character.toLowerCase(c2);
        this.n.q(false);
        return this;
    }

    public MenuItem setCheckable(boolean z2) {
        int i2 = this.x;
        int i3 = (z2 ? 1 : 0) | (i2 & -2);
        this.x = i3;
        if (i2 != i3) {
            this.n.q(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z2) {
        if ((this.x & 4) != 0) {
            p1 p1Var = this.n;
            Objects.requireNonNull(p1Var);
            int groupId = getGroupId();
            int size = p1Var.f.size();
            p1Var.A();
            for (int i2 = 0; i2 < size; i2++) {
                r1 r1Var = p1Var.f.get(i2);
                if (r1Var.b == groupId && r1Var.h() && r1Var.isCheckable()) {
                    r1Var.j(r1Var == this);
                }
            }
            p1Var.z();
        } else {
            j(z2);
        }
        return this;
    }

    @Override // defpackage.r6
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.q = charSequence;
        this.n.q(false);
        return this;
    }

    public MenuItem setEnabled(boolean z2) {
        if (z2) {
            this.x |= 16;
        } else {
            this.x &= -17;
        }
        this.n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.m = 0;
        this.l = drawable;
        this.w = true;
        this.n.q(false);
        return this;
    }

    @Override // defpackage.r6
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.s = colorStateList;
        this.u = true;
        this.w = true;
        this.n.q(false);
        return this;
    }

    @Override // defpackage.r6
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.t = mode;
        this.v = true;
        this.w = true;
        this.n.q(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        if (this.h == c2) {
            return this;
        }
        this.h = c2;
        this.n.q(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.B = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.p = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.h = c2;
        this.j = Character.toLowerCase(c3);
        this.n.q(false);
        return this;
    }

    @Override // defpackage.r6
    public void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            this.y = i2;
            this.n.p();
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    @Override // defpackage.r6
    public MenuItem setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        this.n.q(false);
        a2 a2Var = this.o;
        if (a2Var != null) {
            a2Var.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        this.n.q(false);
        return this;
    }

    @Override // defpackage.r6
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.r = charSequence;
        this.n.q(false);
        return this;
    }

    public MenuItem setVisible(boolean z2) {
        if (l(z2)) {
            p1 p1Var = this.n;
            p1Var.h = true;
            p1Var.q(true);
        }
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // defpackage.r6, android.view.MenuItem
    public MenuItem setActionView(int i2) {
        Context context = this.n.f2757a;
        i(LayoutInflater.from(context).inflate(i2, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    @Override // defpackage.r6
    /* renamed from: setContentDescription  reason: collision with other method in class */
    public r6 m31setContentDescription(CharSequence charSequence) {
        this.q = charSequence;
        this.n.q(false);
        return this;
    }

    @Override // defpackage.r6
    /* renamed from: setTooltipText  reason: collision with other method in class */
    public r6 m32setTooltipText(CharSequence charSequence) {
        this.r = charSequence;
        this.n.q(false);
        return this;
    }

    @Override // defpackage.r6
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.j == c2 && this.k == i2) {
            return this;
        }
        this.j = Character.toLowerCase(c2);
        this.k = KeyEvent.normalizeMetaState(i2);
        this.n.q(false);
        return this;
    }

    @Override // defpackage.r6
    public MenuItem setNumericShortcut(char c2, int i2) {
        if (this.h == c2 && this.i == i2) {
            return this;
        }
        this.h = c2;
        this.i = KeyEvent.normalizeMetaState(i2);
        this.n.q(false);
        return this;
    }

    @Override // defpackage.r6
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.h = c2;
        this.i = KeyEvent.normalizeMetaState(i2);
        this.j = Character.toLowerCase(c3);
        this.k = KeyEvent.normalizeMetaState(i3);
        this.n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.l = null;
        this.m = i2;
        this.w = true;
        this.n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        setTitle(this.n.f2757a.getString(i2));
        return this;
    }
}

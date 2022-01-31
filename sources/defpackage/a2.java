package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import defpackage.p1;

/* renamed from: a2  reason: default package */
/* compiled from: SubMenuBuilder */
public class a2 extends p1 implements SubMenu {
    public r1 A;
    public p1 z;

    public a2(Context context, p1 p1Var, r1 r1Var) {
        super(context);
        this.z = p1Var;
        this.A = r1Var;
    }

    @Override // defpackage.p1
    public boolean d(r1 r1Var) {
        return this.z.d(r1Var);
    }

    @Override // defpackage.p1
    public boolean e(p1 p1Var, MenuItem menuItem) {
        return super.e(p1Var, menuItem) || this.z.e(p1Var, menuItem);
    }

    @Override // defpackage.p1
    public boolean f(r1 r1Var) {
        return this.z.f(r1Var);
    }

    public MenuItem getItem() {
        return this.A;
    }

    @Override // defpackage.p1
    public String j() {
        r1 r1Var = this.A;
        int i = r1Var != null ? r1Var.f3022a : 0;
        if (i == 0) {
            return null;
        }
        return "android:menu:actionviewstates" + ProductDiscountsObject.KEY_DELIMITER + i;
    }

    @Override // defpackage.p1
    public p1 k() {
        return this.z.k();
    }

    @Override // defpackage.p1
    public boolean m() {
        return this.z.m();
    }

    @Override // defpackage.p1
    public boolean n() {
        return this.z.n();
    }

    @Override // defpackage.p1
    public boolean o() {
        return this.z.o();
    }

    @Override // defpackage.p1
    public void setGroupDividerEnabled(boolean z2) {
        this.z.setGroupDividerEnabled(z2);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        y(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        y(0, charSequence, 0, null, null);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        y(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.A.setIcon(drawable);
        return this;
    }

    @Override // defpackage.p1
    public void setQwertyMode(boolean z2) {
        this.z.setQwertyMode(z2);
    }

    @Override // defpackage.p1
    public void x(p1.a aVar) {
        this.z.x(aVar);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        y(0, null, i, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        y(i, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.A.setIcon(i);
        return this;
    }
}

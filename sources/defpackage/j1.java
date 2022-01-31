package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import defpackage.q5;

/* renamed from: j1  reason: default package */
/* compiled from: ActionMenuItem */
public class j1 implements r6 {

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f1861a;
    public CharSequence b;
    public Intent c;
    public char d;
    public int e = 4096;
    public char f;
    public int g = 4096;
    public Drawable h;
    public Context i;
    public CharSequence j;
    public CharSequence k;
    public ColorStateList l = null;
    public PorterDuff.Mode m = null;
    public boolean n = false;
    public boolean o = false;
    public int p = 16;

    public j1(Context context, int i2, int i3, int i4, CharSequence charSequence) {
        this.i = context;
        this.f1861a = charSequence;
    }

    @Override // defpackage.r6
    public r6 a(a8 a8Var) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.r6
    public a8 b() {
        return null;
    }

    public final void c() {
        Drawable drawable = this.h;
        if (drawable == null) {
            return;
        }
        if (this.n || this.o) {
            Drawable H0 = h.H0(drawable);
            this.h = H0;
            Drawable mutate = H0.mutate();
            this.h = mutate;
            if (this.n) {
                mutate.setTintList(this.l);
            }
            if (this.o) {
                this.h.setTintMode(this.m);
            }
        }
    }

    @Override // defpackage.r6
    public boolean collapseActionView() {
        return false;
    }

    @Override // defpackage.r6
    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.r6
    public View getActionView() {
        return null;
    }

    @Override // defpackage.r6
    public int getAlphabeticModifiers() {
        return this.g;
    }

    public char getAlphabeticShortcut() {
        return this.f;
    }

    @Override // defpackage.r6
    public CharSequence getContentDescription() {
        return this.j;
    }

    public int getGroupId() {
        return 0;
    }

    public Drawable getIcon() {
        return this.h;
    }

    @Override // defpackage.r6
    public ColorStateList getIconTintList() {
        return this.l;
    }

    @Override // defpackage.r6
    public PorterDuff.Mode getIconTintMode() {
        return this.m;
    }

    public Intent getIntent() {
        return this.c;
    }

    public int getItemId() {
        return 16908332;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // defpackage.r6
    public int getNumericModifiers() {
        return this.e;
    }

    public char getNumericShortcut() {
        return this.d;
    }

    public int getOrder() {
        return 0;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f1861a;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.b;
        return charSequence != null ? charSequence : this.f1861a;
    }

    @Override // defpackage.r6
    public CharSequence getTooltipText() {
        return this.k;
    }

    public boolean hasSubMenu() {
        return false;
    }

    @Override // defpackage.r6
    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.p & 1) != 0;
    }

    public boolean isChecked() {
        return (this.p & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.p & 16) != 0;
    }

    public boolean isVisible() {
        return (this.p & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.r6, android.view.MenuItem
    public MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.f = Character.toLowerCase(c2);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.p = (z ? 1 : 0) | (this.p & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.p = (z ? 2 : 0) | (this.p & -3);
        return this;
    }

    @Override // defpackage.r6
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.j = charSequence;
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.p = (z ? 16 : 0) | (this.p & -17);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.h = drawable;
        c();
        return this;
    }

    @Override // defpackage.r6
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.l = colorStateList;
        this.n = true;
        c();
        return this;
    }

    @Override // defpackage.r6
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.m = mode;
        this.o = true;
        c();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.c = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.d = c2;
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.d = c2;
        this.f = Character.toLowerCase(c3);
        return this;
    }

    @Override // defpackage.r6
    public void setShowAsAction(int i2) {
    }

    @Override // defpackage.r6
    public MenuItem setShowAsActionFlags(int i2) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1861a = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.b = charSequence;
        return this;
    }

    @Override // defpackage.r6
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.k = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        int i2 = 8;
        int i3 = this.p & 8;
        if (z) {
            i2 = 0;
        }
        this.p = i3 | i2;
        return this;
    }

    @Override // defpackage.r6, android.view.MenuItem
    public MenuItem setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.r6
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f = Character.toLowerCase(c2);
        this.g = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // defpackage.r6
    /* renamed from: setContentDescription  reason: collision with other method in class */
    public r6 m28setContentDescription(CharSequence charSequence) {
        this.j = charSequence;
        return this;
    }

    @Override // defpackage.r6
    public MenuItem setNumericShortcut(char c2, int i2) {
        this.d = c2;
        this.e = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        this.f1861a = this.i.getResources().getString(i2);
        return this;
    }

    @Override // defpackage.r6
    /* renamed from: setTooltipText  reason: collision with other method in class */
    public r6 m29setTooltipText(CharSequence charSequence) {
        this.k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        Context context = this.i;
        Object obj = q5.f2896a;
        this.h = q5.c.b(context, i2);
        c();
        return this;
    }

    @Override // defpackage.r6
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.d = c2;
        this.e = KeyEvent.normalizeMetaState(i2);
        this.f = Character.toLowerCase(c3);
        this.g = KeyEvent.normalizeMetaState(i3);
        return this;
    }
}

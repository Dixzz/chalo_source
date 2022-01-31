package defpackage;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import defpackage.b1;
import defpackage.p1;
import java.lang.ref.WeakReference;

/* renamed from: e1  reason: default package */
/* compiled from: StandaloneActionMode */
public class e1 extends b1 implements p1.a {
    public Context h;
    public ActionBarContextView i;
    public b1.a j;
    public WeakReference<View> k;
    public boolean l;
    public p1 m;

    public e1(Context context, ActionBarContextView actionBarContextView, b1.a aVar, boolean z) {
        this.h = context;
        this.i = actionBarContextView;
        this.j = aVar;
        p1 p1Var = new p1(actionBarContextView.getContext());
        p1Var.l = 1;
        this.m = p1Var;
        p1Var.e = this;
    }

    @Override // defpackage.b1
    public void a() {
        if (!this.l) {
            this.l = true;
            this.i.sendAccessibilityEvent(32);
            this.j.a(this);
        }
    }

    @Override // defpackage.b1
    public View b() {
        WeakReference<View> weakReference = this.k;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // defpackage.b1
    public Menu c() {
        return this.m;
    }

    @Override // defpackage.b1
    public MenuInflater d() {
        return new g1(this.i.getContext());
    }

    @Override // defpackage.b1
    public CharSequence e() {
        return this.i.getSubtitle();
    }

    @Override // defpackage.b1
    public CharSequence f() {
        return this.i.getTitle();
    }

    @Override // defpackage.b1
    public void g() {
        this.j.c(this, this.m);
    }

    @Override // defpackage.b1
    public boolean h() {
        return this.i.isTitleOptional();
    }

    @Override // defpackage.b1
    public void i(View view) {
        this.i.setCustomView(view);
        this.k = view != null ? new WeakReference<>(view) : null;
    }

    @Override // defpackage.b1
    public void j(int i2) {
        this.i.setSubtitle(this.h.getString(i2));
    }

    @Override // defpackage.b1
    public void k(CharSequence charSequence) {
        this.i.setSubtitle(charSequence);
    }

    @Override // defpackage.b1
    public void l(int i2) {
        this.i.setTitle(this.h.getString(i2));
    }

    @Override // defpackage.b1
    public void m(CharSequence charSequence) {
        this.i.setTitle(charSequence);
    }

    @Override // defpackage.b1
    public void n(boolean z) {
        this.g = z;
        this.i.setTitleOptional(z);
    }

    @Override // defpackage.p1.a
    public boolean onMenuItemSelected(p1 p1Var, MenuItem menuItem) {
        return this.j.d(this, menuItem);
    }

    @Override // defpackage.p1.a
    public void onMenuModeChange(p1 p1Var) {
        g();
        this.i.showOverflowMenu();
    }
}

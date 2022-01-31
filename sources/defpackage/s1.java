package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import defpackage.a8;
import java.lang.reflect.Method;

/* renamed from: s1  reason: default package */
/* compiled from: MenuItemWrapperICS */
public class s1 extends l1 implements MenuItem {
    public final r6 d;
    public Method e;

    /* renamed from: s1$a */
    /* compiled from: MenuItemWrapperICS */
    public class a extends a8 {

        /* renamed from: a  reason: collision with root package name */
        public final ActionProvider f3163a;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f3163a = actionProvider;
        }

        @Override // defpackage.a8
        public boolean hasSubMenu() {
            return this.f3163a.hasSubMenu();
        }

        @Override // defpackage.a8
        public View onCreateActionView() {
            return this.f3163a.onCreateActionView();
        }

        @Override // defpackage.a8
        public boolean onPerformDefaultAction() {
            return this.f3163a.onPerformDefaultAction();
        }

        @Override // defpackage.a8
        public void onPrepareSubMenu(SubMenu subMenu) {
            this.f3163a.onPrepareSubMenu(s1.this.d(subMenu));
        }
    }

    /* renamed from: s1$b */
    /* compiled from: MenuItemWrapperICS */
    public class b extends a implements ActionProvider.VisibilityListener {
        public a8.b c;

        public b(s1 s1Var, Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // defpackage.a8
        public boolean isVisible() {
            return this.f3163a.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            a8.b bVar = this.c;
            if (bVar != null) {
                p1 p1Var = r1.this.n;
                p1Var.h = true;
                p1Var.q(true);
            }
        }

        @Override // defpackage.a8
        public View onCreateActionView(MenuItem menuItem) {
            return this.f3163a.onCreateActionView(menuItem);
        }

        @Override // defpackage.a8
        public boolean overridesItemVisibility() {
            return this.f3163a.overridesItemVisibility();
        }

        @Override // defpackage.a8
        public void refreshVisibility() {
            this.f3163a.refreshVisibility();
        }

        @Override // defpackage.a8
        public void setVisibilityListener(a8.b bVar) {
            this.c = bVar;
            this.f3163a.setVisibilityListener(this);
        }
    }

    /* renamed from: s1$c */
    /* compiled from: MenuItemWrapperICS */
    public static class c extends FrameLayout implements c1 {
        public final CollapsibleActionView f;

        public c(View view) {
            super(view.getContext());
            this.f = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // defpackage.c1
        public void onActionViewCollapsed() {
            this.f.onActionViewCollapsed();
        }

        @Override // defpackage.c1
        public void onActionViewExpanded() {
            this.f.onActionViewExpanded();
        }
    }

    /* renamed from: s1$d */
    /* compiled from: MenuItemWrapperICS */
    public class d implements MenuItem.OnActionExpandListener {

        /* renamed from: a  reason: collision with root package name */
        public final MenuItem.OnActionExpandListener f3164a;

        public d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f3164a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f3164a.onMenuItemActionCollapse(s1.this.c(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f3164a.onMenuItemActionExpand(s1.this.c(menuItem));
        }
    }

    /* renamed from: s1$e */
    /* compiled from: MenuItemWrapperICS */
    public class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final MenuItem.OnMenuItemClickListener f3165a;

        public e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f3165a = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f3165a.onMenuItemClick(s1.this.c(menuItem));
        }
    }

    public s1(Context context, r6 r6Var) {
        super(context);
        if (r6Var != null) {
            this.d = r6Var;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.d.collapseActionView();
    }

    public boolean expandActionView() {
        return this.d.expandActionView();
    }

    public ActionProvider getActionProvider() {
        a8 b2 = this.d.b();
        if (b2 instanceof a) {
            return ((a) b2).f3163a;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.d.getActionView();
        return actionView instanceof c ? (View) ((c) actionView).f : actionView;
    }

    public int getAlphabeticModifiers() {
        return this.d.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.d.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.d.getContentDescription();
    }

    public int getGroupId() {
        return this.d.getGroupId();
    }

    public Drawable getIcon() {
        return this.d.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.d.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.d.getIconTintMode();
    }

    public Intent getIntent() {
        return this.d.getIntent();
    }

    public int getItemId() {
        return this.d.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.d.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.d.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.d.getNumericShortcut();
    }

    public int getOrder() {
        return this.d.getOrder();
    }

    public SubMenu getSubMenu() {
        return d(this.d.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.d.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.d.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.d.getTooltipText();
    }

    public boolean hasSubMenu() {
        return this.d.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.d.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.d.isCheckable();
    }

    public boolean isChecked() {
        return this.d.isChecked();
    }

    public boolean isEnabled() {
        return this.d.isEnabled();
    }

    public boolean isVisible() {
        return this.d.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this, this.f2148a, actionProvider);
        r6 r6Var = this.d;
        if (actionProvider == null) {
            bVar = null;
        }
        r6Var.a(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.d.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.d.setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.d.setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.d.setChecked(z);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.d.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.d.setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.d.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.d.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.d.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.d.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.d.setNumericShortcut(c2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.d.setShortcut(c2, c3);
        return this;
    }

    public void setShowAsAction(int i) {
        this.d.setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        this.d.setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.d.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.d.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.d.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return this.d.setVisible(z);
    }

    public MenuItem setAlphabeticShortcut(char c2, int i) {
        this.d.setAlphabeticShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.d.setIcon(i);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i) {
        this.d.setNumericShortcut(c2, i);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.d.setShortcut(c2, c3, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.d.setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        this.d.setActionView(i);
        View actionView = this.d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.d.setActionView(new c(actionView));
        }
        return this;
    }
}

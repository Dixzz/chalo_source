package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: x1  reason: default package */
/* compiled from: MenuWrapperICS */
public class x1 extends l1 implements Menu {
    public final q6 d;

    public x1(Context context, q6 q6Var) {
        super(context);
        if (q6Var != null) {
            this.d = q6Var;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return c(this.d.add(charSequence));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int addIntentOptions = this.d.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = c(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return d(this.d.addSubMenu(charSequence));
    }

    public void clear() {
        u2<r6, MenuItem> u2Var = this.b;
        if (u2Var != null) {
            u2Var.clear();
        }
        u2<s6, SubMenu> u2Var2 = this.c;
        if (u2Var2 != null) {
            u2Var2.clear();
        }
        this.d.clear();
    }

    public void close() {
        this.d.close();
    }

    public MenuItem findItem(int i) {
        return c(this.d.findItem(i));
    }

    public MenuItem getItem(int i) {
        return c(this.d.getItem(i));
    }

    public boolean hasVisibleItems() {
        return this.d.hasVisibleItems();
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.d.isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return this.d.performIdentifierAction(i, i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.d.performShortcut(i, keyEvent, i2);
    }

    public void removeGroup(int i) {
        if (this.b != null) {
            int i2 = 0;
            while (true) {
                u2<r6, MenuItem> u2Var = this.b;
                if (i2 >= u2Var.h) {
                    break;
                }
                if (u2Var.h(i2).getGroupId() == i) {
                    this.b.j(i2);
                    i2--;
                }
                i2++;
            }
        }
        this.d.removeGroup(i);
    }

    public void removeItem(int i) {
        if (this.b != null) {
            int i2 = 0;
            while (true) {
                u2<r6, MenuItem> u2Var = this.b;
                if (i2 >= u2Var.h) {
                    break;
                } else if (u2Var.h(i2).getItemId() == i) {
                    this.b.j(i2);
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.d.removeItem(i);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.d.setGroupCheckable(i, z, z2);
    }

    public void setGroupEnabled(int i, boolean z) {
        this.d.setGroupEnabled(i, z);
    }

    public void setGroupVisible(int i, boolean z) {
        this.d.setGroupVisible(i, z);
    }

    public void setQwertyMode(boolean z) {
        this.d.setQwertyMode(z);
    }

    public int size() {
        return this.d.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return c(this.d.add(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return d(this.d.addSubMenu(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return c(this.d.add(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return d(this.d.addSubMenu(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return c(this.d.add(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return d(this.d.addSubMenu(i, i2, i3, i4));
    }
}

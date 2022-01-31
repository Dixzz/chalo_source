package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import defpackage.q5;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: p1  reason: default package */
/* compiled from: MenuBuilder */
public class p1 implements q6 {
    public static final int[] y = {1, 4, 5, 3, 2, 0};

    /* renamed from: a  reason: collision with root package name */
    public final Context f2757a;
    public final Resources b;
    public boolean c;
    public boolean d;
    public a e;
    public ArrayList<r1> f;
    public ArrayList<r1> g;
    public boolean h;
    public ArrayList<r1> i;
    public ArrayList<r1> j;
    public boolean k;
    public int l = 0;
    public CharSequence m;
    public Drawable n;
    public View o;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public ArrayList<r1> t = new ArrayList<>();
    public CopyOnWriteArrayList<WeakReference<v1>> u = new CopyOnWriteArrayList<>();
    public r1 v;
    public boolean w = false;
    public boolean x;

    /* renamed from: p1$a */
    /* compiled from: MenuBuilder */
    public interface a {
        boolean onMenuItemSelected(p1 p1Var, MenuItem menuItem);

        void onMenuModeChange(p1 p1Var);
    }

    /* renamed from: p1$b */
    /* compiled from: MenuBuilder */
    public interface b {
        boolean invokeItem(r1 r1Var);
    }

    public p1(Context context) {
        boolean z;
        boolean z2 = false;
        this.f2757a = context;
        Resources resources = context.getResources();
        this.b = resources;
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = true;
        this.i = new ArrayList<>();
        this.j = new ArrayList<>();
        this.k = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = x8.f3899a;
            if (Build.VERSION.SDK_INT >= 28) {
                z = viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                z = identifier != 0 && resources2.getBoolean(identifier);
            }
            if (z) {
                z2 = true;
            }
        }
        this.d = z2;
    }

    public void A() {
        if (!this.p) {
            this.p = true;
            this.q = false;
            this.r = false;
        }
    }

    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int i5;
        int i6 = (-65536 & i4) >> 16;
        if (i6 >= 0) {
            int[] iArr = y;
            if (i6 < iArr.length) {
                int i7 = (iArr[i6] << 16) | (65535 & i4);
                r1 r1Var = new r1(this, i2, i3, i4, i7, charSequence, this.l);
                ArrayList<r1> arrayList = this.f;
                int size = arrayList.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        if (arrayList.get(size).d <= i7) {
                            i5 = size + 1;
                            break;
                        }
                    } else {
                        i5 = 0;
                        break;
                    }
                }
                arrayList.add(i5, r1Var);
                q(true);
                return r1Var;
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        PackageManager packageManager = this.f2757a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i7);
            int i8 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i8 < 0 ? intent : intentArr[i8]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            r1 r1Var = (r1) a(i2, i3, i4, resolveInfo.loadLabel(packageManager));
            r1Var.setIcon(resolveInfo.loadIcon(packageManager));
            r1Var.setIntent(intent2);
            if (menuItemArr != null && (i6 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i6] = r1Var;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(v1 v1Var, Context context) {
        this.u.add(new WeakReference<>(v1Var));
        v1Var.initForMenu(context, this);
        this.k = true;
    }

    public final void c(boolean z) {
        if (!this.s) {
            this.s = true;
            Iterator<WeakReference<v1>> it = this.u.iterator();
            while (it.hasNext()) {
                WeakReference<v1> next = it.next();
                v1 v1Var = next.get();
                if (v1Var == null) {
                    this.u.remove(next);
                } else {
                    v1Var.onCloseMenu(this, z);
                }
            }
            this.s = false;
        }
    }

    public void clear() {
        r1 r1Var = this.v;
        if (r1Var != null) {
            d(r1Var);
        }
        this.f.clear();
        q(true);
    }

    public void clearHeader() {
        this.n = null;
        this.m = null;
        this.o = null;
        q(false);
    }

    public void close() {
        c(true);
    }

    public boolean d(r1 r1Var) {
        boolean z = false;
        if (!this.u.isEmpty() && this.v == r1Var) {
            A();
            Iterator<WeakReference<v1>> it = this.u.iterator();
            while (it.hasNext()) {
                WeakReference<v1> next = it.next();
                v1 v1Var = next.get();
                if (v1Var == null) {
                    this.u.remove(next);
                } else {
                    z = v1Var.collapseItemActionView(this, r1Var);
                    if (z) {
                        break;
                    }
                }
            }
            z();
            if (z) {
                this.v = null;
            }
        }
        return z;
    }

    public boolean e(p1 p1Var, MenuItem menuItem) {
        a aVar = this.e;
        return aVar != null && aVar.onMenuItemSelected(p1Var, menuItem);
    }

    public boolean f(r1 r1Var) {
        boolean z = false;
        if (this.u.isEmpty()) {
            return false;
        }
        A();
        Iterator<WeakReference<v1>> it = this.u.iterator();
        while (it.hasNext()) {
            WeakReference<v1> next = it.next();
            v1 v1Var = next.get();
            if (v1Var == null) {
                this.u.remove(next);
            } else {
                z = v1Var.expandItemActionView(this, r1Var);
                if (z) {
                    break;
                }
            }
        }
        z();
        if (z) {
            this.v = r1Var;
        }
        return z;
    }

    public MenuItem findItem(int i2) {
        MenuItem findItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            r1 r1Var = this.f.get(i3);
            if (r1Var.f3022a == i2) {
                return r1Var;
            }
            if (r1Var.hasSubMenu() && (findItem = r1Var.o.findItem(i2)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public r1 g(int i2, KeyEvent keyEvent) {
        char c2;
        ArrayList<r1> arrayList = this.t;
        arrayList.clear();
        h(arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean n2 = n();
        for (int i3 = 0; i3 < size; i3++) {
            r1 r1Var = arrayList.get(i3);
            if (n2) {
                c2 = r1Var.j;
            } else {
                c2 = r1Var.h;
            }
            char[] cArr = keyData.meta;
            if ((c2 == cArr[0] && (metaState & 2) == 0) || ((c2 == cArr[2] && (metaState & 2) != 0) || (n2 && c2 == '\b' && i2 == 67))) {
                return r1Var;
            }
        }
        return null;
    }

    public MenuItem getItem(int i2) {
        return this.f.get(i2);
    }

    public void h(List<r1> list, int i2, KeyEvent keyEvent) {
        char c2;
        int i3;
        boolean n2 = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.f.size();
            for (int i4 = 0; i4 < size; i4++) {
                r1 r1Var = this.f.get(i4);
                if (r1Var.hasSubMenu()) {
                    r1Var.o.h(list, i2, keyEvent);
                }
                if (n2) {
                    c2 = r1Var.j;
                } else {
                    c2 = r1Var.h;
                }
                if (n2) {
                    i3 = r1Var.k;
                } else {
                    i3 = r1Var.i;
                }
                if (((modifiers & 69647) == (i3 & 69647)) && c2 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c2 == cArr[0] || c2 == cArr[2] || (n2 && c2 == '\b' && i2 == 67)) && r1Var.isEnabled()) {
                        list.add(r1Var);
                    }
                }
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.x) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public void i() {
        ArrayList<r1> l2 = l();
        if (this.k) {
            Iterator<WeakReference<v1>> it = this.u.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference<v1> next = it.next();
                v1 v1Var = next.get();
                if (v1Var == null) {
                    this.u.remove(next);
                } else {
                    z |= v1Var.flagActionItems();
                }
            }
            if (z) {
                this.i.clear();
                this.j.clear();
                int size = l2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    r1 r1Var = l2.get(i2);
                    if (r1Var.g()) {
                        this.i.add(r1Var);
                    } else {
                        this.j.add(r1Var);
                    }
                }
            } else {
                this.i.clear();
                this.j.clear();
                this.j.addAll(l());
            }
            this.k = false;
        }
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return g(i2, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public p1 k() {
        return this;
    }

    public ArrayList<r1> l() {
        if (!this.h) {
            return this.g;
        }
        this.g.clear();
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            r1 r1Var = this.f.get(i2);
            if (r1Var.isVisible()) {
                this.g.add(r1Var);
            }
        }
        this.h = false;
        this.k = true;
        return this.g;
    }

    public boolean m() {
        return this.w;
    }

    public boolean n() {
        return this.c;
    }

    public boolean o() {
        return this.d;
    }

    public void p() {
        this.k = true;
        q(true);
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return r(findItem(i2), i3);
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        r1 g2 = g(i2, keyEvent);
        boolean s2 = g2 != null ? s(g2, null, i3) : false;
        if ((i3 & 2) != 0) {
            c(true);
        }
        return s2;
    }

    public void q(boolean z) {
        if (!this.p) {
            if (z) {
                this.h = true;
                this.k = true;
            }
            if (!this.u.isEmpty()) {
                A();
                Iterator<WeakReference<v1>> it = this.u.iterator();
                while (it.hasNext()) {
                    WeakReference<v1> next = it.next();
                    v1 v1Var = next.get();
                    if (v1Var == null) {
                        this.u.remove(next);
                    } else {
                        v1Var.updateMenuView(z);
                    }
                }
                z();
                return;
            }
            return;
        }
        this.q = true;
        if (z) {
            this.r = true;
        }
    }

    public boolean r(MenuItem menuItem, int i2) {
        return s(menuItem, null, i2);
    }

    public void removeGroup(int i2) {
        int size = size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (this.f.get(i3).b == i2) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            int size2 = this.f.size() - i3;
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                if (i4 >= size2 || this.f.get(i3).b != i2) {
                    q(true);
                } else {
                    t(i3, false);
                    i4 = i5;
                }
            }
            q(true);
        }
    }

    public void removeItem(int i2) {
        int size = size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (this.f.get(i3).f3022a == i2) {
                break;
            } else {
                i3++;
            }
        }
        t(i3, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean s(android.view.MenuItem r7, defpackage.v1 r8, int r9) {
        /*
        // Method dump skipped, instructions count: 204
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p1.s(android.view.MenuItem, v1, int):boolean");
    }

    public void setGroupCheckable(int i2, boolean z, boolean z2) {
        int size = this.f.size();
        for (int i3 = 0; i3 < size; i3++) {
            r1 r1Var = this.f.get(i3);
            if (r1Var.b == i2) {
                r1Var.x = (r1Var.x & -5) | (z2 ? 4 : 0);
                r1Var.setCheckable(z);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z) {
        this.w = z;
    }

    public void setGroupEnabled(int i2, boolean z) {
        int size = this.f.size();
        for (int i3 = 0; i3 < size; i3++) {
            r1 r1Var = this.f.get(i3);
            if (r1Var.b == i2) {
                r1Var.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i2, boolean z) {
        int size = this.f.size();
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            r1 r1Var = this.f.get(i3);
            if (r1Var.b == i2 && r1Var.l(z)) {
                z2 = true;
            }
        }
        if (z2) {
            q(true);
        }
    }

    public void setQwertyMode(boolean z) {
        this.c = z;
        q(false);
    }

    public int size() {
        return this.f.size();
    }

    public final void t(int i2, boolean z) {
        if (i2 >= 0 && i2 < this.f.size()) {
            this.f.remove(i2);
            if (z) {
                q(true);
            }
        }
    }

    public void u(v1 v1Var) {
        Iterator<WeakReference<v1>> it = this.u.iterator();
        while (it.hasNext()) {
            WeakReference<v1> next = it.next();
            v1 v1Var2 = next.get();
            if (v1Var2 == null || v1Var2 == v1Var) {
                this.u.remove(next);
            }
        }
    }

    public void v(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = getItem(i2);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((a2) item.getSubMenu()).v(bundle);
                }
            }
            int i3 = bundle.getInt("android:menu:expandedactionview");
            if (i3 > 0 && (findItem = findItem(i3)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void w(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((a2) item.getSubMenu()).w(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public void x(a aVar) {
        this.e = aVar;
    }

    public final void y(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources resources = this.b;
        if (view != null) {
            this.o = view;
            this.m = null;
            this.n = null;
        } else {
            if (i2 > 0) {
                this.m = resources.getText(i2);
            } else if (charSequence != null) {
                this.m = charSequence;
            }
            if (i3 > 0) {
                Context context = this.f2757a;
                Object obj = q5.f2896a;
                this.n = q5.c.b(context, i3);
            } else if (drawable != null) {
                this.n = drawable;
            }
            this.o = null;
        }
        q(false);
    }

    public void z() {
        this.p = false;
        if (this.q) {
            this.q = false;
            q(this.r);
        }
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        return a(0, 0, 0, this.b.getString(i2));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, this.b.getString(i2));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        r1 r1Var = (r1) a(i2, i3, i4, charSequence);
        a2 a2Var = new a2(this.f2757a, this, r1Var);
        r1Var.o = a2Var;
        a2Var.setHeaderTitle(r1Var.e);
        return a2Var;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.b.getString(i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, this.b.getString(i5));
    }
}

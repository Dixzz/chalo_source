package defpackage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import defpackage.mf;
import defpackage.zg;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* renamed from: ke  reason: default package */
/* compiled from: BackStackRecord */
public final class ke extends mf implements FragmentManager.l {
    public final FragmentManager q;
    public boolean r;
    public int s;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ke(androidx.fragment.app.FragmentManager r3) {
        /*
            r2 = this;
            df r0 = r3.K()
            ef<?> r1 = r3.q
            if (r1 == 0) goto L_0x000f
            android.content.Context r1 = r1.g
            java.lang.ClassLoader r1 = r1.getClassLoader()
            goto L_0x0010
        L_0x000f:
            r1 = 0
        L_0x0010:
            r2.<init>(r0, r1)
            r0 = -1
            r2.s = r0
            r2.q = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ke.<init>(androidx.fragment.app.FragmentManager):void");
    }

    @Override // androidx.fragment.app.FragmentManager.l
    public boolean a(ArrayList<ke> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.O(2)) {
            String str = "Run: " + this;
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.g) {
            return true;
        }
        FragmentManager fragmentManager = this.q;
        if (fragmentManager.d == null) {
            fragmentManager.d = new ArrayList<>();
        }
        fragmentManager.d.add(this);
        return true;
    }

    @Override // defpackage.mf
    public int d() {
        return j(false);
    }

    @Override // defpackage.mf
    public void e() {
        if (!this.g) {
            this.h = false;
            this.q.D(this, false);
            return;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    @Override // defpackage.mf
    public void f(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            StringBuilder i0 = hj1.i0("Fragment ");
            i0.append(cls.getCanonicalName());
            i0.append(" must be a public static class to be  properly recreated from instance state.");
            throw new IllegalStateException(i0.toString());
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 == null || str.equals(str2)) {
                fragment.mTag = str;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Can't change tag of fragment ");
                sb.append(fragment);
                sb.append(": was ");
                throw new IllegalStateException(hj1.b0(sb, fragment.mTag, " now ", str));
            }
        }
        if (i != 0) {
            if (i != -1) {
                int i3 = fragment.mFragmentId;
                if (i3 == 0 || i3 == i) {
                    fragment.mFragmentId = i;
                    fragment.mContainerId = i;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        b(new mf.a(i2, fragment));
        fragment.mFragmentManager = this.q;
    }

    public void h(int i) {
        if (this.g) {
            if (FragmentManager.O(2)) {
                String str = "Bump nesting in " + this + " by " + i;
            }
            int size = this.f2365a.size();
            for (int i2 = 0; i2 < size; i2++) {
                mf.a aVar = this.f2365a.get(i2);
                Fragment fragment = aVar.b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    if (FragmentManager.O(2)) {
                        StringBuilder i0 = hj1.i0("Bump nesting of ");
                        i0.append(aVar.b);
                        i0.append(" to ");
                        i0.append(aVar.b.mBackStackNesting);
                        i0.toString();
                    }
                }
            }
        }
    }

    public int i() {
        return j(true);
    }

    public int j(boolean z) {
        if (!this.r) {
            if (FragmentManager.O(2)) {
                String str = "Commit: " + this;
                PrintWriter printWriter = new PrintWriter(new ag("FragmentManager"));
                k("  ", printWriter, true);
                printWriter.close();
            }
            this.r = true;
            if (this.g) {
                this.s = this.q.i.getAndIncrement();
            } else {
                this.s = -1;
            }
            this.q.A(this, z);
            return this.s;
        }
        throw new IllegalStateException("commit already called");
    }

    public void k(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.i);
            printWriter.print(" mIndex=");
            printWriter.print(this.s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.r);
            if (this.f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f));
            }
            if (!(this.b == 0 && this.c == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.c));
            }
            if (!(this.d == 0 && this.e == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (!(this.j == 0 && this.k == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.k);
            }
            if (!(this.l == 0 && this.m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.m);
            }
        }
        if (!this.f2365a.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f2365a.size();
            for (int i = 0; i < size; i++) {
                mf.a aVar = this.f2365a.get(i);
                switch (aVar.f2366a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = cj6.D;
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        StringBuilder i0 = hj1.i0("cmd=");
                        i0.append(aVar.f2366a);
                        str2 = i0.toString();
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.b);
                if (z) {
                    if (!(aVar.c == 0 && aVar.d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.d));
                    }
                    if (aVar.e != 0 || aVar.f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f));
                    }
                }
            }
        }
    }

    public void l() {
        int size = this.f2365a.size();
        for (int i = 0; i < size; i++) {
            mf.a aVar = this.f2365a.get(i);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f);
                fragment.setSharedElementNames(this.n, this.o);
            }
            switch (aVar.f2366a) {
                case 1:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.e0(fragment, false);
                    this.q.a(fragment);
                    break;
                case 2:
                default:
                    StringBuilder i0 = hj1.i0("Unknown cmd: ");
                    i0.append(aVar.f2366a);
                    throw new IllegalArgumentException(i0.toString());
                case 3:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.Z(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.N(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.e0(fragment, false);
                    this.q.i0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.j(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.e0(fragment, false);
                    this.q.c(fragment);
                    break;
                case 8:
                    this.q.g0(fragment);
                    break;
                case 9:
                    this.q.g0(null);
                    break;
                case 10:
                    this.q.f0(fragment, aVar.h);
                    break;
            }
            if (!this.p) {
                int i2 = aVar.f2366a;
            }
        }
    }

    public void m(boolean z) {
        for (int size = this.f2365a.size() - 1; size >= 0; size--) {
            mf.a aVar = this.f2365a.get(size);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.setPopDirection(true);
                int i = this.f;
                int i2 = 8194;
                if (i != 4097) {
                    i2 = i != 4099 ? i != 8194 ? 0 : 4097 : 4099;
                }
                fragment.setNextTransition(i2);
                fragment.setSharedElementNames(this.o, this.n);
            }
            switch (aVar.f2366a) {
                case 1:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.e0(fragment, true);
                    this.q.Z(fragment);
                    break;
                case 2:
                default:
                    StringBuilder i0 = hj1.i0("Unknown cmd: ");
                    i0.append(aVar.f2366a);
                    throw new IllegalArgumentException(i0.toString());
                case 3:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.a(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.i0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.e0(fragment, true);
                    this.q.N(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.c(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.q.e0(fragment, true);
                    this.q.j(fragment);
                    break;
                case 8:
                    this.q.g0(null);
                    break;
                case 9:
                    this.q.g0(fragment);
                    break;
                case 10:
                    this.q.f0(fragment, aVar.g);
                    break;
            }
            if (!this.p) {
                int i3 = aVar.f2366a;
            }
        }
    }

    public boolean n(int i) {
        int size = this.f2365a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f2365a.get(i2).b;
            int i3 = fragment != null ? fragment.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    public boolean o(ArrayList<ke> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f2365a.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.f2365a.get(i4).b;
            int i5 = fragment != null ? fragment.mContainerId : 0;
            if (!(i5 == 0 || i5 == i3)) {
                for (int i6 = i; i6 < i2; i6++) {
                    ke keVar = arrayList.get(i6);
                    int size2 = keVar.f2365a.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = keVar.f2365a.get(i7).b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    public mf p(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.q) {
            b(new mf.a(3, fragment));
            return this;
        }
        StringBuilder i0 = hj1.i0("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
        i0.append(fragment.toString());
        i0.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(i0.toString());
    }

    public mf q(Fragment fragment, zg.b bVar) {
        if (fragment.mFragmentManager != this.q) {
            StringBuilder i0 = hj1.i0("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
            i0.append(this.q);
            throw new IllegalArgumentException(i0.toString());
        } else if (bVar == zg.b.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + bVar + " after the Fragment has been created");
        } else if (bVar != zg.b.DESTROYED) {
            b(new mf.a(10, fragment, bVar));
            return this;
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + bVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    public mf r(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.q) {
            b(new mf.a(8, fragment));
            return this;
        }
        StringBuilder i0 = hj1.i0("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ");
        i0.append(fragment.toString());
        i0.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(i0.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.s >= 0) {
            sb.append(" #");
            sb.append(this.s);
        }
        if (this.i != null) {
            sb.append(" ");
            sb.append(this.i);
        }
        sb.append("}");
        return sb.toString();
    }
}

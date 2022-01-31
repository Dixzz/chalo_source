package defpackage;

import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: tf  reason: default package */
/* compiled from: FragmentTransition */
public class tf {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f3344a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    public static final vf b = new uf();
    public static final vf c;

    /* renamed from: tf$a */
    /* compiled from: FragmentTransition */
    public interface a {
    }

    /* renamed from: tf$b */
    /* compiled from: FragmentTransition */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f3345a;
        public boolean b;
        public ke c;
        public Fragment d;
        public boolean e;
        public ke f;
    }

    static {
        vf vfVar;
        try {
            vfVar = (vf) Class.forName("gn").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            vfVar = null;
        }
        c = vfVar;
    }

    public static void a(ArrayList<View> arrayList, n2<String, View> n2Var, Collection<String> collection) {
        for (int i = n2Var.h - 1; i >= 0; i--) {
            View l = n2Var.l(i);
            AtomicInteger atomicInteger = r8.f3055a;
            if (collection.contains(l.getTransitionName())) {
                arrayList.add(l);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0038, code lost:
        if (r0.mAdded != false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0076, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0087, code lost:
        if (r0.mHidden == false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0089, code lost:
        r9 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00e5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:95:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(defpackage.ke r8, defpackage.mf.a r9, android.util.SparseArray<defpackage.tf.b> r10, boolean r11, boolean r12) {
        /*
        // Method dump skipped, instructions count: 240
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tf.b(ke, mf$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(Fragment fragment, Fragment fragment2, boolean z, n2<String, View> n2Var, boolean z2) {
        o5 o5Var;
        int i;
        if (z) {
            o5Var = fragment2.getEnterTransitionCallback();
        } else {
            o5Var = fragment.getEnterTransitionCallback();
        }
        if (o5Var != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (n2Var == null) {
                i = 0;
            } else {
                i = n2Var.h;
            }
            for (int i2 = 0; i2 < i; i2++) {
                arrayList2.add(n2Var.h(i2));
                arrayList.add(n2Var.l(i2));
            }
            if (z2) {
                throw null;
            }
            throw null;
        }
    }

    public static boolean d(vf vfVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!vfVar.e(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static n2<String, View> e(vf vfVar, n2<String, String> n2Var, Object obj, b bVar) {
        o5 o5Var;
        ArrayList<String> arrayList;
        Fragment fragment = bVar.f3345a;
        View view = fragment.getView();
        if (n2Var.isEmpty() || obj == null || view == null) {
            n2Var.clear();
            return null;
        }
        n2<String, View> n2Var2 = new n2<>();
        vfVar.i(n2Var2, view);
        ke keVar = bVar.c;
        if (bVar.b) {
            o5Var = fragment.getExitTransitionCallback();
            arrayList = keVar.n;
        } else {
            o5Var = fragment.getEnterTransitionCallback();
            arrayList = keVar.o;
        }
        if (arrayList != null) {
            t2.k(n2Var2, arrayList);
            t2.k(n2Var2, n2Var.values());
        }
        if (o5Var == null) {
            n(n2Var, n2Var2);
            return n2Var2;
        }
        throw null;
    }

    public static n2<String, View> f(vf vfVar, n2<String, String> n2Var, Object obj, b bVar) {
        o5 o5Var;
        ArrayList<String> arrayList;
        if (n2Var.isEmpty() || obj == null) {
            n2Var.clear();
            return null;
        }
        Fragment fragment = bVar.d;
        n2<String, View> n2Var2 = new n2<>();
        vfVar.i(n2Var2, fragment.requireView());
        ke keVar = bVar.f;
        if (bVar.e) {
            o5Var = fragment.getEnterTransitionCallback();
            arrayList = keVar.o;
        } else {
            o5Var = fragment.getExitTransitionCallback();
            arrayList = keVar.n;
        }
        if (arrayList != null) {
            t2.k(n2Var2, arrayList);
        }
        if (o5Var == null) {
            t2.k(n2Var, n2Var2.keySet());
            return n2Var2;
        }
        throw null;
    }

    public static vf g(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        vf vfVar = b;
        if (d(vfVar, arrayList)) {
            return vfVar;
        }
        vf vfVar2 = c;
        if (vfVar2 != null && d(vfVar2, arrayList)) {
            return vfVar2;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static ArrayList<View> h(vf vfVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            vfVar.f(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        vfVar.b(obj, arrayList2);
        return arrayList2;
    }

    public static Object i(vf vfVar, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReenterTransition();
        } else {
            obj = fragment.getEnterTransition();
        }
        return vfVar.g(obj);
    }

    public static Object j(vf vfVar, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReturnTransition();
        } else {
            obj = fragment.getExitTransition();
        }
        return vfVar.g(obj);
    }

    public static View k(n2<String, View> n2Var, b bVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        ke keVar = bVar.c;
        if (obj == null || n2Var == null || (arrayList = keVar.n) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = keVar.n.get(0);
        } else {
            str = keVar.o.get(0);
        }
        return n2Var.get(str);
    }

    public static Object l(vf vfVar, Fragment fragment, Fragment fragment2, boolean z) {
        Object obj;
        if (z) {
            obj = fragment2.getSharedElementReturnTransition();
        } else {
            obj = fragment.getSharedElementEnterTransition();
        }
        return vfVar.y(vfVar.g(obj));
    }

    public static Object m(vf vfVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return vfVar.m(obj2, obj, obj3);
        }
        return vfVar.l(obj2, obj, obj3);
    }

    public static void n(n2<String, String> n2Var, n2<String, View> n2Var2) {
        int i = n2Var.h;
        while (true) {
            i--;
            if (i < 0) {
                return;
            }
            if (!n2Var2.containsKey(n2Var.l(i))) {
                n2Var.j(i);
            }
        }
    }

    public static void o(vf vfVar, Object obj, Object obj2, n2<String, View> n2Var, boolean z, ke keVar) {
        String str;
        ArrayList<String> arrayList = keVar.n;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (z) {
                str = keVar.o.get(0);
            } else {
                str = keVar.n.get(0);
            }
            View view = n2Var.get(str);
            vfVar.t(obj, view);
            if (obj2 != null) {
                vfVar.t(obj2, view);
            }
        }
    }

    public static void p(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x03e4  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0428 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x023e A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void q(android.content.Context r39, defpackage.bf r40, java.util.ArrayList<defpackage.ke> r41, java.util.ArrayList<java.lang.Boolean> r42, int r43, int r44, boolean r45, defpackage.tf.a r46) {
        /*
        // Method dump skipped, instructions count: 1083
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tf.q(android.content.Context, bf, java.util.ArrayList, java.util.ArrayList, int, int, boolean, tf$a):void");
    }
}

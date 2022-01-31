package defpackage;

import androidx.fragment.app.Fragment;

/* renamed from: df  reason: default package */
/* compiled from: FragmentFactory */
public class df {

    /* renamed from: a  reason: collision with root package name */
    public static final u2<ClassLoader, u2<String, Class<?>>> f827a = new u2<>();

    public static Class<?> b(ClassLoader classLoader, String str) throws ClassNotFoundException {
        u2<ClassLoader, u2<String, Class<?>>> u2Var = f827a;
        u2<String, Class<?>> orDefault = u2Var.getOrDefault(classLoader, null);
        if (orDefault == null) {
            orDefault = new u2<>();
            u2Var.put(classLoader, orDefault);
        }
        Class<?> orDefault2 = orDefault.getOrDefault(str, null);
        if (orDefault2 != null) {
            return orDefault2;
        }
        Class<?> cls = Class.forName(str, false, classLoader);
        orDefault.put(str, cls);
        return cls;
    }

    /* JADX DEBUG: Type inference failed for r3v3. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends androidx.fragment.app.Fragment> */
    public static Class<? extends Fragment> c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassNotFoundException e) {
            throw new Fragment.j(hj1.T("Unable to instantiate fragment ", str, ": make sure class name exists"), e);
        } catch (ClassCastException e2) {
            throw new Fragment.j(hj1.T("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e2);
        }
    }

    public Fragment a(ClassLoader classLoader, String str) {
        throw null;
    }
}

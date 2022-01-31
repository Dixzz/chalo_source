package defpackage;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: no  reason: default package */
/* compiled from: VersionedParcel */
public abstract class no {

    /* renamed from: a  reason: collision with root package name */
    public final n2<String, Method> f2578a;
    public final n2<String, Method> b;
    public final n2<String, Class> c;

    public no(n2<String, Method> n2Var, n2<String, Method> n2Var2, n2<String, Class> n2Var3) {
        this.f2578a = n2Var;
        this.b = n2Var2;
        this.c = n2Var3;
    }

    public abstract void a();

    public abstract no b();

    public final Class c(Class<? extends po> cls) throws ClassNotFoundException {
        Class orDefault = this.c.getOrDefault(cls.getName(), null);
        if (orDefault != null) {
            return orDefault;
        }
        Class<?> cls2 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.c.put(cls.getName(), cls2);
        return cls2;
    }

    public final Method d(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method orDefault = this.f2578a.getOrDefault(str, null);
        if (orDefault != null) {
            return orDefault;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, no.class.getClassLoader()).getDeclaredMethod("read", no.class);
        this.f2578a.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method e(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method orDefault = this.b.getOrDefault(cls.getName(), null);
        if (orDefault != null) {
            return orDefault;
        }
        Class c2 = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = c2.getDeclaredMethod("write", cls, no.class);
        this.b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean f();

    public abstract byte[] g();

    public abstract CharSequence h();

    public abstract boolean i(int i);

    public abstract int j();

    public int k(int i, int i2) {
        if (!i(i2)) {
            return i;
        }
        return j();
    }

    public abstract <T extends Parcelable> T l();

    public <T extends Parcelable> T m(T t, int i) {
        return !i(i) ? t : (T) l();
    }

    public abstract String n();

    public <T extends po> T o() {
        String n = n();
        if (n == null) {
            return null;
        }
        no b2 = b();
        try {
            return (T) ((po) d(n).invoke(null, b2));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        }
    }

    public abstract void p(int i);

    public abstract void q(boolean z);

    public abstract void r(byte[] bArr);

    public abstract void s(CharSequence charSequence);

    public abstract void t(int i);

    public abstract void u(Parcelable parcelable);

    public abstract void v(String str);

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: no */
    /* JADX WARN: Multi-variable type inference failed */
    public void w(po poVar) {
        if (poVar == null) {
            v(null);
            return;
        }
        try {
            v(c(poVar.getClass()).getName());
            no b2 = b();
            try {
                e(poVar.getClass()).invoke(null, poVar, b2);
                b2.a();
            } catch (IllegalAccessException e) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
            } catch (InvocationTargetException e2) {
                if (e2.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e2.getCause());
                }
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
            } catch (ClassNotFoundException e4) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(poVar.getClass().getSimpleName() + " does not have a Parcelizer", e5);
        }
    }
}

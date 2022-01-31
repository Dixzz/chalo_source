package defpackage;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: vd5  reason: default package */
/* compiled from: Caller */
public class vd5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f3635a;
    public final Object[] b;
    public final Class<?> c;
    public final Class<?> d;
    public final Method e;

    public vd5(Class<?> cls, String str, Object[] objArr, Class<?> cls2) throws NoSuchMethodException {
        Method method;
        this.f3635a = str;
        this.b = objArr;
        this.c = cls2;
        Class[] clsArr = new Class[objArr.length];
        int i = 0;
        while (true) {
            Object[] objArr2 = this.b;
            if (i >= objArr2.length) {
                break;
            }
            clsArr[i] = objArr2[i].getClass();
            i++;
        }
        Method[] methods = cls.getMethods();
        int length = methods.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                method = null;
                break;
            }
            method = methods[i2];
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (name.equals(this.f3635a) && parameterTypes.length == this.b.length && b(this.c).isAssignableFrom(b(method.getReturnType()))) {
                boolean z = true;
                for (int i3 = 0; i3 < parameterTypes.length && z; i3++) {
                    z = b(parameterTypes[i3]).isAssignableFrom(b(clsArr[i3]));
                }
                if (z) {
                    break;
                }
            }
            i2++;
        }
        this.e = method;
        if (method != null) {
            this.d = method.getDeclaringClass();
            return;
        }
        StringBuilder i0 = hj1.i0("Method ");
        i0.append(cls.getName());
        i0.append(".");
        throw new NoSuchMethodException(hj1.a0(i0, this.f3635a, " doesn't exit"));
    }

    public static Class<?> b(Class<?> cls) {
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        return cls == Character.class ? Character.TYPE : cls;
    }

    public Object a(View view, Object[] objArr) {
        if (!this.d.isAssignableFrom(view.getClass())) {
            return null;
        }
        try {
            return this.e.invoke(view, objArr);
        } catch (IllegalAccessException unused) {
            this.e.getName();
            return null;
        } catch (IllegalArgumentException unused2) {
            this.e.getName();
            return null;
        } catch (InvocationTargetException unused3) {
            this.e.getName();
            return null;
        }
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("[Caller ");
        i0.append(this.f3635a);
        i0.append("(");
        i0.append(this.b);
        i0.append(")]");
        return i0.toString();
    }
}

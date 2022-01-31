package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: e6  reason: default package */
/* compiled from: TypefaceCompatApi21Impl */
public class e6 extends k6 {
    public static Class<?> b = null;
    public static Constructor<?> c = null;
    public static Method d = null;
    public static Method e = null;
    public static boolean f = false;

    public static boolean f(Object obj, String str, int i, boolean z) {
        g();
        try {
            return ((Boolean) d.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void g() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!f) {
            f = true;
            Constructor<?> constructor = null;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
                constructor = constructor2;
            } catch (ClassNotFoundException | NoSuchMethodException e2) {
                e2.getClass().getName();
                method2 = null;
                cls = null;
                method = null;
            }
            c = constructor;
            b = cls;
            d = method;
            e = method2;
        }
    }

    @Override // defpackage.k6
    public Typeface a(Context context, u5 u5Var, Resources resources, int i) {
        g();
        try {
            Object newInstance = c.newInstance(new Object[0]);
            v5[] v5VarArr = u5Var.f3453a;
            for (v5 v5Var : v5VarArr) {
                File W = h.W(context);
                if (W == null) {
                    return null;
                }
                try {
                    if (!h.x(W, resources, v5Var.f)) {
                        W.delete();
                        return null;
                    } else if (!f(newInstance, W.getPath(), v5Var.b, v5Var.c)) {
                        return null;
                    } else {
                        W.delete();
                    }
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    W.delete();
                }
            }
            g();
            try {
                Object newInstance2 = Array.newInstance(b, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) e.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055 A[SYNTHETIC, Splitter:B:18:0x0055] */
    @Override // defpackage.k6
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface b(android.content.Context r4, android.os.CancellationSignal r5, defpackage.k7[] r6, int r7) {
        /*
        // Method dump skipped, instructions count: 140
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e6.b(android.content.Context, android.os.CancellationSignal, k7[], int):android.graphics.Typeface");
    }
}

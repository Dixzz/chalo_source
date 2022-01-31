package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: g6  reason: default package */
/* compiled from: TypefaceCompatApi26Impl */
public class g6 extends e6 {
    public final Class<?> g;
    public final Constructor<?> h;
    public final Method i;
    public final Method j;
    public final Method k;
    public final Method l;
    public final Method m;

    public g6() {
        Method method;
        Method method2;
        Method method3;
        Constructor<?> constructor;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(new Class[0]);
            method3 = n(cls2);
            method2 = o(cls2);
            method = cls2.getMethod("freeze", new Class[0]);
            method4 = cls2.getMethod("abortCreation", new Class[0]);
            method5 = p(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.getClass().getName();
            method5 = null;
            method4 = null;
            constructor = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.g = cls;
        this.h = constructor;
        this.i = method3;
        this.j = method2;
        this.k = method;
        this.l = method4;
        this.m = method5;
    }

    private Object m() {
        try {
            return this.h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // defpackage.e6, defpackage.k6
    public Typeface a(Context context, u5 u5Var, Resources resources, int i2) {
        if (!l()) {
            return super.a(context, u5Var, resources, i2);
        }
        Object m2 = m();
        if (m2 == null) {
            return null;
        }
        v5[] v5VarArr = u5Var.f3453a;
        for (v5 v5Var : v5VarArr) {
            if (!i(context, m2, v5Var.f3599a, v5Var.e, v5Var.b, v5Var.c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(v5Var.d))) {
                h(m2);
                return null;
            }
        }
        if (!k(m2)) {
            return null;
        }
        return j(m2);
    }

    @Override // defpackage.e6, defpackage.k6
    public Typeface b(Context context, CancellationSignal cancellationSignal, k7[] k7VarArr, int i2) {
        Typeface j2;
        boolean z;
        if (k7VarArr.length < 1) {
            return null;
        }
        if (!l()) {
            k7 k7Var = (k7) k6.e(k7VarArr, i2, new j6(this));
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(k7Var.f2031a, "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(k7Var.c).setItalic(k7Var.d).build();
                    openFileDescriptor.close();
                    return build;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } catch (IOException unused) {
                return null;
            }
        } else {
            HashMap hashMap = new HashMap();
            for (k7 k7Var2 : k7VarArr) {
                if (k7Var2.e == 0) {
                    Uri uri = k7Var2.f2031a;
                    if (!hashMap.containsKey(uri)) {
                        hashMap.put(uri, h.i0(context, cancellationSignal, uri));
                    }
                }
            }
            Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
            Object m2 = m();
            if (m2 == null) {
                return null;
            }
            boolean z2 = false;
            for (k7 k7Var3 : k7VarArr) {
                ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(k7Var3.f2031a);
                if (byteBuffer != null) {
                    try {
                        z = ((Boolean) this.j.invoke(m2, byteBuffer, Integer.valueOf(k7Var3.b), null, Integer.valueOf(k7Var3.c), Integer.valueOf(k7Var3.d ? 1 : 0))).booleanValue();
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                        z = false;
                    }
                    if (!z) {
                        h(m2);
                        return null;
                    }
                    z2 = true;
                }
            }
            if (!z2) {
                h(m2);
                return null;
            } else if (k(m2) && (j2 = j(m2)) != null) {
                return Typeface.create(j2, i2);
            } else {
                return null;
            }
        }
        throw th;
    }

    @Override // defpackage.k6
    public Typeface d(Context context, Resources resources, int i2, String str, int i3) {
        if (!l()) {
            return super.d(context, resources, i2, str, i3);
        }
        Object m2 = m();
        if (m2 == null) {
            return null;
        }
        if (!i(context, m2, str, 0, -1, -1, null)) {
            h(m2);
            return null;
        } else if (!k(m2)) {
            return null;
        } else {
            return j(m2);
        }
    }

    public final void h(Object obj) {
        try {
            this.l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean i(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface j(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean k(Object obj) {
        try {
            return ((Boolean) this.k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean l() {
        return this.i != null;
    }

    public Method n(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public Method o(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public Method p(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}

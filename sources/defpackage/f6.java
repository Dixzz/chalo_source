package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/* renamed from: f6  reason: default package */
/* compiled from: TypefaceCompatApi24Impl */
public class f6 extends k6 {
    public static final Class<?> b;
    public static final Constructor<?> c;
    public static final Method d;
    public static final Method e;

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            e2.getClass().getName();
            cls = null;
            method2 = null;
            method = null;
        }
        c = constructor;
        b = cls;
        d = method;
        e = method2;
    }

    public static boolean f(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface g(Object obj) {
        try {
            Object newInstance = Array.newInstance(b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // defpackage.k6
    public Typeface a(Context context, u5 u5Var, Resources resources, int i) {
        Object obj;
        MappedByteBuffer mappedByteBuffer;
        try {
            obj = c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        v5[] v5VarArr = u5Var.f3453a;
        for (v5 v5Var : v5VarArr) {
            int i2 = v5Var.f;
            File W = h.W(context);
            if (W != null) {
                try {
                    if (h.x(W, resources, i2)) {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(W);
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
                                fileInputStream.close();
                                W.delete();
                                if (!(mappedByteBuffer == null && f(obj, mappedByteBuffer, v5Var.e, v5Var.b, v5Var.c))) {
                                    return null;
                                }
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        } catch (IOException unused2) {
                            mappedByteBuffer = null;
                        }
                    }
                } finally {
                    W.delete();
                }
            }
            mappedByteBuffer = null;
            if (mappedByteBuffer == null) {
                return null;
            }
        }
        return g(obj);
        throw th;
    }

    @Override // defpackage.k6
    public Typeface b(Context context, CancellationSignal cancellationSignal, k7[] k7VarArr, int i) {
        Object obj;
        try {
            obj = c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        u2 u2Var = new u2();
        for (k7 k7Var : k7VarArr) {
            Uri uri = k7Var.f2031a;
            ByteBuffer byteBuffer = (ByteBuffer) u2Var.get(uri);
            if (byteBuffer == null) {
                byteBuffer = h.i0(context, cancellationSignal, uri);
                u2Var.put(uri, byteBuffer);
            }
            if (byteBuffer == null || !f(obj, byteBuffer, k7Var.b, k7Var.c, k7Var.d)) {
                return null;
            }
        }
        Typeface g = g(obj);
        if (g == null) {
            return null;
        }
        return Typeface.create(g, i);
    }
}

package defpackage;

import defpackage.ba3;
import defpackage.ea3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: ea3  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class ea3<MessageType extends ea3<MessageType, BuilderType>, BuilderType extends ba3<MessageType, BuilderType>> extends s83<MessageType, BuilderType> {
    private static final Map<Object, ea3<?, ?>> zzb = new ConcurrentHashMap();
    public an2 zzc = an2.f;
    public int zzd = -1;

    public static Object e(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static <T extends ea3<T, ?>> T f(T t, g93 g93, s93 s93) throws ma3 {
        try {
            h93 z = g93.z();
            T t2 = (T) ((ea3) t.i(4, null, null));
            try {
                mm2 a2 = im2.c.a(t2.getClass());
                i93 i93 = z.b;
                if (i93 == null) {
                    i93 = new i93(z);
                }
                a2.j(t2, i93, s93);
                a2.d(t2);
                try {
                    z.b(0);
                    h(t2);
                    return t2;
                } catch (ma3 e) {
                    throw e;
                }
            } catch (IOException e2) {
                if (e2.getCause() instanceof ma3) {
                    throw ((ma3) e2.getCause());
                }
                throw new ma3(e2.getMessage());
            } catch (RuntimeException e3) {
                if (e3.getCause() instanceof ma3) {
                    throw ((ma3) e3.getCause());
                }
                throw e3;
            }
        } catch (ma3 e4) {
            throw e4;
        }
    }

    public static <T extends ea3<T, ?>> T g(T t, byte[] bArr, s93 s93) throws ma3 {
        int length = bArr.length;
        T t2 = (T) ((ea3) t.i(4, null, null));
        try {
            mm2 a2 = im2.c.a(t2.getClass());
            a2.g(t2, bArr, 0, length, new v83(s93));
            a2.d(t2);
            if (t2.zza == 0) {
                h(t2);
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof ma3) {
                throw ((ma3) e.getCause());
            }
            throw new ma3(e.getMessage());
        } catch (IndexOutOfBoundsException unused) {
            throw ma3.a();
        }
    }

    public static <T extends ea3<T, ?>> T h(T t) throws ma3 {
        if (t.o()) {
            return t;
        }
        throw new ma3(new ym2().getMessage());
    }

    public static <T extends ea3> T q(Class<T> cls) {
        Map<Object, ea3<?, ?>> map = zzb;
        ea3<?, ?> ea3 = map.get(cls);
        if (ea3 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                ea3 = map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (ea3 == null) {
            ea3 = (ea3) ((ea3) ln2.i(cls)).i(6, null, null);
            if (ea3 != null) {
                map.put(cls, ea3);
            } else {
                throw new IllegalStateException();
            }
        }
        return ea3;
    }

    public static <T extends ea3> void r(Class<T> cls, T t) {
        zzb.put(cls, t);
    }

    @Override // defpackage.s83
    public final int b() {
        return this.zzd;
    }

    @Override // defpackage.s83
    public final void c(int i) {
        this.zzd = i;
    }

    @Override // defpackage.cm2
    public final /* bridge */ /* synthetic */ bm2 d() {
        return (ea3) i(6, null, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return im2.c.a(getClass()).b(this, (ea3) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int a2 = im2.c.a(getClass()).a(this);
        this.zza = a2;
        return a2;
    }

    public abstract Object i(int i, Object obj, Object obj2);

    @Override // defpackage.bm2
    public final int k() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int f = im2.c.a(getClass()).f(this);
        this.zzd = f;
        return f;
    }

    @Override // defpackage.bm2
    public final /* bridge */ /* synthetic */ r83 l() {
        ba3 ba3 = (ba3) i(5, null, null);
        ba3.e(this);
        return ba3;
    }

    @Override // defpackage.bm2
    public final /* bridge */ /* synthetic */ r83 m() {
        return (ba3) i(5, null, null);
    }

    public final <MessageType extends ea3<MessageType, BuilderType>, BuilderType extends ba3<MessageType, BuilderType>> BuilderType n() {
        return (BuilderType) ((ba3) i(5, null, null));
    }

    public final boolean o() {
        byte byteValue = ((Byte) i(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean c = im2.c.a(getClass()).c(this);
        i(2, true != c ? null : this, null);
        return c;
    }

    public final void p(n93 n93) throws IOException {
        mm2 a2 = im2.c.a(getClass());
        o93 o93 = n93.f2524a;
        if (o93 == null) {
            o93 = new o93(n93);
        }
        a2.i(this, o93);
    }

    public final String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        gj1.I1(this, sb, 0);
        return sb.toString();
    }
}

package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;

/* renamed from: lj  reason: default package */
/* compiled from: NavType */
public abstract class lj<T> {
    public static final lj<Integer> b = new c(false);
    public static final lj<Integer> c = new d(false);
    public static final lj<int[]> d = new e(true);
    public static final lj<Long> e = new f(false);
    public static final lj<long[]> f = new g(true);
    public static final lj<Float> g = new h(false);
    public static final lj<float[]> h = new i(true);
    public static final lj<Boolean> i = new j(false);
    public static final lj<boolean[]> j = new k(true);
    public static final lj<String> k = new a(true);
    public static final lj<String[]> l = new b(true);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2225a;

    /* renamed from: lj$a */
    /* compiled from: NavType */
    public class a extends lj<String> {
        public a(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public String a(Bundle bundle, String str) {
            return (String) bundle.get(str);
        }

        @Override // defpackage.lj
        public String b() {
            return "string";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public String c(String str) {
            return str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // defpackage.lj
        public void d(Bundle bundle, String str, String str2) {
            bundle.putString(str, str2);
        }
    }

    /* renamed from: lj$b */
    /* compiled from: NavType */
    public class b extends lj<String[]> {
        public b(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public String[] a(Bundle bundle, String str) {
            return (String[]) bundle.get(str);
        }

        @Override // defpackage.lj
        public String b() {
            return "string[]";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public String[] c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // defpackage.lj
        public void d(Bundle bundle, String str, String[] strArr) {
            bundle.putStringArray(str, strArr);
        }
    }

    /* renamed from: lj$c */
    /* compiled from: NavType */
    public class c extends lj<Integer> {
        public c(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public Integer a(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        @Override // defpackage.lj
        public String b() {
            return "integer";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public Integer c(String str) {
            if (str.startsWith("0x")) {
                return Integer.valueOf(Integer.parseInt(str.substring(2), 16));
            }
            return Integer.valueOf(Integer.parseInt(str));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // defpackage.lj
        public void d(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    /* renamed from: lj$d */
    /* compiled from: NavType */
    public class d extends lj<Integer> {
        public d(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public Integer a(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        @Override // defpackage.lj
        public String b() {
            return "reference";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public Integer c(String str) {
            if (str.startsWith("0x")) {
                return Integer.valueOf(Integer.parseInt(str.substring(2), 16));
            }
            return Integer.valueOf(Integer.parseInt(str));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // defpackage.lj
        public void d(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    /* renamed from: lj$e */
    /* compiled from: NavType */
    public class e extends lj<int[]> {
        public e(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public int[] a(Bundle bundle, String str) {
            return (int[]) bundle.get(str);
        }

        @Override // defpackage.lj
        public String b() {
            return "integer[]";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public int[] c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // defpackage.lj
        public void d(Bundle bundle, String str, int[] iArr) {
            bundle.putIntArray(str, iArr);
        }
    }

    /* renamed from: lj$f */
    /* compiled from: NavType */
    public class f extends lj<Long> {
        public f(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public Long a(Bundle bundle, String str) {
            return (Long) bundle.get(str);
        }

        @Override // defpackage.lj
        public String b() {
            return "long";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public Long c(String str) {
            if (str.endsWith("L")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.startsWith("0x")) {
                return Long.valueOf(Long.parseLong(str.substring(2), 16));
            }
            return Long.valueOf(Long.parseLong(str));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // defpackage.lj
        public void d(Bundle bundle, String str, Long l) {
            bundle.putLong(str, l.longValue());
        }
    }

    /* renamed from: lj$g */
    /* compiled from: NavType */
    public class g extends lj<long[]> {
        public g(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public long[] a(Bundle bundle, String str) {
            return (long[]) bundle.get(str);
        }

        @Override // defpackage.lj
        public String b() {
            return "long[]";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public long[] c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // defpackage.lj
        public void d(Bundle bundle, String str, long[] jArr) {
            bundle.putLongArray(str, jArr);
        }
    }

    /* renamed from: lj$h */
    /* compiled from: NavType */
    public class h extends lj<Float> {
        public h(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public Float a(Bundle bundle, String str) {
            return (Float) bundle.get(str);
        }

        @Override // defpackage.lj
        public String b() {
            return "float";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public Float c(String str) {
            return Float.valueOf(Float.parseFloat(str));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // defpackage.lj
        public void d(Bundle bundle, String str, Float f) {
            bundle.putFloat(str, f.floatValue());
        }
    }

    /* renamed from: lj$i */
    /* compiled from: NavType */
    public class i extends lj<float[]> {
        public i(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public float[] a(Bundle bundle, String str) {
            return (float[]) bundle.get(str);
        }

        @Override // defpackage.lj
        public String b() {
            return "float[]";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public float[] c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // defpackage.lj
        public void d(Bundle bundle, String str, float[] fArr) {
            bundle.putFloatArray(str, fArr);
        }
    }

    /* renamed from: lj$j */
    /* compiled from: NavType */
    public class j extends lj<Boolean> {
        public j(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public Boolean a(Bundle bundle, String str) {
            return (Boolean) bundle.get(str);
        }

        @Override // defpackage.lj
        public String b() {
            return "boolean";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public Boolean c(String str) {
            if ("true".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equals(str)) {
                return Boolean.FALSE;
            }
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // defpackage.lj
        public void d(Bundle bundle, String str, Boolean bool) {
            bundle.putBoolean(str, bool.booleanValue());
        }
    }

    /* renamed from: lj$k */
    /* compiled from: NavType */
    public class k extends lj<boolean[]> {
        public k(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public boolean[] a(Bundle bundle, String str) {
            return (boolean[]) bundle.get(str);
        }

        @Override // defpackage.lj
        public String b() {
            return "boolean[]";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.lj
        public boolean[] c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // defpackage.lj
        public void d(Bundle bundle, String str, boolean[] zArr) {
            bundle.putBooleanArray(str, zArr);
        }
    }

    /* renamed from: lj$l */
    /* compiled from: NavType */
    public static final class l<D extends Enum> extends p<D> {
        public final Class<D> n;

        public l(Class<D> cls) {
            super(false, cls);
            if (cls.isEnum()) {
                this.n = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is not an Enum type.");
        }

        @Override // defpackage.lj.p, defpackage.lj
        public String b() {
            return this.n.getName();
        }

        /* renamed from: f */
        public D e(String str) {
            D[] enumConstants = this.n.getEnumConstants();
            for (D d : enumConstants) {
                if (d.name().equals(str)) {
                    return d;
                }
            }
            throw new IllegalArgumentException(hj1.G(this.n, hj1.l0("Enum value ", str, " not found for type "), "."));
        }
    }

    /* renamed from: lj$m */
    /* compiled from: NavType */
    public static final class m<D extends Parcelable> extends lj<D[]> {
        public final Class<D[]> m;

        public m(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    this.m = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException(cls + " does not implement Parcelable.");
            }
        }

        @Override // defpackage.lj
        public Object a(Bundle bundle, String str) {
            return (Parcelable[]) bundle.get(str);
        }

        @Override // defpackage.lj
        public String b() {
            return this.m.getName();
        }

        @Override // defpackage.lj
        public Object c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // defpackage.lj
        public void d(Bundle bundle, String str, Object obj) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            this.m.cast(parcelableArr);
            bundle.putParcelableArray(str, parcelableArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || m.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((m) obj).m);
        }

        public int hashCode() {
            return this.m.hashCode();
        }
    }

    /* renamed from: lj$n */
    /* compiled from: NavType */
    public static final class n<D> extends lj<D> {
        public final Class<D> m;

        public n(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Parcelable or Serializable.");
        }

        @Override // defpackage.lj
        public D a(Bundle bundle, String str) {
            return (D) bundle.get(str);
        }

        @Override // defpackage.lj
        public String b() {
            return this.m.getName();
        }

        @Override // defpackage.lj
        public D c(String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        @Override // defpackage.lj
        public void d(Bundle bundle, String str, D d) {
            this.m.cast(d);
            if (d == null || (d instanceof Parcelable)) {
                bundle.putParcelable(str, d);
            } else if (d instanceof Serializable) {
                bundle.putSerializable(str, d);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || n.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((n) obj).m);
        }

        public int hashCode() {
            return this.m.hashCode();
        }
    }

    /* renamed from: lj$o */
    /* compiled from: NavType */
    public static final class o<D extends Serializable> extends lj<D[]> {
        public final Class<D[]> m;

        public o(Class<D> cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    this.m = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            }
        }

        @Override // defpackage.lj
        public Object a(Bundle bundle, String str) {
            return (Serializable[]) bundle.get(str);
        }

        @Override // defpackage.lj
        public String b() {
            return this.m.getName();
        }

        @Override // defpackage.lj
        public Object c(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: android.os.Bundle */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, java.io.Serializable[], java.io.Serializable] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // defpackage.lj
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d(android.os.Bundle r2, java.lang.String r3, java.lang.Object r4) {
            /*
                r1 = this;
                java.io.Serializable[] r4 = (java.io.Serializable[]) r4
                java.lang.Class<D extends java.io.Serializable[]> r0 = r1.m
                r0.cast(r4)
                r2.putSerializable(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.lj.o.d(android.os.Bundle, java.lang.String, java.lang.Object):void");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || o.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((o) obj).m);
        }

        public int hashCode() {
            return this.m.hashCode();
        }
    }

    public lj(boolean z) {
        this.f2225a = z;
    }

    public abstract T a(Bundle bundle, String str);

    public abstract String b();

    public abstract T c(String str);

    public abstract void d(Bundle bundle, String str, T t);

    public String toString() {
        return b();
    }

    /* renamed from: lj$p */
    /* compiled from: NavType */
    public static class p<D extends Serializable> extends lj<D> {
        public final Class<D> m;

        public p(Class<D> cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            } else if (!cls.isEnum()) {
                this.m = cls;
            } else {
                throw new IllegalArgumentException(cls + " is an Enum. You should use EnumType instead.");
            }
        }

        @Override // defpackage.lj
        public Object a(Bundle bundle, String str) {
            return (Serializable) bundle.get(str);
        }

        @Override // defpackage.lj
        public String b() {
            return this.m.getName();
        }

        @Override // defpackage.lj
        public void d(Bundle bundle, String str, Object obj) {
            Serializable serializable = (Serializable) obj;
            this.m.cast(serializable);
            bundle.putSerializable(str, serializable);
        }

        /* renamed from: e */
        public D c(String str) {
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof p)) {
                return false;
            }
            return this.m.equals(((p) obj).m);
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        public p(boolean z, Class<D> cls) {
            super(z);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }
    }
}

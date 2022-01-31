package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: h86  reason: default package */
/* compiled from: ClassReference.kt */
public final class h86 implements n96<Object>, g86 {
    public static final Map<Class<? extends g56<?>>, Integer> b;
    public static final HashMap<String, String> c;
    public static final HashMap<String, String> d;
    public static final HashMap<String, String> e;

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f1348a;

    static {
        Class[] clsArr = {h76.class, s76.class, w76.class, x76.class, y76.class, z76.class, a86.class, b86.class, c86.class, d86.class, i76.class, j76.class, k76.class, l76.class, m76.class, n76.class, o76.class, p76.class, q76.class, r76.class, t76.class, u76.class, v76.class};
        n86.e(clsArr, "elements");
        List a2 = y56.a(clsArr);
        ArrayList arrayList = new ArrayList(hd3.I(a2, 10));
        int i = 0;
        for (Object obj : a2) {
            int i2 = i + 1;
            if (i >= 0) {
                arrayList.add(new m56((Class) obj, Integer.valueOf(i)));
                i = i2;
            } else {
                y56.w();
                throw null;
            }
        }
        Map<Class<? extends g56<?>>, Integer> map = c66.f;
        n86.e(arrayList, "$this$toMap");
        int size = arrayList.size();
        if (size != 0) {
            if (size != 1) {
                map = new LinkedHashMap<>(hd3.f2(arrayList.size()));
                y56.z(arrayList, map);
            } else {
                map = hd3.g2((m56) arrayList.get(0));
            }
        }
        b = map;
        HashMap<String, String> n0 = hj1.n0("boolean", "kotlin.Boolean", "char", "kotlin.Char");
        n0.put("byte", "kotlin.Byte");
        n0.put("short", "kotlin.Short");
        n0.put("int", "kotlin.Int");
        n0.put("float", "kotlin.Float");
        n0.put("long", "kotlin.Long");
        n0.put("double", "kotlin.Double");
        c = n0;
        HashMap<String, String> n02 = hj1.n0("java.lang.Boolean", "kotlin.Boolean", "java.lang.Character", "kotlin.Char");
        n02.put("java.lang.Byte", "kotlin.Byte");
        n02.put("java.lang.Short", "kotlin.Short");
        n02.put("java.lang.Integer", "kotlin.Int");
        n02.put("java.lang.Float", "kotlin.Float");
        n02.put("java.lang.Long", "kotlin.Long");
        n02.put("java.lang.Double", "kotlin.Double");
        d = n02;
        HashMap<String, String> n03 = hj1.n0("java.lang.Object", "kotlin.Any", "java.lang.String", "kotlin.String");
        n03.put("java.lang.CharSequence", "kotlin.CharSequence");
        n03.put("java.lang.Throwable", "kotlin.Throwable");
        n03.put("java.lang.Cloneable", "kotlin.Cloneable");
        n03.put("java.lang.Number", "kotlin.Number");
        n03.put("java.lang.Comparable", "kotlin.Comparable");
        n03.put("java.lang.Enum", "kotlin.Enum");
        n03.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        n03.put("java.lang.Iterable", "kotlin.collections.Iterable");
        n03.put("java.util.Iterator", "kotlin.collections.Iterator");
        n03.put("java.util.Collection", "kotlin.collections.Collection");
        n03.put("java.util.List", "kotlin.collections.List");
        n03.put("java.util.Set", "kotlin.collections.Set");
        n03.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        n03.put("java.util.Map", "kotlin.collections.Map");
        n03.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        n03.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        n03.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        n03.putAll(n0);
        n03.putAll(n02);
        Collection<String> values = n0.values();
        n86.d(values, "primitiveFqNames.values");
        for (T t : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            n86.d(t, "kotlinName");
            sb.append(ea6.I(t, '.', t));
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            n03.put(sb2, ((String) t) + ".Companion");
        }
        for (Map.Entry<Class<? extends g56<?>>, Integer> entry : b.entrySet()) {
            int intValue = entry.getValue().intValue();
            String name = entry.getKey().getName();
            n03.put(name, "kotlin.Function" + intValue);
        }
        e = n03;
        LinkedHashMap linkedHashMap = new LinkedHashMap(hd3.f2(n03.size()));
        for (T t2 : n03.entrySet()) {
            Object key = t2.getKey();
            String str = (String) t2.getValue();
            linkedHashMap.put(key, ea6.I(str, '.', str));
        }
    }

    public h86(Class<?> cls) {
        n86.e(cls, "jClass");
        this.f1348a = cls;
    }

    @Override // defpackage.g86
    public Class<?> a() {
        return this.f1348a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof h86) && n86.a(hd3.n1(this), hd3.n1((n96) obj));
    }

    public int hashCode() {
        return hd3.n1(this).hashCode();
    }

    public String toString() {
        return this.f1348a.toString() + " (Kotlin reflection is not available)";
    }
}

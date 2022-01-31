package defpackage;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* renamed from: y56 */
public class y56 extends x56 {
    public static final <T> List<T> A(Iterable<? extends T> iterable) {
        n86.e(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            return B((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        x(iterable, arrayList);
        return arrayList;
    }

    public static final <T> List<T> B(Collection<? extends T> collection) {
        n86.e(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }

    public static final <K, V> Map<K, V> C(Map<? extends K, ? extends V> map) {
        n86.e(map, "$this$toMutableMap");
        return new LinkedHashMap(map);
    }

    public static final <T> Set<T> D(Iterable<? extends T> iterable) {
        d66 d66 = d66.f;
        n86.e(iterable, "$this$toSet");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return d66;
            }
            if (size != 1) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(hd3.f2(collection.size()));
                x(iterable, linkedHashSet);
                return linkedHashSet;
            }
            return hd3.M2(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        x(iterable, linkedHashSet2);
        LinkedHashSet linkedHashSet3 = linkedHashSet2;
        n86.e(linkedHashSet3, "$this$optimizeReadOnlySet");
        int size2 = linkedHashSet3.size();
        if (size2 != 0) {
            return size2 != 1 ? linkedHashSet3 : hd3.M2(linkedHashSet3.iterator().next());
        }
        return d66;
    }

    public static final <T> List<T> a(T[] tArr) {
        n86.e(tArr, "$this$asList");
        List<T> asList = Arrays.asList(tArr);
        n86.d(asList, "ArraysUtilJVM.asList(this)");
        return asList;
    }

    public static final byte[] b(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        n86.e(bArr, "$this$copyInto");
        n86.e(bArr2, FirebaseAnalytics.Param.DESTINATION);
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
        return bArr2;
    }

    public static /* synthetic */ byte[] c(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        b(bArr, bArr2, i, i2, i3);
        return bArr2;
    }

    public static Object[] d(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        n86.e(objArr, "$this$copyInto");
        n86.e(objArr2, FirebaseAnalytics.Param.DESTINATION);
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
        return objArr2;
    }

    public static final byte[] e(byte[] bArr, int i, int i2) {
        n86.e(bArr, "$this$copyOfRangeImpl");
        int length = bArr.length;
        if (i2 <= length) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
            n86.d(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + length + ").");
    }

    public static final <T> void f(T[] tArr, T t, int i, int i2) {
        n86.e(tArr, "$this$fill");
        Arrays.fill(tArr, i, i2, t);
    }

    public static /* synthetic */ void g(Object[] objArr, Object obj, int i, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        f(objArr, obj, i, i2);
    }

    public static final <T> T h(List<? extends T> list) {
        n86.e(list, "$this$first");
        if (!list.isEmpty()) {
            return (T) list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T i(List<? extends T> list) {
        n86.e(list, "$this$firstOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return (T) list.get(0);
    }

    public static final <T> int j(List<? extends T> list) {
        n86.e(list, "$this$lastIndex");
        return list.size() - 1;
    }

    public static final <T, A extends Appendable> A k(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, s76<? super T, ? extends CharSequence> s76) {
        n86.e(iterable, "$this$joinTo");
        n86.e(a2, "buffer");
        n86.e(charSequence, "separator");
        n86.e(charSequence2, "prefix");
        n86.e(charSequence3, "postfix");
        n86.e(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (Object obj : iterable) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            hd3.m(a2, obj, s76);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ Appendable l(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, s76 s76, int i2) {
        int i3 = i2 & 64;
        k(iterable, appendable, (i2 & 2) != 0 ? ", " : charSequence, (i2 & 4) != 0 ? "" : null, (i2 & 8) != 0 ? "" : null, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : null, null);
        return appendable;
    }

    public static String m(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, s76 s76, int i2) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        String str = (i2 & 2) != 0 ? "" : charSequence2;
        String str2 = (i2 & 4) != 0 ? "" : charSequence3;
        int i3 = (i2 & 8) != 0 ? -1 : i;
        String str3 = (i2 & 16) != 0 ? "..." : null;
        s76 s762 = (i2 & 32) != 0 ? null : s76;
        n86.e(iterable, "$this$joinToString");
        n86.e(charSequence, "separator");
        n86.e(str, "prefix");
        n86.e(str2, "postfix");
        n86.e(str3, "truncated");
        StringBuilder sb = new StringBuilder();
        k(iterable, sb, charSequence, str, str2, i3, str3, s762);
        String sb2 = sb.toString();
        n86.d(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static final <T> List<T> n(T... tArr) {
        n86.e(tArr, "elements");
        n86.e(tArr, "$this$filterNotNull");
        ArrayList arrayList = new ArrayList();
        n86.e(tArr, "$this$filterNotNullTo");
        n86.e(arrayList, FirebaseAnalytics.Param.DESTINATION);
        for (T t : tArr) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> o(m56<? extends K, ? extends V>... m56Arr) {
        n86.e(m56Arr, "pairs");
        if (m56Arr.length <= 0) {
            return c66.f;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(hd3.f2(m56Arr.length));
        n86.e(m56Arr, "$this$toMap");
        n86.e(linkedHashMap, FirebaseAnalytics.Param.DESTINATION);
        n86.e(linkedHashMap, "$this$putAll");
        n86.e(m56Arr, "pairs");
        for (m56<? extends K, ? extends V> m56 : m56Arr) {
            linkedHashMap.put(m56.f, m56.g);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends java.lang.Comparable<? super T>> T p(java.lang.Iterable<? extends T> r3) {
        /*
            java.lang.String r0 = "$this$maxOrNull"
            defpackage.n86.e(r3, r0)
            java.util.Iterator r3 = r3.iterator()
            boolean r0 = r3.hasNext()
            if (r0 != 0) goto L_0x0011
            r3 = 0
            return r3
        L_0x0011:
            java.lang.Object r0 = r3.next()
            java.lang.Comparable r0 = (java.lang.Comparable) r0
        L_0x0017:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x002b
            java.lang.Object r1 = r3.next()
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            int r2 = r0.compareTo(r1)
            if (r2 >= 0) goto L_0x0017
            r0 = r1
            goto L_0x0017
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y56.p(java.lang.Iterable):java.lang.Comparable");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> q(List<? extends T> list) {
        n86.e(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size == 0) {
            return b66.f;
        }
        if (size != 1) {
            return list;
        }
        return hd3.c2(list.get(0));
    }

    public static final <T> List<T> r(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        n86.e(collection, "$this$plus");
        n86.e(iterable, "elements");
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection2.size() + collection.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        hd3.j(arrayList2, iterable);
        return arrayList2;
    }

    public static final <T> List<T> s(Collection<? extends T> collection, T t) {
        n86.e(collection, "$this$plus");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t);
        return arrayList;
    }

    public static final <T> Set<T> t(T... tArr) {
        d66 d66 = d66.f;
        n86.e(tArr, "elements");
        if (tArr.length <= 0) {
            return d66;
        }
        n86.e(tArr, "$this$toSet");
        int length = tArr.length;
        if (length == 0) {
            return d66;
        }
        if (length == 1) {
            return hd3.M2(tArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(hd3.f2(tArr.length));
        hd3.Z2(tArr, linkedHashSet);
        return linkedHashSet;
    }

    public static final <T extends Comparable<? super T>> List<T> u(Iterable<? extends T> iterable) {
        n86.e(iterable, "$this$sorted");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return y(iterable);
            }
            Object[] array = collection.toArray(new Comparable[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Comparable[] comparableArr = (Comparable[]) array;
            n86.e(comparableArr, "$this$sort");
            if (comparableArr.length > 1) {
                Arrays.sort(comparableArr);
            }
            return a(comparableArr);
        }
        List<T> A = A(iterable);
        hd3.T2(A);
        return A;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.Collection */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> v(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        n86.e(iterable, "$this$sortedWith");
        n86.e(comparator, "comparator");
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return y(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        n86.e(array, "$this$sortWith");
        n86.e(comparator, "comparator");
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        return a(array);
    }

    public static final void w() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static final <T, C extends Collection<? super T>> C x(Iterable<? extends T> iterable, C c) {
        n86.e(iterable, "$this$toCollection");
        n86.e(c, FirebaseAnalytics.Param.DESTINATION);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    public static final <T> List<T> y(Iterable<? extends T> iterable) {
        n86.e(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            return q(A(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return b66.f;
        }
        if (size != 1) {
            return B(collection);
        }
        return hd3.c2(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M z(Iterable<? extends m56<? extends K, ? extends V>> iterable, M m) {
        n86.e(iterable, "$this$toMap");
        n86.e(m, FirebaseAnalytics.Param.DESTINATION);
        n86.e(m, "$this$putAll");
        n86.e(iterable, "pairs");
        Iterator<? extends m56<? extends K, ? extends V>> it = iterable.iterator();
        while (it.hasNext()) {
            m56 m56 = (m56) it.next();
            m.put(m56.f, m56.g);
        }
        return m;
    }
}

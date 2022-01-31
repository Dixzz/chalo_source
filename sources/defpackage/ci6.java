package defpackage;

import com.google.firebase.analytics.FirebaseAnalytics;
import j$.lang.Iterable;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Spliterator;
import java.util.TreeMap;

/* renamed from: ci6  reason: default package */
/* compiled from: Headers.kt */
public final class ci6 implements Iterable<m56<? extends String, ? extends String>>, c96, Iterable {
    public static final b g = new b(null);
    public final String[] f;

    /* renamed from: ci6$a */
    /* compiled from: Headers.kt */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f569a = new ArrayList(20);

        public final a a(String str, String str2) {
            n86.f(str, "name");
            n86.f(str2, FirebaseAnalytics.Param.VALUE);
            b bVar = ci6.g;
            bVar.a(str);
            bVar.b(str2, str);
            c(str, str2);
            return this;
        }

        public final a b(String str) {
            n86.f(str, "line");
            int m = ea6.m(str, ':', 1, false, 4);
            if (m != -1) {
                String substring = str.substring(0, m);
                n86.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String substring2 = str.substring(m + 1);
                n86.b(substring2, "(this as java.lang.String).substring(startIndex)");
                c(substring, substring2);
            } else if (str.charAt(0) == ':') {
                String substring3 = str.substring(1);
                n86.b(substring3, "(this as java.lang.String).substring(startIndex)");
                c("", substring3);
            } else {
                c("", str);
            }
            return this;
        }

        public final a c(String str, String str2) {
            n86.f(str, "name");
            n86.f(str2, FirebaseAnalytics.Param.VALUE);
            this.f569a.add(str);
            this.f569a.add(ea6.K(str2).toString());
            return this;
        }

        public final ci6 d() {
            Object[] array = this.f569a.toArray(new String[0]);
            if (array != null) {
                return new ci6((String[]) array, null);
            }
            throw new p56("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final String e(String str) {
            n86.f(str, "name");
            i96 d = l96.d(l96.c(this.f569a.size() - 2, 0), 2);
            int i = d.f;
            int i2 = d.g;
            int i3 = d.h;
            if (i3 >= 0) {
                if (i > i2) {
                    return null;
                }
            } else if (i < i2) {
                return null;
            }
            while (!ea6.f(str, this.f569a.get(i), true)) {
                if (i == i2) {
                    return null;
                }
                i += i3;
            }
            return this.f569a.get(i + 1);
        }

        public final a f(String str) {
            n86.f(str, "name");
            int i = 0;
            while (i < this.f569a.size()) {
                if (ea6.f(str, this.f569a.get(i), true)) {
                    this.f569a.remove(i);
                    this.f569a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }
    }

    /* renamed from: ci6$b */
    /* compiled from: Headers.kt */
    public static final class b {
        public b(j86 j86) {
        }

        public final void a(String str) {
            if (str.length() > 0) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (!('!' <= charAt && '~' >= charAt)) {
                        throw new IllegalArgumentException(vi6.i("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str).toString());
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty".toString());
        }

        public final void b(String str, String str2) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (!(charAt == '\t' || (' ' <= charAt && '~' >= charAt))) {
                    throw new IllegalArgumentException(vi6.i("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str2, str).toString());
                }
            }
        }

        public final ci6 c(String... strArr) {
            n86.f(strArr, "namesAndValues");
            if (strArr.length % 2 == 0) {
                Object clone = strArr.clone();
                if (clone != null) {
                    String[] strArr2 = (String[]) clone;
                    int length = strArr2.length;
                    for (int i = 0; i < length; i++) {
                        if (strArr2[i] != null) {
                            String str = strArr2[i];
                            if (str != null) {
                                strArr2[i] = ea6.K(str).toString();
                            } else {
                                throw new p56("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                        } else {
                            throw new IllegalArgumentException("Headers cannot be null".toString());
                        }
                    }
                    i96 d = l96.d(l96.e(0, strArr2.length), 2);
                    int i2 = d.f;
                    int i3 = d.g;
                    int i4 = d.h;
                    if (i4 < 0 ? i2 >= i3 : i2 <= i3) {
                        while (true) {
                            String str2 = strArr2[i2];
                            String str3 = strArr2[i2 + 1];
                            a(str2);
                            b(str3, str2);
                            if (i2 == i3) {
                                break;
                            }
                            i2 += i4;
                        }
                    }
                    return new ci6(strArr2, null);
                }
                throw new p56("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }
    }

    public ci6(String[] strArr, j86 j86) {
        this.f = strArr;
    }

    public final String b(String str) {
        n86.f(str, "name");
        String[] strArr = this.f;
        i96 d = l96.d(l96.c(strArr.length - 2, 0), 2);
        int i = d.f;
        int i2 = d.g;
        int i3 = d.h;
        if (i3 < 0 ? i >= i2 : i <= i2) {
            while (!ea6.f(str, strArr[i], true)) {
                if (i != i2) {
                    i += i3;
                }
            }
            return strArr[i + 1];
        }
        return null;
    }

    public final String d(int i) {
        return this.f[i * 2];
    }

    public final a e() {
        a aVar = new a();
        List<String> list = aVar.f569a;
        String[] strArr = this.f;
        n86.e(list, "$this$addAll");
        n86.e(strArr, "elements");
        list.addAll(y56.a(strArr));
        return aVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ci6) && Arrays.equals(this.f, ((ci6) obj).f);
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f);
    }

    /* Return type fixed from 'java.util.Iterator<m56<java.lang.String, java.lang.String>>' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public Iterator<m56<? extends String, ? extends String>> iterator() {
        int size = size();
        m56[] m56Arr = new m56[size];
        for (int i = 0; i < size; i++) {
            m56Arr[i] = new m56(d(i), n(i));
        }
        n86.e(m56Arr, "array");
        return new e86(m56Arr);
    }

    public final Map<String, List<String>> k() {
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        n86.d(comparator, "java.lang.String.CASE_INSENSITIVE_ORDER");
        TreeMap treeMap = new TreeMap(comparator);
        int size = size();
        for (int i = 0; i < size; i++) {
            String d = d(i);
            Locale locale = Locale.US;
            n86.b(locale, "Locale.US");
            if (d != null) {
                String lowerCase = d.toLowerCase(locale);
                n86.b(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                List list = (List) treeMap.get(lowerCase);
                if (list == null) {
                    list = new ArrayList(2);
                    treeMap.put(lowerCase, list);
                }
                list.add(n(i));
            } else {
                throw new p56("null cannot be cast to non-null type java.lang.String");
            }
        }
        return treeMap;
    }

    public final String n(int i) {
        return this.f[(i * 2) + 1];
    }

    public final List<String> s(String str) {
        n86.f(str, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (ea6.f(str, d(i), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(n(i));
            }
        }
        if (arrayList == null) {
            return b66.f;
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        n86.b(unmodifiableList, "Collections.unmodifiableList(result)");
        return unmodifiableList;
    }

    public final int size() {
        return this.f.length / 2;
    }

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<m56<? extends String, ? extends String>> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            sb.append(d(i));
            sb.append(": ");
            sb.append(n(i));
            sb.append("\n");
        }
        String sb2 = sb.toString();
        n86.b(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}

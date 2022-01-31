package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: ml2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ml2 extends t83<String> implements RandomAccess, nl2 {
    public static final ml2 h;
    public final List<Object> g;

    static {
        ml2 ml2 = new ml2(10);
        h = ml2;
        ml2.f = false;
    }

    public ml2() {
        this(10);
    }

    public static String e(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof g93) {
            g93 g93 = (g93) obj;
            Charset charset = ka3.f2038a;
            if (g93.e() == 0) {
                return "";
            }
            return g93.u(charset);
        }
        Charset charset2 = ka3.f2038a;
        return new String((byte[]) obj, ka3.f2038a);
    }

    @Override // defpackage.ja3
    public final /* bridge */ /* synthetic */ ja3 D(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.g);
            return new ml2(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // defpackage.nl2
    public final void X(g93 g93) {
        b();
        this.g.add(g93);
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.nl2
    public final Object Z0(int i) {
        return this.g.get(i);
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        b();
        this.g.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, j$.util.List, defpackage.t83, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        b();
        if (collection instanceof nl2) {
            collection = ((nl2) collection).i();
        }
        boolean addAll = this.g.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.t83
    public final void clear() {
        b();
        this.g.clear();
        ((AbstractList) this).modCount++;
    }

    /* renamed from: d */
    public final String get(int i) {
        String str;
        Object obj = this.g.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof g93) {
            g93 g93 = (g93) obj;
            Charset charset = ka3.f2038a;
            if (g93.e() == 0) {
                str = "";
            } else {
                str = g93.u(charset);
            }
            if (g93.v()) {
                this.g.set(i, str);
            }
            return str;
        }
        byte[] bArr = (byte[]) obj;
        Charset charset2 = ka3.f2038a;
        String str2 = new String(bArr, ka3.f2038a);
        boolean z = false;
        if (qn2.f2965a.a(0, bArr, 0, bArr.length) == 0) {
            z = true;
        }
        if (z) {
            this.g.set(i, str2);
        }
        return str2;
    }

    @Override // defpackage.nl2
    public final nl2 h() {
        return this.f ? new en2(this) : this;
    }

    @Override // defpackage.nl2
    public final List<?> i() {
        return Collections.unmodifiableList(this.g);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.AbstractList, j$.util.List, defpackage.t83, java.util.List
    public final /* bridge */ /* synthetic */ String remove(int i) {
        b();
        Object remove = this.g.remove(i);
        ((AbstractList) this).modCount++;
        return e(remove);
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        b();
        return e(this.g.set(i, (String) obj));
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.g.size();
    }

    public ml2(int i) {
        this.g = new ArrayList(i);
    }

    public ml2(ArrayList<Object> arrayList) {
        this.g = arrayList;
    }

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.t83, java.util.AbstractCollection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }
}

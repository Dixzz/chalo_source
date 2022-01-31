package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: ih2  reason: default package */
public final class ih2 extends of2<String> implements jh2, RandomAccess {
    public static final ih2 h;
    public final List<Object> g;

    static {
        ih2 ih2 = new ih2(10);
        h = ih2;
        ih2.f = false;
    }

    public ih2(int i) {
        this.g = new ArrayList(i);
    }

    public ih2(ArrayList<Object> arrayList) {
        this.g = arrayList;
    }

    public static String d(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof uf2) {
            uf2 uf2 = (uf2) obj;
            Objects.requireNonNull(uf2);
            return uf2.size() == 0 ? "" : uf2.d(wg2.f3775a);
        }
        Charset charset = wg2.f3775a;
        return new String((byte[]) obj, wg2.f3775a);
    }

    @Override // defpackage.jh2
    public final Object a(int i) {
        return this.g.get(i);
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        b();
        this.g.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List, defpackage.of2
    public final boolean addAll(int i, Collection<? extends String> collection) {
        b();
        if (collection instanceof jh2) {
            collection = ((jh2) collection).g();
        }
        boolean addAll = this.g.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, java.util.AbstractCollection, java.util.List, defpackage.of2
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.of2
    public final void clear() {
        b();
        this.g.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.jh2
    public final List<?> g() {
        return Collections.unmodifiableList(this.g);
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final Object get(int i) {
        Object obj = this.g.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof uf2) {
            uf2 uf2 = (uf2) obj;
            Objects.requireNonNull(uf2);
            String d = uf2.size() == 0 ? "" : uf2.d(wg2.f3775a);
            if (uf2.k()) {
                this.g.set(i, d);
            }
            return d;
        }
        byte[] bArr = (byte[]) obj;
        Charset charset = wg2.f3775a;
        String str = new String(bArr, wg2.f3775a);
        boolean z = false;
        if (lj2.f2227a.a(0, bArr, 0, bArr.length) == 0) {
            z = true;
        }
        if (z) {
            this.g.set(i, str);
        }
        return str;
    }

    @Override // defpackage.jh2
    public final jh2 r() {
        return this.f ? new gj2(this) : this;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ Object remove(int i) {
        b();
        Object remove = this.g.remove(i);
        ((AbstractList) this).modCount++;
        return d(remove);
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        b();
        return d(this.g.set(i, (String) obj));
    }

    @Override // j$.util.Collection, j$.util.List
    public final int size() {
        return this.g.size();
    }

    @Override // defpackage.zg2
    public final /* synthetic */ zg2 y0(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.g);
            return new ih2(arrayList);
        }
        throw new IllegalArgumentException();
    }
}

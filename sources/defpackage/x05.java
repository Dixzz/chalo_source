package defpackage;

import defpackage.s05;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: x05  reason: default package */
/* compiled from: LazyStringArrayList */
public class x05 extends tz4<String> implements y05, RandomAccess {
    public static final x05 h;
    public final List<Object> g;

    static {
        x05 x05 = new x05(10);
        h = x05;
        x05.f = false;
    }

    public x05(int i) {
        this.g = new ArrayList(i);
    }

    public static String d(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof a05) {
            return ((a05) obj).B();
        }
        Charset charset = s05.f3160a;
        return new String((byte[]) obj, s05.f3160a);
    }

    @Override // defpackage.y05
    public void K(a05 a05) {
        b();
        this.g.add(a05);
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.y05
    public Object a(int i) {
        return this.g.get(i);
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public void add(int i, Object obj) {
        b();
        this.g.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.tz4, java.util.AbstractCollection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.tz4
    public void clear() {
        b();
        this.g.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.s05.j
    public s05.j f(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.g);
            return new x05(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object get(int i) {
        String str;
        Object obj = this.g.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof a05) {
            a05 a05 = (a05) obj;
            str = a05.B();
            if (a05.u()) {
                this.g.set(i, str);
            }
        } else {
            byte[] bArr = (byte[]) obj;
            Charset charset = s05.f3160a;
            str = new String(bArr, s05.f3160a);
            boolean z = false;
            if (j25.f1865a.e(0, bArr, 0, bArr.length) == 0) {
                z = true;
            }
            if (z) {
                this.g.set(i, str);
            }
        }
        return str;
    }

    @Override // defpackage.y05
    public List<?> m() {
        return Collections.unmodifiableList(this.g);
    }

    @Override // defpackage.y05
    public y05 q() {
        return this.f ? new h25(this) : this;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object remove(int i) {
        b();
        Object remove = this.g.remove(i);
        ((AbstractList) this).modCount++;
        return d(remove);
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public Object set(int i, Object obj) {
        b();
        return d(this.g.set(i, (String) obj));
    }

    @Override // j$.util.Collection, j$.util.List
    public int size() {
        return this.g.size();
    }

    @Override // java.util.AbstractList, j$.util.List, defpackage.tz4, java.util.List
    public boolean addAll(int i, Collection<? extends String> collection) {
        b();
        if (collection instanceof y05) {
            collection = ((y05) collection).m();
        }
        boolean addAll = this.g.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    public x05(ArrayList<Object> arrayList) {
        this.g = arrayList;
    }
}

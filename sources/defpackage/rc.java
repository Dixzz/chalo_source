package defpackage;

import defpackage.mc;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: rc  reason: default package */
/* compiled from: LazyStringArrayList */
public class rc extends pb<String> implements sc, RandomAccess {
    public static final rc h;
    public final List<Object> g;

    static {
        rc rcVar = new rc(10);
        h = rcVar;
        rcVar.f = false;
    }

    public rc(int i) {
        this.g = new ArrayList(i);
    }

    public static String d(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ub) {
            ub ubVar = (ub) obj;
            Objects.requireNonNull(ubVar);
            return ubVar.size() == 0 ? "" : ubVar.u(mc.f2352a);
        }
        Charset charset = mc.f2352a;
        return new String((byte[]) obj, mc.f2352a);
    }

    @Override // defpackage.sc
    public void Z(ub ubVar) {
        b();
        this.g.add(ubVar);
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.sc
    public Object a(int i) {
        return this.g.get(i);
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public void add(int i, Object obj) {
        b();
        this.g.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.pb, java.util.AbstractCollection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.pb
    public void clear() {
        b();
        this.g.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.mc.c
    public mc.c f(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.g);
            return new rc(arrayList);
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
        if (obj instanceof ub) {
            ub ubVar = (ub) obj;
            Objects.requireNonNull(ubVar);
            str = ubVar.size() == 0 ? "" : ubVar.u(mc.f2352a);
            if (ubVar.n()) {
                this.g.set(i, str);
            }
        } else {
            byte[] bArr = (byte[]) obj;
            Charset charset = mc.f2352a;
            str = new String(bArr, mc.f2352a);
            boolean z = false;
            if (de.f823a.c(0, bArr, 0, bArr.length) == 0) {
                z = true;
            }
            if (z) {
                this.g.set(i, str);
            }
        }
        return str;
    }

    @Override // defpackage.sc
    public List<?> m() {
        return Collections.unmodifiableList(this.g);
    }

    @Override // defpackage.sc
    public sc q() {
        return this.f ? new be(this) : this;
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

    @Override // java.util.AbstractList, j$.util.List, defpackage.pb, java.util.List
    public boolean addAll(int i, Collection<? extends String> collection) {
        b();
        if (collection instanceof sc) {
            collection = ((sc) collection).m();
        }
        boolean addAll = this.g.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    public rc(ArrayList<Object> arrayList) {
        this.g = arrayList;
    }
}

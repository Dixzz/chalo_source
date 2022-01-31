package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: ni3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class ni3 extends tg3<String> implements mi3, RandomAccess {
    public static final ni3 h;
    public final List<Object> g;

    static {
        ni3 ni3 = new ni3(10);
        h = ni3;
        ni3.f = false;
    }

    public ni3(int i) {
        this.g = new ArrayList(i);
    }

    public static String d(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof xg3) {
            xg3 xg3 = (xg3) obj;
            Objects.requireNonNull(xg3);
            return xg3.size() == 0 ? "" : xg3.e(zh3.f4175a);
        }
        Charset charset = zh3.f4175a;
        return new String((byte[]) obj, zh3.f4175a);
    }

    @Override // defpackage.ci3
    public final /* synthetic */ ci3 H0(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.g);
            return new ni3(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        b();
        this.g.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // j$.util.Collection, defpackage.tg3, java.util.Collection, j$.util.List, java.util.AbstractCollection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // j$.util.Collection, defpackage.tg3, j$.util.List
    public final void clear() {
        b();
        this.g.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final Object get(int i) {
        Object obj = this.g.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof xg3) {
            xg3 xg3 = (xg3) obj;
            Objects.requireNonNull(xg3);
            String e = xg3.size() == 0 ? "" : xg3.e(zh3.f4175a);
            if (xg3.n()) {
                this.g.set(i, e);
            }
            return e;
        }
        byte[] bArr = (byte[]) obj;
        Charset charset = zh3.f4175a;
        String str = new String(bArr, zh3.f4175a);
        boolean z = false;
        if (pk3.f2815a.a(0, bArr, 0, bArr.length) == 0) {
            z = true;
        }
        if (z) {
            this.g.set(i, str);
        }
        return str;
    }

    @Override // defpackage.mi3
    public final List<?> j0() {
        return Collections.unmodifiableList(this.g);
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

    @Override // defpackage.mi3
    public final Object w(int i) {
        return this.g.get(i);
    }

    @Override // defpackage.mi3
    public final mi3 x() {
        return this.f ? new lk3(this) : this;
    }

    @Override // defpackage.tg3, java.util.AbstractList, j$.util.List, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        b();
        if (collection instanceof mi3) {
            collection = ((mi3) collection).j0();
        }
        boolean addAll = this.g.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    public ni3(ArrayList<Object> arrayList) {
        this.g = arrayList;
    }
}

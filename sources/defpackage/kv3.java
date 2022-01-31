package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: kv3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class kv3 extends lt3<String> implements jv3, RandomAccess {
    public static final kv3 h;
    public final List<Object> g;

    static {
        kv3 kv3 = new kv3(10);
        h = kv3;
        kv3.f = false;
    }

    public kv3(int i) {
        this.g = new ArrayList(i);
    }

    public static String d(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof qt3) {
            qt3 qt3 = (qt3) obj;
            Objects.requireNonNull(qt3);
            return qt3.d() == 0 ? "" : qt3.s(tu3.f3407a);
        }
        Charset charset = tu3.f3407a;
        return new String((byte[]) obj, tu3.f3407a);
    }

    @Override // defpackage.jv3
    public final jv3 J() {
        return this.f ? new fx3(this) : this;
    }

    @Override // defpackage.jv3
    public final void M(qt3 qt3) {
        b();
        this.g.add(qt3);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, j$.util.List, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        b();
        this.g.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // j$.util.Collection, java.util.Collection, j$.util.List, defpackage.lt3, java.util.AbstractCollection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // j$.util.Collection, j$.util.List, defpackage.lt3
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
        if (obj instanceof qt3) {
            qt3 qt3 = (qt3) obj;
            Objects.requireNonNull(qt3);
            String s = qt3.d() == 0 ? "" : qt3.s(tu3.f3407a);
            if (qt3.z()) {
                this.g.set(i, s);
            }
            return s;
        }
        byte[] bArr = (byte[]) obj;
        Charset charset = tu3.f3407a;
        String str = new String(bArr, tu3.f3407a);
        boolean z = false;
        if (lx3.f2290a.a(0, bArr, 0, bArr.length) == 0) {
            z = true;
        }
        if (z) {
            this.g.set(i, str);
        }
        return str;
    }

    @Override // defpackage.zu3
    public final /* synthetic */ zu3 j(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.g);
            return new kv3(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // defpackage.jv3
    public final Object l(int i) {
        return this.g.get(i);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.AbstractList, j$.util.List, defpackage.lt3, java.util.List
    public final /* synthetic */ String remove(int i) {
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

    @Override // defpackage.jv3
    public final List<?> zzb() {
        return Collections.unmodifiableList(this.g);
    }

    @Override // java.util.AbstractList, j$.util.List, defpackage.lt3, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        b();
        if (collection instanceof jv3) {
            collection = ((jv3) collection).zzb();
        }
        boolean addAll = this.g.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    public kv3(ArrayList<Object> arrayList) {
        this.g = arrayList;
    }
}

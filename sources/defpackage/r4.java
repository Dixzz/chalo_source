package defpackage;

import java.util.ArrayList;
import java.util.HashSet;

/* renamed from: r4  reason: default package */
/* compiled from: DirectedAcyclicGraph */
public final class r4<T> {

    /* renamed from: a  reason: collision with root package name */
    public final v7<ArrayList<T>> f3036a = new w7(10);
    public final u2<T, ArrayList<T>> b = new u2<>();
    public final ArrayList<T> c = new ArrayList<>();
    public final HashSet<T> d = new HashSet<>();

    public void a(T t) {
        if (!(this.b.e(t) >= 0)) {
            this.b.put(t, null);
        }
    }

    public final void b(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList<T> orDefault = this.b.getOrDefault(t, null);
                if (orDefault != null) {
                    int size = orDefault.size();
                    for (int i = 0; i < size; i++) {
                        b(orDefault.get(i), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }
}

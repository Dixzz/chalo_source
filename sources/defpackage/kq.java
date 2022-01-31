package defpackage;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: kq  reason: default package */
/* compiled from: WorkContinuationImpl */
public class kq extends yp {
    public static final String j = tp.e("WorkContinuationImpl");

    /* renamed from: a  reason: collision with root package name */
    public final pq f2103a;
    public final String b;
    public final op c;
    public final List<? extends bq> d;
    public final List<String> e;
    public final List<String> f;
    public final List<kq> g = null;
    public boolean h;
    public wp i;

    public kq(pq pqVar, String str, op opVar, List<? extends bq> list, List<kq> list2) {
        this.f2103a = pqVar;
        this.b = str;
        this.c = opVar;
        this.d = list;
        this.e = new ArrayList(list.size());
        this.f = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String a2 = ((bq) list.get(i2)).a();
            this.e.add(a2);
            this.f.add(a2);
        }
    }

    public static boolean b(kq kqVar, Set<String> set) {
        set.addAll(kqVar.e);
        Set<String> c2 = c(kqVar);
        for (String str : set) {
            if (((HashSet) c2).contains(str)) {
                return true;
            }
        }
        List<kq> list = kqVar.g;
        if (list != null && !list.isEmpty()) {
            for (kq kqVar2 : list) {
                if (b(kqVar2, set)) {
                    return true;
                }
            }
        }
        set.removeAll(kqVar.e);
        return false;
    }

    public static Set<String> c(kq kqVar) {
        HashSet hashSet = new HashSet();
        List<kq> list = kqVar.g;
        if (list != null && !list.isEmpty()) {
            for (kq kqVar2 : list) {
                hashSet.addAll(kqVar2.e);
            }
        }
        return hashSet;
    }

    public wp a() {
        if (!this.h) {
            at atVar = new at(this);
            ((qt) this.f2103a.d).f2987a.execute(atVar);
            this.i = atVar.g;
        } else {
            tp.c().f(j, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.e)), new Throwable[0]);
        }
        return this.i;
    }
}

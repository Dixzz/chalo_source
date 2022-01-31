package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

/* renamed from: m36  reason: default package */
/* compiled from: Emitter */
public class m36 {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentMap<String, ConcurrentLinkedQueue<a>> f2318a = new ConcurrentHashMap();

    /* renamed from: m36$a */
    /* compiled from: Emitter */
    public interface a {
        void a(Object... objArr);
    }

    /* renamed from: m36$b */
    /* compiled from: Emitter */
    public class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public final String f2319a;
        public final a b;

        public b(String str, a aVar) {
            this.f2319a = str;
            this.b = aVar;
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            m36.this.c(this.f2319a, this);
            this.b.a(objArr);
        }
    }

    public m36 a(String str, Object... objArr) {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = this.f2318a.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator<a> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                it.next().a(objArr);
            }
        }
        return this;
    }

    public List<a> b(String str) {
        ArrayList arrayList;
        if (this.f2318a.get(str) == null) {
            arrayList = new ArrayList(0);
        }
        return arrayList;
    }

    public m36 c(String str, a aVar) {
        boolean z;
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = this.f2318a.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator<a> it = concurrentLinkedQueue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (aVar.equals(next)) {
                    z = true;
                    continue;
                } else if (next instanceof b) {
                    z = aVar.equals(((b) next).b);
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    it.remove();
                    break;
                }
            }
        }
        return this;
    }

    public m36 d(String str, a aVar) {
        ConcurrentLinkedQueue<a> putIfAbsent;
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = this.f2318a.get(str);
        if (concurrentLinkedQueue == null && (putIfAbsent = this.f2318a.putIfAbsent(str, (concurrentLinkedQueue = new ConcurrentLinkedQueue<>()))) != null) {
            concurrentLinkedQueue = putIfAbsent;
        }
        concurrentLinkedQueue.add(aVar);
        return this;
    }
}

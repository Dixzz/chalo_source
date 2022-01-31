package androidx.lifecycle;

import defpackage.zg;
import java.util.Map;

public abstract class LiveData<T> {
    public static final Object k = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Object f222a;
    public g2<ph<? super T>, LiveData<T>.c> b;
    public int c;
    public boolean d;
    public volatile Object e;
    public volatile Object f;
    public int g;
    public boolean h;
    public boolean i;
    public final Runnable j;

    public class LifecycleBoundObserver extends LiveData<T>.c implements dh {
        public final fh j;

        public LifecycleBoundObserver(fh fhVar, ph<? super T> phVar) {
            super(phVar);
            this.j = fhVar;
        }

        @Override // defpackage.dh
        public void c(fh fhVar, zg.a aVar) {
            zg.b bVar = ((gh) this.j.getLifecycle()).c;
            if (bVar == zg.b.DESTROYED) {
                LiveData.this.k(this.f);
                return;
            }
            zg.b bVar2 = null;
            while (bVar2 != bVar) {
                h(((gh) this.j.getLifecycle()).c.isAtLeast(zg.b.STARTED));
                bVar2 = bVar;
                bVar = ((gh) this.j.getLifecycle()).c;
            }
        }

        @Override // androidx.lifecycle.LiveData.c
        public void i() {
            gh ghVar = (gh) this.j.getLifecycle();
            ghVar.d("removeObserver");
            ghVar.b.n(this);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean j(fh fhVar) {
            return this.j == fhVar;
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean k() {
            return ((gh) this.j.getLifecycle()).c.isAtLeast(zg.b.STARTED);
        }
    }

    public class a implements Runnable {
        public a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: androidx.lifecycle.LiveData */
        /* JADX WARN: Multi-variable type inference failed */
        public void run() {
            Object obj;
            synchronized (LiveData.this.f222a) {
                obj = LiveData.this.f;
                LiveData.this.f = LiveData.k;
            }
            LiveData.this.l(obj);
        }
    }

    public class b extends LiveData<T>.c {
        public b(LiveData liveData, ph<? super T> phVar) {
            super(phVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean k() {
            return true;
        }
    }

    public abstract class c {
        public final ph<? super T> f;
        public boolean g;
        public int h = -1;

        public c(ph<? super T> phVar) {
            this.f = phVar;
        }

        public void h(boolean z) {
            if (z != this.g) {
                this.g = z;
                LiveData liveData = LiveData.this;
                int i2 = z ? 1 : -1;
                int i3 = liveData.c;
                liveData.c = i2 + i3;
                if (!liveData.d) {
                    liveData.d = true;
                    while (true) {
                        try {
                            int i4 = liveData.c;
                            if (i3 == i4) {
                                break;
                            }
                            boolean z2 = i3 == 0 && i4 > 0;
                            boolean z3 = i3 > 0 && i4 == 0;
                            if (z2) {
                                liveData.h();
                            } else if (z3) {
                                liveData.i();
                            }
                            i3 = i4;
                        } finally {
                            liveData.d = false;
                        }
                    }
                }
                if (this.g) {
                    LiveData.this.c(this);
                }
            }
        }

        public void i() {
        }

        public boolean j(fh fhVar) {
            return false;
        }

        public abstract boolean k();
    }

    public LiveData(T t) {
        this.f222a = new Object();
        this.b = new g2<>();
        this.c = 0;
        this.f = k;
        this.j = new a();
        this.e = t;
        this.g = 0;
    }

    public static void a(String str) {
        if (!c2.d().b()) {
            throw new IllegalStateException(hj1.T("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(LiveData<T>.c cVar) {
        if (cVar.g) {
            if (!cVar.k()) {
                cVar.h(false);
                return;
            }
            int i2 = cVar.h;
            int i3 = this.g;
            if (i2 < i3) {
                cVar.h = i3;
                cVar.f.a((Object) this.e);
            }
        }
    }

    public void c(LiveData<T>.c cVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (cVar == null) {
                g2<K, V>.d d2 = this.b.d();
                while (d2.hasNext()) {
                    b((c) ((Map.Entry) d2.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            } else {
                b(cVar);
                cVar = null;
            }
        } while (this.i);
        this.h = false;
    }

    public T d() {
        T t = (T) this.e;
        if (t != k) {
            return t;
        }
        return null;
    }

    public boolean e() {
        return this.c > 0;
    }

    public void f(fh fhVar, ph<? super T> phVar) {
        a("observe");
        if (((gh) fhVar.getLifecycle()).c != zg.b.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(fhVar, phVar);
            LiveData<T>.c k2 = this.b.k(phVar, lifecycleBoundObserver);
            if (k2 != null && !k2.j(fhVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (k2 == null) {
                fhVar.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    public void g(ph<? super T> phVar) {
        a("observeForever");
        b bVar = new b(this, phVar);
        LiveData<T>.c k2 = this.b.k(phVar, bVar);
        if (k2 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (k2 == null) {
            bVar.h(true);
        }
    }

    public void h() {
    }

    public void i() {
    }

    public void j(T t) {
        boolean z;
        synchronized (this.f222a) {
            z = this.f == k;
            this.f = t;
        }
        if (z) {
            c2.d().f505a.c(this.j);
        }
    }

    public void k(ph<? super T> phVar) {
        a("removeObserver");
        LiveData<T>.c n = this.b.n(phVar);
        if (n != null) {
            n.i();
            n.h(false);
        }
    }

    public void l(T t) {
        a("setValue");
        this.g++;
        this.e = t;
        c(null);
    }

    public LiveData() {
        this.f222a = new Object();
        this.b = new g2<>();
        this.c = 0;
        Object obj = k;
        this.f = obj;
        this.j = new a();
        this.e = obj;
        this.g = -1;
    }
}

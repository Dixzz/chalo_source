package defpackage;

import android.os.Handler;
import android.os.Looper;
import defpackage.jk;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* renamed from: vj  reason: default package */
/* compiled from: AsyncListDiffer */
public class vj<T> {
    public static final Executor h = new c();

    /* renamed from: a  reason: collision with root package name */
    public final pk f3653a;
    public final uj<T> b;
    public Executor c;
    public final List<b<T>> d = new CopyOnWriteArrayList();
    public List<T> e;
    public List<T> f = Collections.emptyList();
    public int g;

    /* renamed from: vj$a */
    /* compiled from: AsyncListDiffer */
    public class a implements Runnable {
        public final /* synthetic */ List f;
        public final /* synthetic */ List g;
        public final /* synthetic */ int h;
        public final /* synthetic */ Runnable i;

        /* renamed from: vj$a$a  reason: collision with other inner class name */
        /* compiled from: AsyncListDiffer */
        public class C0062a extends jk.b {
            public C0062a() {
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: jk$e<T> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // defpackage.jk.b
            public boolean areContentsTheSame(int i, int i2) {
                Object obj = a.this.f.get(i);
                Object obj2 = a.this.g.get(i2);
                if (obj != null && obj2 != null) {
                    return vj.this.b.b.a(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: jk$e<T> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // defpackage.jk.b
            public boolean areItemsTheSame(int i, int i2) {
                Object obj = a.this.f.get(i);
                Object obj2 = a.this.g.get(i2);
                if (obj == null || obj2 == null) {
                    return obj == null && obj2 == null;
                }
                return vj.this.b.b.b(obj, obj2);
            }

            @Override // defpackage.jk.b
            public Object getChangePayload(int i, int i2) {
                Object obj = a.this.f.get(i);
                Object obj2 = a.this.g.get(i2);
                if (obj == null || obj2 == null) {
                    throw new AssertionError();
                }
                Objects.requireNonNull(vj.this.b.b);
                return null;
            }

            @Override // defpackage.jk.b
            public int getNewListSize() {
                return a.this.g.size();
            }

            @Override // defpackage.jk.b
            public int getOldListSize() {
                return a.this.f.size();
            }
        }

        /* renamed from: vj$a$b */
        /* compiled from: AsyncListDiffer */
        public class b implements Runnable {
            public final /* synthetic */ jk.d f;

            public b(jk.d dVar) {
                this.f = dVar;
            }

            public void run() {
                a aVar = a.this;
                vj vjVar = vj.this;
                if (vjVar.g == aVar.h) {
                    List<T> list = aVar.g;
                    jk.d dVar = this.f;
                    Runnable runnable = aVar.i;
                    List<T> list2 = vjVar.f;
                    vjVar.e = list;
                    vjVar.f = Collections.unmodifiableList(list);
                    dVar.a(vjVar.f3653a);
                    vjVar.a(list2, runnable);
                }
            }
        }

        public a(List list, List list2, int i2, Runnable runnable) {
            this.f = list;
            this.g = list2;
            this.h = i2;
            this.i = runnable;
        }

        public void run() {
            vj.this.c.execute(new b(jk.a(new C0062a())));
        }
    }

    /* renamed from: vj$b */
    /* compiled from: AsyncListDiffer */
    public interface b<T> {
        void a(List<T> list, List<T> list2);
    }

    /* renamed from: vj$c */
    /* compiled from: AsyncListDiffer */
    public static class c implements Executor {
        public final Handler f = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            this.f.post(runnable);
        }
    }

    public vj(pk pkVar, uj<T> ujVar) {
        this.f3653a = pkVar;
        this.b = ujVar;
        this.c = h;
    }

    public final void a(List<T> list, Runnable runnable) {
        for (b<T> bVar : this.d) {
            bVar.a(list, this.f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void b(List<T> list, Runnable runnable) {
        int i = this.g + 1;
        this.g = i;
        List<T> list2 = this.e;
        if (list != list2) {
            List<T> list3 = this.f;
            if (list == null) {
                int size = list2.size();
                this.e = null;
                this.f = Collections.emptyList();
                this.f3653a.onRemoved(0, size);
                a(list3, runnable);
            } else if (list2 == null) {
                this.e = list;
                this.f = Collections.unmodifiableList(list);
                this.f3653a.onInserted(0, list.size());
                a(list3, runnable);
            } else {
                this.b.f3511a.execute(new a(list2, list, i, runnable));
            }
        } else if (runnable != null) {
            runnable.run();
        }
    }
}

package defpackage;

import android.os.Bundle;
import android.os.Looper;
import defpackage.ii;
import defpackage.li;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.Objects;

/* renamed from: ji  reason: default package */
/* compiled from: LoaderManagerImpl */
public class ji extends ii {

    /* renamed from: a  reason: collision with root package name */
    public final fh f1927a;
    public final c b;

    /* renamed from: ji$a */
    /* compiled from: LoaderManagerImpl */
    public static class a<D> extends oh<D> implements li.b<D> {
        public final int l;
        public final Bundle m;
        public final li<D> n;
        public fh o;
        public b<D> p;
        public li<D> q;

        public a(int i, Bundle bundle, li<D> liVar, li<D> liVar2) {
            this.l = i;
            this.m = bundle;
            this.n = liVar;
            this.q = liVar2;
            liVar.registerListener(i, this);
        }

        @Override // androidx.lifecycle.LiveData
        public void h() {
            this.n.startLoading();
        }

        @Override // androidx.lifecycle.LiveData
        public void i() {
            this.n.stopLoading();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: ph<? super D> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void k(ph<? super D> phVar) {
            super.k(phVar);
            this.o = null;
            this.p = null;
        }

        @Override // androidx.lifecycle.LiveData, defpackage.oh
        public void l(D d) {
            super.l(d);
            li<D> liVar = this.q;
            if (liVar != null) {
                liVar.reset();
                this.q = null;
            }
        }

        public li<D> m(boolean z) {
            this.n.cancelLoad();
            this.n.abandon();
            b<D> bVar = this.p;
            if (bVar != null) {
                super.k(bVar);
                this.o = null;
                this.p = null;
                if (z && bVar.c) {
                    bVar.b.onLoaderReset(bVar.f1928a);
                }
            }
            this.n.unregisterListener(this);
            if ((bVar == null || bVar.c) && !z) {
                return this.n;
            }
            this.n.reset();
            return this.q;
        }

        public void n() {
            fh fhVar = this.o;
            b<D> bVar = this.p;
            if (fhVar != null && bVar != null) {
                super.k(bVar);
                f(fhVar, bVar);
            }
        }

        public void o(li<D> liVar, D d) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                super.l(d);
                li<D> liVar2 = this.q;
                if (liVar2 != null) {
                    liVar2.reset();
                    this.q = null;
                    return;
                }
                return;
            }
            j(d);
        }

        public li<D> p(fh fhVar, ii.a<D> aVar) {
            b<D> bVar = new b<>(this.n, aVar);
            f(fhVar, bVar);
            b<D> bVar2 = this.p;
            if (bVar2 != null) {
                k(bVar2);
            }
            this.o = fhVar;
            this.p = bVar;
            return this.n;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.l);
            sb.append(" : ");
            h.i(this.n, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: ji$b */
    /* compiled from: LoaderManagerImpl */
    public static class b<D> implements ph<D> {

        /* renamed from: a  reason: collision with root package name */
        public final li<D> f1928a;
        public final ii.a<D> b;
        public boolean c = false;

        public b(li<D> liVar, ii.a<D> aVar) {
            this.f1928a = liVar;
            this.b = aVar;
        }

        @Override // defpackage.ph
        public void a(D d) {
            this.b.onLoadFinished(this.f1928a, d);
            this.c = true;
        }

        public String toString() {
            return this.b.toString();
        }
    }

    /* renamed from: ji$c */
    /* compiled from: LoaderManagerImpl */
    public static class c extends zh {
        public static final ci e = new a();
        public v2<a> c = new v2<>();
        public boolean d = false;

        /* renamed from: ji$c$a */
        /* compiled from: LoaderManagerImpl */
        public static class a implements ci {
            @Override // defpackage.ci
            public <T extends zh> T a(Class<T> cls) {
                return new c();
            }
        }

        @Override // defpackage.zh
        public void b() {
            int h = this.c.h();
            for (int i = 0; i < h; i++) {
                this.c.i(i).m(true);
            }
            v2<a> v2Var = this.c;
            int i2 = v2Var.i;
            Object[] objArr = v2Var.h;
            for (int i3 = 0; i3 < i2; i3++) {
                objArr[i3] = null;
            }
            v2Var.i = 0;
            v2Var.f = false;
        }
    }

    public ji(fh fhVar, gi giVar) {
        zh zhVar;
        this.f1927a = fhVar;
        ci ciVar = c.e;
        String canonicalName = c.class.getCanonicalName();
        if (canonicalName != null) {
            String S = hj1.S("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            zh zhVar2 = giVar.f1264a.get(S);
            if (!c.class.isInstance(zhVar2)) {
                if (ciVar instanceof di) {
                    zhVar = ((di) ciVar).c(S, c.class);
                } else {
                    zhVar = ((c.a) ciVar).a(c.class);
                }
                zhVar2 = zhVar;
                zh put = giVar.f1264a.put(S, zhVar2);
                if (put != null) {
                    put.b();
                }
            } else if (ciVar instanceof fi) {
                ((fi) ciVar).b(zhVar2);
            }
            this.b = (c) zhVar2;
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // defpackage.ii
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        c cVar = this.b;
        if (cVar.c.h() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < cVar.c.h(); i++) {
                a i2 = cVar.c.i(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(cVar.c.f(i));
                printWriter.print(": ");
                printWriter.println(i2.toString());
                printWriter.print(str2);
                printWriter.print("mId=");
                printWriter.print(i2.l);
                printWriter.print(" mArgs=");
                printWriter.println(i2.m);
                printWriter.print(str2);
                printWriter.print("mLoader=");
                printWriter.println(i2.n);
                i2.n.dump(hj1.S(str2, "  "), fileDescriptor, printWriter, strArr);
                if (i2.p != null) {
                    printWriter.print(str2);
                    printWriter.print("mCallbacks=");
                    printWriter.println(i2.p);
                    b<D> bVar = i2.p;
                    Objects.requireNonNull(bVar);
                    printWriter.print(str2 + "  ");
                    printWriter.print("mDeliveredData=");
                    printWriter.println(bVar.c);
                }
                printWriter.print(str2);
                printWriter.print("mData=");
                printWriter.println(i2.n.dataToString((D) i2.d()));
                printWriter.print(str2);
                printWriter.print("mStarted=");
                printWriter.println(i2.e());
            }
        }
    }

    @Override // defpackage.ii
    public <D> li<D> c(int i, Bundle bundle, ii.a<D> aVar) {
        if (this.b.d) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            a e = this.b.c.e(i, null);
            if (e == null) {
                return e(i, bundle, aVar, null);
            }
            return e.p(this.f1927a, aVar);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    @Override // defpackage.ii
    public <D> li<D> d(int i, Bundle bundle, ii.a<D> aVar) {
        if (this.b.d) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            li<D> liVar = null;
            a e = this.b.c.e(i, null);
            if (e != null) {
                liVar = e.m(false);
            }
            return e(i, bundle, aVar, liVar);
        } else {
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
    }

    /* JADX INFO: finally extract failed */
    public final <D> li<D> e(int i, Bundle bundle, ii.a<D> aVar, li<D> liVar) {
        try {
            this.b.d = true;
            li<D> onCreateLoader = aVar.onCreateLoader(i, bundle);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass()) {
                    if (!Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                    }
                }
                a aVar2 = new a(i, bundle, onCreateLoader, liVar);
                this.b.c.g(i, aVar2);
                this.b.d = false;
                return aVar2.p(this.f1927a, aVar);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.b.d = false;
            throw th;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        h.i(this.f1927a, sb);
        sb.append("}}");
        return sb.toString();
    }
}

package androidx.activity;

import android.annotation.SuppressLint;
import defpackage.zg;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f187a;
    public final ArrayDeque<l> b = new ArrayDeque<>();

    public class LifecycleOnBackPressedCancellable implements dh, k {
        public final zg f;
        public final l g;
        public k h;

        public LifecycleOnBackPressedCancellable(zg zgVar, l lVar) {
            this.f = zgVar;
            this.g = lVar;
            zgVar.a(this);
        }

        @Override // defpackage.dh
        public void c(fh fhVar, zg.a aVar) {
            if (aVar == zg.a.ON_START) {
                OnBackPressedDispatcher onBackPressedDispatcher = OnBackPressedDispatcher.this;
                l lVar = this.g;
                onBackPressedDispatcher.b.add(lVar);
                a aVar2 = new a(lVar);
                lVar.b.add(aVar2);
                this.h = aVar2;
            } else if (aVar == zg.a.ON_STOP) {
                k kVar = this.h;
                if (kVar != null) {
                    kVar.cancel();
                }
            } else if (aVar == zg.a.ON_DESTROY) {
                cancel();
            }
        }

        @Override // defpackage.k
        public void cancel() {
            gh ghVar = (gh) this.f;
            ghVar.d("removeObserver");
            ghVar.b.n(this);
            this.g.b.remove(this);
            k kVar = this.h;
            if (kVar != null) {
                kVar.cancel();
                this.h = null;
            }
        }
    }

    public class a implements k {
        public final l f;

        public a(l lVar) {
            this.f = lVar;
        }

        @Override // defpackage.k
        public void cancel() {
            OnBackPressedDispatcher.this.b.remove(this.f);
            this.f.b.remove(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f187a = runnable;
    }

    @SuppressLint({"LambdaLast"})
    public void a(fh fhVar, l lVar) {
        zg lifecycle = fhVar.getLifecycle();
        if (((gh) lifecycle).c != zg.b.DESTROYED) {
            lVar.b.add(new LifecycleOnBackPressedCancellable(lifecycle, lVar));
        }
    }

    public void b() {
        Iterator<l> descendingIterator = this.b.descendingIterator();
        while (descendingIterator.hasNext()) {
            l next = descendingIterator.next();
            if (next.f2142a) {
                next.a();
                return;
            }
        }
        Runnable runnable = this.f187a;
        if (runnable != null) {
            runnable.run();
        }
    }
}

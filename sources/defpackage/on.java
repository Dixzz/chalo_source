package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: on  reason: default package */
/* compiled from: TransitionManager */
public class on {

    /* renamed from: a  reason: collision with root package name */
    public static kn f2712a = new dn();
    public static ThreadLocal<WeakReference<n2<ViewGroup, ArrayList<kn>>>> b = new ThreadLocal<>();
    public static ArrayList<ViewGroup> c = new ArrayList<>();

    /* renamed from: on$a */
    /* compiled from: TransitionManager */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        public kn f;
        public ViewGroup g;

        /* renamed from: on$a$a  reason: collision with other inner class name */
        /* compiled from: TransitionManager */
        public class C0047a extends nn {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ n2 f2713a;

            public C0047a(n2 n2Var) {
                this.f2713a = n2Var;
            }

            @Override // defpackage.kn.d
            public void c(kn knVar) {
                ((ArrayList) this.f2713a.get(a.this.g)).remove(knVar);
                knVar.w(this);
            }
        }

        public a(kn knVar, ViewGroup viewGroup) {
            this.f = knVar;
            this.g = viewGroup;
        }

        /* JADX WARNING: Removed duplicated region for block: B:104:0x0242  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x01ef A[EDGE_INSN: B:133:0x01ef->B:88:0x01ef ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x009f  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x01f4  */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x0215  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onPreDraw() {
            /*
            // Method dump skipped, instructions count: 692
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.on.a.onPreDraw():boolean");
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            this.g.getViewTreeObserver().removeOnPreDrawListener(this);
            this.g.removeOnAttachStateChangeListener(this);
            on.c.remove(this.g);
            ArrayList<kn> arrayList = on.a().get(this.g);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<kn> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().y(this.g);
                }
            }
            this.f.i(true);
        }
    }

    public static n2<ViewGroup, ArrayList<kn>> a() {
        n2<ViewGroup, ArrayList<kn>> n2Var;
        WeakReference<n2<ViewGroup, ArrayList<kn>>> weakReference = b.get();
        if (weakReference != null && (n2Var = weakReference.get()) != null) {
            return n2Var;
        }
        n2<ViewGroup, ArrayList<kn>> n2Var2 = new n2<>();
        b.set(new WeakReference<>(n2Var2));
        return n2Var2;
    }
}

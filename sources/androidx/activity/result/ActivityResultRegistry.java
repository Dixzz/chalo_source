package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import defpackage.zg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public abstract class ActivityResultRegistry {

    /* renamed from: a  reason: collision with root package name */
    public Random f188a = new Random();
    public final Map<Integer, String> b = new HashMap();
    public final Map<String, Integer> c = new HashMap();
    public final Map<String, d> d = new HashMap();
    public ArrayList<String> e = new ArrayList<>();
    public final transient Map<String, c<?>> f = new HashMap();
    public final Map<String, Object> g = new HashMap();
    public final Bundle h = new Bundle();

    public class a extends r<I> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f189a;
        public final /* synthetic */ int b;
        public final /* synthetic */ t c;

        public a(String str, int i, t tVar) {
            this.f189a = str;
            this.b = i;
            this.c = tVar;
        }

        @Override // defpackage.r
        public void a(I i, v4 v4Var) {
            ActivityResultRegistry.this.e.add(this.f189a);
            Integer num = ActivityResultRegistry.this.c.get(this.f189a);
            ActivityResultRegistry.this.b(num != null ? num.intValue() : this.b, this.c, i, v4Var);
        }

        @Override // defpackage.r
        public void b() {
            ActivityResultRegistry.this.f(this.f189a);
        }
    }

    public class b extends r<I> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f190a;
        public final /* synthetic */ int b;
        public final /* synthetic */ t c;

        public b(String str, int i, t tVar) {
            this.f190a = str;
            this.b = i;
            this.c = tVar;
        }

        @Override // defpackage.r
        public void a(I i, v4 v4Var) {
            ActivityResultRegistry.this.e.add(this.f190a);
            Integer num = ActivityResultRegistry.this.c.get(this.f190a);
            ActivityResultRegistry.this.b(num != null ? num.intValue() : this.b, this.c, i, v4Var);
        }

        @Override // defpackage.r
        public void b() {
            ActivityResultRegistry.this.f(this.f190a);
        }
    }

    public static class c<O> {

        /* renamed from: a  reason: collision with root package name */
        public final q<O> f191a;
        public final t<?, O> b;

        public c(q<O> qVar, t<?, O> tVar) {
            this.f191a = qVar;
            this.b = tVar;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final zg f192a;
        public final ArrayList<dh> b = new ArrayList<>();

        public d(zg zgVar) {
            this.f192a = zgVar;
        }
    }

    public final boolean a(int i, int i2, Intent intent) {
        q<O> qVar;
        String str = this.b.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.e.remove(str);
        c<?> cVar = this.f.get(str);
        if (cVar == null || (qVar = cVar.f191a) == null) {
            this.g.remove(str);
            this.h.putParcelable(str, new ActivityResult(i2, intent));
            return true;
        }
        qVar.a(cVar.b.c(i2, intent));
        return true;
    }

    public abstract <I, O> void b(int i, t<I, O> tVar, @SuppressLint({"UnknownNullness"}) I i2, v4 v4Var);

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: q<O> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> r<I> c(String str, t<I, O> tVar, q<O> qVar) {
        int e2 = e(str);
        this.f.put(str, new c<>(qVar, tVar));
        if (this.g.containsKey(str)) {
            Object obj = this.g.get(str);
            this.g.remove(str);
            qVar.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.h.getParcelable(str);
        if (activityResult != null) {
            this.h.remove(str);
            qVar.a(tVar.c(activityResult.f, activityResult.g));
        }
        return new b(str, e2, tVar);
    }

    public final <I, O> r<I> d(final String str, fh fhVar, final t<I, O> tVar, final q<O> qVar) {
        zg lifecycle = fhVar.getLifecycle();
        gh ghVar = (gh) lifecycle;
        if (!ghVar.c.isAtLeast(zg.b.STARTED)) {
            int e2 = e(str);
            d dVar = this.d.get(str);
            if (dVar == null) {
                dVar = new d(lifecycle);
            }
            AnonymousClass1 r0 = new dh() {
                /* class androidx.activity.result.ActivityResultRegistry.AnonymousClass1 */

                @Override // defpackage.dh
                public void c(fh fhVar, zg.a aVar) {
                    if (zg.a.ON_START.equals(aVar)) {
                        ActivityResultRegistry.this.f.put(str, new c<>(qVar, tVar));
                        if (ActivityResultRegistry.this.g.containsKey(str)) {
                            Object obj = ActivityResultRegistry.this.g.get(str);
                            ActivityResultRegistry.this.g.remove(str);
                            qVar.a(obj);
                        }
                        ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.h.getParcelable(str);
                        if (activityResult != null) {
                            ActivityResultRegistry.this.h.remove(str);
                            qVar.a(tVar.c(activityResult.f, activityResult.g));
                        }
                    } else if (zg.a.ON_STOP.equals(aVar)) {
                        ActivityResultRegistry.this.f.remove(str);
                    } else if (zg.a.ON_DESTROY.equals(aVar)) {
                        ActivityResultRegistry.this.f(str);
                    }
                }
            };
            dVar.f192a.a(r0);
            dVar.b.add(r0);
            this.d.put(str, dVar);
            return new a(str, e2, tVar);
        }
        throw new IllegalStateException("LifecycleOwner " + fhVar + " is attempting to register while current state is " + ghVar.c + ". LifecycleOwners must call register before they are STARTED.");
    }

    public final int e(String str) {
        Integer num = this.c.get(str);
        if (num != null) {
            return num.intValue();
        }
        int nextInt = this.f188a.nextInt(2147418112);
        while (true) {
            int i = nextInt + 65536;
            if (this.b.containsKey(Integer.valueOf(i))) {
                nextInt = this.f188a.nextInt(2147418112);
            } else {
                this.b.put(Integer.valueOf(i), str);
                this.c.put(str, Integer.valueOf(i));
                return i;
            }
        }
    }

    public final void f(String str) {
        Integer remove;
        if (!this.e.contains(str) && (remove = this.c.remove(str)) != null) {
            this.b.remove(remove);
        }
        this.f.remove(str);
        if (this.g.containsKey(str)) {
            StringBuilder l0 = hj1.l0("Dropping pending result for request ", str, ": ");
            l0.append(this.g.get(str));
            l0.toString();
            this.g.remove(str);
        }
        if (this.h.containsKey(str)) {
            StringBuilder l02 = hj1.l0("Dropping pending result for request ", str, ": ");
            l02.append(this.h.getParcelable(str));
            l02.toString();
            this.h.remove(str);
        }
        d dVar = this.d.get(str);
        if (dVar != null) {
            Iterator<dh> it = dVar.b.iterator();
            while (it.hasNext()) {
                dVar.f192a.b(it.next());
            }
            dVar.b.clear();
            this.d.remove(str);
        }
    }
}

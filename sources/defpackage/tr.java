package defpackage;

import android.content.Context;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: tr  reason: default package */
/* compiled from: ConstraintTracker */
public abstract class tr<T> {
    public static final String f = tp.e("ConstraintTracker");

    /* renamed from: a  reason: collision with root package name */
    public final pt f3397a;
    public final Context b;
    public final Object c = new Object();
    public final Set<er<T>> d = new LinkedHashSet();
    public T e;

    /* renamed from: tr$a */
    /* compiled from: ConstraintTracker */
    public class a implements Runnable {
        public final /* synthetic */ List f;

        public a(List list) {
            this.f = list;
        }

        public void run() {
            for (er erVar : this.f) {
                erVar.a(tr.this.e);
            }
        }
    }

    public tr(Context context, pt ptVar) {
        this.b = context.getApplicationContext();
        this.f3397a = ptVar;
    }

    public abstract T a();

    public void b(er<T> erVar) {
        synchronized (this.c) {
            if (this.d.remove(erVar) && this.d.isEmpty()) {
                e();
            }
        }
    }

    public void c(T t) {
        synchronized (this.c) {
            T t2 = this.e;
            if (t2 != t) {
                if (t2 == null || !t2.equals(t)) {
                    this.e = t;
                    ((qt) this.f3397a).c.execute(new a(new ArrayList(this.d)));
                }
            }
        }
    }

    public abstract void d();

    public abstract void e();
}

package defpackage;

import android.content.Context;
import app.zophop.models.mTicketing.FareMap;
import defpackage.kr;

/* renamed from: hr  reason: default package */
/* compiled from: WorkConstraintsTracker */
public class hr implements kr.a {
    public static final String d = tp.e("WorkConstraintsTracker");

    /* renamed from: a  reason: collision with root package name */
    public final gr f1414a;
    public final kr<?>[] b;
    public final Object c = new Object();

    public hr(Context context, pt ptVar, gr grVar) {
        Context applicationContext = context.getApplicationContext();
        this.f1414a = grVar;
        this.b = new kr[]{new ir(applicationContext, ptVar), new jr(applicationContext, ptVar), new pr(applicationContext, ptVar), new lr(applicationContext, ptVar), new or(applicationContext, ptVar), new nr(applicationContext, ptVar), new mr(applicationContext, ptVar)};
    }

    public boolean a(String str) {
        synchronized (this.c) {
            kr<?>[] krVarArr = this.b;
            for (kr<?> krVar : krVarArr) {
                FareMap fareMap = (T) krVar.b;
                if (fareMap != null && krVar.c(fareMap) && krVar.f2107a.contains(str)) {
                    tp.c().a(d, String.format("Work %s constrained by %s", str, krVar.getClass().getSimpleName()), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void b(Iterable<rs> iterable) {
        synchronized (this.c) {
            kr<?>[] krVarArr = this.b;
            for (kr<?> krVar : krVarArr) {
                if (krVar.d != null) {
                    krVar.d = null;
                    krVar.e(null, (T) krVar.b);
                }
            }
            for (kr<?> krVar2 : this.b) {
                krVar2.d(iterable);
            }
            kr<?>[] krVarArr2 = this.b;
            for (kr<?> krVar3 : krVarArr2) {
                if (krVar3.d != this) {
                    krVar3.d = this;
                    krVar3.e(this, (T) krVar3.b);
                }
            }
        }
    }

    public void c() {
        synchronized (this.c) {
            kr<?>[] krVarArr = this.b;
            for (kr<?> krVar : krVarArr) {
                if (!krVar.f2107a.isEmpty()) {
                    krVar.f2107a.clear();
                    krVar.c.b(krVar);
                }
            }
        }
    }
}

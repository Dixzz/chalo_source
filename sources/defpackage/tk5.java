package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.urbanairship.UAirship;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.json.JsonValue;
import defpackage.qk5;
import java.util.concurrent.Executor;

/* renamed from: tk5  reason: default package */
/* compiled from: ActionRunRequest */
public class tk5 {

    /* renamed from: a  reason: collision with root package name */
    public qk5 f3371a;
    public String b;
    public ActionValue c;
    public Bundle d;
    public Executor e = pj5.f2814a;
    public int f = 0;

    /* renamed from: tk5$a */
    /* compiled from: ActionRunRequest */
    public class a extends b {
        public final /* synthetic */ pk5 i;
        public final /* synthetic */ Handler j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(tk5 tk5, ok5 ok5, pk5 pk5, Handler handler) {
            super(ok5);
            this.i = pk5;
            this.j = handler;
        }
    }

    /* renamed from: tk5$b */
    /* compiled from: ActionRunRequest */
    public abstract class b implements Runnable {
        public volatile rk5 f;
        public final ok5 g;

        public b(ok5 ok5) {
            this.g = ok5;
        }

        public final void run() {
            rk5 rk5;
            tk5 tk5 = tk5.this;
            ok5 ok5 = this.g;
            String str = tk5.b;
            if (str != null) {
                qk5.a b = tk5.b(str);
                if (b == null) {
                    rk5 = rk5.b(3);
                } else {
                    qk5.b bVar = b.d;
                    if (bVar == null || bVar.a(ok5)) {
                        rk5 = b.a(tk5.f).e(ok5);
                    } else {
                        yj5.f("Action %s will not be run. Registry predicate rejected the arguments: %s", tk5.b, ok5);
                        rk5 = rk5.b(2);
                    }
                }
            } else {
                rk5 = rk5.b(3);
            }
            this.f = rk5;
            ok5 ok52 = this.g;
            rk5 rk52 = this.f;
            a aVar = (a) this;
            if (aVar.i != null) {
                if (aVar.j.getLooper() == Looper.myLooper()) {
                    aVar.i.a(ok52, rk52);
                } else {
                    aVar.j.post(new sk5(aVar, ok52, rk52));
                }
            }
        }
    }

    public tk5(String str, qk5 qk5) {
        this.b = str;
        this.f3371a = null;
    }

    public static tk5 a(String str) {
        return new tk5(str, null);
    }

    public final qk5.a b(String str) {
        qk5 qk5 = this.f3371a;
        if (qk5 != null) {
            return qk5.a(str);
        }
        return UAirship.l().d.a(str);
    }

    public void c(Looper looper, pk5 pk5) {
        if (looper == null && (looper = Looper.myLooper()) == null) {
            looper = Looper.getMainLooper();
        }
        Bundle bundle = this.d == null ? new Bundle() : new Bundle(this.d);
        String str = this.b;
        if (str != null) {
            bundle.putString("com.urbanairship.REGISTRY_ACTION_NAME", str);
        }
        ok5 ok5 = new ok5(this.f, this.c, bundle);
        a aVar = new a(this, ok5, pk5, new Handler(looper));
        qk5.a b2 = b(this.b);
        if (!(b2 != null && b2.a(ok5.f2706a).f())) {
            this.e.execute(aVar);
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            aVar.run();
        } else {
            new Handler(Looper.getMainLooper()).post(aVar);
        }
    }

    public tk5 d(Object obj) {
        try {
            this.c = new ActionValue(JsonValue.r(obj));
            return this;
        } catch (xt5 e2) {
            throw new wk5("Invalid ActionValue object: " + obj, e2);
        } catch (wk5 e3) {
            throw new IllegalArgumentException("Unable to wrap object: " + obj + " as an ActionValue.", e3);
        }
    }
}

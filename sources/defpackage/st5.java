package defpackage;

import com.urbanairship.UAirship;
import com.urbanairship.job.AirshipWorker;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* renamed from: st5  reason: default package */
/* compiled from: JobRunnable */
public class st5 implements Runnable {
    public static final Executor h = pj5.a();
    public final rt5 f;
    public final c g;

    /* renamed from: st5$a */
    /* compiled from: JobRunnable */
    public class a implements Runnable {
        public final /* synthetic */ oj5 f;
        public final /* synthetic */ UAirship g;

        public a(oj5 oj5, UAirship uAirship) {
            this.f = oj5;
            this.g = uAirship;
        }

        public void run() {
            int g2 = this.f.g(this.g, st5.this.f);
            yj5.h("Finished: %s with result: %s", st5.this.f, Integer.valueOf(g2));
            st5 st5 = st5.this;
            c cVar = st5.g;
            if (cVar != null) {
                ((AirshipWorker.a.C0016a) cVar).a(st5, g2);
            }
        }
    }

    /* renamed from: st5$b */
    /* compiled from: JobRunnable */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final rt5 f3255a;
        public c b;

        public b(rt5 rt5) {
            this.f3255a = rt5;
        }
    }

    /* renamed from: st5$c */
    /* compiled from: JobRunnable */
    public interface c {
    }

    public st5(b bVar, a aVar) {
        this.f = bVar.f3255a;
        this.g = bVar.b;
    }

    public void run() {
        UAirship n = UAirship.n(5000);
        if (n == null) {
            yj5.c("UAirship not ready. Rescheduling job: %s", this.f);
            c cVar = this.g;
            if (cVar != null) {
                ((AirshipWorker.a.C0016a) cVar).a(this, 1);
                return;
            }
            return;
        }
        String str = this.f.c;
        oj5 oj5 = null;
        if (!hd3.G1(str)) {
            Iterator<oj5> it = n.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                oj5 next = it.next();
                if (next.getClass().getName().equals(str)) {
                    oj5 = next;
                    break;
                }
            }
        }
        if (oj5 == null) {
            yj5.c("Unavailable to find airship components for jobInfo: %s", this.f);
            c cVar2 = this.g;
            if (cVar2 != null) {
                ((AirshipWorker.a.C0016a) cVar2).a(this, 0);
            }
        } else if (!oj5.c()) {
            yj5.a("Component disabled. Dropping jobInfo: %s", this.f);
            c cVar3 = this.g;
            if (cVar3 != null) {
                ((AirshipWorker.a.C0016a) cVar3).a(this, 0);
            }
        } else {
            oj5.d.execute(new a(oj5, n));
        }
    }
}

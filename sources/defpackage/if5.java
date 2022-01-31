package defpackage;

import com.squareup.picasso.Picasso;
import defpackage.rf5;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: if5  reason: default package */
/* compiled from: PicassoExecutorService */
public class if5 extends ThreadPoolExecutor {

    /* renamed from: if5$a */
    /* compiled from: PicassoExecutorService */
    public static final class a extends FutureTask<ne5> implements Comparable<a> {
        public final ne5 f;

        public a(ne5 ne5) {
            super(ne5, null);
            this.f = ne5;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(a aVar) {
            ne5 ne5 = this.f;
            Picasso.e eVar = ne5.x;
            ne5 ne52 = aVar.f;
            Picasso.e eVar2 = ne52.x;
            return eVar == eVar2 ? ne5.f - ne52.f : eVar2.ordinal() - eVar.ordinal();
        }
    }

    public if5() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new rf5.b());
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        a aVar = new a((ne5) runnable);
        execute(aVar);
        return aVar;
    }
}

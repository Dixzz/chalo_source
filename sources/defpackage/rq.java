package defpackage;

import android.annotation.SuppressLint;
import androidx.work.ListenableWorker;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* renamed from: rq  reason: default package */
/* compiled from: WorkerWrapper */
public class rq implements Runnable {
    public final /* synthetic */ ot f;
    public final /* synthetic */ String g;
    public final /* synthetic */ sq h;

    public rq(sq sqVar, ot otVar, String str) {
        this.h = sqVar;
        this.f = otVar;
        this.g = str;
    }

    @SuppressLint({"SyntheticAccessor"})
    public void run() {
        try {
            ListenableWorker.a aVar = (ListenableWorker.a) this.f.get();
            if (aVar == null) {
                tp.c().b(sq.y, String.format("%s returned a null result. Treating it as a failure.", this.h.j.c), new Throwable[0]);
            } else {
                tp.c().a(sq.y, String.format("%s returned a %s result.", this.h.j.c, aVar), new Throwable[0]);
                this.h.l = aVar;
            }
        } catch (CancellationException e) {
            tp.c().d(sq.y, String.format("%s was cancelled", this.g), e);
        } catch (InterruptedException | ExecutionException e2) {
            tp.c().b(sq.y, String.format("%s failed because it threw an exception/error", this.g), e2);
        } catch (Throwable th) {
            this.h.c();
            throw th;
        }
        this.h.c();
    }
}

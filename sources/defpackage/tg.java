package defpackage;

import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: tg  reason: default package */
/* compiled from: DispatchQueue.kt */
public final class tg {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3350a = true;
    public boolean b;
    public boolean c;
    public final Queue<Runnable> d = new ArrayDeque();

    public final boolean a() {
        return this.b || !this.f3350a;
    }

    public final void b() {
        if (!this.c) {
            boolean z = false;
            z = true;
            try {
                while (true) {
                    if (!(this.d.isEmpty() ^ z)) {
                        break;
                    } else if (!a()) {
                        break;
                    } else {
                        Runnable poll = this.d.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                }
                this.c = z;
            } finally {
                this.c = z;
            }
        }
    }

    public final void c(Runnable runnable) {
        if (this.d.offer(runnable)) {
            b();
            return;
        }
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    }
}

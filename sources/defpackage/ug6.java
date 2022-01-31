package defpackage;

/* renamed from: ug6  reason: default package */
/* compiled from: Tasks.kt */
public final class ug6 extends sg6 {
    public final Runnable h;

    public ug6(Runnable runnable, long j, tg6 tg6) {
        super(j, tg6);
        this.h = runnable;
    }

    public void run() {
        try {
            this.h.run();
        } finally {
            this.g.h();
        }
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Task[");
        i0.append(hd3.e1(this.h));
        i0.append('@');
        i0.append(hd3.l1(this.h));
        i0.append(", ");
        i0.append(this.f);
        i0.append(", ");
        i0.append(this.g);
        i0.append(']');
        return i0.toString();
    }
}

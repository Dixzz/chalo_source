package defpackage;

import java.util.Objects;

/* renamed from: it4  reason: default package */
public final /* synthetic */ class it4 implements Runnable {
    public final lt4 f;
    public final int g;
    public final String h;

    public it4(lt4 lt4, int i, String str) {
        this.f = lt4;
        this.g = i;
        this.h = str;
    }

    public final void run() {
        lt4 lt4 = this.f;
        int i = this.g;
        String str = this.h;
        Objects.requireNonNull(lt4);
        try {
            lt4.i(i, str, 4);
        } catch (zu4 e) {
            lt4.g.b(5, "notifyModuleCompleted failed", new Object[]{e});
        }
    }
}

package defpackage;

import android.os.Bundle;
import java.util.Objects;

/* renamed from: xr4  reason: default package */
public final /* synthetic */ class xr4 implements Runnable {
    public final yr4 f;
    public final Bundle g;

    public xr4(yr4 yr4, Bundle bundle) {
        this.f = yr4;
        this.g = bundle;
    }

    public final void run() {
        ft4 ft4;
        yr4 yr4 = this.f;
        Bundle bundle = this.g;
        dt4 dt4 = yr4.g;
        if (((Boolean) dt4.b(new us4(dt4, bundle, null))).booleanValue()) {
            ps4 ps4 = yr4.h;
            Objects.requireNonNull(ps4);
            nv4 nv4 = ps4.j;
            nv4.b(3, "Run extractor loop", new Object[0]);
            if (ps4.i.compareAndSet(false, true)) {
                while (true) {
                    try {
                        ft4 = ps4.h.a();
                    } catch (os4 e) {
                        ps4.j.b(6, "Error while getting next extraction task: %s", new Object[]{e.getMessage()});
                        if (e.f >= 0) {
                            ps4.g.a().a(e.f);
                            ps4.a(e.f, e);
                        }
                        ft4 = null;
                    }
                    if (ft4 != null) {
                        try {
                            if (ft4 instanceof ms4) {
                                ps4.b.a((ms4) ft4);
                            } else if (ft4 instanceof eu4) {
                                ps4.c.a((eu4) ft4);
                            } else if (ft4 instanceof pt4) {
                                ps4.d.a((pt4) ft4);
                            } else if (ft4 instanceof st4) {
                                ps4.e.a((st4) ft4);
                            } else if (ft4 instanceof yt4) {
                                ps4.f.a((yt4) ft4);
                            } else {
                                ps4.j.b(6, "Unknown task type: %s", new Object[]{ft4.getClass().getName()});
                            }
                        } catch (Exception e2) {
                            ps4.j.b(6, "Error during extraction task: %s", new Object[]{e2.getMessage()});
                            ps4.g.a().a(ft4.f1171a);
                            ps4.a(ft4.f1171a, e2);
                        }
                    } else {
                        ps4.i.set(false);
                        return;
                    }
                }
            } else {
                nv4.b(5, "runLoop already looping; return", new Object[0]);
            }
        }
    }
}

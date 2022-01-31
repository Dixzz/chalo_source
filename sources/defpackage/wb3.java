package defpackage;

import java.util.Objects;
import java.util.concurrent.Callable;

/* renamed from: wb3  reason: default package */
public final class wb3 implements Callable<Void> {
    public final /* synthetic */ sb3 f;

    public wb3(sb3 sb3) {
        this.f = sb3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final Void call() throws Exception {
        mc3 mc3 = this.f.h;
        Objects.requireNonNull(mc3);
        jz1.c();
        mc3.g0();
        mc3.P("Sync dispatching local hits");
        long j = mc3.q;
        mc3.m0();
        try {
            mc3.o0();
            mc3.E().m0();
            mc3.q0();
            if (mc3.q == j) {
                return null;
            }
            mc3.k.b();
            return null;
        } catch (Exception e) {
            mc3.L("Sync local dispatch failed", e);
            mc3.q0();
            return null;
        }
    }
}

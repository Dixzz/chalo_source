package defpackage;

import java.util.concurrent.Callable;

/* renamed from: uc3  reason: default package */
public final class uc3 implements Callable<String> {
    public final /* synthetic */ sc3 f;

    public uc3(sc3 sc3) {
        this.f = sc3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        return this.f.m0();
    }
}

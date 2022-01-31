package defpackage;

import java.util.concurrent.Callable;

/* renamed from: eq5  reason: default package */
/* compiled from: TagGroupApiClient */
public final class eq5 implements Callable<String> {
    public final /* synthetic */ kq5 f;

    public eq5(kq5 kq5) {
        this.f = kq5;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public String call() throws Exception {
        int a2 = this.f.a();
        if (a2 == 1) {
            return "amazon_channel";
        }
        if (a2 == 2) {
            return "android_channel";
        }
        throw new IllegalStateException("Invalid platform");
    }
}

package defpackage;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: uu4  reason: default package */
public final class uu4 implements nw4<Executor> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3556a = 0;

    public uu4() {
    }

    public uu4(byte[] bArr) {
    }

    public uu4(char[] cArr) {
    }

    public uu4(short[] sArr) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.nw4
    public final Executor a() {
        int i = this.f3556a;
        if (i == 0) {
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(mu4.b);
            Objects.requireNonNull(newSingleThreadExecutor, "Cannot return null from a non-@Nullable @Provides method");
            return newSingleThreadExecutor;
        } else if (i == 1) {
            ExecutorService newSingleThreadExecutor2 = Executors.newSingleThreadExecutor(mu4.c);
            Objects.requireNonNull(newSingleThreadExecutor2, "Cannot return null from a non-@Nullable @Provides method");
            return newSingleThreadExecutor2;
        } else if (i != 2) {
            return new ss4();
        } else {
            return new js4();
        }
    }
}

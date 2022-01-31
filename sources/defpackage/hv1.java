package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: hv1  reason: default package */
/* compiled from: ExecutionModule_ExecutorFactory */
public final class hv1 implements Object<Executor> {

    /* renamed from: hv1$a */
    /* compiled from: ExecutionModule_ExecutorFactory */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final hv1 f1432a = new hv1();
    }

    public Object get() {
        return new iv1(Executors.newSingleThreadExecutor());
    }
}

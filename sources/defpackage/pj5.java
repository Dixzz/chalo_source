package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: pj5  reason: default package */
/* compiled from: AirshipExecutors */
public class pj5 {

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f2814a = Executors.newCachedThreadPool(fy5.f1188a);

    public static Executor a() {
        return new dz5(f2814a);
    }
}

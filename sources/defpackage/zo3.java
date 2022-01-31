package defpackage;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* renamed from: zo3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zo3 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public ThreadFactory f4195a = Executors.defaultThreadFactory();

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f4195a.newThread(runnable);
        newThread.setName("ScionFrontendApi");
        return newThread;
    }
}

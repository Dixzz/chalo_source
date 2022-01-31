package defpackage;

import java.util.concurrent.ThreadFactory;

/* renamed from: ui6  reason: default package */
/* compiled from: Util.kt */
public final class ui6 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3510a;
    public final /* synthetic */ boolean b;

    public ui6(String str, boolean z) {
        this.f3510a = str;
        this.b = z;
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f3510a);
        thread.setDaemon(this.b);
        return thread;
    }
}

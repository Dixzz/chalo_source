package defpackage;

import java.util.concurrent.ThreadFactory;

/* renamed from: mu4  reason: default package */
public final /* synthetic */ class mu4 implements ThreadFactory {
    public static final ThreadFactory b = new mu4();
    public static final ThreadFactory c = new mu4(null);

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2447a = 0;

    public mu4() {
    }

    public mu4(byte[] bArr) {
    }

    public final Thread newThread(Runnable runnable) {
        return this.f2447a != 0 ? new Thread(runnable, "AssetPackBackgroundExecutor") : new Thread(runnable, "UpdateListenerExecutor");
    }
}

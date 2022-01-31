package defpackage;

import androidx.annotation.RecentlyNonNull;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* renamed from: jb2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class jb2 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final String f1899a;
    public final ThreadFactory b = Executors.defaultThreadFactory();

    public jb2(@RecentlyNonNull String str) {
        gj1.l(str, "Name must not be null");
        this.f1899a = str;
    }

    @RecentlyNonNull
    public final Thread newThread(@RecentlyNonNull Runnable runnable) {
        Thread newThread = this.b.newThread(new lb2(runnable));
        newThread.setName(this.f1899a);
        return newThread;
    }
}

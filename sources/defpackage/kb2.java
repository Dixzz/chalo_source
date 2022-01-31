package defpackage;

import androidx.annotation.RecentlyNonNull;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: kb2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class kb2 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final String f2043a;
    public final AtomicInteger b = new AtomicInteger();
    public final ThreadFactory c = Executors.defaultThreadFactory();

    public kb2(@RecentlyNonNull String str) {
        gj1.l(str, "Name must not be null");
        this.f2043a = str;
    }

    @RecentlyNonNull
    public final Thread newThread(@RecentlyNonNull Runnable runnable) {
        Thread newThread = this.c.newThread(new lb2(runnable));
        String str = this.f2043a;
        int andIncrement = this.b.getAndIncrement();
        StringBuilder sb = new StringBuilder(str.length() + 13);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        newThread.setName(sb.toString());
        return newThread;
    }
}

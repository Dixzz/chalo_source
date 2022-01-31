package defpackage;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: yn6  reason: default package */
/* compiled from: GifRenderingExecutor */
public final class yn6 extends ScheduledThreadPoolExecutor {
    public static final /* synthetic */ int f = 0;

    /* renamed from: yn6$b */
    /* compiled from: GifRenderingExecutor */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final yn6 f4074a = new yn6(null);
    }

    public yn6(a aVar) {
        super(1, new ThreadPoolExecutor.DiscardPolicy());
    }
}

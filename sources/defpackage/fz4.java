package defpackage;

import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;
import java.util.concurrent.Callable;

/* renamed from: fz4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class fz4 implements Callable {
    public final /* synthetic */ DefaultHeartBeatInfo f;

    public /* synthetic */ fz4(DefaultHeartBeatInfo defaultHeartBeatInfo) {
        this.f = defaultHeartBeatInfo;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f.b();
    }
}

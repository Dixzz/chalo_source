package defpackage;

import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;
import java.util.concurrent.Callable;

/* renamed from: hz4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class hz4 implements Callable {
    public final /* synthetic */ DefaultHeartBeatInfo f;
    public final /* synthetic */ String g;

    public /* synthetic */ hz4(DefaultHeartBeatInfo defaultHeartBeatInfo, String str) {
        this.f = defaultHeartBeatInfo;
        this.g = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.f.c(this.g);
        return null;
    }
}

package defpackage;

import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;
import java.util.concurrent.ThreadFactory;

/* renamed from: ez4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ez4 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ ez4 f1048a = new ez4();

    public final Thread newThread(Runnable runnable) {
        int i = DefaultHeartBeatInfo.f660a;
        return new Thread(runnable, "heartbeat-information-executor");
    }
}

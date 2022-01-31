package defpackage;

import android.content.Context;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;
import com.google.firebase.heartbeatinfo.HeartBeatInfoStorage;
import com.google.firebase.inject.Provider;

/* renamed from: gz4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class gz4 implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1320a;

    public /* synthetic */ gz4(Context context) {
        this.f1320a = context;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        Context context = this.f1320a;
        int i = DefaultHeartBeatInfo.f660a;
        return HeartBeatInfoStorage.getInstance(context);
    }
}

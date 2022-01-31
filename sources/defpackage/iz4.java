package defpackage;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;

/* renamed from: iz4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class iz4 implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ iz4 f1588a = new iz4();

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return DefaultHeartBeatInfo.a(componentContainer);
    }
}

package defpackage;

import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.platforminfo.UserAgentPublisher;

/* renamed from: nz4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class nz4 implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ nz4 f2625a = new nz4();

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new FirebaseInstallations((FirebaseApp) componentContainer.get(FirebaseApp.class), componentContainer.getProvider(UserAgentPublisher.class), componentContainer.getProvider(HeartBeatInfo.class));
    }
}

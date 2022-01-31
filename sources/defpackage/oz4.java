package defpackage;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import com.google.firebase.platforminfo.GlobalLibraryVersionRegistrar;
import com.google.firebase.platforminfo.LibraryVersion;

/* renamed from: oz4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class oz4 implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ oz4 f2750a = new oz4();

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new DefaultUserAgentPublisher(componentContainer.setOf(LibraryVersion.class), GlobalLibraryVersionRegistrar.getInstance());
    }
}

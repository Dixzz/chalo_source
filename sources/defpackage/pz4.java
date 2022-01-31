package defpackage;

import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.platforminfo.LibraryVersion;
import com.google.firebase.platforminfo.LibraryVersionComponent;

/* renamed from: pz4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class pz4 implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2875a;
    public final /* synthetic */ LibraryVersionComponent.VersionExtractor b;

    public /* synthetic */ pz4(String str, LibraryVersionComponent.VersionExtractor versionExtractor) {
        this.f2875a = str;
        this.b = versionExtractor;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return LibraryVersion.create(this.f2875a, this.b.extract((Context) componentContainer.get(Context.class)));
    }
}

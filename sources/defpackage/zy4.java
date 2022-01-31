package defpackage;

import com.google.firebase.components.OptionalProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* renamed from: zy4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class zy4 implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Deferred.DeferredHandler f4230a;
    public final /* synthetic */ Deferred.DeferredHandler b;

    public /* synthetic */ zy4(Deferred.DeferredHandler deferredHandler, Deferred.DeferredHandler deferredHandler2) {
        this.f4230a = deferredHandler;
        this.b = deferredHandler2;
    }

    @Override // com.google.firebase.inject.Deferred.DeferredHandler
    public final void handle(Provider provider) {
        Deferred.DeferredHandler deferredHandler = this.f4230a;
        Deferred.DeferredHandler deferredHandler2 = this.b;
        int i = OptionalProvider.f650a;
        deferredHandler.handle(provider);
        deferredHandler2.handle(provider);
    }
}

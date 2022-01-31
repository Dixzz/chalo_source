package defpackage;

import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;

/* renamed from: ry4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ry4 implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentRegistrar f3152a;

    public /* synthetic */ ry4(ComponentRegistrar componentRegistrar) {
        this.f3152a = componentRegistrar;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        ComponentRegistrar componentRegistrar = this.f3152a;
        int i = ComponentRuntime.f649a;
        return componentRegistrar;
    }
}

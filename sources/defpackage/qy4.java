package defpackage;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.RestrictedComponentContainer;
import com.google.firebase.inject.Provider;
import java.util.Objects;

/* renamed from: qy4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class qy4 implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentRuntime f3008a;
    public final /* synthetic */ Component b;

    public /* synthetic */ qy4(ComponentRuntime componentRuntime, Component component) {
        this.f3008a = componentRuntime;
        this.b = component;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        ComponentRuntime componentRuntime = this.f3008a;
        Component component = this.b;
        Objects.requireNonNull(componentRuntime);
        return component.getFactory().create(new RestrictedComponentContainer(component, componentRuntime));
    }
}

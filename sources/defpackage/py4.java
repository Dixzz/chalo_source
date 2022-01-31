package defpackage;

import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.inject.Provider;

/* renamed from: py4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class py4 implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2869a;

    public /* synthetic */ py4(String str) {
        this.f2869a = str;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return ComponentDiscovery.instantiate(this.f2869a);
    }
}

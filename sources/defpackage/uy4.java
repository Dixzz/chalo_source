package defpackage;

import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.OptionalProvider;
import com.google.firebase.inject.Provider;

/* renamed from: uy4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class uy4 implements Runnable {
    public final /* synthetic */ OptionalProvider f;
    public final /* synthetic */ Provider g;

    public /* synthetic */ uy4(OptionalProvider optionalProvider, Provider provider) {
        this.f = optionalProvider;
        this.g = provider;
    }

    public final void run() {
        OptionalProvider optionalProvider = this.f;
        Provider provider = this.g;
        int i = ComponentRuntime.f649a;
        optionalProvider.set(provider);
    }
}

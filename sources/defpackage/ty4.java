package defpackage;

import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.LazySet;
import com.google.firebase.inject.Provider;

/* renamed from: ty4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ty4 implements Runnable {
    public final /* synthetic */ LazySet f;
    public final /* synthetic */ Provider g;

    public /* synthetic */ ty4(LazySet lazySet, Provider provider) {
        this.f = lazySet;
        this.g = provider;
    }

    public final void run() {
        LazySet lazySet = this.f;
        Provider provider = this.g;
        int i = ComponentRuntime.f649a;
        lazySet.add(provider);
    }
}

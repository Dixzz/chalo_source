package com.google.firebase.perf;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: FirebasePerfRegistrar */
public final /* synthetic */ class FirebasePerfRegistrar$$Lambda$1 implements ComponentFactory {
    private static final FirebasePerfRegistrar$$Lambda$1 instance = new FirebasePerfRegistrar$$Lambda$1();

    private FirebasePerfRegistrar$$Lambda$1() {
    }

    public static ComponentFactory lambdaFactory$() {
        return instance;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return FirebasePerfRegistrar.lambda$getComponents$0(componentContainer);
    }
}

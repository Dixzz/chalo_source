package com.google.firebase.database;

import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

@Keep
public class DatabaseRegistrar implements ComponentRegistrar {
    public static /* synthetic */ FirebaseDatabaseComponent lambda$getComponents$0(ComponentContainer componentContainer) {
        return new FirebaseDatabaseComponent((FirebaseApp) componentContainer.get(FirebaseApp.class), (InternalAuthProvider) componentContainer.get(InternalAuthProvider.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebaseDatabaseComponent.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.optional(InternalAuthProvider.class)).factory(DatabaseRegistrar$$Lambda$1.lambdaFactory$()).build(), LibraryVersionComponent.create("fire-rtdb", BuildConfig.VERSION_NAME));
    }
}

package com.google.firebase.perf;

import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.Arrays;
import java.util.List;

@Keep
public class FirebasePerfRegistrar implements ComponentRegistrar {
    public static /* synthetic */ FirebasePerformance lambda$getComponents$0(ComponentContainer componentContainer) {
        return new FirebasePerformance((FirebaseApp) componentContainer.get(FirebaseApp.class), componentContainer.getProvider(RemoteConfigComponent.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), componentContainer.getProvider(eu1.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebasePerformance.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.requiredProvider(RemoteConfigComponent.class)).add(Dependency.required(FirebaseInstallationsApi.class)).add(Dependency.requiredProvider(eu1.class)).factory(FirebasePerfRegistrar$$Lambda$1.lambdaFactory$()).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-perf", BuildConfig.VERSION_NAME));
    }
}

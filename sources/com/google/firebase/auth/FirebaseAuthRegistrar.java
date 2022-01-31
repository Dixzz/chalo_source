package com.google.firebase.auth;

import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.remoteconfig.BuildConfig;
import java.util.Arrays;
import java.util.List;

@Keep
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class FirebaseAuthRegistrar implements ComponentRegistrar {
    public static final /* synthetic */ int zza = 0;

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebaseAuth.class, InternalAuthProvider.class).add(Dependency.required(FirebaseApp.class)).factory(zzv.zza).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-auth", BuildConfig.VERSION_NAME));
    }
}

package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.Personalization;

/* compiled from: RemoteConfigComponent */
public final /* synthetic */ class RemoteConfigComponent$$Lambda$4 implements bb2 {
    private final Personalization arg$1;

    private RemoteConfigComponent$$Lambda$4(Personalization personalization) {
        this.arg$1 = personalization;
    }

    public static bb2 lambdaFactory$(Personalization personalization) {
        return new RemoteConfigComponent$$Lambda$4(personalization);
    }

    @Override // defpackage.bb2
    public void accept(Object obj, Object obj2) {
        this.arg$1.logArmActive((String) obj, (ConfigContainer) obj2);
    }
}

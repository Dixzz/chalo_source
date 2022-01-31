package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;

/* compiled from: ConfigFetchHandler */
public final /* synthetic */ class ConfigFetchHandler$$Lambda$4 implements xi4 {
    private final ConfigFetchHandler.FetchResponse arg$1;

    private ConfigFetchHandler$$Lambda$4(ConfigFetchHandler.FetchResponse fetchResponse) {
        this.arg$1 = fetchResponse;
    }

    public static xi4 lambdaFactory$(ConfigFetchHandler.FetchResponse fetchResponse) {
        return new ConfigFetchHandler$$Lambda$4(fetchResponse);
    }

    @Override // defpackage.xi4
    public yi4 then(Object obj) {
        ConfigContainer configContainer = (ConfigContainer) obj;
        return hd3.W0(this.arg$1);
    }
}

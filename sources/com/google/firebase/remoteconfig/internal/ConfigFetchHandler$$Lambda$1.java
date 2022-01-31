package com.google.firebase.remoteconfig.internal;

/* compiled from: ConfigFetchHandler */
public final /* synthetic */ class ConfigFetchHandler$$Lambda$1 implements qi4 {
    private final ConfigFetchHandler arg$1;
    private final long arg$2;

    private ConfigFetchHandler$$Lambda$1(ConfigFetchHandler configFetchHandler, long j) {
        this.arg$1 = configFetchHandler;
        this.arg$2 = j;
    }

    public static qi4 lambdaFactory$(ConfigFetchHandler configFetchHandler, long j) {
        return new ConfigFetchHandler$$Lambda$1(configFetchHandler, j);
    }

    @Override // defpackage.qi4
    public Object then(yi4 yi4) {
        return this.arg$1.fetchIfCacheExpiredAndNotThrottled(yi4, this.arg$2);
    }
}

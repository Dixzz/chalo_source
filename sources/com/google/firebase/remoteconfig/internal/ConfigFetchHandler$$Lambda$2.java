package com.google.firebase.remoteconfig.internal;

import java.util.Date;

/* compiled from: ConfigFetchHandler */
public final /* synthetic */ class ConfigFetchHandler$$Lambda$2 implements qi4 {
    private final ConfigFetchHandler arg$1;
    private final yi4 arg$2;
    private final yi4 arg$3;
    private final Date arg$4;

    private ConfigFetchHandler$$Lambda$2(ConfigFetchHandler configFetchHandler, yi4 yi4, yi4 yi42, Date date) {
        this.arg$1 = configFetchHandler;
        this.arg$2 = yi4;
        this.arg$3 = yi42;
        this.arg$4 = date;
    }

    public static qi4 lambdaFactory$(ConfigFetchHandler configFetchHandler, yi4 yi4, yi4 yi42, Date date) {
        return new ConfigFetchHandler$$Lambda$2(configFetchHandler, yi4, yi42, date);
    }

    @Override // defpackage.qi4
    public Object then(yi4 yi4) {
        return ConfigFetchHandler.lambda$fetchIfCacheExpiredAndNotThrottled$1(this.arg$1, this.arg$2, this.arg$3, this.arg$4, yi4);
    }
}

package com.google.firebase.remoteconfig.internal;

import java.util.Date;

/* compiled from: ConfigFetchHandler */
public final /* synthetic */ class ConfigFetchHandler$$Lambda$3 implements qi4 {
    private final ConfigFetchHandler arg$1;
    private final Date arg$2;

    private ConfigFetchHandler$$Lambda$3(ConfigFetchHandler configFetchHandler, Date date) {
        this.arg$1 = configFetchHandler;
        this.arg$2 = date;
    }

    public static qi4 lambdaFactory$(ConfigFetchHandler configFetchHandler, Date date) {
        return new ConfigFetchHandler$$Lambda$3(configFetchHandler, date);
    }

    @Override // defpackage.qi4
    public Object then(yi4 yi4) {
        return this.arg$1.updateLastFetchStatusAndTime(yi4, this.arg$2);
    }
}

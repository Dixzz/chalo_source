package com.google.firebase.remoteconfig.internal;

/* compiled from: ConfigCacheClient */
public final /* synthetic */ class ConfigCacheClient$$Lambda$2 implements xi4 {
    private final ConfigCacheClient arg$1;
    private final boolean arg$2;
    private final ConfigContainer arg$3;

    private ConfigCacheClient$$Lambda$2(ConfigCacheClient configCacheClient, boolean z, ConfigContainer configContainer) {
        this.arg$1 = configCacheClient;
        this.arg$2 = z;
        this.arg$3 = configContainer;
    }

    public static xi4 lambdaFactory$(ConfigCacheClient configCacheClient, boolean z, ConfigContainer configContainer) {
        return new ConfigCacheClient$$Lambda$2(configCacheClient, z, configContainer);
    }

    @Override // defpackage.xi4
    public yi4 then(Object obj) {
        return ConfigCacheClient.lambda$put$1(this.arg$1, this.arg$2, this.arg$3, (Void) obj);
    }
}

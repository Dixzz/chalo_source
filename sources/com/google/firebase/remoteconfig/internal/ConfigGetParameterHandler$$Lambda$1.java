package com.google.firebase.remoteconfig.internal;

/* compiled from: ConfigGetParameterHandler */
public final /* synthetic */ class ConfigGetParameterHandler$$Lambda$1 implements Runnable {
    private final bb2 arg$1;
    private final String arg$2;
    private final ConfigContainer arg$3;

    private ConfigGetParameterHandler$$Lambda$1(bb2 bb2, String str, ConfigContainer configContainer) {
        this.arg$1 = bb2;
        this.arg$2 = str;
        this.arg$3 = configContainer;
    }

    public static Runnable lambdaFactory$(bb2 bb2, String str, ConfigContainer configContainer) {
        return new ConfigGetParameterHandler$$Lambda$1(bb2, str, configContainer);
    }

    public void run() {
        this.arg$1.accept(this.arg$2, this.arg$3);
    }
}

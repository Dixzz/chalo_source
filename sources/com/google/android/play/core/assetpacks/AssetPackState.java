package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Objects;

public abstract class AssetPackState {
    public static AssetPackState b(String str, int i, int i2, long j, long j2, double d, int i3) {
        return new fs4(str, i, i2, j, j2, (int) Math.rint(100.0d * d), i3);
    }

    public static AssetPackState d(Bundle bundle, String str, ss4 ss4, zr4 zr4) {
        double doubleValue;
        int i = bundle.getInt(hd3.L0("status", str));
        Objects.requireNonNull((as4) zr4);
        int i2 = bundle.getInt(hd3.L0("error_code", str));
        long j = bundle.getLong(hd3.L0("bytes_downloaded", str));
        long j2 = bundle.getLong(hd3.L0("total_bytes_to_download", str));
        synchronized (ss4) {
            Double d = ss4.f3250a.get(str);
            doubleValue = d == null ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : d.doubleValue();
        }
        long j3 = bundle.getLong(hd3.L0("pack_version", str));
        long j4 = bundle.getLong(hd3.L0("pack_base_version", str));
        return b(str, i, i2, j, j2, doubleValue, (i != 4 || j4 == 0 || j4 == j3) ? 1 : 2);
    }

    public abstract int a();

    public abstract long c();

    public abstract int e();

    public abstract String f();

    public abstract int g();

    public abstract long h();

    public abstract int i();
}

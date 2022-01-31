package com.razorpay;

public enum NetworkType {
    WIFI(AnalyticsConstants.WIFI),
    CELLULAR(AnalyticsConstants.CELLULAR),
    BLUETOOTH(AnalyticsConstants.BLUETOOTH),
    UNKNOWN("unknown");
    
    private String mNetworkTypeName;

    private NetworkType(String str) {
        this.mNetworkTypeName = str;
    }

    public final String getNetworkTypeName() {
        return this.mNetworkTypeName;
    }
}

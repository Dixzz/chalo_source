package com.razorpay;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

@Keep
@KeepClassMembers
public class RzpPluginCompatibilityResponse {
    private String errorMessage;
    private boolean isCompatible;

    public RzpPluginCompatibilityResponse(boolean z, String str) {
        this.isCompatible = z;
        this.errorMessage = str;
    }

    public String getErrorMessage() {
        String str = this.errorMessage;
        return str == null ? "" : str;
    }

    public boolean isCompatible() {
        return this.isCompatible;
    }
}

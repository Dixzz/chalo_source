package com.razorpay;

import org.json.JSONObject;
import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

@Keep
@KeepClassMembers
public class AnalyticsProperty {
    public Scope scope;
    public Object value;

    public enum Scope {
        PAYMENT,
        ORDER
    }

    public AnalyticsProperty(int i, Scope scope2) {
        this.value = Integer.valueOf(i);
        this.scope = scope2;
    }

    public AnalyticsProperty(long j, Scope scope2) {
        this.value = Long.valueOf(j);
        this.scope = scope2;
    }

    public AnalyticsProperty(String str, Scope scope2) {
        this.value = str;
        this.scope = scope2;
    }

    public AnalyticsProperty(boolean z, Scope scope2) {
        this.value = Boolean.valueOf(z);
        this.scope = scope2;
    }

    public AnalyticsProperty(JSONObject jSONObject, Scope scope2) {
        this.value = jSONObject;
        this.scope = scope2;
    }
}

package com.google.firebase.perf.internal;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ResourceType {
    public static final String NETWORK = "Network";
    public static final String TRACE = "Trace";
}

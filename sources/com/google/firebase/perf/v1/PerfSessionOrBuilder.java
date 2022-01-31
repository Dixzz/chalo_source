package com.google.firebase.perf.v1;

import java.util.List;

public interface PerfSessionOrBuilder extends k15 {
    @Override // defpackage.k15
    /* synthetic */ j15 getDefaultInstanceForType();

    String getSessionId();

    a05 getSessionIdBytes();

    SessionVerbosity getSessionVerbosity(int i);

    int getSessionVerbosityCount();

    List<SessionVerbosity> getSessionVerbosityList();

    boolean hasSessionId();

    @Override // defpackage.k15
    /* synthetic */ boolean isInitialized();
}

package com.google.firebase.perf.internal;

public interface SessionAwareObject {
    void updateSession(PerfSession perfSession);
}

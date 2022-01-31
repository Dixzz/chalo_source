package com.firebase.geofire;

public interface EventRaiser {
    void raiseEvent(Runnable runnable);
}

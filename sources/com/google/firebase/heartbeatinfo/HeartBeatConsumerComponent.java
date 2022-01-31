package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.Component;

public class HeartBeatConsumerComponent {
    private HeartBeatConsumerComponent() {
    }

    public static Component<?> create() {
        return Component.intoSet(new HeartBeatConsumer() {
            /* class com.google.firebase.heartbeatinfo.HeartBeatConsumerComponent.AnonymousClass1 */
        }, HeartBeatConsumer.class);
    }
}

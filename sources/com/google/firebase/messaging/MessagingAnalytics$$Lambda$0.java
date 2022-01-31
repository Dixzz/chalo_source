package com.google.firebase.messaging;

import com.google.firebase.messaging.reporting.MessagingClientEventExtension;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final /* synthetic */ class MessagingAnalytics$$Lambda$0 implements cu1 {
    public static final cu1 $instance = new MessagingAnalytics$$Lambda$0();

    private MessagingAnalytics$$Lambda$0() {
    }

    @Override // defpackage.cu1
    public Object apply(Object obj) {
        return ((MessagingClientEventExtension) obj).toByteArray();
    }
}

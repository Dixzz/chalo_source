package com.google.firebase.messaging.reporting;

import com.google.firebase.encoders.annotations.Encodable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class MessagingClientEventExtension {
    private static final MessagingClientEventExtension DEFAULT_INSTANCE = new Builder().build();
    private final MessagingClientEvent messaging_client_event_;

    /* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
    public static final class Builder {
        private MessagingClientEvent messaging_client_event_ = null;

        public MessagingClientEventExtension build() {
            return new MessagingClientEventExtension(this.messaging_client_event_);
        }

        public Builder setMessagingClientEvent(MessagingClientEvent messagingClientEvent) {
            this.messaging_client_event_ = messagingClientEvent;
            return this;
        }
    }

    public MessagingClientEventExtension(MessagingClientEvent messagingClientEvent) {
        this.messaging_client_event_ = messagingClientEvent;
    }

    public static MessagingClientEventExtension getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Encodable.Ignore
    public MessagingClientEvent getMessagingClientEvent() {
        MessagingClientEvent messagingClientEvent = this.messaging_client_event_;
        return messagingClientEvent == null ? MessagingClientEvent.getDefaultInstance() : messagingClientEvent;
    }

    @kb3
    @Encodable.Field(name = "messagingClientEvent")
    public MessagingClientEvent getMessagingClientEventInternal() {
        return this.messaging_client_event_;
    }

    public byte[] toByteArray() {
        ua3 ua3 = ya3.f4025a;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Objects.requireNonNull(ua3);
            new ra3(byteArrayOutputStream, ua3.f3482a, ua3.b, ua3.c).f(this);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        ua3 ua3 = ya3.f4025a;
        Objects.requireNonNull(ua3);
        new ra3(outputStream, ua3.f3482a, ua3.b, ua3.c).f(this);
    }
}

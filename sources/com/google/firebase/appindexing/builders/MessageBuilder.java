package com.google.firebase.appindexing.builders;

import com.razorpay.AnalyticsConstants;
import java.util.Date;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class MessageBuilder extends IndexableBuilder<MessageBuilder> {
    public MessageBuilder() {
        super("Message");
    }

    public final MessageBuilder setDateRead(Date date) {
        Objects.requireNonNull(date, "null reference");
        return (MessageBuilder) put("dateRead", date.getTime());
    }

    public final MessageBuilder setDateReceived(Date date) {
        Objects.requireNonNull(date, "null reference");
        return (MessageBuilder) put("dateReceived", date.getTime());
    }

    public final MessageBuilder setDateSent(Date date) {
        Objects.requireNonNull(date, "null reference");
        return (MessageBuilder) put("dateSent", date.getTime());
    }

    public final MessageBuilder setIsPartOf(ConversationBuilder... conversationBuilderArr) {
        return (MessageBuilder) put("isPartOf", conversationBuilderArr);
    }

    public final MessageBuilder setMessageAttachment(IndexableBuilder<?>... indexableBuilderArr) {
        return (MessageBuilder) put("messageAttachment", indexableBuilderArr);
    }

    public final MessageBuilder setRecipient(PersonBuilder... personBuilderArr) {
        return (MessageBuilder) put("recipient", personBuilderArr);
    }

    public final MessageBuilder setSender(PersonBuilder personBuilder) {
        return (MessageBuilder) put(AnalyticsConstants.SENDER, personBuilder);
    }

    public final MessageBuilder setText(String str) {
        return (MessageBuilder) put("text", str);
    }

    public MessageBuilder(String str) {
        super(str);
    }
}

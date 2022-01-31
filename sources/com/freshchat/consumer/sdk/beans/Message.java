package com.freshchat.consumer.sdk.beans;

import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Message {
    public static final int DO_NOT_DISPLAY = -1;
    public static final int DO_NOT_TRANSLATE = 0;
    public static final int MESSAGE_READ = 1;
    public static final int MESSAGE_UNREAD = 0;
    public static final int MUST_TRANSLATE = 1;
    public static final int MUST_TRANSLATE_BUT_TRANSLATION_FAILED = 2;
    public static final int RESPONSE_GIVEN = 1;
    public static final int RESPONSE_PENDING = 0;
    public static final int SOURCE_MOBILE = 2;
    public static final int UPLOAD_STATE_PENDING = 0;
    public static final int UPLOAD_STATE_UPLOADED = 1;
    private String alias;
    private long channelId;
    private long conversationId;
    private long createdMillis;
    @SerializedName("messageId")
    private long id;
    private MessageInternalMeta internalMeta;
    private boolean isResponded;
    private long marketingId;
    private List<MessageFragment> messageFragments;
    private int messageType;
    private String messageUserAlias;
    private int messageUserType;
    @SerializedName("readByUser")
    private boolean read;
    private List<MessageFragment> replyFragments;
    private ReplyTo replyTo;
    private int shouldTranslate;
    private int source = 2;
    private transient int uploadState;

    public static class Builder {
        private String alias;
        private long channelId;
        private long createdMillis;
        private long hostConversationId;
        private long id;
        private MessageInternalMeta internalMeta;
        private boolean isResponded;
        private long marketingId;
        private int messageType;
        private String messageUserAlias;
        private int messageUserType;
        private boolean read;
        private List<MessageFragment> replyFragments;
        private ReplyTo replyTo;
        private int shouldTranslate;
        private int source = 2;
        private int uploadState;

        public Builder alias(String str) {
            this.alias = str;
            return this;
        }

        public Message build() {
            Message message = new Message();
            message.id = this.id;
            message.alias = this.alias;
            message.channelId = this.channelId;
            message.marketingId = this.marketingId;
            message.messageType = this.messageType;
            message.conversationId = this.hostConversationId;
            message.messageUserType = this.messageUserType;
            message.messageUserAlias = this.messageUserAlias;
            message.source = this.source;
            message.read = this.read;
            message.createdMillis = this.createdMillis;
            message.uploadState = this.uploadState;
            message.replyFragments = this.replyFragments;
            message.internalMeta = this.internalMeta;
            message.replyTo = this.replyTo;
            message.isResponded = this.isResponded;
            message.shouldTranslate = this.shouldTranslate;
            return message;
        }

        public Builder channelId(long j) {
            this.channelId = j;
            return this;
        }

        public Builder createdMillis(long j) {
            this.createdMillis = j;
            return this;
        }

        public Builder hostConversationId(long j) {
            this.hostConversationId = j;
            return this;
        }

        public Builder id(long j) {
            this.id = j;
            return this;
        }

        public Builder internalMeta(MessageInternalMeta messageInternalMeta) {
            this.internalMeta = messageInternalMeta;
            return this;
        }

        public Builder isResponded(boolean z) {
            this.isResponded = z;
            return this;
        }

        public Builder marketingId(long j) {
            this.marketingId = j;
            return this;
        }

        public Builder messageType(int i) {
            this.messageType = i;
            return this;
        }

        public Builder messageUserAlias(String str) {
            this.messageUserAlias = str;
            return this;
        }

        public Builder messageUserType(int i) {
            this.messageUserType = i;
            return this;
        }

        public Builder read(boolean z) {
            this.read = z;
            return this;
        }

        public Builder replyFragments(List<MessageFragment> list) {
            this.replyFragments = list;
            return this;
        }

        public Builder replyTo(ReplyTo replyTo2) {
            this.replyTo = replyTo2;
            return this;
        }

        public Builder setShouldTranslate(int i) {
            this.shouldTranslate = i;
            return this;
        }

        public Builder uploadState(int i) {
            this.uploadState = i;
            return this;
        }
    }

    public enum MessageType {
        MESSAGE_TYPE_UNKNOWN(-1),
        MESSAGE_TYPE_NORMAL(1),
        MESSAGE_TYPE_CALENDER_INVITE_SENT_BY_AGENT(9001),
        MESSAGE_TYPE_CALENDER_INVITE_CANCELLED_BY_USER(9002),
        MESSAGE_TYPE_CALENDER_BOOKING_SUCCESS(9003),
        MESSAGE_TYPE_CALENDER_BOOKING_FAILURE(9004);
        
        private final int intValue;

        private MessageType(int i) {
            this.intValue = i;
        }

        public static MessageType getMessageTypeFromIntValue(int i) {
            MessageType[] values = values();
            for (int i2 = 0; i2 < 6; i2++) {
                MessageType messageType = values[i2];
                if (messageType.getIntValue() == i) {
                    return messageType;
                }
            }
            return MESSAGE_TYPE_UNKNOWN;
        }

        public int getIntValue() {
            return this.intValue;
        }
    }

    public static class ReplyTo {
        private long originalMessageId;

        public long getOriginalMessageId() {
            return this.originalMessageId;
        }

        public void setOriginalMessageId(long j) {
            this.originalMessageId = j;
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("ReplyTo{originalMessageId=");
            i0.append(this.originalMessageId);
            i0.append('}');
            return i0.toString();
        }
    }

    public void addMessageFragment(MessageFragment messageFragment) {
        if (this.messageFragments == null) {
            this.messageFragments = new ArrayList();
        }
        if (messageFragment != null) {
            this.messageFragments.add(messageFragment);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Message message = (Message) obj;
        int b = k.b(this.messageFragments);
        boolean z = this.marketingId == message.marketingId && this.channelId == message.channelId && this.conversationId == message.conversationId && this.messageUserType == message.messageUserType && this.source == message.source && this.read == message.read && this.createdMillis == message.createdMillis && this.uploadState == message.uploadState && this.messageType == message.messageType && as.o(this.alias, message.alias) && as.o(this.messageUserAlias, message.messageUserAlias) && b == k.b(message.messageFragments) && k.b(this.replyFragments) == k.b(message.replyFragments) && ((this.internalMeta == null && message.internalMeta == null) || !(this.internalMeta == null || message.internalMeta == null)) && this.id == message.id && this.isResponded == message.isResponded && this.shouldTranslate == message.shouldTranslate;
        ReplyTo replyTo2 = this.replyTo;
        long j = 0;
        long j2 = replyTo2 != null ? replyTo2.originalMessageId : 0;
        ReplyTo replyTo3 = message.replyTo;
        if (replyTo3 != null) {
            j = replyTo3.originalMessageId;
        }
        if (!(z && j2 == j)) {
            return false;
        }
        if (!(this.messageFragments == null || message.messageFragments == null)) {
            for (int i = 0; i < b; i++) {
                if (!this.messageFragments.get(i).equals(message.getMessageFragments().get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getAlias() {
        return this.alias;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getConversationId() {
        return this.conversationId;
    }

    public long getCreatedMillis() {
        return this.createdMillis;
    }

    public long getId() {
        return this.id;
    }

    public MessageInternalMeta getInternalMeta() {
        return this.internalMeta;
    }

    public long getMarketingId() {
        return this.marketingId;
    }

    public List<MessageFragment> getMessageFragments() {
        return this.messageFragments;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public String getMessageUserAlias() {
        return this.messageUserAlias;
    }

    public int getMessageUserType() {
        return this.messageUserType;
    }

    public List<MessageFragment> getReplyFragments() {
        return this.replyFragments;
    }

    public ReplyTo getReplyTo() {
        return this.replyTo;
    }

    public int getShouldTranslate() {
        return this.shouldTranslate;
    }

    public int getUploadState() {
        return this.uploadState;
    }

    public boolean isRead() {
        return this.read;
    }

    public boolean isResponded() {
        return this.isResponded;
    }

    public boolean isUploaded() {
        return this.uploadState == 1;
    }

    public boolean isUserMessage() {
        return this.messageUserType == 0;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setChannelId(long j) {
        this.channelId = j;
    }

    public void setConversationId(long j) {
        this.conversationId = j;
    }

    public void setCreatedMillis(long j) {
        this.createdMillis = j;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setInternalMeta(MessageInternalMeta messageInternalMeta) {
        this.internalMeta = messageInternalMeta;
    }

    public void setMarketingId(long j) {
        this.marketingId = j;
    }

    public void setMessageFragments(List<MessageFragment> list) {
        if (this.messageFragments == null) {
            this.messageFragments = new ArrayList();
        }
        if (k.a(list)) {
            this.messageFragments.clear();
            this.messageFragments.addAll(list);
        }
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }

    public void setMessageUserAlias(String str) {
        this.messageUserAlias = str;
    }

    public void setMessageUserType(int i) {
        this.messageUserType = i;
    }

    public void setRead(boolean z) {
        this.read = z;
    }

    public void setReplyFragments(List<MessageFragment> list) {
        this.replyFragments = list;
    }

    public void setReplyTo(ReplyTo replyTo2) {
        this.replyTo = replyTo2;
    }

    public void setResponded(boolean z) {
        this.isResponded = z;
    }

    public void setShouldTranslate(int i) {
        this.shouldTranslate = i;
    }

    public void setUploadState(int i) {
        this.uploadState = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Message{");
        sb.append("alias='");
        hj1.U0(sb, this.alias, '\'', ", marketingId=");
        sb.append(this.marketingId);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(", channelId='");
        sb.append(this.channelId);
        sb.append('\'');
        sb.append(", messageType= '");
        sb.append(this.messageType);
        sb.append('\'');
        sb.append(", conversationId=");
        sb.append(this.conversationId);
        sb.append(", messageUserType=");
        sb.append(this.messageUserType);
        sb.append(", messageUserAlias='");
        hj1.U0(sb, this.messageUserAlias, '\'', ", source=");
        sb.append(this.source);
        sb.append(", read=");
        sb.append(this.read);
        sb.append(", createdMillis=");
        sb.append(this.createdMillis);
        sb.append(", uploadState=");
        sb.append(this.uploadState);
        sb.append(", messageFragments=");
        sb.append(this.messageFragments);
        sb.append(", replyFragments=");
        sb.append(this.replyFragments);
        sb.append(", internalMeta=");
        sb.append(this.internalMeta);
        sb.append(", replyTo=");
        sb.append(this.replyTo);
        sb.append(", isResponded=");
        sb.append(this.isResponded);
        sb.append(", shouldTranslate=");
        return hj1.W(sb, this.shouldTranslate, '}');
    }
}

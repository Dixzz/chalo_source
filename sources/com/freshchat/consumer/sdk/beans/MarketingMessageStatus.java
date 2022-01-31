package com.freshchat.consumer.sdk.beans;

public class MarketingMessageStatus {
    private int clicked;
    private int delivered;
    private long marketingId;
    private int seen;

    public static class Builder {
        private int clicked;
        private int delivered;
        private long marketingId;
        private int seen;

        public MarketingMessageStatus build() {
            MarketingMessageStatus marketingMessageStatus = new MarketingMessageStatus();
            marketingMessageStatus.delivered = this.delivered;
            marketingMessageStatus.seen = this.seen;
            marketingMessageStatus.clicked = this.clicked;
            marketingMessageStatus.marketingId = this.marketingId;
            return marketingMessageStatus;
        }

        public Builder clicked(int i) {
            this.clicked = i;
            return this;
        }

        public Builder delivered(int i) {
            this.delivered = i;
            return this;
        }

        public Builder marketingId(long j) {
            this.marketingId = j;
            return this;
        }

        public Builder seen(int i) {
            this.seen = i;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.marketingId == ((MarketingMessageStatus) obj).marketingId;
    }

    public int getClicked() {
        return this.clicked;
    }

    public int getDelivered() {
        return this.delivered;
    }

    public long getMarketingId() {
        return this.marketingId;
    }

    public int getSeen() {
        return this.seen;
    }

    public int hashCode() {
        long j = this.marketingId;
        return 31 + ((int) (j ^ (j >>> 32)));
    }

    public void setClicked(int i) {
        this.clicked = i;
    }

    public void setDelivered(int i) {
        this.delivered = i;
    }

    public void setMarketingId(long j) {
        this.marketingId = j;
    }

    public void setSeen(int i) {
        this.seen = i;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("MarketingMessageStatus [delivered=");
        i0.append(this.delivered);
        i0.append(", seen=");
        i0.append(this.seen);
        i0.append(", clicked=");
        i0.append(this.clicked);
        i0.append(", marketingId=");
        i0.append(this.marketingId);
        i0.append("]");
        return i0.toString();
    }
}

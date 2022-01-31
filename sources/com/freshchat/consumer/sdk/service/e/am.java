package com.freshchat.consumer.sdk.service.e;

public class am implements j {
    private final String categoryId;
    private final String faqId;
    private final String lastUpdatedAt;
    private final String locale;
    private final a rk;

    public enum a {
        THUMBS_UP("thumbs_up"),
        THUMBS_DOWN("thumbs_down");
        
        private final String value;

        private a(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    public am(String str, String str2, String str3, a aVar, String str4) {
        this.categoryId = str;
        this.faqId = str2;
        this.locale = str3;
        this.rk = aVar;
        this.lastUpdatedAt = str4;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getFaqId() {
        return this.faqId;
    }

    public String getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public String getLocale() {
        return this.locale;
    }

    public a iX() {
        return this.rk;
    }
}

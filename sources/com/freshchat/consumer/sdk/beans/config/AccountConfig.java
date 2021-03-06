package com.freshchat.consumer.sdk.beans.config;

public class AccountConfig {
    private FAQAPIVersion fcFaqApiVersion;

    public enum FAQAPIVersion {
        STANDALONE(1),
        KBASE_SERVICE(2);
        
        private final int apiVersionCode;

        private FAQAPIVersion(int i) {
            this.apiVersionCode = i;
        }

        public static FAQAPIVersion fromInt(int i) {
            FAQAPIVersion[] values = values();
            for (int i2 = 0; i2 < 2; i2++) {
                FAQAPIVersion fAQAPIVersion = values[i2];
                if (fAQAPIVersion.asInt() == i) {
                    return fAQAPIVersion;
                }
            }
            return STANDALONE;
        }

        public int asInt() {
            return this.apiVersionCode;
        }
    }

    public FAQAPIVersion getFcFaqApiVersion() {
        if (this.fcFaqApiVersion == null) {
            this.fcFaqApiVersion = DefaultAccountConfig.DEFAULT_FAQ_API_VERSION;
        }
        return this.fcFaqApiVersion;
    }

    public void setFcFaqApiVersion(FAQAPIVersion fAQAPIVersion) {
        this.fcFaqApiVersion = fAQAPIVersion;
    }
}

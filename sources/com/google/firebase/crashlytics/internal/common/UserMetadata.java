package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Map;

public class UserMetadata {
    public static final int MAX_ATTRIBUTES = 64;
    public static final int MAX_ATTRIBUTE_SIZE = 1024;
    private final ConcurrentHashMap<String, String> attributes = new ConcurrentHashMap<>();
    private String userId = null;

    private static String sanitizeAttribute(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > 1024 ? trim.substring(0, 1024) : trim;
    }

    public Map<String, String> getCustomKeys() {
        return Collections.unmodifiableMap(this.attributes);
    }

    public String getUserId() {
        return this.userId;
    }

    public void setCustomKey(String str, String str2) {
        String str3;
        if (str != null) {
            String sanitizeAttribute = sanitizeAttribute(str);
            if (this.attributes.size() < 64 || this.attributes.containsKey(sanitizeAttribute)) {
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = sanitizeAttribute(str2);
                }
                this.attributes.put(sanitizeAttribute, str3);
                return;
            }
            Logger.getLogger().d("Exceeded maximum number of custom attributes (64)");
            return;
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public void setUserId(String str) {
        this.userId = sanitizeAttribute(str);
    }
}

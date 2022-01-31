package com.freshchat.consumer.sdk.beans.fragment;

import com.freshchat.consumer.sdk.j.as;

public enum TemplateType {
    QUICK_REPLY_DROP_DOWN("quick_reply_dropdown", QuickReplyDropDownFragment.class),
    CAROUSEL("carousel", CarouselFragment.class),
    CAROUSEL_CARD_DEFAULT("carousel_card_default", CarouselCardDefaultFragment.class);
    
    private Class clz;
    private String str;

    private TemplateType(String str2, Class cls) {
        this.str = str2;
        this.clz = cls;
    }

    public static TemplateType get(String str2) {
        if (as.isEmpty(str2)) {
            return null;
        }
        TemplateType[] values = values();
        for (int i = 0; i < 3; i++) {
            TemplateType templateType = values[i];
            if (templateType.str.equals(str2)) {
                return templateType;
            }
        }
        return null;
    }

    public String asString() {
        return this.str;
    }

    public Class getClz() {
        return this.clz;
    }
}

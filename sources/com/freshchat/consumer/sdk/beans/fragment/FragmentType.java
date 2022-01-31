package com.freshchat.consumer.sdk.beans.fragment;

import com.google.firebase.appindexing.Indexable;

public enum FragmentType {
    TEXT(1, TextFragment.class),
    IMAGE(2, ImageFragment.class),
    AUDIO(3, AudioFragment.class),
    VIDEO(4, VideoFragment.class),
    BUTTON(5, ButtonFragment.class),
    CALENDAR_EVENT(7, CalendarEventFragment.class),
    QUICK_REPLY_BUTTON(51, QuickReplyButtonFragment.class),
    CALLBACK_BUTTON(52, CallbackButtonFragment.class),
    COLLECTION(Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL, CollectionFragment.class),
    TEMPLATE(1002, TemplateFragment.class);
    
    private final Class clz;
    private final int intValue;

    private FragmentType(int i, Class cls) {
        this.intValue = i;
        this.clz = cls;
    }

    public static FragmentType fromInt(int i) {
        FragmentType[] values = values();
        for (int i2 = 0; i2 < 10; i2++) {
            FragmentType fragmentType = values[i2];
            if (fragmentType.asInt() == i) {
                return fragmentType;
            }
        }
        return null;
    }

    public int asInt() {
        return this.intValue;
    }

    public Class getClz() {
        return this.clz;
    }
}

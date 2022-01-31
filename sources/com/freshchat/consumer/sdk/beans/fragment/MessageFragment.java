package com.freshchat.consumer.sdk.beans.fragment;

import com.freshchat.consumer.sdk.j.as;

public abstract class MessageFragment {
    private String content;
    private String contentType;
    private int fragmentType;
    private String translatedContent;

    public MessageFragment(int i) {
        this.fragmentType = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MessageFragment messageFragment = (MessageFragment) obj;
        return this.fragmentType == messageFragment.fragmentType && as.o(this.content, messageFragment.content) && as.o(this.contentType, messageFragment.contentType) && as.o(this.translatedContent, messageFragment.translatedContent);
    }

    public String getContent() {
        return this.content;
    }

    public String getContentType() {
        return this.contentType;
    }

    public int getFragmentType() {
        return this.fragmentType;
    }

    public String getTranslatedContent() {
        return this.translatedContent;
    }

    public MessageFragment setContent(String str) {
        this.content = str;
        return this;
    }

    public MessageFragment setContentType(String str) {
        this.contentType = str;
        return this;
    }

    public void setTranslatedContent(String str) {
        this.translatedContent = str;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("MessageFragment{content='");
        hj1.U0(i0, this.content, '\'', ", contentType='");
        hj1.U0(i0, this.contentType, '\'', ", fragmentType=");
        i0.append(this.fragmentType);
        i0.append(", translatedContent='");
        i0.append(this.translatedContent);
        i0.append('\'');
        i0.append('}');
        return i0.toString();
    }
}
